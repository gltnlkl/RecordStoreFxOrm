package com.gulukal.marathone.controller;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.gulukal.marathone.entity.record.CdEntity;

public class CdController implements Controllable<CdEntity>, Sessionable {

	@Override
	public void create(CdEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CdEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CdEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<CdEntity> list() {

		Session session = databaseConnectionHibernate();

		String hql = "select str from CdEntity as str ";

		TypedQuery<CdEntity> typedQuery = session.createQuery(hql, CdEntity.class);

		typedQuery.setMaxResults(5);

		ArrayList<CdEntity> arrayList = (ArrayList<CdEntity>) typedQuery.getResultList();

		return arrayList;
	}

	public ArrayList<CdEntity> listSale() {

		Session session = databaseConnectionHibernate();

		String hql = "select str from CdEntity as str where str.discount > 0 ";

		TypedQuery<CdEntity> typedQuery = session.createQuery(hql, CdEntity.class);

		typedQuery.setMaxResults(5);

		ArrayList<CdEntity> arrayList = (ArrayList<CdEntity>) typedQuery.getResultList();

		return arrayList;
	}

	public ArrayList<CdEntity> listCdBySinger(long singerId) {

		Session session = databaseConnectionHibernate();

		String hql = "select str from CdEntity as str where singerid=:key ";

		TypedQuery<CdEntity> typedQuery = session.createQuery(hql, CdEntity.class);
		
		typedQuery.setParameter("key ", singerId);

		ArrayList<CdEntity> arrayList = (ArrayList<CdEntity>) typedQuery.getResultList();

		return arrayList;
	}

}
