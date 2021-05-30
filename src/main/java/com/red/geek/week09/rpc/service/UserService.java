package com.red.geek.week09.rpc.service;

import com.red.geek.week09.rpc.model.User;

/**
 * @author lw
 */
public interface UserService {

    /**
     * find by id
     * @param id id
     * @return user
     */
    User findById(Integer id);
}
