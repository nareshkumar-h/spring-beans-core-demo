package com.naresh.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDAO {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
		userDAO.insert();
		UserDAO userDAO2 = (UserDAO) ctx.getBean("userDAO");
		userDAO2.insert();

	}

}
