package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.atguigu.bean.Car;

/**
 * bean的生命周期：
 * 		bean创建---初始化---销毁的过程
 * 容器管理bean的生命周期：
 * 我们可以自定义初始化和销毁方法，容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 * 构造（对象创建）
 * 		单实例：在容器启动时创建对象；
 * 		多实例：在每次获取时创建对象；
 * BeanPostProcessor.postProcessBeforeInitialization
 * 初始化：
 * 		对象创建完成，并赋值好，调用初始化方法
 * BeanPostProcessor.postProcessAfterInitialization
 * 销毁：
 * 		单实例：容器关闭的时候进行销毁	
 * 		多实例：容器不会管理这个bean，容器不会调用销毁方法
 * 
 * 遍历得到容器中所有的BeanPostProcessor，挨个执行beforeInitialization，
 * 一但返回null，跳出for循环，不会执行后边的BeanPostProcessor
 * 
 * BeanPostProcessor原理
 * populateBean(beanName, mbd, instanceWrapper);给bean进行属性赋值
 * {
 * 	applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 * 	initializeBean(beanName, exposedObject, mbd);执行初始化
 * 	applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 * }
 * 
 * 1）指定初始化、销毁方法
 * 		指定init-method="" destroy-method=""
 * 2）通过让bean实现InitializingBean接口定义初始化逻辑，实现DisposableBean接口定义销毁逻辑
 * 3）可以使用JSR250:
 * 		@PostConstruct：在bean创建完成并且属性赋值完成，来执行初始化方法
 * 		@PreDestroy：在容器销毁bean之前通知我们进行清理操作
 * 4）BeanPostProcessor【interface】：bean的后置处理器；
 * 		在bean初始化前后进行一些处理工作；
 * 		postProcessBeforeInitialization：在初始化之前工作
 * 		postProcessAfterInitialization：在初始化之后工作
 * 
 * @author yaoran
 *
 */
@ComponentScan("com.atguigu.bean")
@Configuration
public class MainConfigOfLifeCycle {

	//@Scope("prototype")
	@Bean(initMethod="init", destroyMethod="destroy")
	public Car car(){
		return new Car();
	}
}
