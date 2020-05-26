package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.bean.Person;
import com.atguigu.config.MyConfigOfPropertyValue;

public class IOCTest_PropertyValue {
	
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigOfPropertyValue.class);

	@Test
	public void test01(){
		printlnBean(applicationContext);
		Person person = (Person) applicationContext.getBean("person");
		System.out.println("======");
		System.out.println(person);
		applicationContext.close();
	}
	
	private void printlnBean(AnnotationConfigApplicationContext applicationContext){
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}
}
