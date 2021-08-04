package com.ztwo.fmmall.dao;


import com.ztwo.fmmall.bean.Product;
import com.ztwo.fmmall.bean.ProductVO;
import com.ztwo.fmmall.general.GeneralDAO;

import java.util.List;

public interface ProductMapper extends GeneralDAO<Product> {

    //获取首页推荐商品
    List<ProductVO> selectRecommendProduct();

    List<ProductVO> selectTop6ByCategory(Integer cid);

}