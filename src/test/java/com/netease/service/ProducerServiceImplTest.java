package com.netease.service;

import com.netease.service.impl.ProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.Test;

import javax.jms.Destination;

/**
 * Created by miracler on 5/21/16.
 */

@WebAppConfiguration
@ContextConfiguration(value = "classpath:modules/applicationContext-jms.xml")
public class ProducerServiceImplTest extends AbstractTestNGSpringContextTests {


    @Autowired
    @Qualifier(value = "producerService")
    ProducerServiceImpl producerService;
    @Autowired
    @Qualifier("queueDestination")
    Destination destination;

    @Test
    public void testProducer() {
        producerService.sendMsg(destination, "hello from jms producers");
    }
}
