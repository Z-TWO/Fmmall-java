package com.ztwo.controller;

import com.ztwo.fmmall.service.ProductService;
import com.ztwo.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
    @ApiImplicitParam(dataType = "Integer", name = "pid", value = "商品ID", required = true)
    @RequestMapping(value = "/productBasicInfo/{pid}", method = RequestMethod.GET)
    public ResultVO getProductBasicInfo(@PathVariable("pid") Integer pid) {
        return productService.getProductBasicInfo(pid);
    }

}
