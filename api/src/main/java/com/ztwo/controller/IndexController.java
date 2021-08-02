package com.ztwo.controller;

import com.ztwo.fmmall.service.IndexService;
import com.ztwo.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/2 18:01
 */
@Api(value = "首页轮播图...", tags = "首页管理")
@RestController
@CrossOrigin
public class IndexController {

    @Resource
    private IndexService indexService;

    @ApiOperation("获取轮播图")
    @RequestMapping(value = "/indexImg", method = RequestMethod.GET)
    public ResultVO listIndexImg() {
        return indexService.listIndexImg();
    }
}
