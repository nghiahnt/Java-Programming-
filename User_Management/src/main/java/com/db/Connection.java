package com.db;

import org.hibernate.cfg.Configuration;

import com.entity.Users;

public class Connection {
	// Create configuration
	Configuration configuration;
	
	public Configuration getConfig() {
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Users.class);
		
		return configuration;
		
	}
}
