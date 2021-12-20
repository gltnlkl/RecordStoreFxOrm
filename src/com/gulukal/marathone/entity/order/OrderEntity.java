package com.gulukal.marathone.entity.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.gulukal.marathone.entity.record.CdEntity;
import com.gulukal.marathone.entity.record.DvdEntity;
import com.gulukal.marathone.entity.record.VinylEntity;
import com.gulukal.marathone.entity.user.UserEntity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "table_order")
public class OrderEntity implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long orderId;
	
	@OneToMany 
	private List <CdEntity> cd =new ArrayList<>();
	
	@OneToMany  
	private List <DvdEntity> dvd =new ArrayList<>();
	
	@OneToMany  
	private List <VinylEntity> vinyl =new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private UserEntity user;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private Date date;

	public OrderEntity(List<CdEntity> cd, List<DvdEntity> dvd, List<VinylEntity> vinyl) {
		super();
		this.cd    = cd;
		this.dvd   = dvd;
		this.vinyl = vinyl;
	
	}

	

	



	
	
	
	
	

}
