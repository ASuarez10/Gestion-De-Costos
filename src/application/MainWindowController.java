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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import src.Empresa;
import src.Producto;

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
	
	private Empresa empresa;
	
    @FXML
    void seeIndicator(ActionEvent event) {
    	if(empresa == null) {
    		Alert noData = new Alert(AlertType.ERROR);
    		noData.setContentText("No hay productos agregados");
    		noData.setTitle("Sin datos");
    		noData.show();
    	}else {
	    	try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("IndicatorWindow.fxml"));
				Parent root = (Parent) loader.load();
				root.getStylesheets().add("application.css");// CSS
				IndicatorWindowController nc = loader.getController();
				nc.setEmpresa(empresa);
				nc.generarDatos();
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				stage.setScene(new Scene(root));
	
			} catch (Exception ex) {
				ex.printStackTrace();
			}
    	}
    }
    
    public void disableTextFields() {
    	costosFijos.setDisable(true);
    	crecimiento.setDisable(true);
    	utilidadMeta.setDisable(true);
    }
    
    
    @FXML
    void guardarProducto(ActionEvent event) {
    	if(precioVenta.getText().equals("") || precioVenta.getText().equals("") || precioVenta.getText().equals("") 
    	|| precioVenta.getText().equals("") || precioVenta.getText().equals("") || precioVenta.getText().equals(""))
    	{
    		Alert noData = new Alert(AlertType.ERROR);
    		noData.setContentText("Tienes campos vacios");
    		noData.setTitle("Datos insuficientes");
    		noData.show();
    	}else {
    		Alert added = new Alert(AlertType.INFORMATION);
    		added.setContentText("Datos agregados exitosamente");
    		added.setTitle("Agregado");
    		
	    	if(empresa == null) {
	    		empresa = new Empresa(Double.parseDouble(costosFijos.getText()), Double.parseDouble(crecimiento.getText()),
	    									Double.parseDouble(utilidadMeta.getText()));
	    		
	    		Producto nuevo = new Producto(Double.parseDouble(precioVenta.getText()),
	    		Double.parseDouble(costoVariable.getText()), Double.parseDouble(cantidadesVendidas.getText()));
	    		
	    		empresa.addProducto(nuevo);
	    		disableTextFields();
	    		added.show();
	    	}else {
	    		Producto nuevo = new Producto(Double.parseDouble(precioVenta.getText()),
						Double.parseDouble(costoVariable.getText()), Double.parseDouble(cantidadesVendidas.getText()));

	    		empresa.addProducto(nuevo);
	    		added.show();
	    	}
    	}
    }
    
    @FXML
    void generar(ActionEvent event) {
    	if(empresa == null) {
    		Alert noData = new Alert(AlertType.ERROR);
    		noData.setContentText("No hay productos agregados");
    		noData.setTitle("Sin datos");
    		noData.show();
    	}else {
    		uoPorcentaje.setText(" "+ empresa.utilidadActualP());
    		uoPesos.setText(" "+ empresa.utilidadActual());
    		upPesos.setText(" "+ empresa.utilidadPlanesPesos());
    		upPorcentaje.setText(" "+ empresa.utilidadProyectada());
    		unidadesMeta.setText(" "+ empresa.UtilidadPlaneada());
    	}
    }

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
    
}//final
