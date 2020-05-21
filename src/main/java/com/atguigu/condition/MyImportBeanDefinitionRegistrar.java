package com.atguigu.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.atguigu.bean.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

	/**
	 * AnnotationMetadata：当前类的注释信息
	 * BeanDefinitionRegistry：BeanDefinition注册类
	 * 	把所有需要添加到容器中的bean：调用此方法自定义手工注册进来
	 * 		BeanDefinitionRegistry.registerBeanDefinition
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		boolean blue = registry.containsBeanDefinition("com.atguigu.bean.Blue");
		boolean red = registry.containsBeanDefinition("com.atguigu.bean.Red");
		if(blue && red){
			// 置顶bean定义信息（Bean的类型。。。。）
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
			// 注册一个bean，指定bean名
			registry.registerBeanDefinition("rainBow", rootBeanDefinition);
		}
		
	}

}
