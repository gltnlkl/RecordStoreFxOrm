package com.gulukal.marathone.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gulukal.marathone.entity.order.OrderEntity;
import com.gulukal.marathone.entity.record.CdEntity;
import com.gulukal.marathone.entity.record.DvdEntity;
import com.gulukal.marathone.entity.record.SingerEntity;
import com.gulukal.marathone.entity.record.VinylEntity;
import com.gulukal.marathone.entity.user.UserEntity;

public class HibernateUtil {
		private static final SessionFactory sessionFactory = sessionFactory();

		private static SessionFactory sessionFactory() {
			try {
				Configuration configuration = new Configuration();
				
				configuration.addAnnotatedClass(UserEntity.class);
				configuration.addAnnotatedClass(VinylEntity.class);
				configuration.addAnnotatedClass(CdEntity.class);
				configuration.addAnnotatedClass(DvdEntity.class);
				configuration.addAnnotatedClass(OrderEntity.class);
				configuration.addAnnotatedClass(SingerEntity.class);
				
			
				SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

				return factory;
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}
		
		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}
	}
