package application;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainWindowController {
    
	@FXML private TextField precioVenta;
	@FXML private TextField costoVariable;
	@FXML private TextField costosFijos;
	@FXML private TextField cantidadesVendidas;
	@FXML private TextField crecimiento;
	@FXML private TextField utilidadMeta;
	@FXML private Label uoPorcentaje;
	@FXML private Label uoPesos;
	@FXML private Label upPorcentaje;
	@FXML private Label upPesos;
	@FXML private Label unidadesMeta;
	
    @FXML
    void seeIndicator(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("IndicatorWindow.fxml"));
			Parent root = (Parent) loader.load();
			root.getStylesheets().add("application.css");// CSS
			IndicatorWindowController nc = loader.getController();
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
    
}//final
