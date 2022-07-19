package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import persistência.BD;

public class Cliente {

	public static String removerCliente (String cpf) {
		String sql = "DELETE FROM Clientes WHERE CPF = ?";

		try {
			PreparedStatement comando = BD.conexão.prepareStatement(sql);
			//expecifica quem é cada ?
			comando.setString(1, cpf);
			comando.executeUpdate();
			comando.close();
			return null;
		} catch (SQLException exceção_sql) {
			exceção_sql.printStackTrace ();
			return "Erro na Remoção do Cliente no BD";
		}
	}

	public static Cliente buscarCliente (String cpf) {
		String sql = "SELECT Nome, Endereço, Telefone FROM Clientes" + " WHERE CPF = ?";

		ResultSet lista_resultados = null; //resultado do sql
		Cliente cliente = null;

		try {
			PreparedStatement comando = BD.conexão.prepareStatement(sql);
			//expecifica quem é cada ?
			comando.setString(1, cpf);
			//executa pesquisa
			lista_resultados = comando.executeQuery();
			
			while (lista_resultados.next()) {
				cliente = new Cliente (cpf, lista_resultados.getString("Nome"), lista_resultados.getString("Endereço"), lista_resultados.getString("Telefone"));
			}

			lista_resultados.close();
			comando.close();
		} catch (SQLException exceção_sql) {
			exceção_sql.printStackTrace ();
			cliente = null;
		}
			return cliente;
	}

	public static String inserirCliente (Cliente cliente) {
		String sql = "INSERT INTO Clientes (CPF, Nome, Endereço, Telefone)" + " VALUES (?,?,?,?)";
		
		try {
			PreparedStatement comando = BD.conexão.prepareStatement(sql);
			//expecifica quem é cada ?
			comando.setString(1, cliente.getCpf());
			comando.setString(2, cliente.getNome());
			comando.setString(3, cliente.getEndereço());
			comando.setString(4, cliente.getTelefone());
			comando.executeUpdate();
			comando.close();
			return null;
		} catch (SQLException exceção_sql) {
			exceção_sql.printStackTrace ();
			return "Erro na Inserção do Cliente no BD";
		}
	}

	public static String alterarCliente (Cliente cliente) {
		String sql = "UPDATE Clientes SET Nome = ?, Endereço = ?, Telefone = ?" + " WHERE CPF = ?";
		
		try {
			PreparedStatement comando = BD.conexão.prepareStatement(sql);
			//expecifica quem é cada ?
			comando.setString(1, cliente.getNome());
			comando.setString(2, cliente.getEndereço());
			comando.setString(3, cliente.getTelefone());
			comando.setString(4, cliente.getCpf());

			comando.executeUpdate();
			comando.close();
			return null;
		} catch (SQLException exceção_sql) {
			exceção_sql.printStackTrace ();
			return "Erro na Alteração do Cliente no BD";
		}
	}

	public static Vector<Visão<String>> getVisões () {
		String sql = "SELECT CPF, Nome FROM Clientes";
		ResultSet lista_resultados = null;
		Vector<Visão<String>> visões = new Vector<Visão<String>> ();
		String cpf;

		try {
			PreparedStatement comando = BD.conexão.prepareStatement(sql);
			lista_resultados = comando.executeQuery();
			
			while (lista_resultados.next()) {
				cpf = lista_resultados.getString("CPF");
				visões.addElement(new Visão<String> (cpf,
				lista_resultados.getString("Nome") + " - " + cpf));
			}

			lista_resultados.close();
			comando.close();
		} catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
		
		return visões;
	}

	private String cpf, nome, endereço, telefone;

	public Cliente(String cpf, String nome, String endereço, String telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.endereço = endereço;
		this.telefone = telefone;
	}

	public Cliente(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	public Visão<String> getVisão () {
		return new Visão<String> (cpf, nome + " - " + cpf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereço() {
		return endereço;
	}
	
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString () {
		return nome + " - " + cpf;
	}
}
