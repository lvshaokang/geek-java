package com.red.geek.week05.database.hikari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * HikariApplication
 *
 * @author red
 * @class_name HikariApplication
 * @date 2021-04-18
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.red.geek.week05.database.hikari")
public class HikariApplication {

    public static void main(String[] args) {
        SpringApplication.run(HikariApplication.class, args);
    }
}
