package com.ztwo.fmmall;


import com.ztwo.SpringDemo1Application;
import com.ztwo.fmmall.bean.*;
import com.ztwo.fmmall.dao.*;
import com.ztwo.fmmall.service.ProductService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/8/2 17:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDemo1Application.class)
public class Test {
    @Resource
    private ShoppingCartMapper shoppingCartMapper;

    @org.junit.Test
    public void shoppingCartTest() {
        List<ShoppingCartVO> shoppingCartVOS = shoppingCartMapper.listShoppingCartByUserId(6);
        for (ShoppingCartVO shoppingCartVO : shoppingCartVOS) {
            System.out.println(shoppingCartVO);
        }
    }

    @org.junit.Test
    public void shoppingCartTest1() {
        List<Integer> list = new ArrayList<>();
        list.add(29);
        list.add(30);
        List<ShoppingCartVO> shoppingCartVOS = shoppingCartMapper.listShoppingCartByCartIds(list);
        for (ShoppingCartVO shoppingCartVO : shoppingCartVOS) {
            System.out.println(shoppingCartVO);
        }
    }
}
