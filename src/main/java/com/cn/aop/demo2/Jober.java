package com.cn.aop.demo2;

import org.springframework.stereotype.Component;

@Component
public class Jober {
	@Log(operationType="jober操作",operationName="写代码吧")
	@CardNeed
	public void saying(){
		System.out.println("工人工作");
	}
}
