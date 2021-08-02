package com.ztwo.configure;

/**
 * @Description
 * @Author ZTwo
 * @Date 2021/7/28 9:09
 */

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigure {

    //创建封面
    public Docket getDdocket() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("《锋迷商城》后端接口说明")
                .description("此文档详细说明了锋迷商城项目后端接口规范....")
                .version("v 2.0.1")
                .contact(new Contact("ZTwo", "www.ztwo.com", "ztwo@qq.com"));
        ApiInfo apiInfo = apiInfoBuilder.build();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qfedu.fmmall.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
