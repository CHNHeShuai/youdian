package com.youdian.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author hs
 * @date 2019/3/23 - 16:59
 */
@Component
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(new LoginInterceptor());
        interceptor.addPathPatterns("/**");
        interceptor.excludePathPatterns("/youdian/login");
        interceptor.excludePathPatterns("/youdian/toLogin");

        interceptor.excludePathPatterns("/youdian/getBanner");
        interceptor.excludePathPatterns("/youdian/getCompany");
        interceptor.excludePathPatterns("/youdian/getZhaopin");
        interceptor.excludePathPatterns("/youdian/getCategory");
        interceptor.excludePathPatterns("/youdian/getExampleByCid");
        interceptor.excludePathPatterns("/youdian/getExampleList");
        interceptor.excludePathPatterns("/youdian/getExampleById");
        interceptor.excludePathPatterns("/youdian/getState");
        interceptor.excludePathPatterns("/youdian/getStateById");
        interceptor.excludePathPatterns("/youdian/getStateByDesc");
        interceptor.excludePathPatterns("/youdian/addCustomer");
        interceptor.excludePathPatterns("/youdian/getFriend");
        interceptor.excludePathPatterns("/youdian/getWelfare");
    }
}
