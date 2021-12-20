package com.gulukal.marathone.entity.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.gulukal.marathone.entity.order.OrderEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "table_user")

public class UserEntity extends Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;


	private String address;
	private int    phoneNo;
	

	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private Date date;

	@OneToMany(mappedBy = "user")
	private List<OrderEntity> order = new ArrayList<>();

	
	
	
	
	public UserEntity(String mail, Name name, String password, String address, int phoneNo) {
		super(mail, name, password);
		this.address = address;
		this.phoneNo = phoneNo;
	}



	public UserEntity(String mail, Name name, String password, String address, int phoneNo, List<OrderEntity> order) {
		super(mail, name, password);
		this.address = address;
		this.phoneNo = phoneNo;
		this.order   = order;
	}



	public UserEntity(String mail, String password) {
		super(mail,password);
	}

	

	

}
