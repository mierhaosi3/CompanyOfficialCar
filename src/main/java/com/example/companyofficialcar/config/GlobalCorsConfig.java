package com.example.companyofficialcar.config;

import com.example.companyofficialcar.filter.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Configuration
@EnableWebMvc
public class GlobalCorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .exposedHeaders("*")
                .allowCredentials(true);
    }
    private TokenInterceptor tokenInterceptor;
    //构造方法
    public GlobalCorsConfig(TokenInterceptor tokenInterceptor){
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer){
        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3)));
        configurer.setDefaultTimeout(30000);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        //排除拦截，除了注册登录(此时还没token)，其他都拦截
//        excludePath.add("/approvalrecords");  //登录
//        excludePath.add("/user");  //登录
//        excludePath.add("/carend");  //登录
//        excludePath.add("/carrequests");  //登录
//        excludePath.add("/dispatchprocess");  //登录
//        excludePath.add("/fleet");  //登录
//        excludePath.add("/statistics");  //登录
//        excludePath.add("/vehicles");  //登录
        excludePath.add("/**");  //登录

        excludePath.add("/img/**");  //静态资源
        excludePath.add("/song/**");  //静态资源

        registry.addInterceptor(tokenInterceptor)
//                .addPathPatterns("/drivers")
                .excludePathPatterns(excludePath);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
