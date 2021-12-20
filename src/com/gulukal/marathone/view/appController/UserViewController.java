package com.gulukal.marathone.view.appController;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gulukal.marathone.view.utilForGui.UtilForGui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class UserViewController {

	private static final Logger logger = LogManager.getLogger(UserViewController.class);

	UtilForGui util = new UtilForGui();

	@FXML
	private Label name;



	@FXML
	void switchToCdList(MouseEvent event) {

		String rootFxml     = "CdView";
		String rootFxmlLong = "../fxml/CdView.fxml";
		String rootCss      = "../utilForGui/application.css";

		util.switchPage(rootFxml, rootFxmlLong, rootCss);

	}

	@FXML
	void switchToDvdList(MouseEvent event) {

		String rootFxml     = "DvdView";
		String rootFxmlLong = "../fxml/DvdView.fxml";
		String rootCss      = "../utilForGui/application.css";

		util.switchPage(rootFxml, rootFxmlLong, rootCss);

	}

	@FXML
	void switchToOrderInformation(MouseEvent event) {

		String rootFxml     = "OrderView";
		String rootFxmlLong = "../fxml/OrderView.fxml";
		String rootCss      = "../utilForGui/application.css";

		util.switchPage(rootFxml, rootFxmlLong, rootCss);

	}

	@FXML
	void switchToSingerList(MouseEvent event) {

		String rootFxml     = "SingerView";
		String rootFxmlLong = "../fxml/SingerView.fxml";
		String rootCss      = "../utilForGui/application.css";

		util.switchPage(rootFxml, rootFxmlLong, rootCss);
	}

	@FXML
	void switchToUserSetup(MouseEvent event) {

		String rootFxml     = "UserSetupView";
		String rootFxmlLong = "../fxml/UserSetupView.fxml";
		String rootCss      = "../utilForGui/application.css";

		util.switchPage(rootFxml, rootFxmlLong, rootCss);

	}

	@FXML
	void switchToVinylList(MouseEvent event) {

		String rootFxml     = "VinylView";
		String rootFxmlLong = "../fxml/VinylView.fxml";
		String rootCss      = "../utilForGui/application.css";

		util.switchPage(rootFxml, rootFxmlLong, rootCss);
	}

	@FXML
	void cancelAction(MouseEvent event) {

		util.cancelAction();

		logger.info(" CLOSE APP REQUEST  " + LogInViewController.class);
	}



}
