package com.ztwo.fmmall;


import com.ztwo.SpringDemo1Application;
import com.ztwo.fmmall.bean.IndexImg;
import com.ztwo.fmmall.dao.IndexImgMapper;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
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
    private IndexImgMapper indexImgMapper;

    @org.junit.Test
    public void mapperTest() {
        List<IndexImg> indexImgs = indexImgMapper.selectIndexImgActive();
        for (IndexImg indexImg : indexImgs) {
            System.out.println(indexImg);
        }
    }
}
