package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.BD;


public class Cliente {

    public static Cliente buscarCliente(String cpf) {
        String sql = "SELECT Nome, RendaBruta, Telefone, Profissão FROM Cliente " + "WHERE Cpf = ?";
        
        ResultSet listaResultados = null;
        Cliente cliente = null;
        
        try {
        	
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, cpf); //atribui ao parametro "?"
            
            listaResultados = comando.executeQuery(); //executa pesquisa
                         
            while(listaResultados.next())
                cliente = new Cliente (listaResultados.getString("Nome"), cpf, listaResultados.getFloat("RendaBruta"), listaResultados.getString("Telefone"), listaResultados.getString("Profissão") );
            
            listaResultados.close();
            comando.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace ();  
        }        
        return cliente;     
    }

    public static String inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (Nome, Cpf, RendaBruta, Telefone, Profissão)" + " VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getCpf());
            comando.setFloat(3, cliente.getRendaBruta());
            comando.setString(4, cliente.getTelefone());
            comando.setString(5, cliente.getProfissao());
            
            comando.executeUpdate();
            comando.close();           
            return null;
            
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return "Erro de Comunicação com Bando de Dados :(";
        }
    }
    
    
    public static String alterarCliente(Cliente cliente) {

    	String sql = "UPDATE Cliente SET Nome = ?, RendaBruta = ?, Telefone = ?, Profissão = ? " + "WHERE Cpf = ?";
    	
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            
            comando.setString(1, cliente.getNome());
            comando.setFloat(2, cliente.getRendaBruta());
            comando.setString(3, cliente.getTelefone());
            comando.setString(4, cliente.getProfissao());
            comando.setString(5, cliente.getCpf());
            
            comando.executeUpdate();
            comando.close();
            return null;
            
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro de Comunicação com Bando de Dados :(";
        }
      
    }
    
    public static String removerCliente(String cpf) {
       String sql = "DELETE FROM Cliente " + " WHERE Cpf = ?";
       
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            
            comando.setString(1, cpf);
            
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro de Comunicação com Bando de Dados :(";
        }
    }
    
    //gera visao para o combobox da janela de cadastro de clientes
    public static Vector<Visão<String>> getVisões() {
       String sql = "SELECT Nome, Cpf FROM Cliente";
       Vector <Visão<String>> visoes = new Vector <Visão<String>>(); //vetor de visoes
       
       String cpf;
       String nome;
       ResultSet listaResultado = null;
       
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            listaResultado = comando.executeQuery();

            while(listaResultado.next()){
                nome = listaResultado.getString("Nome");
                cpf = listaResultado.getString("Cpf");
                visoes.addElement(new Visão<String> (cpf, nome) );
            }
            
            listaResultado.close();
            comando.close();
           
        } catch (SQLException ex) {
            ex.printStackTrace ();                     
        }
        return visoes;  
    }


	private String nome;
	private String cpf;
	private Float rendaBruta;
	private String telefone;
	private String profissao;    
        
        

	public Cliente (String nome, String cpf, Float rendaBruta, String telefone, String profissao){
		this.nome = nome;
		this.cpf = cpf;
		this.rendaBruta = rendaBruta;
		this.telefone = telefone;
		this.profissao = profissao;
	}

	public String getNome(){
		return nome;
	}

	public String getCpf(){
		return cpf;
	}

	public Float getRendaBruta(){
		return rendaBruta;
	}

	public String getTelefone(){
		return telefone;
	}

	public String getProfissao(){
		return profissao;
	}
        
    public Visão<String> getVisao(){
        return new Visão<String> (cpf, nome);
    }

	public String toString(){
		String dados = "["+cpf+"] - " + nome + " - " + profissao;
		return dados;
	}
}
