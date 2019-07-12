package com.naresh.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.naresh.demo.DemoBean;

public class TestDemo {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		DemoBean obj = (DemoBean) ctx.getBean("demoBean");
		obj.hello();
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
