package clases.unidades;

public class UnidadAtaque extends Unidad{
	private byte daño;

	public UnidadAtaque(String nombre, byte vida, byte rangoMovimiento, byte daño) {
		super(nombre, vida, rangoMovimiento);
		this.daño = daño;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\tDaño: " + daño + "\n";
	}
	
	
}
