package br.ucsal.lamis.util;

import java.sql.Connection;
import java.sql.DriverManager;
public class BancoUtil { 
	private static Connection connection; 
	static { 
		try { 
			Class.forName("org.hsqldb.jdbc.JDBCDriver" ); //essa linha nada mais é do que carregar o drive
			connection = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/banco",
					"SA", ""); //essa linha é para criar uma conexão como banco. retorno false ou true
			} catch (Exception e) { 
				e.printStackTrace(); 
				}
		} 
	public static Connection getConnection() { 
		return connection; 
		} 
	}