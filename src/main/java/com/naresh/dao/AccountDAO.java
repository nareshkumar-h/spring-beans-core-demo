package com.naresh.dao;

import javax.sql.DataSource;

public class AccountDAO {

	private DataSource dataSource;
	
	public AccountDAO(DataSource dataSource) {
		System.out.println("AccountDAO -> Constructor Based Injection ");
		this.dataSource = dataSource;
	}
	

	public void insert() {
		System.out.println("AccountDAO->insert : " + this);
	}

}
