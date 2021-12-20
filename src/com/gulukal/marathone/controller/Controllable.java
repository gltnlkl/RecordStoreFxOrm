package com.gulukal.marathone.controller;

import java.util.ArrayList;


public interface  Controllable<T> {
	
public void create(T entity);
	
	public void delete(T entity);
	
	public void update(T entity);
	
	default ArrayList<T> list() {
		return null;
	}
	
	default T find(int id) {
		return null;
	}
	
	default T singleResult(int id) {
		return null;
	}

}
