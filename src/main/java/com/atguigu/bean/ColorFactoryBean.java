package com.atguigu.bean;

import org.springframework.beans.factory.FactoryBean;

// 创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color>{

	// 返回一个Color对象，这个对象会添加到容器中
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean。。。调用getObject。。");
		return new Color();
	}

	public Class<?> getObjectType() {
		return Color.class;
	}

	//是否单例：true:单实例，在容器中只保存一份；false：多实例，每次获取都会创建新的bean
	public boolean isSingleton() {
		return false;
	}

}
