package com.gulukal.marathone;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MovieDatabaseManager extends Application {
	private static Scene scene;

	public static void main(String... args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		scene = new Scene(loadFXML("view/logIn/MainLogInView"));
		stage.setScene(scene);
		stage.show();
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(MovieDatabaseManager.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}
} 