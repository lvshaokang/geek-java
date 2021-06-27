package com.red.geek.week12;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * TODO:
 *
 * @author red
 * @class_name JmsProducer
 * @date 2021-06-27
 */
@Component
public class JmsProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(final String topic, final String message) {
        Map map = new Gson().fromJson(message, Map.class);
        jmsTemplate.convertAndSend(topic, map);
    }
}
