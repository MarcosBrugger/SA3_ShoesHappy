<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastros - Editar</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Cadastro</h1>
	<form name="frmContato" action="update">
		<table>
			<tr>
				<td><input type="text" name="matricula" id="caixa3" readonly
					value="<%out.print(request.getAttribute("matricula"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1"
					value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="endereco" class="Caixa2"
					value="<%out.print(request.getAttribute("endereco"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="modalidade" class="Caixa1"
					value="<%out.print(request.getAttribute("modalidade"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>