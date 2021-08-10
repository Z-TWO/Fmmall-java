package com.ztwo.fmmall.service.impl;

import com.ztwo.fmmall.bean.ShoppingCart;
import com.ztwo.fmmall.bean.ShoppingCartVO;
import com.ztwo.fmmall.dao.ShoppingCartMapper;
import com.ztwo.fmmall.service.ShopCartService;
import com.ztwo.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/7 13:47
 */
@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Resource
    private ShoppingCartMapper shoppingCartMapper;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    @Override
    public ResultVO addShoppingCart(ShoppingCart shoppingCart) {
        shoppingCart.setCartTime(simpleDateFormat.format(new Date()));
        int i = shoppingCartMapper.insertUseGeneratedKeys(shoppingCart);
        if (i > 0) {
            return ResultVO.getSuccessVo("添加成功");
        } else {
            return ResultVO.getErrorVo("添加失败");
        }
    }

    @Override
    public ResultVO listShoppingCart(Integer userId) {
        if (userId == null || userId == 0) {
            return ResultVO.getErrorVo("参数错误");
        } else {
            List<ShoppingCartVO> shoppingCartVOS = shoppingCartMapper.listShoppingCartByUserId(userId);
            return ResultVO.getSuccessVo("查询成功", shoppingCartVOS);
        }
    }

    @Override
    public ResultVO updateShoppingCartNum(Integer cartId, Integer cartNum) {
        if (cartId == null || cartId == 0 || cartNum == null || cartNum == 0) {
            return ResultVO.getErrorVo("参数错误");
        } else {
            Integer i = shoppingCartMapper.updateShoppingCartByCartId(cartId, cartNum);
            if (i > 0) {
                return ResultVO.getSuccessVo("修改成功");
            } else {
                return ResultVO.getErrorVo("修改失败");
            }
        }
    }
}
