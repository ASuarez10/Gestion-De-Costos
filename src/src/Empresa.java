package src;

import java.util.ArrayList;

public class Empresa {
	private double costoF;
	private ArrayList<Producto> productos;
	private double crecimiento;
	private double utilidadMeta;

	public Empresa(double costoF, double crecimiento, double utilidadMeta) {
		super();
		this.costoF = costoF;
		productos = new ArrayList<Producto>();
	}

	public double getCostoF() {
		return costoF;
	}

	public void setCostoF(double costoF) {
		this.costoF = costoF;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public double getCrecimiento() {
		return crecimiento;
	}

	public void setCrecimiento(double crecimiento) {
		this.crecimiento = crecimiento;
	}

	public double getUtilidadMeta() {
		return utilidadMeta;
	}

	public void setUtilidadMeta(double utilidadMeta) {
		this.utilidadMeta = utilidadMeta;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public double volumenVentas() {
		double cantidades = 0;
		for (int i = 0; i < getProductos().size(); i++) {
			cantidades += getProductos().get(i).getCantidades();
		}
		return cantidades;
	}

	public double volumenVentasP() {
		double cantidad = 0;
		for (int i = 0; i < getProductos().size(); i++) {
			cantidad += getProductos().get(i).utilidadUnitaria();
		}
		return cantidad;
	}

	public double utilidadActual() {
		return volumenVentasP() - getCostoF();
	}

	public double utilidadActualP() {
		return utilidadActual() / ventasT();
	}

	public double ventasT() {
		double volumen = 0;
		for (int i = 0; i < getProductos().size(); i++) {
			volumen += getProductos().get(i).Tventa();
		}
		return volumen;
	}

	public ArrayList<Double> mixVentasU() {
		ArrayList<Double> porcentajes = new ArrayList<>();
		double aux;
		for (int i = 0; i < getProductos().size(); i++) {
			aux = getProductos().get(i).getCantidades() / volumenVentas();
			porcentajes.add(aux);
		}
		return porcentajes;
	}

	public double mcTotal() {
		double aux = 0;
		for (int i = 0; i < getProductos().size(); i++) {
			aux += getProductos().get(i).mc();
		}
		return aux;
	}

	public double mcTotalP() {
		return mcTotal() / ventasT();
	}

	public ArrayList<Double> mixVentasDinero() {
		ArrayList<Double> porcentajes = new ArrayList<>();
		double aux;
		for (int i = 0; i < getProductos().size(); i++) {
			aux = getProductos().get(i).Tventa() / ventasT();
			porcentajes.add(aux);
		}
		return porcentajes;
	}

	public double apalancamiento() {
		return utilidadActual() / mcTotal();
	}

	public double utilidadProyectada() {
		return apalancamiento() * (crecimiento/100);
	}

	public double mcPonderado() {
		double aux = 0;
		for (int i = 0; i < getProductos().size(); i++) {
			aux += getProductos().get(i).mc() * mixVentasU().get(i);
		}
		return aux;
	}

	public double mcPonderadoP() {
		double aux = 0;
		for (int i = 0; i < getProductos().size(); i++) {
			aux += getProductos().get(i).mcP() * mixVentasDinero().get(i);
		}
		return aux;
	}

	public double puntoQ() {
		return getCostoF() / mcPonderado();
	}

	public double puntoQP() {
		return getCostoF() / mcPonderadoP();
	}

	public double UtilidadPlaneada(double utilidad) { // devuelve las unidades necesarias para obtener la utilidad
														// planeada
		return (getCostoF() + utilidad) / mcPonderadoP();
	}

	public double UtilidadPlaneadaInv(double x) { // devuelve la utilidad obtenida segun una cantidad
		return (x * mcPonderado()) - getCostoF();
	}

	public double MS() {
		return volumenVentas() - puntoQ();
	}

	public double MSP() {
		return volumenVentasP() - puntoQP();
	}

	public void addProducto(Producto nuevo) {
		productos.add(nuevo);
	}

	public double utilidadPlanesPesos() {//TODO
		return utilidadActual()+(utilidadActual()*utilidadProyectada());
	}

}// final
