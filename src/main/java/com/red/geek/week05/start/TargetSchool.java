package com.red.geek.week05.start;

import com.red.geek.week05.bean.Student;

import java.util.List;

/**
 * TargetSchool
 *
 * @author red
 * @class_name TargetSchool
 * @date 2021-04-18
 */
public class TargetSchool {
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public TargetSchool() {
    }

    public TargetSchool(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "TargetSchool{" +
                "students=" + students +
                '}';
    }
}
