package com.red.geek.week12;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * TODO:
 *
 * @author red
 * @class_name JmsConsumer
 * @date 2021-06-27
 */
@Component
public class JmsConsumer {
    @JmsListener(destination = "activeTest")
    public void receiveMessage(final Map message) {
        System.out.println(message.toString());
    }
}
