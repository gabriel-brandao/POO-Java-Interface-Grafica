package entidade;

public class Veículos{

	protected String modelo;
	protected float potencia;
	protected int ano;
	protected boolean zero;

	public Veículos(String modelo, float potencia, int ano, boolean zero){
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
    	String dados = "+Modelo: " + modelo + "+Potência: " + potencia + "+Ano: " + ano;

    	if(zero)
    		dados += " --É Zero";

    	return dados;
    }
}