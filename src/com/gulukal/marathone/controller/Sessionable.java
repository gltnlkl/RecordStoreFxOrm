package com.gulukal.marathone.controller;

import org.hibernate.Session;

import com.gulukal.marathone.utils.HibernateUtil;

public interface Sessionable {
	

	default Session databaseConnectionHibernate() {
		return HibernateUtil.getSessionFactory().openSession();
	}

}
