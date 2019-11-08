package br.ucsal.lamis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.lamis.dao.LaboratorioDAO;

/**
 * Servlet implementation class LaboratorioExcluirServlet
 */
@WebServlet("/LaboratorioExcluir")
public class LaboratorioExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Repositorio repositorio = (Repositorio) request.getSession().getServletContext().getAttribute("repositorio");

		String sId = request.getParameter("id");
		LaboratorioDAO.removerLaboratorio(Integer.parseInt(sId));
		//repositorio.removerLaboratorio(Integer.parseInt(sId));
		
		response.sendRedirect("./LaboratorioLista");

	}



}
