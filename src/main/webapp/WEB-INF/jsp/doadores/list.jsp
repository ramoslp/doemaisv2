<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
		Resultado da busca:
		
		<ul>
		<c:forEach var="centro" items="${centros}">
			<li>${centro.id}: ${centro.nome}</li>
		</c:forEach>
		</ul>
		
	</body>
</html>