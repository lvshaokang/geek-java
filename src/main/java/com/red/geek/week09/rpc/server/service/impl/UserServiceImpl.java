package com.red.geek.week09.rpc.server.service.impl;

import com.red.geek.week09.rpc.model.User;
import com.red.geek.week09.rpc.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User findById(Integer id) {
        return new User(id, "RPC");
    }
}
