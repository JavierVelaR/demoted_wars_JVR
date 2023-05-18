package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import clases.Usuario;
import excepciones.ContraseñaInvalidaException;
import excepciones.UsuarioNoExisteException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaRegistro extends JPanel{
protected Ventana ventana;
private JTextField campoEmail;
private JTextField campoNick;
private JPasswordField passwordField;
	
	public PantallaRegistro(Ventana v) {
		this.ventana = v;
		setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setBounds(367, 216, 51, 20);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblEmail);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(453, 213, 143, 26);
		campoEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		add(campoEmail);
		campoEmail.setColumns(10);
		
		JLabel lblNick = new JLabel("Nick");
		lblNick.setForeground(new Color(0, 0, 0));
		lblNick.setBounds(368, 253, 40, 20);
		lblNick.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblNick);
		
		campoNick = new JTextField();
		campoNick.setBounds(453, 250, 143, 26);
		campoNick.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		campoNick.setColumns(10);
		add(campoNick);
		
		JLabel lblPass = new JLabel("Contraseña");
		lblPass.setForeground(new Color(0, 0, 0));
		lblPass.setBounds(348, 292, 89, 20);
		lblPass.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lblPass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(453, 290, 143, 26);
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		add(passwordField);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String email = campoEmail.getText();
				String nick = campoNick.getText();
				String pass = new String(passwordField.getPassword());
				
				try {
					Usuario nuevo = new Usuario(email, nick, pass);
					
					JOptionPane.showMessageDialog(ventana, "Se ha registrado el usuario", 
						"Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
					
					ventana.cambiarAPantalla(PantallaLogin.class);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, "No se puede conectar a la BD",
							"Error al registrarse", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(417, 372, 111, 29);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tengo cuenta, iniciar sesión");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);
			}
		});
		btnNewButton_1.setBounds(729, 552, 227, 25);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..\\dw_fotos\\register.png"));
		lblNewLabel.setBounds(0, 0, 966, 588);
		add(lblNewLabel);
	}
	
}