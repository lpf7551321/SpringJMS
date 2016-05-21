package com.netease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by hz-lpf on 16-5-19.
 */
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class AbstractTest extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private WebApplicationContext wac;
}
