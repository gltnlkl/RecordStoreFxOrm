package com.gulukal.marathone.view.appController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gulukal.marathone.admin.Admin;
import com.gulukal.marathone.controller.UserController;
import com.gulukal.marathone.entity.user.UserEntity;
import com.gulukal.marathone.view.utilForGui.UtilForGui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LogInViewController {

	private static final Logger logger = LogManager.getLogger(LogInViewController.class);

	UtilForGui util = new UtilForGui();

	@FXML
	private TextField mail;

	@FXML
	private Button newUser;

	@FXML
	private PasswordField password;

	@FXML
	void cancelAction(MouseEvent event) {

		util.cancelAction();

		logger.info(" CLOSE APP REQUEST  " + LogInViewController.class);
	}

	@FXML
	void newUserAction(MouseEvent event) {

		String rootFxml     = "NewUserLogInView";
		String rootFxmlLong = "../fxml/NewUserSignUpView.fxml";
		String rootCss      = "../utilForGui/application.css";

		util.switchPage(rootFxml, rootFxmlLong, rootCss);

		logger.info(" SWITCH PAGE TO CREATING NEW USER " + LogInViewController.class);
	}

	@FXML
	void commitAction(MouseEvent event) throws IOException {

		Admin          admin          = new Admin();
		UserController userController = new UserController();

		String adminName     = admin.getAdminName().trim();
		String adminPassword = admin.getAdminPassword().trim();

		String userMail     = mail.getText().trim();
		String userPassword = password.textProperty().get().trim();

		UserEntity logInUser = new UserEntity(userMail, userPassword);

		logger.info("CHECK MAIL AND PASSWORD INPUT " + LogInViewController.class);

		if (userMail.equals(adminName) && userPassword.equals(adminPassword)) {

			String rootAdminFxml     = "view/logIn/AdminSignUpView";
			String rootAdminFxmlLong = "../fxml/AdminAppMainView.fxml";
			String rootAdminCss      = "../utilForGui/application.css";

			util.switchPage(rootAdminFxml, rootAdminFxmlLong, rootAdminCss);

			logger.info("ADMIN CHECK IN " + LogInViewController.class);

		}
		else if (userController.checkUserLogin(logInUser)) {

			String rootUserFxml     = "UserAppMainView";
			String rootUserFxmlLong = "../fxml/UserAppMainView.fxml";
			String rootUserCss      = "../utilForGui/application.css";

			util.switchPage(rootUserFxml, rootUserFxmlLong, rootUserCss);

			logger.info("USER CHECK IN " + userMail + LogInViewController.class);

			fileWrite(userMail);
		}
		else {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Hata!");
			alert.setHeaderText("Girilen bilgiler yanlis");
			alert.show();
			mail.clear();
			password.clear();

			logger.info("UNSUCCESSFUL LOG IN " + mail + LogInViewController.class);

		}
	}

	private void fileWrite(String text) {
		
		String path = "D:\\JavaWorkingSpace\\BoostMarathoneDecember\\src\\com\\gulukal\\marathone\\view\\tempFolder\\temp.txt";
		
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {

			bufferedWriter.write(text);
			bufferedWriter.flush();
			
			logger.info(" LOCAL DOSYAYA GIRIS YAPILAN MAIL ADRESI YAZDIRILDI " + LogInViewController.class);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}