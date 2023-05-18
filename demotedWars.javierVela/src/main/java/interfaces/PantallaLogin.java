package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;

import clases.Usuario;
import excepciones.ContraseñaInvalidaException;
import excepciones.UsuarioNoExisteException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaLogin extends JPanel {
	protected Ventana ventana;
	private JTextField campoEmail;
	private JPasswordField campoPass;
	
	public PantallaLogin(Ventana v) {
		this.ventana = v;
		setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(327, 305, 51, 21);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblEmail);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(451, 304, 167, 23);
		campoEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		add(campoEmail);
		campoEmail.setColumns(10);
		
		JLabel lblPass = new JLabel("Contraseña");
		lblPass.setBounds(307, 362, 91, 21);
		lblPass.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblPass);
		
		campoPass = new JPasswordField();
		campoPass.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		campoPass.setBounds(451, 362, 167, 20);
		add(campoPass);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String email = campoEmail.getText();
				String pass = new String(campoPass.getPassword());
				
				try {
					Usuario login = new Usuario(email,pass);
					
					JOptionPane.showMessageDialog(ventana, "Se ha iniciado sesión", 
							"Inicio de sesión válido", JOptionPane.INFORMATION_MESSAGE);
					
					ventana.cambiarAPantalla(PantallaJuego.class);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, "No se puede conectar a la BD",
							"Error al hacer Login", JOptionPane.ERROR_MESSAGE);
				} catch (UsuarioNoExisteException e1) {
					JOptionPane.showMessageDialog(ventana, "No existe el usuario",
							"Error al hacer Login", JOptionPane.ERROR_MESSAGE);
				} catch (ContraseñaInvalidaException e1) {
					JOptionPane.showMessageDialog(ventana, "Contraseña inválida",
							"Error al hacer Login", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnIniciarSesion.setBounds(387, 433, 143, 29);
		btnIniciarSesion.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(btnIniciarSesion);
		
		JButton btnRegistrarse = new JButton("No tengo cuenta, registrarme");
		btnRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaRegistro.class);
			}
		});
		btnRegistrarse.setBounds(727, 556, 230, 25);
		btnRegistrarse.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		add(btnRegistrarse);
		
		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setIcon(new ImageIcon("..\\dw_fotos\\Intro.jpg"));
		lblImagenFondo.setBounds(0, 0, 965, 589);
		add(lblImagenFondo);
	
	}
}