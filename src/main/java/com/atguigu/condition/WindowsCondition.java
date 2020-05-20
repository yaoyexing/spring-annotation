package com.atguigu.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否是Windows系统
 * @author yaoran
 *
 */
public class WindowsCondition implements Condition{

	/**
	 * ConditionContext：判断条件使用的上下文（环境）
	 * AnnotatedTypeMetadata：标记了@Conditional注解的注释信息
	 */
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO 判断是否为Windows系统
		//1、获取ioc使用的beanfactory（创建对象以及装配的工厂）
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//2、获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		//3、获取bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		//4、获取当前环境信息
		Environment environment = context.getEnvironment();
		String property = environment.getProperty("os.name");
		if(property.contains("Windows")){
			return true;
		}
		return false;
	}

}
