<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login - DoeMais</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://getbootstrap.com/docs/3.3/examples/signin/signin.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form class="form-signin" action="executa" method="POST">
			<input type="hidden" name="action" value="Login">
			<h2 class="form-signin-heading">Login</h2>
			<label for="inputUsuario" class="sr-only">Usuário</label>
			<input type="text" name="login" class="form-control" placeholder="Usuário" required autofocus />
			<label for="inputSenha" class="sr-only">Senha</label>
			<input type="password" name="senha" class="form-control" placeholder="Senha" required />
			<button type="submit" class="btn btn-lg btn-primary btn-block">Login</button>
		</form>
	</div>
</body>
</html>