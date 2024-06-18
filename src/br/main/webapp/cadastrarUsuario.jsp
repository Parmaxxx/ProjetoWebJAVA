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
		<form action="cadastrarUsuario" method="post" class="userForm">
			<div>
				<label><strong>Nome:</strong></label><input type="text"
					name="nome">
			</div>
			<div>
				<label><strong>Login:</strong></label><input type="text"
					name="login">
			</div>
			<div>
				<label><strong>Senha:</strong></label><input type="text"
					name="senha">
			</div>

			<br>
			<div>
				<input id="userButton" type="submit" name="salvar"
					value="Cadastrar Usuario">
			</div>
			<div> 

				<% 
				
				String mensagem=(String) request.getAttribute("mensagem"); 
				
				if(mensagem!=null) 
				
				     out.print(mensagem); 
				
				%> 

			</div> 
		</form>
	</main>
</body>
</html>