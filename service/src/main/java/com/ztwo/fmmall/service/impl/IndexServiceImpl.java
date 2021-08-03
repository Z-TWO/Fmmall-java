package com.ztwo.fmmall.service.impl;

import com.ztwo.fmmall.bean.CategoryVO;
import com.ztwo.fmmall.bean.IndexImg;
import com.ztwo.fmmall.bean.ProductVO;
import com.ztwo.fmmall.dao.CategoryMapper;
import com.ztwo.fmmall.dao.IndexImgMapper;
import com.ztwo.fmmall.dao.ProductMapper;
import com.ztwo.fmmall.service.IndexService;
import com.ztwo.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/2 17:54
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    private IndexImgMapper indexImgMapper;

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private ProductMapper productMapper;

    @Override
    public ResultVO listIndexImg() {
        List<IndexImg> indexImgs = indexImgMapper.selectIndexImgActive();
        if (indexImgs.size() == 0) {
            return ResultVO.getErrorVo("获取失败");
        } else {
            return ResultVO.getSuccessVo("获取成功", indexImgs);
        }
    }

    @Override
    public ResultVO listIndexCategory() {
        List<CategoryVO> categories = categoryMapper.selectAllCategories();
        if (categories == null || categories.size() == 0) {
            return ResultVO.getErrorVo("获取失败");
        } else {
            return ResultVO.getSuccessVo("获取成功", categories);
        }
    }

    @Override
    public ResultVO listIndexRecommendProduct() {
        List<ProductVO> productVOS = productMapper.selectRecommendProduct();
        if (productVOS == null || productVOS.size() == 0) {
            return ResultVO.getErrorVo("获取失败");
        } else {
            return ResultVO.getSuccessVo("获取成功", productVOS);
        }
    }


}
