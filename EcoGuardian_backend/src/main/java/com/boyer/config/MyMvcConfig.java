package com.boyer.config;

import com.boyer.filter.LoginFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyMvcConfig implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginFilter()).addPathPatterns("/**")
                        .excludePathPatterns("/index.jsp", "/login.jsp", "/login","/js/**","/css/**","/img/**","/fonts/**","/lib/**","/static/**");
    }
}
