package com.atguigu.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Dog {

	public Dog(){
		System.out.println("dog...constructor...");
	}

	//对象创建并赋值之后调用
	@PostConstruct
	public void init(){
		System.out.println("dog...@PostConstruct...");
	}
	
	//容器移除对象之前调用
	@PreDestroy
	public void destroy(){
		System.out.println("dog...@PreDestroy...");
	}
	
}
