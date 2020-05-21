package com.atguigu.test;


import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;

public class IOCTest {

	@Test
	public void testImport(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		printBeans(applicationContext);
	}
	
	private void printBeans(ApplicationContext applicationContext){
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}
	/*@SuppressWarnings("resource")
	@Test
	public void test03(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		String[] names = applicationContext.getBeanNamesForType(Person.class);
		for (String name : names) {
			System.out.println(name);
		}
		Map<String, Person> map = applicationContext.getBeansOfType(Person.class);
		System.out.println(map);
		
		//动态获取环境变量的值：Windows 10
		Environment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("os.name");
		System.out.println(property);
	}*/
	
	
	
	/*@Test
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
	}*/
	
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
