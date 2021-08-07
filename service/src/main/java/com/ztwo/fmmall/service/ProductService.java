package com.ztwo.fmmall.service;

import com.ztwo.fmmall.bean.ProductVO;
import com.ztwo.fmmall.vo.ResultVO;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/4 16:18
 */
public interface ProductService {

    //查询指定商品基本信息（简要信息，套餐，图片）---product_id
    ResultVO getProductBasicInfo(String productId);

    //查询商品参数信息---product_id
    ResultVO getProductParams(String productId);

    //查询商品评价分页查询
    ResultVO getProductComment(String productId, Integer pageNum, Integer limit);

    //查询商品评价并统计
    ResultVO analysisProductComment(String productId);
}
