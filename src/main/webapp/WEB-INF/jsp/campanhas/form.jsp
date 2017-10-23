<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.unipe.doemaisv2.model.*" %>

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
      			<li><a href="${contextPath}/executa?action=ListUsuario">Usuários</a></li>
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
      			<li class="dropdown active">
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
	<h3>Adicionar Campanha</h3>
		<form action="executa?action=AddCampanha" method="POST">
			<input type="hidden" name="criador" value="${usuarioLogado.login}">
			Nome:<br>
			<input type="text" name="nome" required="required" /><br>
			Data:<br>
			<input type="text" name="data" required="required" /><br>
			Local:<br>
			<select name="local">
				<c:forEach items="${centros}" var="centro">
				<option value="${centro.id}">${centro.nome}</option>
				</c:forEach>			
			</select>
			<br><br>
			<input type="submit" value="Adicionar" />
		</form>
	</div>
</body>
</html>