package com.red.geek.week09.rpc.service;


import com.red.geek.week09.rpc.model.Order;

public interface OrderService {

    /**
     * find by id
     * @param id id
     * @return order
     */
    Order findById(Integer id);

    /**
     * return exception
     * @return exception
     */
    Order findError();
}
