package clases.unidades;

import clases.ElementoConNombre;

public class Unidad extends ElementoConNombre {
	private byte vida;
	private byte rangoMovimiento;
	
	public Unidad(String nombre, byte vida, byte rangoMovimiento) {
		super(nombre);
		this.vida = vida;
		this.rangoMovimiento = rangoMovimiento;
	}

	public byte getVida() {
		return vida;
	}

	public void setVida(byte vida) {
		if(vida>10){
			this.vida = 10;
		}else if(vida<0) {
			this.vida = 0;
		}else {
			this.vida = vida;
		}
	}

	public byte getRangoMovimiento() {
		return rangoMovimiento;
	}

	public void setRangoMovimiento(byte rangoMovimiento) {
		this.rangoMovimiento = rangoMovimiento;
	}

	@Override
	public String toString() {
		return super.toString() + "\tVida: " + vida + "\n\tRango de movimiento: " + rangoMovimiento + "\n";
	}
	
	
	
}
