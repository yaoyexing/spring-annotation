package com.atguigu.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否是linux系统
 * @author yaoran
 *
 */
public class LinuxCondition implements Condition{

	/**
	 * ConditionContext：判断条件使用的上下文（环境）
	 * AnnotatedTypeMetadata：标记了@Conditional注解的注释信息
	 */
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO 是否linux系统
		//1、能获取到ioc使用的beanfactory（创建对象以及装配的工厂）
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//2、获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		//3、获取当前环境信息
		Environment environment = context.getEnvironment();
		//4、获取bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		
		//可以判断容器中注册情况，也可以给容器中注册bean
		boolean containsBeanDefinition = registry.containsBeanDefinition("person");
//		registry.registerBeanDefinition(beanName, beanDefinition);
		//判断操作系统
		String property = environment.getProperty("os.name");
		if(property.contains("linux")){
			return true;
		}
		return false;
	}

}
