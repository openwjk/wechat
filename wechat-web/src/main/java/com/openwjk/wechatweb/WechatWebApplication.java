package com.openwjk.wechatweb;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.openwjk")
@MapperScan(basePackages = {"com.openwjk.wechatdao.dao.mapper"}, annotationClass = Mapper.class)
public class WechatWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WechatWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WechatWebApplication.class);
    }
}
