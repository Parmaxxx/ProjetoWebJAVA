<%@page import="projetoWebDSM.model.Usuario"%>
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
		<form action="alterarUsuario" method="post" class="userForm">
			<%
			Usuario user = null;
			if (request.getAttribute("user") != null) {
				user = (Usuario) request.getAttribute("user");
			}
			%>
			<input type="hidden" name="id" value="<%out.print(user.getidUsuario());%>">
			<div>
				<label><strong>Nome:</strong></label><input type="text"
					name="nome" value="<%out.print(user.getNome());%>">
			</div>
			<div>
				<label><strong>Login:</strong></label><input type="text"
					name="login" value="<%out.print(user.getLogin());%>">
			</div>
			<div>
				<label><strong>Senha:</strong></label><input type="text"
					name="senha" value="<%out.print(user.getSenha());%>">
			</div>
			<br>
			<div>
				<input id="userButton" type="submit" name="alterar"
					value="Alterar Usuario">
			</div>
			<div>
				<input type="hidden" name="id">
			</div>
			<div>
				<%
				String mensagem = (String) request.getAttribute("mensagem");
				if (mensagem != null)
					out.print(mensagem);
				%>
			</div>
		</form>
	</main>
</body>
</html>