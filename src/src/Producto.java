package src;

public class Producto {
	private String nombre;
	private String id;
	private double precio;
	private double costoV;
	private double cantidades;
	private double vVentas;
	
	
	public Producto(String nombre, String id, double precio, double costoV, double cantidades, double vVentas) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.precio = precio;
		this.costoV = costoV;
		this.cantidades = cantidades;
		this.vVentas = vVentas;
	}
	


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
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



	public double getvVentas() {
		return vVentas;
	}



	public void setvVentas(double vVentas) {
		this.vVentas = vVentas;
	}



	public double Tventa() {
		return (getPrecio())*getCantidades();
	}
	
	public double costeM() {
		return (getPrecio()-getCostoV());
	}
	
	public double costeMP() {
		return (getPrecio()/costeM());
	}
	
	public double utilidadUnitaria() {
		return (costeM()*getCantidades());
	}
	
	public double mcTotal() {
		return getCantidades()*getPrecio();
	}
	
	
}
