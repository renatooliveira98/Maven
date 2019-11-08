package br.ucsal.lamis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.lamis.dao.LaboratorioDAO;
import br.ucsal.lamis.model.Laboratorio;

/**
 * Servlet implementation class LaboratorioListaServlet
 */
@WebServlet("/LaboratorioLista")
public class LaboratorioListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Repositorio repositorio = (Repositorio) request.getSession().getServletContext().getAttribute("repositorio");
		List<Laboratorio> laboratorios = LaboratorioDAO.buscarLaboratorios();
		request.setAttribute("laboratorios", laboratorios);
		request.getRequestDispatcher("laboratoriolista.jsp").forward(request, response);
	}

}
