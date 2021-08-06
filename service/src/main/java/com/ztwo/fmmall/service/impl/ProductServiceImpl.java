package com.ztwo.fmmall.service.impl;

import com.ztwo.fmmall.bean.Product;
import com.ztwo.fmmall.bean.ProductImg;
import com.ztwo.fmmall.bean.ProductSku;
import com.ztwo.fmmall.dao.ProductImgMapper;
import com.ztwo.fmmall.dao.ProductMapper;
import com.ztwo.fmmall.dao.ProductSkuMapper;
import com.ztwo.fmmall.service.ProductService;
import com.ztwo.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
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

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ResultVO getProductBasicInfo(Integer productId) {
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
}
