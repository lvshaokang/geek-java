package com.red.geek.week05.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO:
 *
 * @author red
 * @class_name BeanConfig
 * @date 2021-04-17
 */
public class BeanConfig {

    @Bean(name = "registerUserBean")
    public User registerUserBean() {
        User user = new User("red", 20);
        return user;
    }

}
