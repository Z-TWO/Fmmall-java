package com.ztwo.fmmall.service.impl;

import com.ztwo.fmmall.bean.Users;
import com.ztwo.fmmall.dao.UsersMapper;
import com.ztwo.fmmall.service.UserService;
import com.ztwo.fmmall.util.JwtUtil;
import com.ztwo.fmmall.util.Md5Util;
import com.ztwo.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/7/27 21:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public ResultVO login(String username, String password) {
        ResultVO resultVO;
        //判断是否为空
        if (username == null || password == null) {
            resultVO = ResultVO.getErrorVo("参数错误");
            return resultVO;
        }
        //数据库查询
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        List<Users> users = usersMapper.selectByExample(example);
        //登陆判断
        if (users.size() == 0) {
            resultVO = ResultVO.getErrorVo("登陆失败，用户不存在");
        } else {
            //加密password
            String encodePwd = Md5Util.encode(password);
            //密码校验
            Users user = users.get(0);
            if (user.getPassword().equals(encodePwd)) {
                //生成token
                String token = JwtUtil.createToken(user.getUsername(), user.getPassword());
                //返回token和user对象
                resultVO = ResultVO.getSuccessVo(token, user);
            } else {
                resultVO = ResultVO.getErrorVo("登陆失败，账号密码有误");
            }
        }

        return resultVO;
    }

    @Override
    @Transactional
    public ResultVO register(String username, String password) {
        ResultVO resultVO;
        if (username == null || password == null) {
            resultVO = ResultVO.getErrorVo("参数错误");
            return resultVO;
        }
        //数据库查询
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        List<Users> users = usersMapper.selectByExample(example);
        //注册判断
        if (users.size() > 0) {
            resultVO = ResultVO.getErrorVo("注册失败，用户已存在");
        } else {
            Users user = new Users();
            //密码加密
            String encodePwd = Md5Util.encode(password);
            user.setUsername(username);
            user.setPassword(encodePwd);
            user.setUserImg("img/default.jpg");
            user.setUserRegtime(new Date());
            user.setUserModtime(new Date());
            int result = usersMapper.insert(user);
            if (result > 0) {
                resultVO = ResultVO.getSuccessVo("注册成功", user);
            } else {
                resultVO = ResultVO.getErrorVo("注册失败");
            }
        }
        return resultVO;
    }
}
