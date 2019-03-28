package com.cn.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cn.BaseTest;
import com.cn.entity.User;

import junit.framework.Assert;

public class UserServiceTest extends BaseTest{
	
	@Autowired
	UserService userService;
	
	@Test
	public void testUueryUser(){
		List<User> list =  userService.queryUser();
		//Assert.assertEquals(2, list.size());
		System.out.println("userList.size()="+list.size());
	}

}
