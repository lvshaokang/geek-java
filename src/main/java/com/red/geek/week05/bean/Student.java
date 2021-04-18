package com.red.geek.week05.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Student
 *
 * @author red
 * @class_name Student
 * @date 2021-04-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String studentName;
    private Integer studentAge;
}
