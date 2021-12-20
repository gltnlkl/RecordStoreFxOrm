package com.gulukal.marathone.entity.record;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.gulukal.marathone.entity.order.OrderEntity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "table_cd")
public class CdEntity extends Record implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long cdId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "singerId")
	private SingerEntity singer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId")
	private OrderEntity order;

	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private Date date;

	public CdEntity(String name, Type type, int publishYear, int price, double discount, byte[] albumImg) {
		super(name, type, publishYear, price, discount, albumImg);
	
	}

	

	

	

}
