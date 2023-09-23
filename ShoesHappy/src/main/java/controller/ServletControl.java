package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import model.DAO;



@WebServlet(urlPatterns = {"/ServletControl", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class ServletControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	DAO dao = new DAO();
	
	
	Cliente contato = new Cliente();

	
	public ServletControl() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			adicionarContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Cadastros.
	
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Cliente> lista = dao.listarContatos();
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	//Adicionar cadastro.
	 
	protected void adicionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setNome(request.getParameter("nome"));
		contato.setEndereco(request.getParameter("endereco"));
		contato.setModalidade(request.getParameter("modalidade"));
		dao.inserirContato(contato);
		response.sendRedirect("main");
	}

	// Listar
	
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setMatricula(request.getParameter("matricula"));
		dao.selecionarContato(contato);
		request.setAttribute("matricula", contato.getMatricula());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("endereco", contato.getEndereco());
		request.setAttribute("modalidade", contato.getModalidade());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	//Editar
	
	
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setMatricula(request.getParameter("matricula"));
		contato.setNome(request.getParameter("nome"));
		contato.setEndereco(request.getParameter("endereco"));
		contato.setModalidade(request.getParameter("modalidade"));
		dao.alterarContato(contato);
		response.sendRedirect("main");
	}

	//Deletar
	
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setMatricula(request.getParameter("matricula"));
		dao.deletarContato(contato);
		response.sendRedirect("main");
	}

	//Gerar relatorio.

	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de Clientes:"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(3);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Endereço"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Modalidade"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			ArrayList<Cliente> lista = dao.listarContatos();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getEndereco());
				tabela.addCell(lista.get(i).getModalidade());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
	}
	
//}