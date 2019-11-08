package br.ucsal.lamis.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.lamis.dao.LaboratorioDAO;
import br.ucsal.lamis.dao.ReservaDAO;
import br.ucsal.lamis.model.Reserva;
import br.ucsal.lamis.model.Usuario;

/**
 * Servlet implementation class ReservaSalvarServlet
 */
@WebServlet("/ReservaSalvar")
public class ReservaSalvarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaSalvarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Repositorio repositorio = (Repositorio) request.getSession().getServletContext().getAttribute("repositorio");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("H:mm");
		int idLab = Integer.parseInt(request.getParameter("laboratorio"));
		String dataReservaR = request.getParameter("datadareserva");
		String horaInicioR = request.getParameter("horadeinicio");
		String horaFimR = request.getParameter("horadefim");
		String objetivo = request.getParameter("objetivo");
		String descricao = request.getParameter("descricao");
		
		LocalDate dataReserva =  LocalDate.parse(dataReservaR, dateFormat);
		LocalTime horaInicio = LocalTime.parse(horaInicioR, timeFormat);
		LocalTime horaFim = LocalTime.parse(horaFimR, timeFormat);
		
		//System.out.println(possibilidadeInserirNovaReserva(horaInicio, horaFim, dataReserva, repositorio));
		
		Reserva reserva = new Reserva();
		reserva.setDescricao(descricao);
		reserva.setDiaDaReserva(dataReserva);
		reserva.setHoraFim(horaFim);
		reserva.setHoraInicio(horaInicio);
		reserva.setId(1);
		reserva.setLaboratorio(LaboratorioDAO.buscarLaboratorio(idLab));
		//reserva.setLaboratorio(repositorio.obterLaboratorio(idLab));
		reserva.setObjetivo(objetivo);
		
		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
		System.out.println(u.getLogin());
		System.out.println(u.getSenha());
		reserva.setUsuario(u);
		//repositorio.inserirReserva(reserva);
		ReservaDAO.inserirReserva(reserva);
		response.sendRedirect("./ReservasLista");
		
		
	}

//	public boolean possibilidadeInserirNovaReserva(LocalTime inicio, LocalTime fim, LocalDate data, Repositorio r){
//		List<Reserva> reservas = r.getReservas();
//		for (Reserva reserva : reservas) {
//			if(reserva.getDiaDaReserva().getYear()==data.getYear()) {
//				if(reserva.getDiaDaReserva().getMonth()==data.getMonth()) {
//					if (reserva.getDiaDaReserva().getDayOfMonth()==data.getDayOfMonth()) {
//						if(inicio.getHour()>=reserva.getHoraInicio().getHour() && inicio.getHour()<=reserva.getHoraFim().getHour()) {
//							return false;
//						}else {
//							if(fim.getHour()<=reserva.getHoraFim().getHour()&& fim.getHour()>= reserva.getHoraInicio().getHour()
//									&& fim.getHour()<=reserva.getHoraFim().getHour()) {
//								return false;
//							
//							}
//						}
//						
//					}
//				}
//			}
//		}
//		
//		return true;
//	}
}
