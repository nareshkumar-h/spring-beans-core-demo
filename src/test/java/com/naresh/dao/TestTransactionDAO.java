package com.naresh.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransactionDAO {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		TransactionDAO transactionDAO = (TransactionDAO) ctx.getBean("transactionDAO");
		transactionDAO.insert();

	}

}
