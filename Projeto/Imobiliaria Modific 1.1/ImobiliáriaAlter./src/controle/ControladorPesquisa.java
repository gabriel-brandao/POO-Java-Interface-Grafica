package controle;

import entidade.Imóvel;
import entidade.Negócio;
import interfaces.JanelaPesquisa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.BD;

public class ControladorPesquisa {
    
    public ControladorPesquisa(){
        new JanelaPesquisa(this).setVisible(true);
    }

    public Vector<String> pesquisa(boolean filtro, Negócio.Tipo tipoNeg, String cliente, Imóvel.Tipo tipoImo, float valorMin, float valorMax) {
        String sql = "SELECT * FROM Cliente C, Imóvel I, Negócio N WHERE N.ClienteId = C.Cpf AND N.ImovelId = I.SequencialImo";
        int index = 1;
        ResultSet resultado = null;
        Vector <String> visoesResultado = new Vector<String>();
        
        if(filtro){
            if(tipoNeg != null)
                sql += " AND N.Tipo = ?";            
            
            if(cliente != null)
                sql += " AND C.Nome = ?";
        
            if(tipoImo != null)
                sql += " AND I.Tipo = ?";
            
            if(valorMin >= 0.0f)
                sql += " AND I.Valor >= ?";
            
            if(valorMax >= 0.0f)
                sql += " AND I.Valor <= ?";
        }
        
        try {
           PreparedStatement comando = BD.conexao.prepareStatement(sql);
           
            if(tipoNeg != null)
                comando.setString(index++, tipoNeg.name());  
            
            if(cliente != null)
                comando.setString(index++, cliente);
            
            if(tipoImo != null)
                comando.setString(index++, tipoImo.name());
            
            if(valorMin >= 0.0f)
                comando.setFloat(index++, valorMin);
            
            if(valorMax >= 0.0f)
                comando.setFloat(index++, valorMax);
           
           resultado = comando.executeQuery();

           while(resultado.next()){
              int seqNeg = resultado.getInt("N.SequencialNeg");
              String TipoImo = resultado.getString("I.Tipo");
              String TipoNeg = resultado.getString("N.Tipo");
              String nome = resultado.getString("C.Nome");
              float valor = resultado.getFloat("I.Valor");
              String dados = "[" +seqNeg+ "] - " +TipoImo+ " " +TipoNeg+ " à: " +nome+ " por R$ " +valor;
              
              visoesResultado.add(dados);
           }

           resultado.close();
           comando.close();

           return visoesResultado;           
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPesquisa.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
