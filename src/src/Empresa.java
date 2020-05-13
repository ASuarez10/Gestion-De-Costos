package src;

import java.util.ArrayList;

public class Empresa {
	private double costoF;
	private ArrayList<Producto> productos;
	private String nombre;
	public Empresa(double costoF, String nombre) {
		super();
		this.costoF = costoF;
		this.nombre = nombre;
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
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double volumenVentas() {
		double cantidades = 0;
		for (int i = 0; i < getProductos().size(); i++) {
			cantidades += getProductos().get(i).getCantidades();
		}
		return cantidades;
	}
	
	public double volumenVentasP() {
		double cantidad =0;
		for (int i = 0; i < getProductos().size(); i++) {
			cantidad+=getProductos().get(i).utilidadUnitaria();
		}
		return cantidad;
	}
	
	public double utilidadActual() {
		return volumenVentasP()-getCostoF();
	}
	
	public double utilidadActualP() {
		return utilidadActual()/ventasT();
	}
	
	public double ventasT() {
		double volumen = 0;
		for (int i = 0; i < getProductos().size(); i++) {
			volumen+=getProductos().get(i).Tventa();
		}
		return volumen;
	}
	
	public ArrayList<Double> mixVentasU(){
		ArrayList<Double> porcentajes = new ArrayList<>();
		double aux;
		for (int i = 0; i < getProductos().size(); i++) {
			aux = getProductos().get(i).getCantidades()/volumenVentas();
			porcentajes.add(aux);
		}
		return porcentajes;
	}
	
	public double mcTotal() {
		double aux = 0;
		for (int i = 0; i < getProductos().size(); i++) {
			aux+=getProductos().get(i).mc();
		}
		return aux;
	}
	
	public double mcTotalP() {
		return mcTotal()/ventasT();
	}
	
	public ArrayList<Double> mixVentasDinero(){
		ArrayList<Double> porcentajes = new ArrayList<>();
		double aux;
		for (int i = 0; i < getProductos().size(); i++) {
			aux = getProductos().get(i).Tventa()/ventasT();
			porcentajes.add(aux);
		}
		return porcentajes;
	}
	
	public double apalancamiento() {
		return utilidadActual()/mcTotal();
	}
	
	public double utilidadProyectada(double pro) {
		return apalancamiento()*pro;
	}
	
	public double mcPonderado() {
		double aux = 0;
		for (int i = 0; i <getProductos().size(); i++) {
			aux+= getProductos().get(i).mc()*mixVentasU().get(i);
		}
		return aux;
	}
	
	public double mcPonderadoP() {
		double aux = 0;
		for (int i = 0; i <getProductos().size(); i++) {
			aux+= getProductos().get(i).mcP()*mixVentasDinero().get(i);
		}
		return aux;
	}
	
	public double puntoQ() {
		return getCostoF()/mcPonderado();
	}
	
	public double puntoQP() {
		return getCostoF()/mcPonderadoP();
	}
	
	public double  UtilidadPlaneada(double Utilidad) { // devuelve las unidades necesarias para obtener la utilidad planeada
		return (getCostoF()+Utilidad)/mcPonderadoP();
	}
	
	public double  UtilidadPlaneadaInv(double x) { // devuelve la utilidad obtenida segun una cantidad
		return (x*mcPonderado())-getCostoF();
	}
	
	public double MS(double ventasCant) {
		return ventasCant-puntoQ();
	}
	
	public double MSP(double ventas) {
		return ventas-puntoQP();
	}
	
}
