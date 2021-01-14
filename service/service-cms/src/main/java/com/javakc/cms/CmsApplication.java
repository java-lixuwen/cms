package com.javakc.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @program: javakc-parent
 * @description:
 * @author: Li xuwen
 * @create: 2021-01-11 21:37
 **/
// XZP
@SpringBootApplication
@ComponentScan(basePackages = {"com.javakc"})
@EnableJpaAuditing
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class,args);
    }
}
