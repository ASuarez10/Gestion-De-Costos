package application;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IndicatorWindowController {

	@FXML
	void back(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			Parent root = (Parent) loader.load();
			root.getStylesheets().add("application.css");// CSS
			MainWindowController nc = loader.getController();
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
				nc.graficar(240000.0, 6.0, 12.0);
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				stage.setScene(new Scene(root));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
	    }
	
}//final
