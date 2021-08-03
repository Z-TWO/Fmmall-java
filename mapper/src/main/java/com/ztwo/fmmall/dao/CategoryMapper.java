package com.ztwo.fmmall.dao;


import com.ztwo.fmmall.bean.Category;
import com.ztwo.fmmall.bean.CategoryVO;
import com.ztwo.fmmall.general.GeneralDAO;

import java.util.List;

public interface CategoryMapper extends GeneralDAO<Category> {

    //连接查询
    List<CategoryVO> selectAllCategories();

    //子查询
    List<CategoryVO> selectAllCategoriesById();

}