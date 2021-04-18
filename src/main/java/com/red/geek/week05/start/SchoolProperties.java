package com.red.geek.week05.start;

import com.red.geek.week05.bean.Student;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * SchoolProperties
 *
 * @author red
 * @class_name School
 * @date 2021-04-18
 */
@ConfigurationProperties(prefix = "school")
public class SchoolProperties {
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
