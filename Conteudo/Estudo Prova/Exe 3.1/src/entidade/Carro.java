package entidade;

import entidade.Veículo;

public class Carro extends Veículo{

	public enum Combustivel {Gasolina, Alcool, Flex};

	private boolean quatroPortas;
	private Combustivel combustivel;

	public Carro(String modelo, int potencia, int ano, boolean zero, boolean quatroPortas, Combustivel combustivel){
		super(modelo,potencia,ano,zero);
		this.quatroPortas = quatroPortas;
		this.combustivel = combustivel;
	}

	public boolean isQuatroPortas(){
		return quatroPortas;
	}

	public Combustivel getCombustivel(){
		return combustivel;
	}

	public String toString(){
		String dados = " >Modelo:" + modelo + " >Potência:" + potencia + " >Ano:" + ano;

		if(zero)
			dados += " --É Zero!";

		dados += " >Combustível:" + combustivel;

		if(quatroPortas)
			dados += " --É Quatro Portas";
	
		return dados;
	}


}