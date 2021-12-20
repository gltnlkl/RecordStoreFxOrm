package com.gulukal.marathone.view.appController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gulukal.marathone.controller.UserController;
import com.gulukal.marathone.entity.user.UserEntity;
import com.gulukal.marathone.view.utilForGui.UtilForGui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class UserSetupController {

	private static final Logger logger = LogManager.getLogger(UserSetupController.class);

	UtilForGui util = new UtilForGui();

	@FXML
	private Label address;

	@FXML
	private Label firstName;

	@FXML
	private Label lastName;

	@FXML
	private Label mail;

	@FXML
	private Label password;

	@FXML
	private Label phone;

	@FXML
	void cancel(MouseEvent event) {

		util.cancelAction();

		logger.info(" CLOSE APP REQUEST  " + UserSetupController.class);

	}

	@FXML
	void userAppMainView(MouseEvent event) {

		String rootFxml     = "UserAppMainView";
		String rootFxmlLong = "../fxml/UserAppMainView.fxml";
		String rootCss      = "../utilForGui/application.css";

		util.switchPage(rootFxml, rootFxmlLong, rootCss);

	}

	@FXML
	void setMailLabel(MouseEvent event) {

		UserController userController = new UserController();
		UserEntity     userEntity     = new UserEntity();

		mail.setText(readFile());

		logger.info(" MAIL BILGISI LOCAL DOSYADAN OKUNDU" +  UserSetupController.class);

		userEntity = userController.getUser(mail.getText());
		
		address.setText(userEntity.getAddress());
		firstName.setText(userEntity.getName().getFirstName());
		lastName.setText(userEntity.getName().getLastName());
		password.setText(userEntity.getPassword());
		phone.setText(String.valueOf((userEntity).getPhoneNo()));

		
		logger.info(" GUI DEGISKENLERINE DATABASE DEGERLERI ATANDI" +  UserSetupController.class);
	}

	private static String readFile() {

		String path = "D:\\JavaWorkingSpace\\BoostMarathoneDecember\\src\\com\\gulukal\\marathone\\view\\tempFolder\\temp.txt";

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

			return bufferedReader.readLine();

		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
