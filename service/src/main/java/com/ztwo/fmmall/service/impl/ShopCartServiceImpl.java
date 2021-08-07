package com.ztwo.fmmall.service.impl;

import com.ztwo.fmmall.bean.ShoppingCart;
import com.ztwo.fmmall.dao.ShoppingCartMapper;
import com.ztwo.fmmall.service.ShopCartService;
import com.ztwo.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/7 13:47
 */
@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Resource
    private ShoppingCartMapper shoppingCartMapper;


    @Override
    public ResultVO addShoppingCart(ShoppingCart shoppingCart) {
        int i = shoppingCartMapper.insertUseGeneratedKeys(shoppingCart);
        if (i > 0) {
            return ResultVO.getSuccessVo("添加成功");
        }else{
            return ResultVO.getErrorVo("添加失败");
        }
    }
}
