package com.gulukal.marathone.entity.record;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "table_singer")
public class SingerEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long singerId;
	private String name;
	private String title;
	
	@OneToMany(mappedBy = "singer",cascade = CascadeType.ALL)
	private List<DvdEntity> dvdEntity = new ArrayList<>();
	
	@OneToMany(mappedBy = "singer",cascade = CascadeType.ALL)
	private List<CdEntity> cdEntity = new ArrayList<>();
	
	@OneToMany(mappedBy = "singer",cascade = CascadeType.ALL)
	private List<VinylEntity> vinylEntity = new ArrayList<>();


	public SingerEntity(String name, String title) {
		super();
		this.name        = name;
		this.title       = title;
	
	}

	
	
	
	
	

}
