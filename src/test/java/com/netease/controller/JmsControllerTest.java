package com.netease.controller;

import com.netease.AbstractTest;
import com.netease.service.ProducerServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.jms.Destination;

/**
 * Created by miracler on 5/22/16.
 */

public class JmsControllerTest extends AbstractTest {

    @Mock
    private Destination destination;
    @Mock
    private ProducerServiceImpl producerService;

    @InjectMocks
    private JmsController jmsController = new JmsController();
    MockMvc mockMvc;

    @BeforeTest
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(jmsController).build();

    }

    @Test
    public void testToSend() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/jms/toSend"))
                .andExpect(MockMvcResultMatchers.view().name("toSendPage")).andReturn();
    }

    @Test
    public void testSend() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/jms/send").param("msg","hello"))
                .andExpect(MockMvcResultMatchers.view().name("sendPage")).andReturn();
    }
}
