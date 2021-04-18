package com.red.geek.week05.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AnnotationBean
 *
 * @author red
 * @class_name AnnotationBean
 * @date 2021-04-17
 */
//@Slf4j
public class AnnotationBean implements AssembleBean {
    @Override
    public void assemble() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(BeanConfig.class);
        ctx.refresh();

        User registerUserBean = ctx.getBean("registerUserBean", User.class);
        System.out.println(registerUserBean.toString());
    }
}
