package com.naresh.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccountDAO {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AccountDAO accountDAO = (AccountDAO) ctx.getBean("accountDAO");
		accountDAO.insert();
		AccountDAO accountDAO2 = (AccountDAO) ctx.getBean("accountDAO");
		accountDAO2.insert();

	}

}
