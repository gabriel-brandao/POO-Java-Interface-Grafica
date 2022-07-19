
package entidade;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistencia.ConexãoBD;
import entidade.Casa;
import java.sql.ResultSet;


public class Imóvel {

   

    protected String endereco;
    protected float valor;

    public Imóvel (String endereco, float valor){
    	this.endereco = endereco;
    	this.valor = valor;
    }

    public String getEndereco(){
    	return endereco;
    }

    public float getValor(){
    	return valor;
    }
    
    public static String inserirImovel (Imóvel imovel) {
		
        if(imovel instanceof Casa){ 
            Casa casa = (Casa)imovel;
            return Casa.inserirCasa(casa);           
	}
        return"";
    }
    
    public static Imóvel buscarCliente (String endereco) {
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
}
