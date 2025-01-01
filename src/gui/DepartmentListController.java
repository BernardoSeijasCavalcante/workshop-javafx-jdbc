package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable{

	private DepartmentService service;
	
	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn <Department, Integer> tableColumnId;
	@FXML
	private TableColumn <Department, String> tableColumnName;
	@FXML
	private Button btNew;
	
	private ObservableList<Department> obslist;
	
	@FXML
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initializeNodes();
		
	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id")); // Padrão do JavaFX para iniciar o comportamento das colunas (entre parênteses está o nome da variável do objeto dado à TableColumn correspondente)
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow(); //Recolhe o palco que está sendo utilizado
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty()); //Macete para tornar o tamanho da tabela ajustado à janela.
		
	}
	
	public void updateTableView() {
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.findAll();
	}
	
	
}
