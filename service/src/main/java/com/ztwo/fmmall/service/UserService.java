package com.ztwo.fmmall.service;

import com.ztwo.fmmall.vo.ResultVO;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/7/27 21:33
 */
public interface UserService {

    //用户登陆
    public ResultVO login(String username, String password);

    //用户注册
    public ResultVO register(String username, String password);

}
