package com.gulukal.marathone.entity.user;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor


@MappedSuperclass
public class Person implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mail;
	
	@Embedded
	private Name   name;

	private String password;

	public Person(String mail, String password) {
		super();
		this.mail     = mail;
		this.password = password;
	}

	

	

	
	


	
	
}
