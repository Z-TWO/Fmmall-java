package com.ztwo.fmmall.dao;


import com.ztwo.fmmall.bean.ShoppingCart;
import com.ztwo.fmmall.bean.ShoppingCartVO;
import com.ztwo.fmmall.general.GeneralDAO;

import java.util.List;

public interface ShoppingCartMapper extends GeneralDAO<ShoppingCart> {

    //查询购物车记录---userId
    List<ShoppingCartVO> listShoppingCartByUserId(Integer userId);

    //修改购物车商品数量
    Integer updateShoppingCartByCartId(Integer cartId, Integer cartNum);

    //查询购物车记录---cartIds
    List<ShoppingCartVO> listShoppingCartByCartIds(List<Integer> cids);

}