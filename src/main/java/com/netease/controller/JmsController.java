package com.netease.controller;

import com.netease.service.ProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jms.Destination;

/**
 * Created by miracler on 5/22/16.
 */
@Controller
@RequestMapping("/jms")
public class JmsController {

    @Autowired
    @Qualifier(value = "producerService")
    ProducerServiceImpl producerService;
    @Autowired
    @Qualifier("queueDestination")
    Destination destination;

    @RequestMapping("/toSend")
    public String toSend(){
        return "toSendPage";
    }

    @RequestMapping("/send")
    public String send(ModelMap modelMap, @RequestParam String msg) {
        producerService.sendMsg(destination, msg);
        System.out.println("send success!");
        return "sendPage";
    }


    @Autowired
    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
