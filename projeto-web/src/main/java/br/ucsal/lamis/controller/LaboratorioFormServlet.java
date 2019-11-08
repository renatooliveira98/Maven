package br.ucsal.lamis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.lamis.dao.BlocoDAO;
import br.ucsal.lamis.dao.LaboratorioDAO;
import br.ucsal.lamis.model.Bloco;
import br.ucsal.lamis.model.Laboratorio;

/**
 * Servlet implementation class LaboratorioForm
 */
@WebServlet("/LaboratorioForm")
public class LaboratorioFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bloco> blocos = BlocoDAO.buscarBlocos();
		List<Laboratorio> laboratorios = LaboratorioDAO.buscarLaboratorios();
		
		String sid = request.getParameter("id");
		Laboratorio laboratorio = null;
		//Repositorio repositorio = (Repositorio) request.getSession().getServletContext().getAttribute("repositorio");
		if(sid !=null ) {
			//laboratorio = repositorio.obterLaboratorio(Integer.parseInt(sid));
			laboratorio = LaboratorioDAO.buscarLaboratorio(Integer.parseInt(sid));
		}
		request.setAttribute("laboratorio", laboratorio);
		request.setAttribute("blocos", blocos);
		request.getRequestDispatcher("laboratorioForm.jsp").forward(request, response);
		
	}


}
