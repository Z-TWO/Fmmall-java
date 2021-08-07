package com.ztwo.fmmall.service;

import com.ztwo.fmmall.bean.ShoppingCart;
import com.ztwo.fmmall.vo.ResultVO;

/**
 * @Description 购物车服务类
 * @Author ZTwo
 * @Date 2021/8/7 13:45
 */
public interface ShopCartService {

    //添加购物车
    ResultVO addShoppingCart(ShoppingCart shoppingCart);
}
