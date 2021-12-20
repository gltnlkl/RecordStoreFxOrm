package com.gulukal.marathone.entity.record;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
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
public class Record implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String name;
	
	@Enumerated(value = EnumType.STRING)
	private Type type;
	private int publishYear;
	
	private int price;
	
	private double discount;
	
	@Lob
	@Column(name = "big_blob")
	private byte[] albumImg;

	
	
	


	

	
	
	
	
	

}
