package com.netease.controller;

import com.netease.meta.bean.User;
import com.netease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hz-lpf on 16-5-19.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @RequestMapping(value = "/form")
    public String form(ModelMap modelmap) {
        return "formPage";
    }

    @RequestMapping("/success")
    public String form(ModelMap modelMap,@RequestParam String name,@RequestParam int age){
        modelMap.addAttribute("name",name);
        modelMap.addAttribute("age",age);
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userService.insert(user);
        System.out.println("*******");
        return "successResult";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
