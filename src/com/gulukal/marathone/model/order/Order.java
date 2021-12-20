package com.gulukal.marathone.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gulukal.marathone.entity.record.CdEntity;
import com.gulukal.marathone.entity.record.DvdEntity;
import com.gulukal.marathone.entity.record.VinylEntity;
import com.gulukal.marathone.entity.user.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Order {
	
	private long orderId;
	
	private List <CdEntity> cd =new ArrayList<>();
	
	private List <DvdEntity> dvd =new ArrayList<>();
	
	private List <VinylEntity> vinyl =new ArrayList<>();

	private UserEntity user;
	
	private Date date;

	

	

	



	
	
	
	
	

}
