package com.ztwo.controller;

import com.ztwo.fmmall.service.ProductService;
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
 * @Date 2021/8/4 16:44
 */
@Api(value = "商品信息获取", tags = "商品管理")
@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @ApiOperation("获取商品基本信息")
    @ApiImplicitParam(dataType = "String", name = "pid", value = "商品ID", required = true)
    @RequestMapping(value = "/productBasicInfo/{pid}", method = RequestMethod.GET)
    public ResultVO getProductBasicInfo(@PathVariable("pid") String pid) {
        return productService.getProductBasicInfo(pid);
    }

    @ApiOperation("获取商品参数信息")
    @ApiImplicitParam(dataType = "String", name = "pid", value = "商品ID", required = true)
    @RequestMapping(value = "/productParams/{pid}", method = RequestMethod.GET)
    public ResultVO getProductParams(@PathVariable("pid") String pid) {
        return productService.getProductParams(pid);
    }

    @ApiOperation("获取商品评价信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "pid", value = "商品ID", required = true),
            @ApiImplicitParam(dataType = "Integer", name = "limit", value = "每页的结果数", required = false),
            @ApiImplicitParam(dataType = "Integer", name = "pageNum", value = "页数", required = false)
    })
    @RequestMapping(value = "/productComment/{pid}", method = RequestMethod.GET)
    public ResultVO getProductComment(@PathVariable("pid") String pid, Integer pageNum, Integer limit) {
        return productService.getProductComment(pid, pageNum, limit);
    }

    @ApiOperation("获取商品评价统计数据")
    @ApiImplicitParam(dataType = "String", name = "pid", value = "商品ID", required = true)
    @RequestMapping(value = "/productCommentPercent/{pid}", method = RequestMethod.GET)
    public ResultVO getProductCommentPercent(@PathVariable("pid") String pid) {
        return productService.analysisProductComment(pid);
    }

}
