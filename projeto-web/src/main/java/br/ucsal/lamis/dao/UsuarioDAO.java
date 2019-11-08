package br.ucsal.lamis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ucsal.lamis.model.Usuario;
import br.ucsal.lamis.util.BancoUtil;

public class UsuarioDAO {

	public static Usuario autenticador(Usuario u) {
		boolean autenticado = false;
		Connection c = BancoUtil.getConnection();
		try {
			String sql = "select * from usuario where login=? and senha=?;";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, u.getLogin());
			pstmt.setString(2, u.getSenha());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				autenticado = true;
				u.setId(Integer.parseInt(rs.getString(1)));
			}
			rs.close();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if (autenticado) {
			
			return u;
		}else {
			return null;
		}
	}

	public static Usuario buscarUsuario(int id) {
		Usuario usuario = null;
		Connection c = BancoUtil.getConnection();
		try {
			
			String sql = "select * from usuario where usuario_id=?;";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int idUsuario = Integer.parseInt(rs.getString(1));
				String login = rs.getString(2);
				usuario = new Usuario(idUsuario, login);
			}
			rs.close();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	
}
