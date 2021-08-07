package com.ztwo.fmmall.util;

import java.util.List;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/6 10:27
 */
public class PageHelper<T> {

    //总记录数
    private Integer count;

    //总页数
    private Integer pageCount;

    //分页数据
    private List<T> list;

    public PageHelper(){}

    public PageHelper(Integer count, Integer pageCount, List<T> list) {
        this.count = count;
        this.pageCount = pageCount;
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
