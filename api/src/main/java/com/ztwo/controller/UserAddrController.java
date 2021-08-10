package com.ztwo.controller;

import com.ztwo.fmmall.service.UserAddrService;
import com.ztwo.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/10 8:59
 */
@Api(value = "收货地址查询，添加，修改", tags = "收货地址管理")
@RestController
@CrossOrigin
@RequestMapping("/addr")
public class UserAddrController {

    @Resource
    private UserAddrService userAddrService;

    @ApiOperation("获取收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer", name = "uid", value = "用户ID", required = true),
            @ApiImplicitParam(dataType = "String", name = "token", value = "token", required = true)
    })
    @RequestMapping(value = "/listAddr", method = RequestMethod.GET)
    public ResultVO listAddr(Integer uid, @RequestHeader String token) {
        return userAddrService.listAddrByUserId(uid);
    }

}
