package com.ztwo.fmmall.bean;

import java.util.List;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/3 16:57
 */
public class ProductVO extends Product {
    private List<ProductImg> imgList;

    public List<ProductImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<ProductImg> imgList) {
        this.imgList = imgList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
