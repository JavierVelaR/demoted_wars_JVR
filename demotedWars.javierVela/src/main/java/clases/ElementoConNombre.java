package clases;

public class ElementoConNombre {
	private String nombre;

	public ElementoConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\n";
	}
	
}
