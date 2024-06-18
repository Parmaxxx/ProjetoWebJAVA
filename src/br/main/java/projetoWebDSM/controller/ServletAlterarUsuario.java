package projetoWebDSM.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import projetoWebDSM.model.Usuario;

import java.io.IOException;

/**
 * Servlet implementation class ServletAlterarUsuario
 */
public class ServletAlterarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlterarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String id = request.getParameter("id");
		String mensagem;
		
		
		if(nome!=null && !nome.isEmpty() && login!=null && !login.isEmpty() && senha!=null && !senha.isEmpty()) { 
			Usuario usuario = new Usuario(nome,login,senha);
			usuario.setidUsuario(Long.valueOf(id));
			usuario.alterar();
			mensagem = "\n Dados alterados com sucesso! ";
			} else { 
				mensagem = "\n Erro. Campos vazios! ";

			} 
		request.setAttribute("mensagem", mensagem); 

		RequestDispatcher dispatcher= request.getRequestDispatcher("cadastrarUsuario.jsp"); 

		dispatcher.forward(request, response); 
	}

}
