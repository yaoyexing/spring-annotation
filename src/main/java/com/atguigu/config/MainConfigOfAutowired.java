package com.atguigu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.atguigu.dao.BookDao;

/**
 * 自动装配：
 * 		spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值；
 * 1、@Autowired：自动注入：
 * 		1）默认优先按照类型去容器中找对应组件：applicationContext.getBean(BookDao.class);
 * 		2)如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 * 				applicationContext.getBean(bookDao);
 * 		3)@Qualifier("bookDao")：使用@Qualifier指定需要装配的组件的id，而不是使用属性名
 * 		4）自动装配默认一定要将属性赋值好，没有就会报错
 * 			可以使用@Autowired(required=false)，能装配就装配
 * 		5)@Primary：spring自动装配的时候，默认使用首选的bean
 * 			也可以继续使用@Qualifier指定需要装配的bean的名字
 * 		BookService{
 * 			@Autowired
 * 			BookDao bookDao;
 * 		}
 * 
 * 
 * 
 * @author yaoran
 *
 */
@Configuration
@ComponentScan({"com.atguigu.controller","com.atguigu.dao","com.atguigu.service"})
public class MainConfigOfAutowired {

	@Primary
	@Bean("bookDao2")
	public BookDao bookDao(){
		BookDao bookDao = new BookDao();
		bookDao.setLabel("2");
		return bookDao;
	}
}
