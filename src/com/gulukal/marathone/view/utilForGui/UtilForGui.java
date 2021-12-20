package com.gulukal.marathone.view.utilForGui;

import java.io.IOException;

import com.gulukal.marathone.Main;
import com.gulukal.marathone.MovieDatabaseManager;
import com.gulukal.marathone.view.appController.UserSetupController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UtilForGui {

	
	public void cancelAction() {
		
		System.exit(0);
	}
	
	public void switchPage(String rootFxml, String rootFxmlLong, String rootCss ) {
		
		
				try {
					MovieDatabaseManager.setRoot(rootFxml);
				}
				catch (Exception ex) {
					// TODO: handle exception
				}
				BorderPane root;
				
				try {

					root = (BorderPane) FXMLLoader.load(getClass().getResource(rootFxmlLong));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource(rootCss).toExternalForm());
					Main.getPrimaryStage().setScene(scene);
					Main.getPrimaryStage().show();
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
		
	}


}
