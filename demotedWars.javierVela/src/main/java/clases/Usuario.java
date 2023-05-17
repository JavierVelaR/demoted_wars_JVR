package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import excepciones.ContraseñaInvalidaException;
import excepciones.UsuarioNoExisteException;
import utils.DAO;

public class Usuario{
	private String email;
	private String nick;
	private int dinero;
	
	
	public Usuario(String email, String nick, String pass) throws SQLException {
		super();
		LinkedHashMap<String, Object> nuevo = new LinkedHashMap<String, Object>();
		nuevo.put("nick", nick);
		nuevo.put("password", pass);
		nuevo.put("email", email);
		DAO.insert("user", nuevo);
		
		this.email = email;
		this.nick = nick;
	}
	
	public Usuario(String email, String pass) throws SQLException, UsuarioNoExisteException, ContraseñaInvalidaException {
		super();
		LinkedHashSet<String> buscar = new LinkedHashSet<String>();
		buscar.add("email");
		buscar.add("password");
		buscar.add("nick");
		
		LinkedHashMap<String, Object> restr= new LinkedHashMap<String,Object>();
		restr.put("email", email);
		
		ArrayList<Object> usuario = DAO.select("user", buscar, restr);
		String passString;
		
			if(usuario.isEmpty()) {
				throw new UsuarioNoExisteException("No existe el usuario");
				
			}else {
				if(usuario.get(1).getClass()!=String.class) {
					passString = Integer.toString((int) usuario.get(1));
					
				}else{
					passString = (String) usuario.get(1);
				}
				
				if(passString.equals(pass)) {
					this.email = (String) usuario.get(0);
					this.nick = (String) usuario.get(2);
				}else {
					throw new ContraseñaInvalidaException("Contraseña inválida");
				}
			}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws SQLException {
		HashMap<String, Object> datosAModificar = new HashMap<String, Object>();
		datosAModificar.put("email", email);
		
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		restricciones.put("email", this.email);
		
		DAO.update("user", datosAModificar, restricciones);
		
		this.email = email;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) throws SQLException {
		HashMap<String, Object> datoAModificar = new HashMap<String, Object>();
		datoAModificar.put("nick", nick);
		
		HashMap<String, Object> restriccion = new HashMap<String, Object>();
		restriccion.put("email", this.email);
		
		DAO.update("user", datoAModificar, restriccion);
		
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "Email: " + email + "\nNick: " + nick + "\nDinero: " + dinero;
	}
	
	
	
	
}
