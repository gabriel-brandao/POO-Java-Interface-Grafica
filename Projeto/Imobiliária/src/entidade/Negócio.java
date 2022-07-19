package entidade;

import entidade.Cliente;
import entidade.Imóvel;

public class Negócio {
    
    public enum Tipo {Aluguel, Venda};
    
    private Tipo tipo;
    private boolean fiador;
    
    private Cliente cliente;
    private Imóvel imovel;
    
    public Negócio(boolean fiador, Tipo tipo, Cliente cliente, Imóvel imovel){
        this.fiador = fiador;
        this.tipo = tipo;
        this.cliente = cliente;
        this.imovel = imovel;
    }
    
    public boolean getFiador(){
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
    
    
    
    
}
