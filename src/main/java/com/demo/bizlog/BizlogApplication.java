package com.demo.bizlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:spring.xml"})
public class BizlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BizlogApplication.class, args);
    }

}

