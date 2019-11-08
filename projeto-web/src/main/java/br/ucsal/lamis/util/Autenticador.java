package br.ucsal.lamis.util;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ucsal.lamis.model.Usuario;

public class Autenticador {
	
	private boolean autenticar (Usuario user) {
		boolean autenticado = false;
		Connection con = BancoUtil.getConnection();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery(
					"select * from usuarios where "+
			"login='"+user.getLogin().trim()+"' and "+
			"senha='"+user.getSenha().trim()+"';");
			
			if(resultSet.next()) {
				autenticado = true;
			}
			
			resultSet.close();
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return autenticado;
	}
}
