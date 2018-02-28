package com.mtz.main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class Main extends Application{
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(Main.class.getResource("/com/mtz/view/Main.fxml"));
		Scene scene = new Scene(root); 
	/*	stage.setResizable(false);
		stage.initStyle(StageStyle. UTILITY);*/
		stage.setScene(scene);
		stage.show();
		stage.setTitle("拖拉机小游戏");
		stage.getIcons().add(new Image(getClass().getResourceAsStream("car.png")));
		scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
