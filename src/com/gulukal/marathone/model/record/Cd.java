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


public class Cd{

	
	private long cdId;

	private Singer singer;

	private Order order;

	private Date date;


	

	

	

}
