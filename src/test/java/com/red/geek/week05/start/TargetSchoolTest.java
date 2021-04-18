package com.red.geek.week05.start;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TargetSchoolTest
 *
 * @author red
 * @class_name TargetSchoolTest
 * @date 2021-04-18
 */
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolAutoConfig.class)
public class TargetSchoolTest {

    @Autowired
    TargetSchool targetSchool;

    @Test
    public void test() {
        System.out.println(targetSchool.toString());
    }
}
