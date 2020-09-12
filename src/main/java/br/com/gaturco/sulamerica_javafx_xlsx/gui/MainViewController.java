package br.com.gaturco.sulamerica_javafx_xlsx.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.gaturco.sulamerica_javafx_xlsx.application.App;
import br.com.gaturco.sulamerica_javafx_xlsx.domain.Paciente;
import br.com.gaturco.sulamerica_javafx_xlsx.domain.Usuario;
import br.com.gaturco.sulamerica_javafx_xlsx.utils.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemInicio;
	
	@FXML
	private MenuItem menuItemPacientesEditar;
	
	@FXML
	private MenuItem menuItemPacientesAdicionar;
	
	@FXML
	private MenuItem menuItemPacientesDeletar;
	
	@FXML
	private MenuItem menuItemUsuariosEditar;
	
	@FXML
	private ComboBox<Usuario> comboUsuario;
	
	@FXML
	private ComboBox<Paciente> comboPaciente;
	
	@FXML
	private Button iniciarButton;
	
	@FXML
	public void onMenuItemInicioAction() {
		System.out.println("onMenuItemInicioAction");
	}
	
	@FXML
	public void onMenuItemPacientesEditar() {
		loadView("./pages/EditarPaciente.fxml");
	}
	
	@FXML
	public void onMenuItemPacientesAdicionar() {
		loadView("./pages/AdicionarPaciente.fxml");
	}
	
	@FXML
	public void onMenuItemPacientesDeletar() {
		loadView("./pages/DeletarPaciente.fxml");
	}
	
	@FXML
	public void onMenuItemUsuariosEditar() {
		loadView("./pages/EditarUsuario.fxml");
	}
	
	@FXML
	public void onComboBoxUsuarioAction() {
		System.out.println("onComboBoxUsuarioAction");
	}
	
	@FXML
	public void onComboBoxPacienteAction() {
		System.out.println("onComboBoxPacienteAction");
	}
	
	@FXML
	public void onIniciarButtonAction() {
		System.out.println("onIniciarButtonAction");
	}
	

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
	}
	
	private void loadView(String path) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
			VBox newVbox = loader.load();
			
			Scene mainScene = App.getMainScene();
			AnchorPane mainAnchor = (AnchorPane) ((ScrollPane) mainScene.getRoot()).getContent();
			VBox mainVBox = (VBox) mainAnchor.getChildren().get(0);
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().add(newVbox);
			
//			T controller = loader.getController();
//			initializingAction.accept(controller);
		} catch (IOException e) {
			Alerts.showAlert("IOException", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}
