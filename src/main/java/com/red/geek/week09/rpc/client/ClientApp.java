package com.red.geek.week09.rpc.client;

import com.red.geek.week09.rpc.model.Order;
import com.red.geek.week09.rpc.model.User;
import com.red.geek.week09.rpc.proxy.RpcByteBuddy;
import com.red.geek.week09.rpc.proxy.RpcClient;
import com.red.geek.week09.rpc.proxy.RpcClientJdk;
import com.red.geek.week09.rpc.service.OrderService;
import com.red.geek.week09.rpc.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientApp {

    public static void main(String[] args) {

        RpcClient jdk = new RpcClientJdk();
        UserService userService = jdk.create(UserService.class, "http://localhost:8080/");
        User user = userService.findById(1);
        if (user == null) {
            log.info("Clint service invoke Error");
            return;
        }
        System.out.println("find user id=1 from server: " + user.getName());

        RpcClient buddy = new RpcByteBuddy();
        OrderService orderService = buddy.create(OrderService.class, "http://localhost:8080/");
        Order order = orderService.findById(1992129);
        if (order == null) {
            log.info("Clint service invoke Error");
            return;
        }
        System.out.println(String.format("find order name=%s, user=%d",order.getName(),order.getUserId()));

//        order = orderService.findError();
//        if (order == null) {
//            log.info("Clint service invoke Error");
//        }
    }

}
