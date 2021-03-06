package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.atguigu.bean.Person;
import com.atguigu.service.BookService;


/**
 * 配置类=原来的配置文件
 * @author yaoran
 *
 */
@Configuration
//@ComponentScan(value="com.atguigu", includeFilters={
//		@Filter(type=FilterType.ANNOTATION, classes={Controller.class})
//},useDefaultFilters = false)
@ComponentScans(
		value = {
				@ComponentScan(value="com.atguigu", includeFilters={
/*						@Filter(type=FilterType.ANNOTATION, classes={Controller.class}),
						@Filter(type=FilterType.ASSIGNABLE_TYPE, classes={BookService.class}),*/
						@Filter(type=FilterType.CUSTOM, classes={MyTypeFilter.class})
				},useDefaultFilters = false)
		}
		)
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[],扫描的时候按照什么规则排除哪些组件
//includeFilters = Filter[],置顶扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则表达式
//FilterType.CUSTOM：使用自定义规则
public class MainConfig {

	//给容器中注册一个Bean；类型为返回值的类型，id默认为方法名
	@Bean("person")
	public Person person01(){
		return new Person("lisi", 18, "11");
	}
}
