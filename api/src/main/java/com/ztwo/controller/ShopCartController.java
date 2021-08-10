package com.ztwo.controller;

import com.ztwo.fmmall.bean.ShoppingCart;
import com.ztwo.fmmall.service.ShopCartService;
import com.ztwo.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 购物车控制器
 * @Author ZTwo
 * @Date 2021/7/31 20:50
 */
@Api(value = "用户购物车添加、删除、展示", tags = "购物车管理")
@RestController
@CrossOrigin
@RequestMapping("/shop")
public class ShopCartController {

    @Resource
    private ShopCartService shopCartService;

    @ApiOperation("获取用户购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer", name = "userId", value = "用户id", required = true),
            @ApiImplicitParam(dataType = "String", name = "token", value = "token", required = true)
    })
    @RequestMapping(value = "/listShoppingCart", method = RequestMethod.GET)
    public ResultVO listShopCart(Integer userId, @RequestHeader String token) {
        return shopCartService.listShoppingCart(userId);
    }

    @ApiOperation("添加购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "ShoppingCart", name = "shoppingCart", value = "shoppingCart对象", required = true),
            @ApiImplicitParam(dataType = "String", name = "token", value = "token", required = true)
    })
    @RequestMapping(value = "/addShoppingCart", method = RequestMethod.PUT)
    public ResultVO addShopCart(@RequestBody ShoppingCart shoppingCart, @RequestHeader String token) {
        return shopCartService.addShoppingCart(shoppingCart);
    }

    @ApiOperation("修改购物车商品数量")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer", name = "cid", value = "购物车id", required = true),
            @ApiImplicitParam(dataType = "Integer", name = "num", value = "修改后的购买数量", required = true),
            @ApiImplicitParam(dataType = "String", name = "token", value = "token", required = true)
    })
    @RequestMapping(value = "/updateShoppingCart/{cid}/{num}", method = RequestMethod.PUT)
    public ResultVO updateShopCart(@PathVariable("cid") Integer cid, @PathVariable("num") Integer num, @RequestHeader String token) {
        return shopCartService.updateShoppingCartNum(cid, num);
    }
}
