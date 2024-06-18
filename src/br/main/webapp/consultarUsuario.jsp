<%@page import="projetoWebDSM.model.Usuario"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/Style.css">

<meta charset="ISO-8859-1">
<title>User Manager</title>
</head>
<body>
		<nav class="userNav">
		<ul>
			<li><a href="home.jsp"><span style="color: white">User Manager</span></a></li>
			<li><img src="img/icon.png" height="20px"></li>
			<li><a href="cadastrarUsuario.jsp"><span style="color: white">Cadastrar Usuario</span></a></li>
			<li><a href="consultarUsuario.jsp"><span style="color: white">Consultar Usuario</span></a></li>
		</ul>
	</nav>
	<main class="userMain">
		<form action="consultarUsuario" method="post" class="userForm">
			<div>
				<label><strong>Buscar pelo Login:</strong></label><input type="text"
					name="login">
			</div>
			<br>
			<div class="userColumn">
				<input id="userButton" type="submit" name="salvar"
					value="Consultar Usuário">
			</div>
						<div> 

				<% 
				
				String mensagem=(String) request.getAttribute("mensagem"); 
				
				if(mensagem!=null) 
				
				     out.print(mensagem); 
				
				%> 

			</div> 
			</form>
			
			<%
			if(request.getAttribute("users")!=null){
				List<?> users = (List<?>) request.getAttribute("users");
				for(int i = 0; i <=(users.size()-1);i++){
					Usuario user = (Usuario) users.get(i);
				
			
			%>
			<form action="modificarUsuario" method="post" class="userForm">
			<div class="userdivMother">
				<div class="userdivItem">
					<div class="userColumn">
						<span style="font-weight: bold">ID</span>
						<span><%out.print(user.getidUsuario()); %></span>
						<input type="hidden" name="id" value="<%out.print(user.getidUsuario()); %>">
					</div>
					<div class="userColumn">
						<span style="font-weight: bold">Nome</span>
						<span><%out.print(user.getNome()); %></span>
					</div>
					<div class="userColumn">
						<span style="font-weight: bold">Login</span>
						<span><%out.print(user.getLogin()); %></span>
					</div>
					<div class="userColumn">
						<span style="font-weight: bold">Senha</span>
						<span><%out.print(user.getSenha()); %></span>
					</div>
					<div class="userColumn">
						<input id="useritemButton" type="submit" name="alterar" value="alterar">
						<input id="useritemButton" type="submit" name="excluir" value="excluir">
					</div>
				</div>
			</div>
			</form>
			<%}} %>
		
	</main>
</body>
</html>