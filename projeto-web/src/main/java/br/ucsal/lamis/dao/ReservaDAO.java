package br.ucsal.lamis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.lamis.model.Laboratorio;
import br.ucsal.lamis.model.Reserva;
import br.ucsal.lamis.model.Usuario;
import br.ucsal.lamis.util.BancoUtil;

public class ReservaDAO {

	public static List<Reserva> buscarReservas() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		Connection c = BancoUtil.getConnection();
		try {
			String sql = "select * from reserva;";
			PreparedStatement pstmt = c.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Integer idReserva = Integer.parseInt(rs.getString(1));
				Laboratorio laboratorio = LaboratorioDAO.buscarLaboratorio(Integer.parseInt(rs.getString(2)));
				String diaDaReserva = rs.getString(3);
				String horaInicio = rs.getString(4);
				String horaFim = rs.getString(5);
				String objetivo = rs.getString(6);
				String descricao = rs.getString(7);
				Usuario usuario = UsuarioDAO.buscarUsuario(Integer.parseInt(rs.getString(8)));

				Reserva reserva = new Reserva(idReserva, laboratorio, diaDaReserva, horaInicio, horaFim, objetivo,
						descricao, usuario);
				reservas.add(reserva);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reservas;
	}

	public static void removerReserva(int idReserva) {
		Connection c = BancoUtil.getConnection();
		try {
			String sql = "DELETE FROM reserva where reserva_id=?;";

			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, idReserva);
			pstmt.executeUpdate();
			pstmt.close();
//			if(i==1) {
//				System.out.println("Update sucesso");
//			}else {
//				System.out.println("falhou");
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void inserirReserva(Reserva r) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm");
		String diaDaReserva = r.getDiaDaReserva().format(dateFormat);
		String horaInicio = r.getHoraInicio().format(timeFormat);
		String horaFim = r.getHoraFim().format(timeFormat);
		
		Connection c = BancoUtil.getConnection();
		try {
			String sql = "insert into reserva (laboratorio_id, dia_da_reserva, hora_inicio, hora_fim, objetivo, descricao, usuario_id) values"
					+ "(?, ?, ?, ?, ?, ?, ?);";
			
			
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, r.getLaboratorio().getId());
			pstmt.setString(2, diaDaReserva);
			pstmt.setString(3, horaInicio);
			pstmt.setString(4, horaFim);
			pstmt.setString(5, r.getObjetivo());
			pstmt.setString(6, r.getDescricao());
			pstmt.setInt(7, r.getUsuario().getId());
			
			
			
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
