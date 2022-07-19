package entidade;

public class Caminhão extends Veículos{

	public enum Capacidade {normal, bitrem, treminhâo};//criacao de um novo tipo

	private int numeroDeEixos;
	private Capacidade capacidade;

	public Caminhão (String modelo, float potencia, int ano, boolean zero, int numeroDeEixos, Capacidade capacidade){
		super(modelo, potencia, ano, zero); //inicializa campos da superclasse
		this.numeroDeEixos = numeroDeEixos;
		this.capacidade = capacidade;
	}

	public int getNumeroDeEixos(){
		return numeroDeEixos;
	}

	public Capacidade getCapacidade(){
		return capacidade;
	}

	public String toString(){
		String dados = ">CAMINHÃO:\n" + "+Modelo:" + modelo + " +Potência:" + potencia + " +Ano:" + ano + " +Numero de Eixos:" + numeroDeEixos + " +Capacidade:" + capacidade;
		if(zero)
			dados += "--É Zero";

		return dados;
	}

}