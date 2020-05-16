package src;

public class Producto {
	private double precio;
	private double costoV;
	private double cantidades;

	public Producto(double precio, double costoV, double cantidades) {
		super();
		this.precio = precio;
		this.costoV = costoV;
		this.cantidades = cantidades;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getCostoV() {
		return costoV;
	}

	public void setCostoV(double costoV) {
		this.costoV = costoV;
	}

	public double getCantidades() {
		return cantidades;
	}

	public void setCantidades(double cantidades) {
		this.cantidades = cantidades;
	}

	public double Tventa() {
		return (getPrecio()) * getCantidades();
	}

	public double mc() {
		return (getPrecio() - getCostoV());
	}

	public double mcP() {
		return (getPrecio() / mc());
	}

	public double utilidadUnitaria() {
		return (mc() * getCantidades());
	}

}
