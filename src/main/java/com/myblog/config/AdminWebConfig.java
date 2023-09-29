package com.myblog.config;//package com.myblog.config;
//
//import com.jielim36.springboot04_webpratical.interceptor.LoginInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class AdminWebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())//激活登录拦截器
//                .addPathPatterns("/**")//让用户访问的每个地址都必须验证是否登录(注意：这里同时拦截了静态资源包括css文件)
//                .excludePathPatterns("/","/login","/css/**","/js/**","/fonts/**","/images/**");//除了登入页面
//    }
//}
