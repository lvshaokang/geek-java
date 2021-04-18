package com.red.geek.week05.start;

import com.red.geek.week05.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * SchoolAutoConfig
 *
 * @author red
 * @class_name SchoolAutoConfig
 * @date 2021-04-18
 */
@Configuration
@EnableConfigurationProperties(SchoolProperties.class)
@PropertySource("classpath:application.yml")
public class SchoolAutoConfig {

    @Autowired
    private SchoolProperties schoolProperties;

    @Bean
    public TargetSchool targetSchool() {
        List<Student> students = schoolProperties.getStudents();
        System.out.println("原始students=" + students);
        return new TargetSchool(students);
    }
}
