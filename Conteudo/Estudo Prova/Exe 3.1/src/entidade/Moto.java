package entidade;

import entidade.Veículo;

public class Moto extends Veículo{

	private int cilindradas;

	public Moto(String modelo, int potencia, int ano, boolean zero, int cilindradas){
		super(modelo,potencia,ano, zero);
		this.cilindradas = cilindradas;
	}

	public int getCilindradas(){
		return cilindradas;
	}

	public String toString(){
		String dados = " >Modelo:" + modelo + " >Potência:" + potencia + " >Ano:" + ano;

		if(zero)
			dados += " --É Zero!";

		return dados += " >Cilindradas:" + cilindradas;
	}
}