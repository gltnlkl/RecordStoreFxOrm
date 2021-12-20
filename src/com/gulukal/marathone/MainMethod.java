package com.gulukal.marathone;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gulukal.marathone.controller.AdminController;
import com.gulukal.marathone.controller.CdController;
import com.gulukal.marathone.controller.OrderController;
import com.gulukal.marathone.controller.RecordController;
import com.gulukal.marathone.controller.SingerController;
import com.gulukal.marathone.controller.UserController;
import com.gulukal.marathone.entity.record.CdEntity;
import com.gulukal.marathone.entity.record.SingerEntity;

public class MainMethod {

	private static final Logger logger = LogManager.getLogger(MainMethod.class);
	
	UserController userController = new UserController();

	SingerController singerController = new SingerController();

	RecordController recordController = new RecordController();

	protected void createUserTest() {

		userController.createUser();

	}

	protected void loginUserTest() {

		userController.userLoginCheck();

	}

	protected void createRecordTest() throws IOException {

		recordController.createRecord();

	}

	protected void createSingerTest() {

		singerController.createSinger();

	}

	protected void createOrderTest() {

		OrderController orderController = new OrderController();

		orderController.creteOrder();
	}

	protected void listSinger() {

		ArrayList<SingerEntity> arrayList = new ArrayList<>();

		arrayList = singerController.list();

		for (int i = 0; i < arrayList.size(); i++) {

			System.out.println(arrayList.get(i));

		}

	}

	protected void adminLogin() {

		AdminController adminController = new AdminController();

		adminController.adminLogin();

	}

	protected void listRecord() {

		CdController controller = new CdController();

		ArrayList<CdEntity> arrayList = new ArrayList<>();

		arrayList = controller.list();

		for (int i = 0; i < arrayList.size(); i++) {

			System.out.println(arrayList.get(i));

		}

	}

	protected void listSaleRecord() {

		CdController controller = new CdController();

		ArrayList<CdEntity> arrayList = new ArrayList<>();

		arrayList = controller.listSale();

		for (int i = 0; i < arrayList.size(); i++) {

			System.out.println(arrayList.get(i));

		}
	}
	
	
	protected void tempFile() {
		
		String path = "C:\\Users\\gulte\\OneDrive - Bilgeadam Akademi\\Desktop\\BoostMarathoneDecember\\src\\com\\gulukal\\marathone\\view\\tempFolder\\temp.txt";
		File file = new File(path);
		
		try {
			
			if (file.exists()) {
				file.delete();
				
				
				logger.info(" TEMP DOSYASI TEMIZLENDI" +  MainMethod.class);
				
				 file.createNewFile();
				 
				 logger.info(" TEMP DOSYASI TEMIZLENDI VE YENIDEN OLUSTURULDU" +  MainMethod.class);
				
			} else {
				logger.info(" TEMP DOSYASI SILINEMEDI - HATA !!!" +  MainMethod.class);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
