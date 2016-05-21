package com.netease.service;

import com.netease.AbstractTest;
import com.netease.meta.bean.User;
import com.netease.meta.dao.UserDao;
import com.netease.service.impl.UserServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by hz-lpf on 16-5-20.
 */
public class UserServiceTest extends AbstractTest {

    @Mock
    UserDao userDao;

    @InjectMocks
    UserService userService = new UserServiceImpl();

    User user = new User();
    @BeforeTest
    public void setup() {
        MockitoAnnotations.initMocks(this);
        user.setId(1);
        user.setName("test");
        user.setAge(100);
    }

    @Test
    public void testInsert() {
        Mockito.when(userDao.insert(user)).thenReturn(1);
        Assert.assertEquals(userService.insert(user) ,1);
    }

    @Test
    public void testDeleteById() {
        Mockito.when(userDao.deleteById(1)).thenReturn(1);
        Assert.assertEquals(userService.deleteById(1), 1);
    }
    @Test
    public void testUpdate() {
        Mockito.when(userDao.update(user)).thenReturn(1);
        Assert.assertEquals(userService.update(user), 1);
    }
    @Test
    public void testFindById() {
        Mockito.when(userDao.findById(1)).thenReturn(user);
        Assert.assertEquals(userService.findById(1),user);
    }
}
