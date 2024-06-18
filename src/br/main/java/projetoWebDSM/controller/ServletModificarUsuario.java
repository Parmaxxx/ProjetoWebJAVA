package projetoWebDSM.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import projetoWebDSM.model.Usuario;

import java.io.IOException;

/**
 * Servlet implementation class ServletModificarUsuario
 */
public class ServletModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String excluir = request.getParameter("excluir");
		String alterar = request.getParameter("alterar");
		String id = request.getParameter("id");
		if(excluir !=null && id!= null) {
			new Usuario().excluir(Long.valueOf(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("consultarUsuario.jsp");
			request.setAttribute("mensagem", "Usuario excluido com sucesso!");
			dispatcher.forward(request, response);
		}else if(alterar!=null && id!= null) {
			Usuario user = new Usuario().buscarUsuarioPorId(Long.valueOf(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("modificarUsuario.jsp");
			request.setAttribute("user", user);
			dispatcher.forward(request, response);
		}
			}

}
