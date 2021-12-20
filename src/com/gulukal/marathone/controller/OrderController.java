package com.gulukal.marathone.controller;

import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gulukal.marathone.entity.order.OrderEntity;
import com.gulukal.marathone.entity.record.CdEntity;
import com.gulukal.marathone.entity.record.DvdEntity;
import com.gulukal.marathone.entity.record.VinylEntity;

public class OrderController implements Controllable<OrderEntity>, Sessionable {

	private static final Logger logger = LogManager.getLogger(OrderController.class);

	@Override
	public void create(OrderEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdir" + OrderEntity.class);
		}
		catch (Exception e) {
			logger.error("ekleme aninda hata meydana geldi !!!!! " + OrderEntity.class);
			e.printStackTrace();
		}

	}

	@Override
	public void delete(OrderEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(OrderEntity entity) {
		// TODO Auto-generated method stub

	}

	public void creteOrder() {

		logger.info(" - create order -  ");

		Session session = databaseConnectionHibernate();

		String hqlCd = "select t from CdEntity as t where t.name =:keyCd";
		String hqlDvd = "select t from DvdEntity as t where t.name =:keyDvd";
		String hqlVinyl = "select t from VinylEntity as t where t.name =:keyVinyl";

		TypedQuery<CdEntity> typedQueryCd = session.createQuery(hqlCd, CdEntity.class);
		TypedQuery<DvdEntity> typedQueryDvd = session.createQuery(hqlDvd, DvdEntity.class);
		TypedQuery<VinylEntity> typedQueryViynl = session.createQuery(hqlVinyl, VinylEntity.class);

		typedQueryCd.setParameter("keyCd", "cd record 3");
		typedQueryDvd.setParameter("keyDvd", "dvd record 4");
		typedQueryViynl.setParameter("keyVinyl", "vinyl record 3");

		List<CdEntity> cd = typedQueryCd.getResultList();   // cd
		List<DvdEntity> dvd = typedQueryDvd.getResultList();   // dvd
		List<VinylEntity> vinyl = typedQueryViynl.getResultList();   // viynl
	
		OrderEntity orderEntity = new OrderEntity(cd,dvd,vinyl);

		create(orderEntity);

	}

}
