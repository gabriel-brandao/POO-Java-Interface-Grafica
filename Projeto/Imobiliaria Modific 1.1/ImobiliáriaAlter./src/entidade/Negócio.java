package entidade;

import entidade.Cliente;
import entidade.Imóvel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.BD;

public class Negócio {

    public static Negócio buscarNegocio1(int sequencialImo) { //passar CPF & SequencialImo***
        String sql = "SELECT * FROM Imóvel I, Negócio N, Cliente C " + "WHERE I.SequencialImo = ? AND N.ClienteId = C.Cpf AND N.ImovelId = I.SequencialImo";
        Negócio negocio = null;
        
        ResultSet resultado = null;
        
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencialImo);
            
            resultado = comando.executeQuery();
            
            if(resultado.next()){
                Cliente cliente = Cliente.buscarCliente(resultado.getString("Cpf"));
                Imóvel imovel = Imóvel.buscarImovel2(sequencialImo);
                negocio = new Negócio(cliente, imovel, Enum.valueOf(Tipo.class, resultado.getString("N.Tipo")),resultado.getBoolean("Fiador"));
            }
            resultado.close();
            comando.close();
  
        } catch (SQLException ex) {
            Logger.getLogger(Negócio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return negocio;
    }
    
    public static Negócio buscarNegocio2(int sequencialNeg) {
        String sql = "SELECT * FROM  Negócio N, Cliente C, Imóvel I " + "WHERE N.SequencialNeg = ? AND N.ClienteId = C.Cpf AND N.ImovelId = I.SequencialImo";
        Negócio negocio = null;
        
        ResultSet resultado;
        
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencialNeg);
            
            resultado = comando.executeQuery();
            
            while(resultado.next()){
                Cliente cliente = Cliente.buscarCliente(resultado.getString("Cpf"));
                Imóvel imovel = Imóvel.buscarImovel2(resultado.getInt("SequencialImo"));
                negocio = new Negócio(cliente, imovel, Enum.valueOf(Tipo.class, resultado.getString("Tipo")),resultado.getBoolean("Fiador"));
            }
            comando.close();
            resultado.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Negócio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return negocio;
    }

    public static String inserirNegocio(Negócio negocio) {
        String sql = "INSERT INTO Negócio (Fiador, Tipo, ClienteId, ImovelId) " + "VALUES (?, ?, ?, ?)";
        ResultSet resultado = null;
        
        try {
            PreparedStatement comando = BD.conexao.prepareCall(sql);
            comando.setBoolean(1, negocio.isFiador());
            comando.setString(2, negocio.getTipo().name());
            comando.setString(3, negocio.getCliente().getCpf());
            comando.setInt(4, negocio.getImovel().getSequencial());
            
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Negócio.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro Na Comunicação com Banco de Dados :(";
        }
        
    }
    
    public static String removerNegocio(Integer sequencial) {
        String sql = "DELETE N FROM Negócio N " + "WHERE N.SequencialNeg = ?";
        
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Negócio.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro de Comunicação com Bando de Dados :(";
        }    
    }
    
    public static String alterarNegocio(Negócio negocio) {
       String sql = "UPDATE Negócio N SET N.Tipo = ?, N.Fiador = ? WHERE N.SequencialNeg = ?";
       
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, negocio.getTipo().name());
            comando.setBoolean(2, negocio.isFiador());
            comando.setInt(3, negocio.getSequencial());
            
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Negócio.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro de Comunicação com Bando de Dados :(";
        }
    }
 
    public static Vector<Visão<Integer>> getVisões() {
        String sql = "SELECT * FROM Cliente C, Imóvel I, Negócio N " + "WHERE N.ClienteId = C.Cpf AND N.ImovelId = I.SequencialImo";
        Vector <Visão <Integer>> visoes = new Vector <Visão<Integer>>();
        
        int sequencialNeg, sequencialImo;
        String tipoImo, tipoNeg;
        String cpfCli, nome;

        ResultSet resultado = null;
        
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            resultado = comando.executeQuery();
            
            while(resultado.next()){
                sequencialNeg = resultado.getInt("SequencialNeg");
                sequencialImo = resultado.getInt("SequencialImo");
                tipoImo = resultado.getString("I.Tipo");
                tipoNeg = resultado.getString("N.Tipo");
                cpfCli = resultado.getString("Cpf");
                nome = resultado.getString("Nome");

                String dados = "(" +sequencialImo+ " - " +tipoImo+ ") " +tipoNeg+ " à: (" +cpfCli+ " - " +nome+ ")";
                visoes.addElement(new Visão<Integer>(sequencialNeg, dados));
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(Negócio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return visoes;   
    }

    public static int obtemSequencial() {
        String sql = "SELECT MAX(SequencialNeg) FROM Negócio";
        ResultSet resultado = null;
        int sequencial = -1;
        
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            resultado = comando.executeQuery();
            
           if(resultado.next()) 
              sequencial = resultado.getInt("MAX(SequencialNeg)");
           
            comando.close();
            resultado.close();

        } catch (SQLException ex) {
            Logger.getLogger(Negócio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sequencial;      
    }

    
    
    public enum Tipo {Aluguel, Venda};
    
    private int sequencial;
    
    private Cliente cliente;
    private Imóvel imovel;   
    private Tipo tipo;
    private boolean fiador;
    
    public Negócio(Cliente cliente, Imóvel imovel, Tipo tipo, boolean fiador){
        this.cliente = cliente;
        this.imovel = imovel;
        this.tipo = tipo;
        this.fiador = fiador;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setImovel(Imóvel imovel) {
        this.imovel = imovel;
    }
    
    public boolean isFiador(){
        return fiador;
    }
    
    public Tipo getTipo(){
        return tipo;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public Imóvel getImovel(){
        return imovel;
    }
    
    public int getSequencial(){
        return sequencial;
    }
    
    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }
    
    public Visão<Integer> getVisao(){
        
        int sequencialNeg = sequencial;
        int sequencialImo = imovel.getSequencial();
        Imóvel.Tipo tipoImo = imovel.getTipo(); 
        Negócio.Tipo tipoNeg = tipo;
        String cpfCli = cliente.getCpf();
        String nome = cliente.getNome();
        
        String dados = "(" +imovel.getVisao()+ ") " +tipo+ " à: (" +cliente.getVisao()+ ")"; 

        return new Visão<Integer>(sequencial, dados);
    }

}
