package com.gulukal.marathone.model.record;

import java.util.Date;

import com.gulukal.marathone.model.order.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Vinyl{


	private long vinylId;

	private Diametar diametar;

	private Speed speed;

	private Singer singer;

	private Order order; 
	
	private Date date;


	

	

	

	

}
