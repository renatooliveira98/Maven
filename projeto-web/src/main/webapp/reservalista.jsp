<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Hora de inicio</th>
				<th>Hora de fim</th>
				<th><a href="./ReservaForm" >Nova Reserva</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="l" items="${reservas}">
			<tr>
				<td>${l.descricao}</td>
				<td>${l.horaInicio }</td>
				<td>${l.horaFim }</td>
				<td><a	href='./ReservaExcluir?id=${l.id}'>Excluir</a></td>
			</tr>
			</c:forEach>
		</tbody>

	</table>
	<a href="./Painel">Painel</a>
</body>
</html>
