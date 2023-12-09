package cl.inacap.tiendafullejb.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cl.inacap.tiendafullejb.model.Categoria;
import cl.inacap.tiendafullejb.model.Producto;
import cl.inacap.tiendafullejb.model.Sucursal;
import cl.inacap.tiendafullejb.model.Usuario;

/**
 * Session Bean implementation class Servicio
 */
@Stateless
@LocalBean
public class Servicio implements ServicioLocal {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TiendaFullEJB");
    /**
     * Default constructor. 
     */
    public Servicio() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String saveSucursal(Sucursal su) {
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(su);
			em.flush();
			return "Sucursal añadida con exito";
		} catch (Exception ex) {
			return "No se pudo añadir la sucursal";
		}
		finally {
			em.close();
		}
	}

	@Override
	public List<Sucursal> getAllSucursal() {
		EntityManager em = this.emf.createEntityManager();
		try {
			List<Sucursal> sucursales = em.createNamedQuery("Sucursal.getAllSucursales", Sucursal.class).getResultList();
			return sucursales;
		} catch (Exception ex) {
			return null;
		}
		finally {
			em.close();
		}
	}

	@Override
	public void deleteSucursal(int id) {
		EntityManager em = this.emf.createEntityManager();
		Sucursal su = new Sucursal();
		try {
			su = em.find(Sucursal.class, id);
			em.remove(su);
			em.flush();
		} catch (Exception ex) {
			
		}
		finally {
			em.close();
		}
	}

	@Override
	public void updateSucursal(Sucursal su) {
		EntityManager em = this.emf.createEntityManager();
		Sucursal suc = new Sucursal();
		try {
			suc = em.find(Sucursal.class, su.getId());
			suc.setNombre(su.getNombre());
			suc.setDireccion(su.getDireccion());
			suc.setComuna(su.getComuna());
			suc.setTelefono(su.getTelefono());
			em.merge(suc);
			em.flush();
		} catch (Exception ex) {

		}
		finally {
			em.close();
		}
	}

	@Override
	public List<Producto> getAllProducto() {
		EntityManager em = this.emf.createEntityManager();
		try {
			List<Producto> productos = em.createNamedQuery("Producto.getAllProductos", Producto.class).getResultList();
			return productos;
		} catch (Exception ex) {
			return null;
		}
		finally {
			em.close();
		}
	}

	@Override
	public String saveProducto(Producto pr) {
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(pr);
			em.flush();
			return "Producto añadido con exito";
		} catch (Exception ex) {
			return "No se pudo añadir el producto";
		}
		finally {
			em.close();
		}
	}

	@Override
	public void deleteProducto(int id) {
		EntityManager em = this.emf.createEntityManager();
		Producto pr=new Producto();
		try {
			pr = em.find(Producto.class, id);
			em.remove(pr);
			em.flush();
		} catch (Exception ex) {
			
		}
		finally {
			em.close();
		}
		
	}

	@Override
	public void updateProducto(Producto pr) {
		EntityManager em = this.emf.createEntityManager();
		Producto pro = new Producto();
		try {
			pro = em.find(Producto.class, pr.getId());
			pro.setNombre(pr.getNombre());
			pro.setDescripcion(pr.getDescripcion());
			pro.setPrecio(pr.getPrecio());
			pro.setStock(pr.getStock());
			pro.setStock_minimo(pr.getStock_minimo());
			pro.setCategoria_id(pr.getCategoria_id());
			em.merge(pro);
			em.flush();
		}catch (Exception ex) {

		}
		finally {
			em.close();
		}
		
	}

	@Override
	public List<Categoria> getAllCategoria() {
		EntityManager em = this.emf.createEntityManager();
		try {
			List<Categoria> categorias = em.createNamedQuery("Categoria.getAllCategorias", Categoria.class).getResultList();
			return categorias;
		} catch (Exception ex) {
			return null;
		}
		finally {
			em.close();
		}
	}

	@Override
	public String saveCategoria(Categoria ca) {
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(ca);
			em.flush();
			return "Categoría añadida con exito";
		} catch (Exception ex) {
			return "No se pudo añadir la categoría";
		}
		finally {
			em.close();
		}
	}

	@Override
	public String deleteCategoria(int id) {
		EntityManager em = this.emf.createEntityManager();
		Categoria ca = new Categoria();
		try {
			ca = em.find(Categoria.class, id);
			em.remove(ca);
			em.flush();
			return null;
		} catch (Exception ex) {
			return "No se puede borrar (La categoría esta siendo utilizada por un producto)";
		}
		finally {
			em.close();
		}
		
	}

	@Override
	public void updateCategoria(Categoria ca) {
		EntityManager em = this.emf.createEntityManager();
		Categoria cat = new Categoria();
		try {
			cat = em.find(Categoria.class, ca.getId());
			cat.setNombre(ca.getNombre());
			cat.setDetalle(ca.getDetalle());
			em.merge(cat);
			em.flush();
		} catch (Exception ex) {

		}
		finally {
			em.close();
		}
		
	}

	@Override
	public List<Usuario> getAllUsuario() {
		EntityManager em = this.emf.createEntityManager();
		try {
			List<Usuario> usuarios = em.createNamedQuery("Usuario.getAllUsuarios", Usuario.class).getResultList();
			return usuarios;
		} catch (Exception ex) {
			return null;
		}
		finally {
			em.close();
		}
	}

	@Override
	public String saveUsuario(Usuario us) {
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(us);
			em.flush();
			return "Usuario añadido con exito";
		} catch (Exception ex) {
			return "No se pudo añadir el usuario";
		}
		finally {
			em.close();
		}
	}

}
