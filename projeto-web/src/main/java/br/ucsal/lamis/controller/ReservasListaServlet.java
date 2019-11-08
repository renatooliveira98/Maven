package br.ucsal.lamis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.lamis.dao.ReservaDAO;
import br.ucsal.lamis.model.Reserva;

/**
 * Servlet implementation class ReservasListaServlet
 */
@WebServlet("/ReservasLista")
public class ReservasListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ReservasListaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Repositorio repositorio = (Repositorio) request.getSession().getServletContext().getAttribute("repositorio");
		List<Reserva> reservas = ReservaDAO.buscarReservas();
		request.setAttribute("reservas", reservas);
		request.getRequestDispatcher("reservalista.jsp").forward(request, response);
	}

}
