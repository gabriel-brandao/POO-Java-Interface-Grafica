
package entidade;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistencia.ConexãoBD;

public class Casa extends Imóvel {

    
   
    private int garagemCoberta;
    private float iptu;

    public Casa (String endereco, float valor, int garagemCoberta, float iptu){
    	super(endereco, valor);
    	this.garagemCoberta = garagemCoberta;
    	this.iptu = iptu;
    }

    public int getGaragemCoberta(){
    	return garagemCoberta;
    }

    public float getIptu(){
    	return iptu;
    }

   public static String inserirCasa (Casa casa) {
		String sql = "INSERT INTO Casa (CPF, Nome, Endereço, Telefone)" + " VALUES (?,?,?,?)";
		
		try {
			PreparedStatement comando = ConexãoBD.conexão.prepareStatement(sql);
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

}
