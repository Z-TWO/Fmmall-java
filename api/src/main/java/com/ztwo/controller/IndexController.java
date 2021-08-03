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
@RequestMapping("/index")
public class IndexController {

    @Resource
    private IndexService indexService;

    @ApiOperation("获取轮播图")
    @RequestMapping(value = "/bannerImg", method = RequestMethod.GET)
    public ResultVO listIndexImg() {
        return indexService.listIndexImg();
    }

    @ApiOperation("获取分类信息")
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResultVO listIndexCategory() {
        return indexService.listIndexCategory();
    }

    @ApiOperation("获取推荐商品信息")
    @RequestMapping(value = "/recommendProduct", method = RequestMethod.GET)
    public ResultVO listIndexRecommendProduct() {
        return indexService.listIndexRecommendProduct();
    }
}
