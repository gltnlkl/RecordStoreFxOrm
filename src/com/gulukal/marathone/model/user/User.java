package com.gulukal.marathone.model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gulukal.marathone.model.order.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class User{

	private long userId;

	private String address;
	
	private int    phoneNo;
	
	private Date date;

	private List<Order> order = new ArrayList<>();



}
