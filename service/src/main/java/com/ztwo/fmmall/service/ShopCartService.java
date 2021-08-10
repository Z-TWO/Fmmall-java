package com.ztwo.fmmall.service;

import com.ztwo.fmmall.bean.ShoppingCart;
import com.ztwo.fmmall.vo.ResultVO;

import java.util.List;

/**
 * @Description 购物车服务类
 * @Author ZTwo
 * @Date 2021/8/7 13:45
 */
public interface ShopCartService {

    //添加购物车
    ResultVO addShoppingCart(ShoppingCart shoppingCart);

    //获取购物车记录---userId
    ResultVO listShoppingCart(Integer userId);

    //获取购物车记录---cartId
    ResultVO listShoppingCart(String cids);

    //修改购物车商品数量
    ResultVO updateShoppingCartNum(Integer cartId, Integer num);
}
