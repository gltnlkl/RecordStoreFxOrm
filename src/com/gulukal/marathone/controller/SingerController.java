package com.gulukal.marathone.controller;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gulukal.marathone.entity.record.SingerEntity;

public class SingerController implements Controllable<SingerEntity>, Sessionable {

	private static final Logger logger = LogManager.getLogger(SingerController.class);

	@Override
	public void create(SingerEntity entity) {

		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdir" + SingerController.class);
		}
		catch (Exception e) {
			logger.error("ekleme aninda hata meydana geldi !!!!! " + SingerController.class);
			e.printStackTrace();
		}

	}

	@Override
	public void delete(SingerEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(SingerEntity entity) {
		// TODO Auto-generated method stub

	}

	public void createSinger() {

		SingerEntity singerEntity = new SingerEntity("singer 1 ", "singer hakkinda bilgiler");

		create(singerEntity);

	}

	@Override
	public ArrayList<SingerEntity> list() {

		Session session = databaseConnectionHibernate();

		String hql = "select str from SingerEntity as str ";

		TypedQuery<SingerEntity> typedQuery = session.createQuery(hql, SingerEntity.class);

		typedQuery.setMaxResults(5);

		ArrayList<SingerEntity> arrayList = (ArrayList<SingerEntity>) typedQuery.getResultList();

		return arrayList;

	}

	public long getSingerIdBySingerName(String singerName) {

		Session session = databaseConnectionHibernate();

		String hql = "select singerId from SingerEntity as str where name=:key ";

		TypedQuery<SingerEntity> typedQuery = session.createQuery(hql, SingerEntity.class);

		typedQuery.setParameter("key ", singerName);

		long singerId = typedQuery.getSingleResult().getSingerId();

		return singerId;
	}

}
