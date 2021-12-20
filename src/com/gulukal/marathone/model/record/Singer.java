package com.gulukal.marathone.model.record;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Singer{
	

	private long singerId;
	private String name;
	private String title;
	
	private List<Dvd> dvd = new ArrayList<>();
	
	private List<Cd> cd= new ArrayList<>();
	
	private List<Vinyl> vinyl = new ArrayList<>();

	
	
	
	

}
