package com.youdian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author hs
 * @date 2019/3/4 - 14:58
 */
@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/youdian/toLogin").setViewName("login");
                registry.addViewController("/youdian/index").setViewName("index");
                registry.addViewController("/youdian/toUpdatePassword").setViewName("updatePassword");
            }
        };
        return webMvcConfigurerAdapter;
    }
}
