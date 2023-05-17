package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

public abstract class DAO {
	private static Connection connection;

	private static Statement connect() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:17770/demoted_wars", "root", "");
			return connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static int insert(String table, HashMap<String, Object> campos) throws SQLException {
		Statement querier = connect();
		String query = "insert into " + table + " (";
		Iterator it = campos.keySet().iterator();
		while (it.hasNext()) {
			String clave = "" + it.next();
			query += clave + ",";
		}
		query = query.substring(0, query.length() - 1) + ") values (";

		Iterator iter = campos.values().iterator();
		while (iter.hasNext()) {
			Object elem = iter.next();
			
			if(elem.getClass()!=String.class && elem.getClass()!=Character.class) {
				query += elem + ",";
			}else {
				query += "'" + (String)elem + "',";
			}
			
			
		}
		query = query.substring(0, query.length() - 1) + ")";

		if (Config.verboseMode) {
			System.out.println(query);
		}

		int ret = querier.executeUpdate(query);
		disconnect(querier);
		return ret;
	}

	public static int delete(String table, HashMap<String, Object> campos) throws SQLException {
		Statement querier = connect();
		String query = "delete from " + table + " where ";
		Iterator it = campos.entrySet().iterator();
		while (it.hasNext()) {
			Entry actual = (Entry) it.next();
			
			if(actual.getValue().getClass()!=String.class && actual.getValue().getClass()!=Character.class) {
				query += actual.getKey() + " = " + actual.getValue() + " and ";
			}else {
				query += actual.getKey() + " = '" + (String)actual.getValue() + "' and ";
			}
		}
		query = query.substring(0, query.length() - 5);

		if (Config.verboseMode) {
			System.out.println(query);
		}

		int ret = querier.executeUpdate(query);

		disconnect(querier);
		return ret;
	}

	public static ArrayList<Object> select(String table, LinkedHashSet<String> columnasSelect, HashMap<String, Object> restricciones) throws SQLException {
		Statement smt = connect();
		String query = "select ";
		
		Iterator ith = columnasSelect.iterator();
		while(ith.hasNext()) {
			query += ith.next()+", ";
		}

		query = query.substring(0,query.length()-2);
		query += " from " + table + (restricciones.size() > 0 ? " where " : "");
		
		Iterator itr = restricciones.entrySet().iterator();
		while(itr.hasNext()) {
			Entry actual = (Entry)itr.next();
			
			if(actual.getValue().getClass()!=String.class && actual.getValue().getClass()!=Character.class) {
				query += actual.getKey() + " = " + (String)actual.getValue() + " and ";
			}else {
				query += actual.getKey() + " = '" + (String)actual.getValue() + "' and ";
			}
		}
		
		if(restricciones.size()>0) {
			query = query.substring(0,query.length()-5);
		}
		
		if (Config.verboseMode) {
			System.out.println(query);
		}
		
		ResultSet cursor = smt.executeQuery(query);
		ArrayList<Object> fila = new ArrayList<Object>();
		
		while (cursor.next()) {
			Iterator hsCols = columnasSelect.iterator();
			while(hsCols.hasNext()) {
				String nombreCol = "" + hsCols.next();
				try {
					fila.add(cursor.getInt(cursor.findColumn(nombreCol)));
					
				}catch(NumberFormatException | SQLDataException  e) {
					fila.add(cursor.getString(cursor.findColumn(nombreCol)));

				}
			}
	
		}

		disconnect(smt);
		
		return fila;

	}
	
	public static int update(String table, HashMap<String, Object> datosModificar, HashMap<String, Object> restricciones) throws SQLException{
		String query = "update " + table + " set ";
		Iterator itm = datosModificar.entrySet().iterator();
		while(itm.hasNext()) {
			Entry actual = (Entry)itm.next();
			
			if(actual.getValue().getClass()!=String.class && actual.getValue().getClass()!=Character.class) {
				query += actual.getKey() + " = " + actual.getValue() + ", ";
			}else {
				query += actual.getKey() + " = '" + (String)actual.getValue() + "', ";
			}
			
		}
		
		query = query.substring(0, query.length() - 2) + " where ";
		
		Iterator itr = restricciones.entrySet().iterator();
		while(itr.hasNext()) {
			Entry actual = (Entry)itr.next();
			
			if(actual.getValue().getClass()!=String.class && actual.getValue().getClass()!=Character.class) {
				query += actual.getKey() + " = " + actual.getValue() + " and ";
			}else {
				query += actual.getKey() + " = '" + (String)actual.getValue() + "' and ";
			}
		}

		query = query.substring(0, query.length() - 5);
		
		if (Config.verboseMode) {
			System.out.println(query);
		}
		
		Statement smt = connect();
		int ret = smt.executeUpdate(query);
		disconnect(smt);
		
		return ret;
	}
	

	private static void disconnect(Statement smt) {
		try {
			smt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
