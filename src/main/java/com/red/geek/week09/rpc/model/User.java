package com.red.geek.week09.rpc.model;

import lombok.Data;

/**
 * @author lw
 */
@Data
public class User {

    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
