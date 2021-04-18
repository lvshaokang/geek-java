package com.red.geek.week05.bean;

import lombok.Data;

import java.util.List;

/**
 * Klass
 *
 * @author red
 * @class_name Klass
 * @date 2021-04-17
 */
@Data
public class Klass {
    List<Student> students;

    public void dong() {
        System.out.println(this.getStudents());
    }
}
