<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Laboratorios</title>

</head>
<body>
	<form action="./Login" method="post">
		${erro} <br>
		Login: <input name="login" type="text"> <br>
		Senha: <input name="senha" type="password"> <br>
		<button type="submit">Entrar</button>
	</form>
	
</body>
</html>

