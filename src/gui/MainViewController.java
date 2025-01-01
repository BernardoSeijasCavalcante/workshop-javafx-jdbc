package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}
	@FXML
	public void onMenuItemDepartmentAction() {
		System.out.println("onMenuItemDepartmentAction");
	}
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene(); // Aponta para a cena que compõe o palco
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent(); //Pega a referência do VBox da primeira janela
			
			Node mainMenu = mainVBox.getChildren().get(0); //Pega a barra de menu da primeira janela
			mainVBox.getChildren().clear(); // Apaga todo o conteúdo da vbox da primeira janela (Inclusive a barra de menu)
			mainVBox.getChildren().add(mainMenu); // Adiciona o menu à janela atual (que é uma reciclagem da primeira, ou seja, a mesma janela)
			mainVBox.getChildren().addAll(newVBox.getChildren()); //Adiciona o conteúdo da nova janela à janela atual
			
		}catch(IOException e) {
			Alerts.showAlert("IO Exception", "Error Loading View", e.getMessage(), AlertType.ERROR);
		}
		
	}

}
