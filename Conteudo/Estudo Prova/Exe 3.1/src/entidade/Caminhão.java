package entidade;

import entidade.Veículo;

public class Caminhão extends Veículo{

	public enum Capacidade {Normal, Bitrem, Treminhão};

	private int numeroEixos;
	private Capacidade capacidade;

	public Caminhão(String modelo, int potencia, int ano, boolean zero, int numeroEixos, Capacidade capacidade){
		super(modelo,potencia,ano,zero);
		this.numeroEixos = numeroEixos;
		this.capacidade = capacidade;
	}

	public int getNumeroEixos(){
		return numeroEixos;
	}

	public Capacidade getCapacidade(){
		return capacidade;
	}

	public String toString(){
		String dados = " >Modelo:" + modelo + " >Potência:" + potencia + " >Ano:" + ano;

		if(zero)
			dados += " --É Zero!";

		dados += " >Numero de Eixos:" + numeroEixos + " >Capacidade:" + capacidade;
		return dados;
	}
}