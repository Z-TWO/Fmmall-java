package com.ztwo.fmmall.dao;


import com.ztwo.fmmall.bean.ProductComments;
import com.ztwo.fmmall.bean.ProductCommentsVO;
import com.ztwo.fmmall.general.GeneralDAO;

import java.util.List;

public interface ProductCommentsMapper extends GeneralDAO<ProductComments> {

    List<ProductCommentsVO> selectProductCommentByProductId(String productId, Integer start, Integer limit);

}