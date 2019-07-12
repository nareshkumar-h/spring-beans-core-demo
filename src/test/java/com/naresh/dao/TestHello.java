package com.naresh.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.naresh.demo.HelloBean;

public class TestHello {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		HelloBean obj = (HelloBean) ctx.getBean("helloBean");
		obj.hello();
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
