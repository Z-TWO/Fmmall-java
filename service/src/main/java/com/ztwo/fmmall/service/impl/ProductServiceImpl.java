package com.ztwo.fmmall.service.impl;

import com.ztwo.fmmall.bean.*;
import com.ztwo.fmmall.dao.*;
import com.ztwo.fmmall.service.ProductService;
import com.ztwo.fmmall.util.PageHelper;
import com.ztwo.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/4 16:24
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductImgMapper productImgMapper;

    @Resource
    private ProductSkuMapper productSkuMapper;

    @Resource
    private ProductParamsMapper productParamsMapper;

    @Resource
    private ProductCommentsMapper productCommentsMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ResultVO getProductBasicInfo(String productId) {
        //参数判断
        if (productId.equals(null) || productId.equals("")) {
            return ResultVO.getErrorVo("参数错误");
        }
        //查询基本信息
        Example example1 = new Example(Product.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("productId", productId);
        criteria1.andEqualTo("productStatus", 1);
        List<Product> products = productMapper.selectByExample(example1);
        if (products.size() > 0) {
            //查询商品图片
            Example example2 = new Example(ProductImg.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("itemId", productId);
            List<ProductImg> productImgs = productImgMapper.selectByExample(example2);
            //查询商品套餐
            Example example3 = new Example(ProductSku.class);
            Example.Criteria criteria3 = example3.createCriteria();
            criteria3.andEqualTo("productId", productId);
            criteria3.andEqualTo("status", 1);
            List<ProductSku> productSkus = productSkuMapper.selectByExample(example3);

            HashMap<String, Object> map = new HashMap<>();
            map.put("product", products.get(0));
            map.put("productImgs", productImgs);
            map.put("productSkus", productSkus);
            return ResultVO.getSuccessVo("查询成功", map);
        } else {
            return ResultVO.getErrorVo("查询失败");
        }
    }

    @Override
    public ResultVO getProductParams(String productId) {
        //参数判断
        if (productId.equals(null) || productId.equals("")) {
            return ResultVO.getErrorVo("参数错误");
        }
        Example example = new Example(ProductParams.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId", productId);
        List<ProductParams> productParams = productParamsMapper.selectByExample(example);
        if (productParams.size() > 0) {
            return ResultVO.getSuccessVo("查询成功", productParams.get(0));
        } else {
            return ResultVO.getErrorVo("查询失败");
        }
    }

    @Override
    public ResultVO getProductComment(String productId, Integer pageNum, Integer limit) {
        //参数判断
        if (productId.equals(null) || productId.equals("") || limit == 0) {
            return ResultVO.getErrorVo("参数错误");
        }
        //获取总记录数
        Example example = new Example(ProductComments.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId", productId);
        int count = productCommentsMapper.selectCountByExample(example);
        //计算页数
        int pageCount = count % limit == 0 ? count / limit : count / limit + 1;
        //获取评论集合
        List<ProductCommentsVO> productCommentsVOS = productCommentsMapper.selectProductCommentByProductId(productId, pageNum, limit);
        PageHelper<ProductCommentsVO> pageHelper = new PageHelper<>(count, pageCount, productCommentsVOS);
        return ResultVO.getSuccessVo("查询成功", pageHelper);
    }

    @Override
    public ResultVO analysisProductComment(String productId) {
        //参数判断
        if (productId.equals(null) || productId.equals("")) {
            return ResultVO.getErrorVo("参数错误");
        }
        //获取评价总数
        Example example1 = new Example(ProductComments.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("productId", productId);
        int total = productCommentsMapper.selectCountByExample(example1);
        //获取好评数
        Example example2 = new Example(ProductComments.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("productId", productId);
        criteria2.andEqualTo("commType", 1);
        int goodTotal = productCommentsMapper.selectCountByExample(example2);
        //获取中评数
        Example example3 = new Example(ProductComments.class);
        Example.Criteria criteria3 = example3.createCriteria();
        criteria3.andEqualTo("productId", productId);
        criteria3.andEqualTo("commType", 0);
        int mediaTotal = productCommentsMapper.selectCountByExample(example3);
        //获取差评数
        Example example4 = new Example(ProductComments.class);
        Example.Criteria criteria4 = example4.createCriteria();
        criteria4.andEqualTo("productId", productId);
        criteria4.andEqualTo("commType", -1);
        int badTotal = productCommentsMapper.selectCountByExample(example4);
        //double格式转换保留两位小数
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        //计算好评率
        String percent = decimalFormat.format((double) goodTotal / (double) total * 100);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("goodTotal", goodTotal);
        map.put("mediaTotal", mediaTotal);
        map.put("badTotal", badTotal);
        map.put("percent", percent);
        return ResultVO.getSuccessVo("查询成功", map);
    }
}
