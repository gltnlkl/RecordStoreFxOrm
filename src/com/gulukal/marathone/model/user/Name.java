package com.gulukal.marathone.model.user;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor


@Embeddable
public class Name {
	
	private String firstName;
	private String lastName;
	
	
	
	public Name(String firstName) {
		super();
		this.firstName = firstName;
	}

	
	
}
