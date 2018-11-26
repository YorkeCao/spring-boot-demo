package io.yorkecao.springbootdemo.config;

import io.yorkecao.springbootdemo.interceptor.DemoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Yorke
 */
@EnableWebMvc
@Configuration
public class DemoConfig implements WebMvcConfigurer {

    private final DemoInterceptor demoInterceptor;

    @Autowired
    public DemoConfig(DemoInterceptor demoInterceptor) {
        this.demoInterceptor = demoInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor).addPathPatterns("/**");
    }
}
