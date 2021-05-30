package com.red.geek.week09.rpc.server.config;


import com.red.geek.week09.rpc.server.service.impl.OrderServiceImpl;
import com.red.geek.week09.rpc.server.service.impl.UserServiceImpl;
import com.red.geek.week09.rpc.service.OrderService;
import com.red.geek.week09.rpc.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean("com.example.demo.service.UserService")
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean("com.example.demo.service.OrderService")
    public OrderService orderService() {
        return new OrderServiceImpl();
    }
}
