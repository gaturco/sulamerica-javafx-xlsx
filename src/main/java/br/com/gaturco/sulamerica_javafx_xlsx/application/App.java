package br.com.gaturco.sulamerica_javafx_xlsx.application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class App extends Application {
	
	private static Scene mainScene;

	public void start(Stage stage) throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../gui/MainView.fxml"));
			ScrollPane root = loader.load();
			root.setFitToHeight(true);
			root.setFitToWidth(true);
			mainScene = new Scene(root);
			stage.setScene(mainScene);
			stage.setTitle("Gerador de guia");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		launch(args);
	}

}