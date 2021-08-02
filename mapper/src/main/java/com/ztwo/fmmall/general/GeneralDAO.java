package com.ztwo.fmmall.general;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/7/27 21:18
 */
public interface GeneralDAO<T> extends Mapper<T>, MySqlMapper<T> {
}
