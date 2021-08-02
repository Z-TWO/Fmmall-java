package com.ztwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 29941
 */
@SpringBootApplication
@MapperScan("com.ztwo.fmmall.dao")
public class SpringDemo1Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringDemo1Application.class, args);
    }

}
