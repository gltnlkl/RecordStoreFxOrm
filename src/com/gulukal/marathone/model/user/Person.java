package com.gulukal.marathone.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Person {

	private String mail;

	private Name   name;

	private String password;


	
}
