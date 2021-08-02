package com.ztwo.controller;

import com.ztwo.fmmall.bean.Users;
import com.ztwo.fmmall.service.UserService;
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
 * @Date 2021/7/28 8:43
 */
@Api(value = "用户登陆、注册", tags = "用户管理")
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("用户登陆接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户账号", required = true),
            @ApiImplicitParam(dataType = "String", name = "password", value = "用户密码", required = true)
    })
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResultVO login(String username, String password) {
        return userService.login(username, password);
    }

    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "username", value = "用户注册账号", required = true),
            @ApiImplicitParam(dataType = "String", name = "password", value = "用户注册密码", required = true)
    })
    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public ResultVO register(@RequestBody Users user) {
        return userService.register(user.getUsername(), user.getPassword());
    }

}
