package entidade;

public class Veículo{

	protected String modelo;
	protected int potencia;
	protected int ano;
	protected boolean zero;

	public Veículo(String modelo, int potencia, int ano, boolean zero){
		this.modelo = modelo;
		this.potencia = potencia;
		this.ano = ano;
		this.zero = zero;
	}

	public String getModelo(){
		return modelo;
	}

	public int getPotencia(){
		return potencia;
	}

	public int getAno(){
		return ano;
	}

	public boolean isZero(){
		return zero;
	}

	public String toString(){
		String dados = " >Modelo:" + modelo + " >Potência:" + potencia + " >Ano:" + ano;

		if(zero)
			dados += " --É Zero!";

		return dados;
	}

}