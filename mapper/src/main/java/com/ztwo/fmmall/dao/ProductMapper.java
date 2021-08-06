package com.ztwo.fmmall.dao;


import com.ztwo.fmmall.bean.Product;
import com.ztwo.fmmall.bean.ProductVO;
import com.ztwo.fmmall.general.GeneralDAO;

import java.util.List;

public interface ProductMapper extends GeneralDAO<Product> {

    //查询最近上架前3个商品
    List<ProductVO> selectRecommendProduct();

    //查询指定分类的销售量前6的商品
    List<ProductVO> selectTop6ByCategory(Integer cid);

}