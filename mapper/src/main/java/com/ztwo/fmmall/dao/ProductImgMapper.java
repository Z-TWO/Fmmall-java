package com.ztwo.fmmall.dao;


import com.ztwo.fmmall.bean.ProductImg;
import com.ztwo.fmmall.general.GeneralDAO;

import java.util.List;

public interface ProductImgMapper extends GeneralDAO<ProductImg> {

    //查询商品的图片---id
    List<ProductImg> selectProductImgById(Integer ProductId);

}