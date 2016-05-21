package com.netease.meta.dao;

import com.netease.AbstractTest;
import com.netease.meta.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by hz-lpf on 16-5-19.
 */
public class UserDaoTest extends AbstractTest {
    @Autowired
    UserDao userDao;
    User user;

    @BeforeTest
    public void setup() {
        user = new User();
        user.setId(1);
        user.setName("test");
        user.setAge(100);
    }

    @Test
    public void testFindByID() {
        User user = userDao.findById(1);
        Assert.assertEquals(user.getName(), "lpf");
    }

    @Test
    public void testInsert() {
        Assert.assertNull(userDao.findById(4));
        userDao.insert(user);
        Assert.assertNotNull(userDao.findById(4));
        user.setId(1);
    }

    @Test
    public void testUpdate() {
        Assert.assertEquals(userDao.findById(1).getName(), "lpf");
        userDao.update(user);
        Assert.assertEquals(userDao.findById(1).getName(), user.getName());
    }

    @Test
    public void deleteByID() {
        Assert.assertNotNull(userDao.findById(1));
        userDao.deleteById(1);
        Assert.assertNull(userDao.findById(1));
    }

}
