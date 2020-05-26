package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.config.MainConfigOfAutowired;
import com.atguigu.dao.BookDao;
import com.atguigu.service.BookService;

public class IOCTest_Autowired {

	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

	@Test
	public void test01(){
		BookService bean = applicationContext.getBean(BookService.class);
		System.out.println(bean);
		
//		BookDao bean2 = applicationContext.getBean(BookDao.class);
//		System.out.println(bean2);
		applicationContext.close();
	}
}
