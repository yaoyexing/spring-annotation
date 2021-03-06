package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {

	//使用@Value赋值：
	//1、基本数值
	//2、可以写springEL（spring表达式）：#{}
	//3、可以写${}：取出配置文件中的值（在运行的环境变量里的值）
	
	@Value("lisi")
	private String name;
	
	@Value("#{19+3}")
	private Integer age;
	
	@Value("${person.nickName}")
	private String nickName;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", nickName=" + nickName + "]";
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, Integer age, String nickName) {
		super();
		this.name = name;
		this.age = age;
		this.nickName = nickName;
	}
	
}
