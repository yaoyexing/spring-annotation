package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.atguigu.bean.Person;

@Configuration
public class MainConfig2 {

	/**
	 * ConfigurableBeanFactory#SCOPE_PROTOTYPE	prototype
	 * ConfigurableBeanFactory#SCOPE_SINGLETON	singleton
	 * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST	request
	 * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION	session
	 * 
	 * @Scope 调整作用域
	 * prototype：多实例，ioc容器启动并不会调用方法创建对象放入容器中。
	 * 				每次获取的时候才会调用方法创建对象
	 * singleton：单实例（默认值），ioc容易启动就会调用方法创建对象放到ioc容器中。
	 * 			以后每次获取就是直接从容器中拿（map.get()）。
	 * request：同一次请求创建一个实例
	 * session：同一个session创建实例
	 * 
	 * 懒加载：针对单实例
	 * 		单实例Bean，默认在容器启动的时候创建对象
	 * 		懒加载：容器启动不创建对象，第一次使用（获取）Bean的时候创建对象
	 * 
	 * @return
	 */
//	@Scope("prototype")
	// 默认是单实例的
	@Lazy
	@Bean
	public Person person(){
		System.out.println("给容器中添加person。。。");
		return new Person("wangwu", 32);
	}
}
