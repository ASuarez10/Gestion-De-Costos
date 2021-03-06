package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import src.Empresa;

public class GraphicsWindowController {

	@FXML
	private Label equilibrio;
	private double equilibrio2;
	private Empresa empresa;
	// Primera funcion
	@FXML
	private LineChart<Double, Double> graph;
	@FXML
	private NumberAxis x;
	@FXML
	private NumberAxis y;

	@FXML
	void back(ActionEvent event) {
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

	private void pintarGrafica(int min, double max, double cfijo, double cvariable, double ingresos) {

		equilibrio.setText("Punto de equilibrio: " + equilibrio2);

		ObservableList<XYChart.Series<Double, Double>> lineChartData = FXCollections.observableArrayList();

		LineChart.Series<Double, Double> series = new LineChart.Series<Double, Double>();
		LineChart.Series<Double, Double> series2 = new LineChart.Series<Double, Double>();

		series.setName("f(" + cfijo + "+" + cvariable + "X)");
		series2.setName("f(" + ingresos + "X)");

		double multiplicador = cfijo / 100;

		for (double i = min; i < max; i = i + multiplicador) {
			series.getData().add(new XYChart.Data<Double, Double>(i, cfijo + (cvariable * i)));
			series2.getData().add(new XYChart.Data<Double, Double>(i, ingresos * i));
		}

		lineChartData.add(series);
		lineChartData.add(series2);

		graph.setCreateSymbols(false);

		graph.setData(lineChartData);
		graph.createSymbolsProperty();
	}

	public void graficar(double cfijo, double cvariable, double ingresos) {
		equilibrio2 = cfijo / (ingresos - cvariable);
		pintarGrafica(0, (equilibrio2 * 2), cfijo, cvariable, ingresos);
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}// final