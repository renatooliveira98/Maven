package br.ucsal.lamis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.lamis.model.Bloco;
import br.ucsal.lamis.model.Laboratorio;
import br.ucsal.lamis.util.BancoUtil;

public class LaboratorioDAO {

	
	public static void inserirLaboratorio(Laboratorio l) {
	Connection c = BancoUtil.getConnection();
	try {
		String sql = "insert into laboratorio (nome, descricao, bloco_id) values(?, ?, ?);";
		
		PreparedStatement pstmt = c.prepareStatement(sql);
		pstmt.setString(1, l.getNome());
		pstmt.setString(2, l.getDescricao());
		int n = l.getBloco().getId();
		pstmt.setInt(3, n);
		pstmt.executeUpdate();
		pstmt.close();
//		if(i==1) {
//			System.out.println("Update sucesso");
//		}else {
//			System.out.println("falhou");
//		}
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	public static void editarLaboratorio(Laboratorio l) {
	Connection c = BancoUtil.getConnection();
	try {
		String sql = "UPDATE laboratorio " + 
				"set nome=?, descricao = ?, bloco_id = ? " + 
				"where laboratorio_id = ?;";
		
		PreparedStatement pstmt = c.prepareStatement(sql);
		pstmt.setString(1, l.getNome());
		pstmt.setString(2, l.getDescricao());
		pstmt.setInt(3, l.getBloco().getId());
		pstmt.setInt(4, l.getId());
		int n = l.getBloco().getId();
		pstmt.executeUpdate();
		pstmt.close();
//		if(i==1) {
//			System.out.println("Update sucesso");
//		}else {
//			System.out.println("falhou");
//		}
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}

	public static List<Laboratorio> buscarLaboratorios() {
	List<Laboratorio> laboratorios = new ArrayList<Laboratorio>();
	Connection c = BancoUtil.getConnection();
	try {
		String sql = "select * from laboratorio;";
		PreparedStatement pstmt = c.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = Integer.parseInt(rs.getString(1));
			String nome = rs.getString(2);
			String descricao = rs.getString(3);
			Bloco bloco = BlocoDAO.buscarBloco(Integer.parseInt(rs.getString(4)));
			//String bloco = rs.getString(4);
			Laboratorio laboratorio = new Laboratorio(id, nome, descricao, bloco);
			laboratorios.add(laboratorio);
		}
		rs.close();
		pstmt.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	return laboratorios;
	}
	
	public static Laboratorio buscarLaboratorio(int id) {
		Laboratorio laboratorio = null;
		Connection c = BancoUtil.getConnection();
		try {
			
			String sql = "select * from laboratorio where laboratorio_id=?;";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int idLaboratorio = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				String descricao = rs.getString(3);
				Bloco bloco = BlocoDAO.buscarBloco(Integer.parseInt(rs.getString(4)));
				laboratorio = new Laboratorio(id, nome, descricao, bloco);
			}
			rs.close();
			pstmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return laboratorio;
	}
	
	public static void removerLaboratorio(int idLaboratorio) {
		Connection c = BancoUtil.getConnection();
		try {
			String sql = "DELETE FROM laboratorio where laboratorio_id=?;";
			
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, idLaboratorio);
			pstmt.executeUpdate();
			pstmt.close();
//			if(i==1) {
//				System.out.println("Update sucesso");
//			}else {
//				System.out.println("falhou");
//			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
