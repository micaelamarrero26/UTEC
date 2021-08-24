import java.util.LinkedList;

public class Funcionalidad {
	private int id_funcionalidad;
	private String nombre;
	private String descripcion;
	private LinkedList<Rol> rolesConEsaFuncionalidad = new LinkedList<Rol>();
	
	public Funcionalidad(int id_funcionalidad, String nombre, String descripcion,
			LinkedList<Rol> rolesConEsaFuncionalidad) {
		super();
		this.id_funcionalidad = id_funcionalidad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.rolesConEsaFuncionalidad = rolesConEsaFuncionalidad;
	}
	
	public int getId_funcionalidad() {
		return id_funcionalidad;
	}
	public void setId_funcionalidad(int id_funcionalidad) {
		this.id_funcionalidad = id_funcionalidad;
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
	public LinkedList<Rol> getRolesConEsaFuncionalidad() {
		return rolesConEsaFuncionalidad;
	}
	public void setRolesConEsaFuncionalidad(LinkedList<Rol> rolesConEsaFuncionalidad) {
		this.rolesConEsaFuncionalidad = rolesConEsaFuncionalidad;
	}
	
	@Override
	public String toString() {
		return "Funcionalidad [id_funcionalidad=" + id_funcionalidad + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", rolesConEsaFuncionalidad=" + rolesConEsaFuncionalidad + "]";
	}
	
	

}
