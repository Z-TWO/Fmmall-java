package com.ztwo.fmmall.service;

import com.ztwo.fmmall.bean.ProductVO;
import com.ztwo.fmmall.vo.ResultVO;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/4 16:18
 */
public interface ProductService {
    //查询指定商品基本信息（参数，套餐，图片）---product_id
    ResultVO getProductBasicInfo(Integer productId);
}
