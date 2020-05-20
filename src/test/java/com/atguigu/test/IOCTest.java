package com.atguigu.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;

public class IOCTest {

	
	@Test
	public void test02(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//		for (String name : beanDefinitionNames) {
//			System.out.println(name);
//		}
		System.out.println("ioc容器创建完成...");
		Object bean = applicationContext.getBean("person");
		Object bean2 = applicationContext.getBean("person");
		System.out.println(bean == bean2);
	}
	
//	@SuppressWarnings("resource")
//	@Test
//	public void test01(){
//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
//		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//		for (String name : beanDefinitionNames) {
//			System.out.println(name);
//		}
//	}
}
