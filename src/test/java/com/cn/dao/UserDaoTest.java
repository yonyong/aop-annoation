package com.cn.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cn.BaseTest;
import com.cn.entity.User;

import junit.framework.Assert;

public class UserDaoTest extends BaseTest{
	
	@Autowired
	UserDao userDao;
	
	@Test
	public void testQueryUser(){
		List<User> userList = userDao.queryUser();
		//Assert.assertEquals(2, userList.size());
		System.out.println("userList.size()="+userList.size());
	}

}
