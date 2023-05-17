package clases;

import java.util.Arrays;

public class Mapa {
	private Casilla[][] casillas = new Casilla[8][8];

	public Mapa(Casilla[][] casillas) {
		super();
		this.casillas = casillas;
	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}

	@Override
	public String toString() {
		return "Mapa:\nCasillas: " + Arrays.toString(casillas);
	}
	
}
