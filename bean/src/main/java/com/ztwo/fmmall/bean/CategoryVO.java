package com.ztwo.fmmall.bean;

import java.util.List;

/**
 * @Description 首页分类视图视图对象
 * @Author ZTwo
 * @Date 2021/8/3 9:17
 */
public class CategoryVO extends Category {

    private List<CategoryVO> categoryList;

    public List<CategoryVO> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryVO> categoryList) {
        this.categoryList = categoryList;
    }
}
