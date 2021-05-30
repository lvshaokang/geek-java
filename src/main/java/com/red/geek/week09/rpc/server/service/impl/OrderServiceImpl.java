package com.red.geek.week09.rpc.server.service.impl;


import com.red.geek.week09.rpc.exception.CustomException;
import com.red.geek.week09.rpc.model.Order;
import com.red.geek.week09.rpc.service.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order findById(Integer id) {
        return new Order(1, "RPC", 1);
    }

    @Override
    public Order findError() {
        throw new CustomException("Custom exception");
    }
}
