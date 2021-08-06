package com.ztwo.fmmall.dao;


import com.ztwo.fmmall.bean.IndexImg;
import com.ztwo.fmmall.general.GeneralDAO;

import java.util.List;

public interface IndexImgMapper extends GeneralDAO<IndexImg> {

    //查询当前status为1且以seq排序
    List<IndexImg> selectIndexImgActive();

}