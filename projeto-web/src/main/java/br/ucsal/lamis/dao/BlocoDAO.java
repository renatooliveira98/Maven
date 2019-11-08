package br.ucsal.lamis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.lamis.model.Bloco;
import br.ucsal.lamis.util.BancoUtil;

public class BlocoDAO {

	public static List<Bloco> buscarBlocos() {
		List<Bloco> blocos = new ArrayList<Bloco>();
		Connection c = BancoUtil.getConnection();
		try {
			String sql = "select * from bloco;";
			PreparedStatement pstmt = c.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int id = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				Bloco bloco = new Bloco(id, nome);
				blocos.add(bloco);
			}
			rs.close();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return blocos;
		}

	public static Bloco buscarBloco(int id) {
		Bloco bloco = null;
		Connection c = BancoUtil.getConnection();
		try {
			
			String sql = "select * from bloco where bloco_id=?;";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int idBloco = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				bloco = new Bloco(id, nome);
			}
			rs.close();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return bloco;
	}
}
