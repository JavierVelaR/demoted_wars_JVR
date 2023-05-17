package clases.unidades;

public class UnidadAtaqueDistancia extends UnidadAtaque{
	private byte rangoAtaque;
	
	public UnidadAtaqueDistancia(String nombre, byte vida, byte rangoMovimiento, byte daño, byte rangoAtaque) {
		super(nombre, vida, rangoMovimiento, daño);
		this.rangoAtaque = rangoAtaque;
		// TODO Auto-generated constructor stub
	}

	public byte getRangoAtaque() {
		return rangoAtaque;
	}
	
	public void setRangoAtaque(byte rangoAtaque) {
		this.rangoAtaque = rangoAtaque;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
