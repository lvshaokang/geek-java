package com.red.geek.week05.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AutowiredBean
 *
 * @author red
 * @class_name AutowiredBean
 * @date 2021-04-17
 */
public class AutowiredBean implements AssembleBean {
    @Override
    public void assemble() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context-autowire.xml");
        UserServiceImpl userService = (UserServiceImpl) ctx.getBean("userService");
        userService.printUser(new User("lsk", 20));
    }

    public static void main(String[] args) {
        AutowiredBean autowiredBean = new AutowiredBean();
        autowiredBean.assemble();
    }
}
