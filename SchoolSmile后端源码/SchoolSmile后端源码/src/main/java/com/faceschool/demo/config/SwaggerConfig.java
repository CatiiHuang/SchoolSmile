package com.faceschool.demo.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ConditionalOnClass(Docket.class)
@EnableSwagger2
@ComponentScan(basePackages = { "com.faceschool.demo.controller" })
public class SwaggerConfig {

    @Bean
    public Docket buildDocket() {
        System.out.println("======  SWAGGER CONFIG  ======");
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//调用下面apiInfo()方法
                .select()
                //Controller所在路径
                .apis(RequestHandlerSelectors.basePackage("com.faceschool.demo.controller"))
                .paths(PathSelectors.any())
                .build();

    }

    public ApiInfo apiInfo() {
        return  new ApiInfoBuilder()
                .title("faceschool springboot结合swagger2构建Restful API")
                .description("faceschool接口文档")
                .termsOfServiceUrl("www.baidu.com")

                .version("0.0.1")
                .build();

    }
}

