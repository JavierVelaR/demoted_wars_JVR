package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PantallaJuego extends JPanel{
	private Ventana ventana;
	
	public PantallaJuego(Ventana v) {
		this.ventana = v;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("..\\dw_fotos\\cap general.png"));
		lblNewLabel.setBounds(0, 0, 958, 587);
		add(lblNewLabel);
	}
}
