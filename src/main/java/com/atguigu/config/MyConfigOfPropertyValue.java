package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atguigu.bean.Person;

@Configuration
public class MyConfigOfPropertyValue {

	@Bean
	public Person person(){
		return new Person();
	}
}
