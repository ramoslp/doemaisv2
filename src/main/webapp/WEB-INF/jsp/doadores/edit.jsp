<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>DoeMais</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
</head>
<body>
	<nav class="navbar navbar-default">
  		<div class="container-fluid">
    		<div class="navbar-header">
      			<a class="navbar-brand" href="${contextPath}/">DoeMais</a>
    		</div>
    		<ul class="nav navbar-nav">
      			<li><a href="${contextPath}/">Home</a></li>
      			<!-- VERIFICA SE O USUÁRIO É ADMIN -->
      			<c:if test="${usuarioLogado.login eq 'admin'}">
      			<li class="dropdown active">
        			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Doadores
        				<span class="caret"></span>
        			</a>
        			<ul class="dropdown-menu">
          				<li><a href="${contextPath}/executa?action=ListDoador">Lista</a></li>
          				<li><a href="${contextPath}/executa?action=FormDoador">Cadastro</a></li>
        			</ul>
      			</li>
      			<li class="dropdown">
        			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Doações
        				<span class="caret"></span>
        			</a>
        			<ul class="dropdown-menu">
          				<li><a href="${contextPath}/executa?action=ListDoacao">Lista</a></li>
          				<li><a href="${contextPath}/executa?action=FormDoacao">Cadastro</a></li>
        			</ul>
      			</li>
      			</c:if>
      			<li class="dropdown">
        			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Centros
        				<span class="caret"></span>
        			</a>
        			<ul class="dropdown-menu">
          				<li><a href="${contextPath}/executa?action=ListCentro">Lista</a></li>
          				<!-- VERIFICA SE O USUÁRIO É ADMIN -->
          				<c:if test="${usuarioLogado.login eq 'admin'}">
          				<li><a href="${contextPath}/executa?action=FormCentro">Cadastro</a></li>
          				</c:if>
        			</ul>
      			</li>
      			<li class="dropdown">
        			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Campanhas
        				<span class="caret"></span>
        			</a>
        			<ul class="dropdown-menu">
          				<li><a href="${contextPath}/executa?action=ListCampanha">Lista</a></li>
          				<c:if test="${not empty usuarioLogado}">
          				<li><a href="${contextPath}/executa?action=FormCampanha">Cadastro</a></li>
          				</c:if>
        			</ul>
      			</li>
    		</ul>
    		<ul class="nav navbar-nav navbar-right">
    			<c:choose>
    			<c:when test="${not empty usuarioLogado}">
    			<li><a href="#"><span class="glyphicon glyphicon-user">${usuarioLogado.login}</span></a></li>
    			<li><a href="${contextPath}/executa?action=Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    			</c:when>
    			<c:otherwise>
      			<li><a href="${contextPath}/executa?action=SignUp"><span class="glyphicon glyphicon-user"></span> Cadastre-se</a></li>
      			<li><a href="${contextPath}/executa?action=SignIn"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      			</c:otherwise>
    			</c:choose>
    		</ul>
  		</div>
	</nav>

	<div class="container">
	
		<h3>Editar Doador</h3><br>
		<form action="executa?action=UpdateDoador" method="POST" role="form">
			<input type="hidden" name="id" value="${doador.id}">
			<div class="form-group">
				<label for="nome">Nome Completo</label>
				<input type="text" name="nome" value="${doador.nome}" class="form-control" style="width:300px" required="required" />
			</div>
			<div class="form-group">
				<label for="cpf">CPF</label>
				<input type="text" name="cpf" value="${doador.cpf}" class="form-control" style="width:300px" required="required" />
			</div>
			<div class="form-group">
				<label for="dataNascimento">Data de Nascimento</label>
				<input type="text" name="dataNascimento" value="${doador.dataNascimento}" class="form-control" style="width:300px" required="required" />
			</div>
			<div class="form-group">
				<label for="tipoSanguineo">Tipo Sanguíneo</label>
				<select name="tipoSanguineo" class="form-control" style="width:300px">
					<option value="A+">A+</option>
					<option value="A-">A-</option>
					<option value="B+">B+</option>
					<option value="B-">B-</option>
					<option value="AB+">AB+</option>
					<option value="AB-">AB-</option>
					<option value="O+">O+</option>
					<option value="O-">O-</option>
				</select>
			</div>
			<div class="form-group">
				<label for="endereco.cep">CEP</label>
				<input type="text" name="endereco.cep" value="${doador.endereco.cep}" class="form-control" style="width:300px" required="required" />
			</div>
			<div class="form-group">
				<label for="endereco.logradouro">Endereço</label>
				<input type="text" name="endereco.logradouro" value="${doador.endereco.logradouro}" class="form-control" style="width:300px" required="required" />
			</div>
			<div class="form-group">
				<label for="endereco.numero">Número</label>
				<input type="text" name="endereco.numero" value="${doador.endereco.numero}" class="form-control" style="width:300px" required="required" />
			</div>
			<div class="form-group">
				<label for="endereco.complemento">Complemento</label>
				<input type="text" name="endereco.complemento" value="${doador.endereco.complemento}" class="form-control" style="width:300px" />
			</div>
			<div class="form-group">
				<label for="contato.telefone">Telefone</label>
				<input type="text" name="contato.telefone" value="${doador.contato.telefone}" class="form-control" style="width:300px" required="required" />
			</div>
			<div class="form-group">
				<label for="contato.email">E-mail</label>
				<input type="text" name="contato.email" value="${doador.contato.email}" class="form-control" style="width:300px" required="required" />
			</div>
			<div class="form-group">
				<label for="usuario.login">Usuário</label>
				<select name=usuario.login class="form-control" style="width:300px">
					<c:forEach items="${usuarios}" var="usuario">
					<option value="${usuario.login}">${usuario.login}</option>
					</c:forEach>			
				</select>
			</div>
			<br>
			<input type="submit" class="btn btn-default" value="Atualizar" />
		</form>
	</div>
</body>
</html>