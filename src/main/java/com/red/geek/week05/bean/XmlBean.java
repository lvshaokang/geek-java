package com.red.geek.week05.bean;

import kotlin.reflect.KClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * XmlBean
 *
 * @author red
 * @class_name XmlBean
 * @date 2021-04-17
 */
public class XmlBean implements AssembleBean{
    @Override
    public void assemble() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context-bean.xml");
        Klass klass = ctx.getBean("klass", Klass.class);
        klass.dong();
    }

    public static void main(String[] args) {
        XmlBean xmlBean = new XmlBean();
        xmlBean.assemble();
    }
}
