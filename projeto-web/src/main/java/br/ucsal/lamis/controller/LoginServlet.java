package br.ucsal.lamis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.lamis.dao.UsuarioDAO;
import br.ucsal.lamis.model.Usuario;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Connection db = BancoUtil.getConnection();
		
		
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		if(UsuarioDAO.autenticador(usuario)!=null) {
			request.getSession().setAttribute("usuario", usuario);
			response.sendRedirect("./Painel");
		}else {
			request.setAttribute("erro", "login ou senha invalido!");
			request.getRequestDispatcher("./index.jsp").forward(request, response);
		}
//		Repositorio repositorio = (Repositorio) request.getSession().getServletContext().getAttribute("repositorio");
//		
//		usuario = repositorio.autenticar(usuario);
//		
//		if(usuario !=null) {
//			request.getSession().setAttribute("usuario", usuario);
//			response.sendRedirect("./Painel");
//		}else {
//			request.setAttribute("erro", "login ou senha invalido!");
//			request.getRequestDispatcher("./index.jsp").forward(request, response);
//		}

	}

}
