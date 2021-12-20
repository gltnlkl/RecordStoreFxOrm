package com.gulukal.marathone.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gulukal.marathone.entity.record.CdEntity;
import com.gulukal.marathone.entity.record.Diametar;
import com.gulukal.marathone.entity.record.DvdEntity;
import com.gulukal.marathone.entity.record.Quality;
import com.gulukal.marathone.entity.record.Speed;
import com.gulukal.marathone.entity.record.Type;
import com.gulukal.marathone.entity.record.VinylEntity;

public class RecordController implements Sessionable {

	private static final Logger logger = LogManager.getLogger(RecordController.class);

	public void dvdCreate(DvdEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdir" + DvdEntity.class);
		}
		catch (Exception e) {
			logger.error("ekleme aninda hata meydana geldi !!!!! " + DvdEntity.class);
			e.printStackTrace();
		}
	}

	public void cdCreate(CdEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdir" + CdEntity.class);
		}
		catch (Exception e) {
			logger.error("ekleme aninda hata meydana geldi !!!!! " + CdEntity.class);
			e.printStackTrace();
		}
	}

	public void vinylCreate(VinylEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdir" + VinylEntity.class);
		}
		catch (Exception e) {
			logger.error("ekleme aninda hata meydana geldi !!!!! " + VinylEntity.class);
			e.printStackTrace();
		}
	}

	public void createRecord() throws IOException {

		byte[] img1 = Files.readAllBytes(Paths.get("1.jpg"));
		byte[] img2 = Files.readAllBytes(Paths.get("2.jpg"));
		byte[] img3 = Files.readAllBytes(Paths.get("3.jpg"));

		DvdEntity dvdEntity1 = new DvdEntity("dvd record 1", Type.Pop, 2001, 100, 15.0, img1, Quality.BLURAY);
		DvdEntity dvdEntity2 = new DvdEntity("dvd record 2", Type.Rack, 1966, 50, 0.0, img2, Quality.HD);
		DvdEntity dvdEntity3 = new DvdEntity("dvd record 3", Type.HipHop, 2021, 120, 50, img3, Quality.FOURK);
		DvdEntity dvdEntity4 = new DvdEntity("dvd record 4", Type.HipHop, 2012, 170, 80, null, Quality.HD);

		CdEntity cdEntity1 = new CdEntity("cd record 1", Type.Rock, 1988, 200, 0.0, img1);
		CdEntity cdEntity2 = new CdEntity("cd record 2", Type.Country, 2008, 100, 70.0, img2);
		CdEntity cdEntity3 = new CdEntity("cd record 3", Type.HipHop, 2008, 100, 70.0, null);

		VinylEntity vinylEntity1 = new VinylEntity("vinyl record 1", Type.Pop, 2005, 120, 25.0, img3,
				Diametar.OtuzUcluk, Speed.ON);
		VinylEntity vinylEntity2 = new VinylEntity("vinyl record 2", Type.Rock, 2012, 124, 0.0, img2,
				Diametar.KirkBeslik, Speed.YUZ);
		VinylEntity vinylEntity3 = new VinylEntity("vinyl record 3", Type.Rock, 2012, 124, 0.0, null,
				Diametar.KirkBeslik, Speed.YUZ);
		

		dvdCreate(dvdEntity1);
		dvdCreate(dvdEntity2);
		dvdCreate(dvdEntity3);
		dvdCreate(dvdEntity4);

		cdCreate(cdEntity1);
		cdCreate(cdEntity2);
		cdCreate(cdEntity3);

		vinylCreate(vinylEntity1);
		vinylCreate(vinylEntity2);
		vinylCreate(vinylEntity3);

	}
	
	
	public void listRecord() {
		
		
	}

}
