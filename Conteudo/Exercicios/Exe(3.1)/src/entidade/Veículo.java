package entidade;

//sera uma super classe, unica diferenca é o protected nos campos
public class Veículo{
    //modificador protected define uma superclasse, campos comuns a outras classes
    protected String modelo;
    protected float potencia;
    protected int ano;
    protected boolean zero;
    
    public Veículo (String modelo, float potencia, int ano, boolean zero){
        this.modelo = modelo;
        this.potencia = potencia;
        this.ano = ano;
        this.zero = zero;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public float getPotencia(){
        return potencia;
    }
    
    public int getAno(){
        return ano;
    }
    
    public boolean isZero(){
        return zero;
    }
    
    public String toString(){
        String dados = "MOdelo: " + modelo + "Potência: " + potencia + "Ano: " + ano;
        
        if(zero)
            dados += "--**É Zero**\n";
        return dados;
    }
}