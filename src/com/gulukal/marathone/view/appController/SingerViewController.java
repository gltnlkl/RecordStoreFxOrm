package com.gulukal.marathone.view.appController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gulukal.marathone.controller.SingerController;
import com.gulukal.marathone.entity.record.SingerEntity;
import com.gulukal.marathone.view.utilForGui.UtilForGui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SingerViewController implements Initializable {

	private static final Logger logger = LogManager.getLogger(LogInViewController.class);

	UtilForGui util = new UtilForGui();

	@FXML
	private Label singer;

	@FXML
	private Label title;

	@FXML
	private TableView<SingerEntity> tableSinger;

	@FXML
	private TableColumn<SingerEntity, String> columnSinger;

	@FXML
	void cancel(MouseEvent event) {
		util.cancelAction();

		logger.info(" CLOSE APP REQUEST  " + SingerViewController.class);
	}

	@FXML
	void switchSingersRecord(MouseEvent event) throws IOException {

		// secili bilgileri belirtilen scene aktarir

		FXMLLoader loader = new FXMLLoader(getClass().getResource("../../view/fxml/CdView.fxml"));
		Parent     root   = loader.load();

		CdViewController cdViewController = loader.getController();

		String name = singer.getText();

		cdViewController.showInformation(name);

		Stage stage = new Stage();

		stage.setScene(new Scene(root));

		stage.setTitle("Cd View Controller");
		stage.show();
	}

	@FXML
	void switchUserAppMenu(MouseEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList<SingerEntity> obList = FXCollections.observableArrayList();

		SingerController singerController = new SingerController();

		ArrayList<SingerEntity> aList = new ArrayList<>();

		aList = singerController.list();

		for (int i = 0; i < aList.size(); i++) {

			obList.add(i, aList.get(i));

		}

		columnSinger.setCellValueFactory(new PropertyValueFactory<>("name"));
		tableSinger.setItems(obList);

		// secili ogeyi degerlere atar
		tableSinger.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showDetails(newValue));
	}

	private void showDetails(SingerEntity singerEntity) {
		if (singerEntity == null) {
			singer.setText("");
			title.setText("");
		}
		else {
			singer.setText(singerEntity.getName()); 
			title.setText(singerEntity.getTitle());

		}

	}
}
