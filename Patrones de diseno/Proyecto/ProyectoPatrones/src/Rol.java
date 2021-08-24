import java.util.LinkedList;

public class Rol {
	private int id_rol;
	private String nombre;
	private String descripcion;
	private LinkedList<Persona> personas = new LinkedList<Persona>();
	private LinkedList<Funcionalidad> funcionalidades = new LinkedList<Funcionalidad>();
	public Rol(int id_rol, String nombre, String descripcion, LinkedList<Persona> personas,
			LinkedList<Funcionalidad> funcionalidades) {
		super();
		this.id_rol = id_rol;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.personas = personas;
		this.funcionalidades = funcionalidades;
	}
	
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
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
	public LinkedList<Persona> getPersonas() {
		return personas;
	}
	public void setPersonas(LinkedList<Persona> personas) {
		this.personas = personas;
	}
	public LinkedList<Funcionalidad> getFuncionalidades() {
		return funcionalidades;
	}
	public void setFuncionalidades(LinkedList<Funcionalidad> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}
	
	@Override
	public String toString() {
		return "Rol [id_rol=" + id_rol + ", nombre=" + nombre + ", descripcion=" + descripcion + ", personas="
				+ personas + ", funcionalidades=" + funcionalidades + "]";
	}

	
	
}
