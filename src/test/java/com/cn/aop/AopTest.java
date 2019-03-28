package com.cn.aop;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cn.BaseTest;
import com.cn.aop.demo2.Jober;
import com.cn.aop.demo2.Seller;

public class AopTest extends BaseTest{
	
	/*@Resource(name="hello1")
	HelloWorld helloWorldImpl1;
	
	@Resource(name="hello2")
	HelloWorld helloWorldImpl2;
	
	@Resource(name="java")
	Worker java;
	
	@Resource(name="ios")
	Worker ios;
	
	@Test
	@Ignore
	public void myTest(){
		helloWorldImpl1.printHelloWorld();
		helloWorldImpl1.doPrint();
		helloWorldImpl2.printHelloWorld();
		helloWorldImpl2.doPrint();
	}
	
	@Test
	public void myTest2(){
		java.work();
		ios.work();
	}*/
	
	
	@Autowired
	Jober jober;

	@Autowired
	Seller seller;
	
	@Test
	public void myTest(){
		jober.saying();
		seller.saying();
	}
	

}
