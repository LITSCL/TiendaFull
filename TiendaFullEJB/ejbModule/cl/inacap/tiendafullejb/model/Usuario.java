package cl.inacap.tiendafullejb.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
	@NamedQuery(name = "Usuario.getAllUsuarios", query = "SELECT us FROM Usuario us")
})
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String nombre;
	private String apellido;
	private String correo;
	private String password;
	private String tipo;
	
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario() {
		super();
	}
   
}
