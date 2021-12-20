package com.gulukal.marathone.view.appController;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gulukal.marathone.controller.UserController;
import com.gulukal.marathone.entity.user.UserEntity;
import com.gulukal.marathone.view.utilForGui.UtilForGui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SignUpViewController {

	private static final Logger logger = LogManager.getLogger(SignUpViewController.class);

	UtilForGui util = new UtilForGui();

	@FXML
	private TextField newMail;

	@FXML
	private PasswordField newPassword;

	@FXML
	private Button cancel;

	@FXML
	void NewUserCreateAction(MouseEvent event) {

		String userNewMail     = newMail.getText();
		String userNewPassword = newPassword.textProperty().get();

		UserEntity loginEntity = new UserEntity();

		UserController loginCont = new UserController();

		loginEntity.setMail(userNewMail);
		loginEntity.setPassword(userNewPassword);

		loginCont.create(loginEntity);

		switchPage();

		logger.info(" NEW USER HAS BEEN CREATED " + userNewMail + SignUpViewController.class);

	}

	public void switchPage() {

		String rootFxml     = "view/fxml/NewUserLogInView";
		String rootFxmlLong = "../../view/fxml/NewUserLogInView.fxml";
		String rootCss      = "../../view/utilForGui/application.css";

		util.switchPage(rootFxml, rootFxmlLong, rootCss);

		logger.info(" SWITCH PAGE TO NEW USER LOGIN " + SignUpViewController.class);

	}

	@FXML
	void cancelAction(MouseEvent event) {

		util.cancelAction();

		logger.info(" CLOSE APP REQUEST  " + SignUpViewController.class);
	}

}
