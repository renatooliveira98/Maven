package br.ucsal.lamis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.lamis.dao.LaboratorioDAO;
import br.ucsal.lamis.dao.ReservaDAO;
import br.ucsal.lamis.model.Laboratorio;
import br.ucsal.lamis.model.Reserva;

/**
 * Servlet implementation class ReservaFormServlet
 */
@WebServlet("/ReservaForm")
public class ReservaFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Repositorio repositorio = (Repositorio) request.getSession().getServletContext().getAttribute("repositorio");
		List<Reserva> reservas = ReservaDAO.buscarReservas();
		List<Laboratorio> laboratorios = LaboratorioDAO.buscarLaboratorios();
		request.setAttribute("laboratorios", laboratorios);
		request.setAttribute("reservas", reservas);
		request.getRequestDispatcher("reservaForm.jsp").forward(request, response);
	}



}
