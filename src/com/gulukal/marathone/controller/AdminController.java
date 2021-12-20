package com.gulukal.marathone.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gulukal.marathone.admin.Admin;

public class AdminController {
	
	private static final Logger logger = LogManager.getLogger(AdminController.class);

	
	public void adminLogin() {
		
		
		Admin admin =new Admin();
		
		String adminName = "Admin";

		String adminPassword = "qwerty";
		
		
		logger.info(" - LOGIN ADMIN TRY NUMBER ONE -  ");

	

		if (adminName == admin.getAdminName() && adminPassword == admin.getAdminPassword()) {

			logger.info(" - Admin Login is Successful ");

		}
		else {

			logger.warn(" - Admin Login failed");

		}

	}

}
