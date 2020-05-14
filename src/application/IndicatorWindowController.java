package application;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import src.Empresa;

public class IndicatorWindowController {

	@FXML private Label equilibrioDinero;
	@FXML private Label equilibrioUnidades;
	@FXML private Label contribucionDinero;
	@FXML private Label contribucionPorcentaje;
	@FXML private Label seguridadDinero;
	@FXML private Label seguridadUnidades;
	@FXML private Label seguridadPorcentaje;
	@FXML private Label apalancamiento;
	
	private Empresa empresa;
	
	@FXML
	void back(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			Parent root = (Parent) loader.load();
			root.getStylesheets().add("application.css");// CSS
			MainWindowController nc = loader.getController();
			nc.disableTextFields();
			nc.setEmpresa(empresa);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	 @FXML
	    void seeGraphics(Event event) {
	    	try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("GraphicsWindow.fxml"));
				Parent root = (Parent) loader.load();
				root.getStylesheets().add("application.css");// CSS
				GraphicsWindowController nc = loader.getController();
				nc.setEmpresa(empresa);
				nc.graficar(240000.0, 6.0, 12.0);
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				stage.setScene(new Scene(root));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
	    }

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void generarDatos() {
		equilibrioDinero.setText(" "+ empresa.puntoQP());
		equilibrioUnidades.setText(" "+ empresa.puntoQ());
		seguridadDinero.setText(" "+ empresa.MSP());
		seguridadPorcentaje.setText("Esto falta");
		seguridadUnidades.setText(" "+ empresa.MS());
		contribucionDinero.setText(" "+ empresa.mcPonderadoP());
		contribucionPorcentaje.setText(" "+ empresa.mcPonderado());
		apalancamiento.setText(" "+ empresa.apalancamiento());
	}
	 
}//final
