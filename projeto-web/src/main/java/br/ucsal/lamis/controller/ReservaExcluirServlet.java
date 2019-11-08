package br.ucsal.lamis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.lamis.dao.LaboratorioDAO;
import br.ucsal.lamis.dao.ReservaDAO;

/**
 * Servlet implementation class ReservaExcluirServlet
 */
@WebServlet("/ReservaExcluir")
public class ReservaExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaExcluirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Repositorio repositorio = (Repositorio) request.getSession().getServletContext().getAttribute("repositorio");

		String sId = request.getParameter("id");
		ReservaDAO.removerReserva(Integer.parseInt(sId));
		//repositorio.removerReserva(Integer.parseInt(sId));
		response.sendRedirect("./ReservasLista");
		
	}

	

}
