package com.red.geek.week05.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User
 *
 * @author red
 * @class_name User
 * @date 2021-04-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private Integer age;
}
