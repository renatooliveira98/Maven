<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário reserva</title>
</head>
<body>
<form action="./ReservaSalvar" method="post">
		
			
		Laboratorio: <select name="laboratorio">
					<option value="">Selecione</option>
					<c:forEach var="lab" items="${laboratorios}">
						<option value="${lab.id}" >${lab.nome} </option>
					</c:forEach>

		</select><br>
		Data da reserva: <input name="datadareserva" type="tex"><br>
		Hora de início: <input name="horadeinicio" type="text"><br>
		Hora de fim:  <input name="horadefim" type="text"><br>
		Objetivo da reserva: <input  name="objetivo" type="text"><br>
		Descrição da reserva: <input  name="descricao" type="text"><br>

		<button type="submit">Salvar</button>
	</form>
</body>
</html>