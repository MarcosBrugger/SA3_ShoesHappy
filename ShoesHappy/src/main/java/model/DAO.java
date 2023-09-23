package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/shoeshappy?useTimezone=true&serverTimezine=UTC";
	private static String user = "usuario";
	private static String password = "1a2b3c4d5e6f";
	

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	//Inserir Cadastro.
	 
	public void inserirContato(Cliente contato) {
		String create = "insert into contatos (nome,endereco,modalidade) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getEndereco());
			pst.setString(3, contato.getModalidade());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//Listar Cadastro.
	 
	public ArrayList<Cliente> listarContatos() {
		ArrayList<Cliente> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String matricula = rs.getString(1);
				String nome = rs.getString(2);
				String endereco = rs.getString(3);
				String modalidade = rs.getString(4);
				contatos.add(new Cliente(matricula, nome, endereco, modalidade));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	//Selecionar Cadastro.
	
	public void selecionarContato(Cliente contato) {
		String read2 = "select * from contatos where matricula = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getMatricula());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setMatricula(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setEndereco(rs.getString(3));
				contato.setModalidade(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//Alterar contato.
	
	public void alterarContato(Cliente contato) {
		String update = "update contatos set nome=?,endereco=?,modalidade=? where matricula=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getEndereco());
			pst.setString(3, contato.getModalidade());
			pst.setString(4, contato.getMatricula());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//Deletar contato.
	
	public void deletarContato(Cliente contato) {
		String delete = "delete from contatos where matricula=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getMatricula());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}