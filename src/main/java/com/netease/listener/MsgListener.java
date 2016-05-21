package com.netease.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by miracler on 5/21/16.
 */
public class MsgListener implements MessageListener {
    private final Logger LOGGER = LoggerFactory.getLogger(MsgListener.class);

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(textMessage.getText());
        } catch (JMSException e) {
            LOGGER.error("listening occur error", e);
        }
    }
}
