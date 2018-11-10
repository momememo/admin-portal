package com.baiwang.admin.portal.common.config;

import com.baiwang.admin.portal.common.filter.RequestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description: 初始化配置
 * @author: liyunfei
 * @date: 2018/8/28 21:27
 */
@Configuration
public class InitializerConfiguration extends WebMvcConfigurationSupport {


    @Bean
    public FilterRegistrationBean filterRegistration() {
        RequestFilter requestFilter = new RequestFilter();
        FilterRegistrationBean registration = new FilterRegistrationBean(requestFilter);
        registration.addUrlPatterns("/method/*");
        return registration;
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        super.addResourceHandlers(registry);
    }


}
