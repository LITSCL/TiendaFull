package cl.inacap.tiendafullejb.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Categoria
 *
 */
@Entity
@Table(name = "categoria")
@NamedQueries({
	@NamedQuery(name = "Categoria.getAllCategorias", query = "SELECT ca FROM Categoria ca")
})
public class Categoria implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String nombre;
	private String detalle;
	
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

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Categoria() {
		super();
	}
   
}
