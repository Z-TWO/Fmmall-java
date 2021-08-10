package com.ztwo.fmmall.service;

import com.ztwo.fmmall.bean.UserAddr;
import com.ztwo.fmmall.vo.ResultVO;

import java.util.List;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/10 8:49
 */
public interface UserAddrService {

    //查询收获地址---userId
    ResultVO listAddrByUserId(Integer userId);
}
