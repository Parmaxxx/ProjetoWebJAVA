package projetoWebDSM.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import projetoWebDSM.model.Usuario;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class ServletBuscarUsuario
 */
public class ServletBuscarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBuscarUsuario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String login=request.getParameter("login");
		ArrayList<Usuario> users = new Usuario().BuscarUsuariosPorLogin(login);
		request.setAttribute("users", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("consultarUsuario.jsp");
		dispatcher.forward(request, response);
		 
	
			
		
	}

}
