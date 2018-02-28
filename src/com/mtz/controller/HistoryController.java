package com.mtz.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.List;

import com.mtz.dao.MTZDao;
import com.mtz.po.MTZ;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HistoryController {
	@FXML
	private Button btn;
	@FXML
	private TableColumn<MTZ, String> time;
	@FXML
	private TableColumn<MTZ, String> grate;
	@FXML
	private TableColumn<MTZ, String> stage;
	@FXML
	private TableView<MTZ> tabel;
	MTZDao dao =new MTZDao();
	public void initialize() {
		btn.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				try {
					Parent root = FXMLLoader
							.load(getClass().getResource(
									"/com/mtz/view/Main.fxml"));
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.initStyle(StageStyle.DECORATED);
					stage.setScene(scene);
					stage.setTitle("开始游戏");
					stage.show();
					scene.getStylesheets().add(
							getClass().getResource(
									"/com/mtz/main/main.css")
									.toExternalForm());
					btn.getScene().getWindow().hide();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				
			}
		});
		inin();
	}
	public void inin(){
		List<MTZ> mtzs = dao.findAll();
		// 表数据
		ObservableList<MTZ> data=null;
		data = FXCollections.observableList(mtzs);
		time.setCellValueFactory(new PropertyValueFactory<MTZ, String>(
				"time"));
		grate.setCellValueFactory(new PropertyValueFactory<MTZ, String>(
				"grade"));
		stage.setCellValueFactory(new PropertyValueFactory<MTZ, String>(
				"state"));
		tabel.setItems((ObservableList<MTZ>) data);
	}
}
