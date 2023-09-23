<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Cliente"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings ("unchecked")
	ArrayList<Cliente> lista = (ArrayList<Cliente>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Cadastro de Contatos</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Cadastro de Cliente</h1>
	<a href="novo.html" class="Botao1">Novo Cadastro</a>
	<a href="report" class="Botao2">Relatório</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Matrícula</th>
				<th>Nome</th>
				<th>Endereço</th>
				<th>Modalidade</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getMatricula()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getEndereco()%></td>
				<td><%=lista.get(i).getModalidade()%></td>
				<td>
					<a href="select?matricula=<%=lista.get(i).getMatricula()%>"
					class="Botao1">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getMatricula()%>)"
					class="Botao2">Excluir</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>