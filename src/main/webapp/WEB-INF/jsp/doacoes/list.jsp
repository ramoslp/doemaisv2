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
      			<li class="dropdown">
        			<a class="dropdown-toggle" data-toggle="dropdown" href="#">Doadores
        				<span class="caret"></span>
        			</a>
        			<ul class="dropdown-menu">
          				<li><a href="${contextPath}/executa?action=ListDoador">Lista</a></li>
          				<li><a href="${contextPath}/executa?action=FormDoador">Cadastro</a></li>
        			</ul>
      			</li>
      			<li class="dropdown active">
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
		<h3>Doações</h3>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Data</th>
					<th>Doador</th>
					<th>Local</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${doacoes}" var="doacao">
				<tr>
					<td>${doacao.id}</td>
					<td>${doacao.dataDoacao}</td>
					<td>${doacao.doador.nome}</td>
					<td>${doacao.local.nome}</td>
					<td>
						<a href="executa?action=EditDoacao&id=${doacao.id}">
							<span class="glyphicon glyphicon-pencil"></span>
						</a>
						<a href="executa?action=RemoveDoacao&id=${doacao.id}" onclick="return confirm('Você tem certeza?')">
							<span class="glyphicon glyphicon-remove"></span>
						</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>