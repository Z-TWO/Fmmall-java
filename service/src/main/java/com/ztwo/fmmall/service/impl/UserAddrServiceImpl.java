package com.ztwo.fmmall.service.impl;

import com.ztwo.fmmall.bean.UserAddr;
import com.ztwo.fmmall.dao.UserAddrMapper;
import com.ztwo.fmmall.service.UserAddrService;
import com.ztwo.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/10 8:52
 */
@Service
public class UserAddrServiceImpl implements UserAddrService {

    @Resource
    private UserAddrMapper userAddrMapper;

    @Override
    public ResultVO listAddrByUserId(Integer userId) {
        if (userId == null || userId == 0) {
            return ResultVO.getErrorVo("参数错误");
        } else {
            Example example = new Example(UserAddr.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userId", userId);
            criteria.andEqualTo("status", 1);
            List<UserAddr> userAddrs = userAddrMapper.selectByExample(example);
            return ResultVO.getSuccessVo("查询成功", userAddrs);
        }
    }
}
