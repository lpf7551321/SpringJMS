package com.netease.controller;

import com.netease.AbstractTest;
import com.netease.meta.bean.User;
import com.netease.service.UserService;
import com.netease.service.impl.UserServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by hz-lpf on 16-5-20.
 */
public class UserControllerTest extends AbstractTest {
    @Mock
    UserServiceImpl userService;
    @InjectMocks
    UserController userController = new UserController();

    protected MockMvc mockMvc;

    @BeforeTest
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        User user = new User();
        user.setId(1);
        user.setName("test");
        user.setAge(100);
        Mockito.when(userService.insert(user)).thenReturn(1);
    }

    @Test
    public void testForm() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/form")).
                andExpect(MockMvcResultMatchers.view().name("formPage")).andReturn();
        Assert.assertEquals(mvcResult.getModelAndView().getViewName(), "formPage");
    }
    @Test
    public void testSuccess() throws Exception {
        MvcResult resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/user/success?name=ttest&age=100"))
                .andExpect(MockMvcResultMatchers.view().name("successResult"))
                .andExpect(MockMvcResultMatchers.model().attribute("name","ttest"))
                .andExpect(MockMvcResultMatchers.model().attribute("age",100))
                .andReturn();

    }
}
