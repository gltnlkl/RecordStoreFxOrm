package com.gulukal.marathone.view.appController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gulukal.marathone.controller.CdController;
import com.gulukal.marathone.controller.SingerController;
import com.gulukal.marathone.entity.record.CdEntity;
import com.gulukal.marathone.view.utilForGui.UtilForGui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class CdViewController implements Initializable{
	
	private static final Logger logger = LogManager.getLogger(UserViewController.class);

	UtilForGui util = new UtilForGui();
	
	
	@FXML
	private TableView<CdEntity> tableCd;
	
	@FXML
    private TableColumn<CdEntity, String> columnCd;
	
	@FXML
	private Label singer;

    @FXML
    private Label discount;

    @FXML
    private Label price;

    @FXML
    private Label publishYear;

    @FXML
    private Label recordName;

    @FXML
    private Label type;

    @FXML
    void addToCart(MouseEvent event) {
    	
    	// TO DO ADD TO CART METHOD

    }

    @FXML
    void cancel(MouseEvent event) {

    	util.cancelAction();

		logger.info(" CLOSE APP REQUEST  " + CdViewController.class);
		
    }

    @FXML
    void switchUserAppMenu(MouseEvent event) {
    	
    	String rootFxml     = "UserAppMainView";
		String rootFxmlLong = "../fxml/UserAppMainView.fxml";
		String rootCss      = "../utilForGui/application.css";

		util.switchPage(rootFxml, rootFxmlLong, rootCss);


    }
	
	public void showInformation(String name) {
		
		singer.setText(name);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList<CdEntity> obList = FXCollections.observableArrayList();

		CdController cdController = new CdController();
		
		SingerController singerController = new SingerController();
		
		long singerId= singerController.getSingerIdBySingerName(singer.getText());

		ArrayList<CdEntity> aList = new ArrayList<>();

				
		aList = cdController.listCdBySinger(singerId);

		for (int i = 0; i < aList.size(); i++) {

			obList.add(i, aList.get(i));

		}

		columnCd.setCellValueFactory(new PropertyValueFactory<>("name"));
		tableCd.setItems(obList);

		// secili ogeyi degerlere atar
		tableCd.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showDetails(newValue));
	}

	private void showDetails(CdEntity cdEntity) {
		if (cdEntity == null) {
			singer.setText("");
			discount.setText("");
			price.setText("");
			publishYear.setText("");
			recordName.setText("");
			type.setText("");
		}
		else {
			singer.setText(cdEntity.getName());
			discount.setText(String.valueOf(cdEntity.getDiscount()));
			price.setText(String.valueOf(cdEntity.getPrice()));
			publishYear.setText(String.valueOf(cdEntity.getPublishYear()));
			recordName.setText(cdEntity.getName());
			type.setText(cdEntity.getType().toString());
		}

	}

}
