package com.atguigu.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector{

	// 返回值，就是导入到容器中的组件全类名
	// AnnotationMetadata：当前标注@Import注解的类的所有注释信息
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		importingClassMetadata.getClassName();
		//方法不要返回null
		return new String[]{"com.atguigu.bean.Blue", "com.atguigu.bean.Yellow"};
	}

}
