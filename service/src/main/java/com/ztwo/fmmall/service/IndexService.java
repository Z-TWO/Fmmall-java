package com.ztwo.fmmall.service;

import com.ztwo.fmmall.vo.ResultVO;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/2 17:49
 */
public interface IndexService {

    //获取首页banner轮播图
    ResultVO listIndexImg();

    //获取首页分类
    ResultVO listIndexCategory();

    //获取首页推荐商品
    ResultVO listIndexRecommendProduct();

    //获取首页分类中的前6销量产品
    ResultVO listIndexTop6CategoryProduct();
}
