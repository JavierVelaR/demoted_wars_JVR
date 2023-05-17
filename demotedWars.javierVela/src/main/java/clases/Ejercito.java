package clases;

import java.awt.MultipleGradientPaint.ColorSpaceType;
import java.util.TreeSet;

import clases.unidades.Unidad;
import enums.Colores;

public class Ejercito {
	private Usuario usuario;
	private TreeSet<Unidad> unidades;
	private Colores color;
	
	public Ejercito(Usuario usuario, TreeSet<Unidad> unidades, Colores color) {
		super();
		this.usuario = usuario;
		this.unidades = unidades;
		this.color = color;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TreeSet<Unidad> getUnidades() {
		return unidades;
	}

	public void setUnidades(TreeSet<Unidad> unidades) {
		this.unidades = unidades;
	}

	public Colores getColor() {
		return color;
	}

	public void setColor(Colores color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Ejercito:\nUsuario: " + usuario.getNick() + "\nUnidades: " + unidades.toString() + "\nColor: " + color;
	}
	
}
