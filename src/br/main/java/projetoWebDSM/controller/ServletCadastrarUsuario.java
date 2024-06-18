package projetoWebDSM.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import projetoWebDSM.model.Usuario;

import java.io.IOException;

public class ServletCadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastrarUsuario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//mostra página com mensagem 

		response.getWriter().append("\n Dados cadastrados com sucesso "); 


		
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
		String mensagem;
		
		
		if(nome!=null && !nome.isEmpty() && login!=null && !login.isEmpty() && senha!=null && !senha.isEmpty()) { 

			//adicionar ao banco de dados e salvar com id 

			//Persistencia.getLista().add(new Usuario(nome,login,senha)); 
			Usuario usuario = new Usuario(nome,login,senha);
			usuario.salvar();

			//System.out.println(Persistencia.getLista()); 
			mensagem = "\n Dados cadastrados com sucesso! ";


			} else { 
				mensagem = "\n Erro. Campos vazios! ";

			} 
		request.setAttribute("mensagem", mensagem); 

		RequestDispatcher dispatcher= request.getRequestDispatcher("cadastrarUsuario.jsp"); 

		dispatcher.forward(request, response); 

			//doGet(request, response); 

		
		
		
			} 

			 

			
		
	}


