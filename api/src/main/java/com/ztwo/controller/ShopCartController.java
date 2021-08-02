package com.ztwo.controller;

import com.ztwo.fmmall.util.JwtUtil;
import com.ztwo.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 购物车控制器
 * @Author ZTwo
 * @Date 2021/7/31 20:50
 */
@Api(value = "用户购物车添加、删除、展示", tags = "用户购物车管理")
@RestController
@CrossOrigin
public class ShopCartController {

    @ApiOperation("获取用户购物车")
    @ApiImplicitParam(dataType = "String", name = "token", value = "token用户校验码", required = true)
    @RequestMapping(value = "/user/shopcart", method = RequestMethod.GET)
    public ResultVO listShopCart(String token) {
        return ResultVO.getSuccessVo("购物车列表");
    }
}
