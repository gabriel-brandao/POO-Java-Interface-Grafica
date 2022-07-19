package entidade;

import entidade.Endereço;
import entidade.Cômodos;
import static entidade.Endereço.ESTADO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.BD;

public class Imóvel {

    public static Imóvel buscarImovel1(String cep, String complemento) {
        String sql = "SELECT * FROM Imóvel I, Endereço E, Comodo C " + "WHERE I.EndereçoId = E.SequencialEnd AND I.ComodosId = C.SequencialCom AND E.Cep = ? AND E.Complemento = ?";        
        ResultSet res = null;
        Imóvel imovel = null;
        
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, cep);
            comando.setString(2, complemento);
            
            res = comando.executeQuery(); //executa pesquisa                                                               
            
            while(res.next()){
               Endereço endereco = new Endereço(res.getString("Cep"), res.getString("Rua"), res.getInt("Numero"), res.getString("Complemento"), res.getString("Bairro"), ESTADO[res.getInt("Estado")], res.getString("Cidade"));
               Cômodos comodos = new Cômodos(res.getString("Dormitorios"), res.getString("ambientes"), res.getString("serviços"), res.getInt("Bwc"));
                imovel = new Imóvel(endereco, comodos, res.getFloat("AreaTotal"), res.getFloat("Valor"), res.getBoolean("Segurança"), Enum.valueOf(Tipo.class, res.getString("Tipo")));
            }
            res.close();
            comando.close();
        
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return imovel;      
    }

    public static Imóvel buscarImovel2(Integer sequencial) {
        String sql = "SELECT * FROM Imóvel I, Comodo C, Endereço E " + "WHERE I.SequencialImo = ? AND I.ComodosId = C.SequencialCom AND I.EndereçoId = E.SequencialEnd";        
        ResultSet res = null;
        Imóvel imovel = null;
        
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, sequencial+"");

            res = comando.executeQuery(); //executa pesquisa                                                               
            
            while(res.next()){
               Endereço endereco = new Endereço(res.getString("Cep"), res.getString("Rua"), res.getInt("Numero"), res.getString("Complemento"), res.getString("Bairro"), ESTADO[res.getInt("Estado")], res.getString("Cidade"));
               Cômodos comodos = new Cômodos(res.getString("Dormitorios"), res.getString("ambientes"), res.getString("serviços"), res.getInt("Bwc"));
               imovel = new Imóvel(endereco, comodos, res.getFloat("AreaTotal"), res.getFloat("Valor"), res.getBoolean("Segurança"), Enum.valueOf(Tipo.class, res.getString("Tipo")));
               imovel.setSequencial(sequencial);
            }           
            res.close();
            comando.close();
        
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return imovel;      
    }

    public static String inserirImovel(Imóvel imovel) {
        String sqlEnd = "INSERT INTO Endereço (Cep, Rua, Numero, Complemento, Bairro, Cidade, Estado) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        String sqlPKEnd = "SELECT MAX(SequencialEnd) FROM Endereço";       
        int pkEnd = -1;
        
        String sqlCom = "INSERT INTO Comodo (Dormitorios, Ambientes, Serviços, Bwc) " + "VALUES (?, ?, ?, ?)";
        String sqlPKCom = "SELECT MAX(SequencialCom) FROM Comodo";
        int pkCom = -1;
       
        String sqlImo = "INSERT INTO Imóvel (AreaTotal, Valor, Segurança, Tipo, EndereçoId, ComodosId) " + "VALUES (?, ?, ?, ?, ?, ?)";

        ResultSet resultadoPK = null;
 
        try {
            //Insere Endereço no Banco de Dados
            PreparedStatement comandoEnd = BD.conexao.prepareStatement(sqlEnd);           
                comandoEnd.setString(1, imovel.getEndereco().getCep());
                comandoEnd.setString(2, imovel.getEndereco().getRua());
                comandoEnd.setInt(3, imovel.getEndereco().getNumero());
                comandoEnd.setString(4, imovel.getEndereco().getComplemento());
                comandoEnd.setString(5, imovel.getEndereco().getBairro());
                comandoEnd.setString(6, imovel.getEndereco().getCidade());
                comandoEnd.setInt(7, imovel.getEndereco().getEstado().ordinal());                       
            comandoEnd.executeUpdate();
            comandoEnd.close();
            //Extrai a chave primaria do ultimo Endereço cadastrado
            PreparedStatement comandoPKEnd = BD.conexao.prepareStatement(sqlPKEnd);
            resultadoPK = comandoPKEnd.executeQuery();
                while(resultadoPK.next())            
                  pkEnd = resultadoPK.getInt("MAX(SequencialEnd)");
            resultadoPK.close();
            comandoPKEnd.close();
            
            //Insere Comodo no Banco de Dados
            PreparedStatement comandoCom = BD.conexao.prepareStatement(sqlCom);           
                comandoCom.setString(1, imovel.getComodos().getDormitorios());
                comandoCom.setString(2, imovel.getComodos().getAmbientes());
                comandoCom.setString(3, imovel.getComodos().getServicos());
                comandoCom.setInt(4, imovel.getComodos().getBwc());
            comandoCom.executeUpdate();
            comandoCom.close();
            //Extrai a chave primaria do ultimo comodo
            PreparedStatement comandoPKCom = BD.conexao.prepareStatement(sqlPKCom);
            resultadoPK = comandoPKCom.executeQuery();
                while(resultadoPK.next())
                    pkCom = resultadoPK.getInt("MAX(SequencialCom)");
            resultadoPK.close();
            comandoPKCom.close();
            
            if(pkEnd < 0 || pkCom < 0)
                return "Erro Na Comunicação com Banco de Dados :(";
            
            //Insere Imovel no Banco de Dados
            PreparedStatement comandoImo = BD.conexao.prepareStatement(sqlImo);
                comandoImo.setFloat(1, imovel.getAreaTotal());
                comandoImo.setFloat(2, imovel.getValor());
                comandoImo.setBoolean(3, imovel.isSeguranca());
                comandoImo.setString(4, imovel.getTipo().name());
                comandoImo.setInt(5, pkEnd);
                comandoImo.setInt(6, pkCom);
            comandoImo.executeUpdate();
            comandoImo.close();

            return null;
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return "Erro Na Comunicação com Banco de Dados :(";
        }
 
    }

    public static String alterarImovel(Imóvel imovel) {
        String sql = "UPDATE Comodo C, Imóvel I, Endereço E " +
                        "SET C.Dormitorios = ?, C.Ambientes = ?, C.Serviços = ?, C.Bwc = ?, I.AreaTotal = ?, I.Valor = ?, Segurança = ?, Tipo = ? " +
                        "WHERE C.SequencialCom = I.ComodosId AND " + 
                               "E.SequencialEnd = I.EndereçoId AND " + 
                               "E.Cep = ? AND E.Complemento = ?";
        
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setString(1, imovel.getComodos().getDormitorios());
                comando.setString(2, imovel.getComodos().getAmbientes());
                comando.setString(3, imovel.getComodos().getServicos());
                comando.setInt(4, imovel.getComodos().getBwc());
                
                comando.setFloat(5, imovel.getAreaTotal());
                comando.setFloat(6, imovel.getValor());
                comando.setBoolean(7, imovel.isSeguranca());
                comando.setString(8, imovel.getTipo().name());
                
                comando.setString(9, imovel.getEndereco().getCep());
                comando.setString(10, imovel.getEndereco().getComplemento());
            comando.executeUpdate();
            comando.close();
            return null;             
                        
        } catch (SQLException ex) {
            Logger.getLogger(Imóvel.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro de Comunicação com Bando de Dados :(";
        }  
    }
    
    public static String removerImovel(Integer sequencial) {
        String sql = "DELETE I, C, E FROM Imóvel I, Comodo C, Endereço E " + "WHERE I.SequencialImo = ? AND I.ComodosId = C.SequencialCom AND I.EndereçoId = E.SequencialEnd";
        
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Imóvel.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro de Comunicação com Bando de Dados :(";
        }
    
    }

    public static Vector<Visão<Integer>> getVisões() {
       String sql = "SELECT SequencialImo, Tipo FROM Imóvel";
       Vector <Visão<Integer>> visoes = new Vector <Visão<Integer>>(); //vetor de visoes       
       int sequencial;
       String tipo;
       
       ResultSet listaResultado = null;
       
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            listaResultado = comando.executeQuery();

            while(listaResultado.next()){
                sequencial = listaResultado.getInt("SequencialImo");
                tipo = listaResultado.getString("Tipo");
                visoes.addElement(new Visão<Integer> (sequencial, tipo) );
            }           
            listaResultado.close();
            comando.close();
           
        } catch (SQLException ex) {
            ex.printStackTrace ();                     
        }
        return visoes;  
    }

    public static int obtemSequencial(){
        String sqlPKImo = "SELECT MAX(SequencialImo) FROM Imóvel";
        int sequencial = -1;
        ResultSet resultado = null;
        
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sqlPKImo);
            resultado = comando.executeQuery();
                
            if(resultado.next())
                sequencial = resultado.getInt("MAX(SequencialImo)");
           
            resultado.close();
            comando.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Imóvel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sequencial;
    }

    

    public enum Tipo {Casa, Apartamento};

    private int sequencial;
    private Endereço endereco;
    private Cômodos comodos;

    private float areaTotal;
    private float valor; 
    private boolean seguranca;
    private Tipo tipo;

    public Imóvel(Endereço endereco, Cômodos comodos, float areaTotal, float valor, boolean seguranca, Tipo tipo){
        this.endereco = endereco;
    	this.comodos = comodos;
        this.areaTotal = areaTotal;
        this.valor = valor;
    	this.seguranca = seguranca;
    	this.tipo = tipo;
    }
    
    public int getSequencial(){
        return sequencial;
    }
    
    public void setSequencial(int sequencial){
        this.sequencial = sequencial;
    }
    
    public Endereço getEndereco(){
    	return endereco;
    }

    public float getAreaTotal(){
    	return areaTotal;
    }

    public float getValor(){
    	return valor;
    }

    public Cômodos getComodos(){
    	return comodos;
    }

    public boolean isSeguranca(){
    	return seguranca;
    }

    public Tipo getTipo(){
    	return tipo;
    }
    
    public Visão<Integer> getVisao(){
        return new Visão<Integer> (sequencial, tipo+"");
    }
    
    public String toString(){
    	String dados = "Tipo: " + tipo + "valor :" + valor;
   	return dados;
    }

}
