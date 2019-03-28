package com.cn;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-common.xml","classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml","classpath:spring/spring-aop.xml"})
public class BaseTest {

}
