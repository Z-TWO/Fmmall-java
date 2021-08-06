package com.ztwo.fmmall;


import com.ztwo.SpringDemo1Application;
import com.ztwo.fmmall.bean.*;
import com.ztwo.fmmall.dao.CategoryMapper;
import com.ztwo.fmmall.dao.IndexImgMapper;
import com.ztwo.fmmall.dao.ProductMapper;
import com.ztwo.fmmall.service.ProductService;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/2 17:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDemo1Application.class)
public class Test {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private ProductMapper productMapper;


    @org.junit.Test
    public void CategoryMapperTest() {
        List<CategoryVO> categories1 = categoryMapper.selectAllCategories();
        for (CategoryVO c1 : categories1) {
            System.out.println(c1);
            for (CategoryVO c2 : c1.getCategoryList()) {
                System.out.println("\t" + c2);
                for (CategoryVO c3 : c2.getCategoryList()) {
                    System.out.println("\t\t" + c3);
                }
            }
        }
    }

    @org.junit.Test
    public void RecommendProductTest() {
        List<ProductVO> productVOS = productMapper.selectRecommendProduct();
        for (ProductVO productVO : productVOS) {
            System.out.println(productVO);
        }
    }

    @org.junit.Test
    public void Top6ProductTest() {
        List<CategoryVO> categories = categoryMapper.selectFirstLevelCategories();
        for (CategoryVO category : categories) {
            System.out.println(category);
            for (ProductVO productVO : category.getProductVOList()) {
                System.out.println("\t"+productVO);
                for (ProductImg productImg : productVO.getImgList()) {
                    System.out.println("\t\t"+productImg);
                }
            }
        }
    }

    @Resource
    private ProductService productService;

    @org.junit.Test
    public void SelectProductTest() {
        productService.getProductBasicInfo(1);
    }
}
