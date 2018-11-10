package com.baiwang.admin.portal;

import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableCaching
@EnableFeignClients
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class AdminPortalApplication {


    public static void main(String[] args) {
        SpringApplication.run(AdminPortalApplication.class, args);

        File file = new File("D:/temp/upload");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

}
