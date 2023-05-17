package interfaces;

import javax.swing.JFrame;
import clases.Usuario;

public class Ventana extends JFrame {
	
	protected Usuario usuarioLogueado;
	
	public Ventana() {
		this.setSize(625,550);
		this.setTitle("Prueba interfaces");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(new PantallaLogin(this));
		this.setVisible(true);
	}
	
	public void cambiarAPantalla(Class<?>clase) {
		this.getContentPane().setVisible(false);
		if(clase.equals(PantallaLogin.class)) {
			this.setContentPane(new PantallaLogin(this));
		}else if(clase.equals(PantallaRegistro.class)) {
			this.setContentPane(new PantallaRegistro(this));
		}
		this.setVisible(true);

	}
}
