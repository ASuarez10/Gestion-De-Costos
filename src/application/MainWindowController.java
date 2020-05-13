package application;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainWindowController {
	
    @FXML
	void seeProducts(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductWindow.fxml"));
			Parent root = (Parent) loader.load();
			root.getStylesheets().add("application.css");// CSS
			ProductWindowController nc = loader.getController();
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
    
    @FXML
    void seeUtility(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("UtilityWindow.fxml"));
			Parent root = (Parent) loader.load();
			root.getStylesheets().add("application.css");// CSS
			UtilityWindowController nc = loader.getController();
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
			nc.graficar(100000.0/1000, 6.0, 12.0/1000);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
    
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
    
    @FXML
    void seeApalancamiento(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ApalancamientoWindow.fxml"));
			Parent root = (Parent) loader.load();
			root.getStylesheets().add("application.css");// CSS
			ApalancamientoWindowController nc = loader.getController();
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
}//final
