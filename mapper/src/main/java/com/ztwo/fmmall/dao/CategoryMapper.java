package com.ztwo.fmmall.dao;


import com.ztwo.fmmall.bean.Category;
import com.ztwo.fmmall.bean.CategoryVO;
import com.ztwo.fmmall.general.GeneralDAO;

import java.util.List;

public interface CategoryMapper extends GeneralDAO<Category> {

    //查询所有分类和子分类
    List<CategoryVO> selectAllCategories();

    //查询一级分类
    List<CategoryVO> selectFirstLevelCategories();

}