package com.org.config;

import com.org.compent.LoginInterceptor;
import com.org.compent.MylocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Locale;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver MyviewResolver(){
        return new MyviewResolver();
    }

    public class  MyviewResolver implements ViewResolver {

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }

        @Bean
        public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){

            WebMvcConfigurerAdapter  webMvcConfigurerAdapter=new WebMvcConfigurerAdapter() {
                @Override
                public void addViewControllers(ViewControllerRegistry registry) {
                   registry.addViewController("/").setViewName("login");
                    registry.addViewController("/login.html").setViewName("login");
                    registry.addViewController("/main.html").setViewName("dashboard");
                }

                @Override
                public void addInterceptors(InterceptorRegistry registry) {
                    registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                                                                   .excludePathPatterns("/","/login.html","/user/login");
                }
            };
            return webMvcConfigurerAdapter;
        }

        @Bean
        public LocaleResolver localeResolver(){
         return    new MylocalResolver();
        }
    }


}
