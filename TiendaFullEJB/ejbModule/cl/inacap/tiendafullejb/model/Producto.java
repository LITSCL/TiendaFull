package cl.inacap.tiendafullejb.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity
@Table(name = "producto")
@NamedQueries({
	@NamedQuery(name = "Producto.getAllProductos", query = "SELECT pr FROM Producto pr")
})

public class Producto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String nombre;
	private String descripcion;
	private int precio;
	private int stock;
	private int stock_minimo;
	private int categoria_id;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getStock_minimo() {
		return stock_minimo;
	}


	public void setStock_minimo(int stock_minimo) {
		this.stock_minimo = stock_minimo;
	}


	public int getCategoria_id() {
		return categoria_id;
	}


	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}


	public Producto() {
		super();
	}
   
}
