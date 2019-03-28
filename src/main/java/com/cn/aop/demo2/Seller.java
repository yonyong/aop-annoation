package com.cn.aop.demo2;

import org.springframework.stereotype.Component;

@Component
public class Seller {
	public void saying(){
		System.out.println("销售人员销售东西");
	}
}
