package entidade;

public class Carro extends Veículos{ //subClasse

	public enum  Combustivel {Alcool, Gasolina, Flex};

	private Combustivel combustivel;
	private boolean quatroPortas;

	public Carro(String modelo, float potencia, int ano, boolean zero, Combustivel combustivel, boolean quatroPortas){
		super(modelo, potencia, ano, zero); //inicializa campos da superclasse
		this.combustivel = combustivel;
		this.quatroPortas = quatroPortas;
	}

	public Combustivel getCombustivel(){
		return combustivel;
	}

	public boolean isQuatroPortas(){
		return quatroPortas;
	}

	public String toString(){
		String dados = ">CARRO:\n" + "+Modelo:" + modelo + " +Potência:" + potencia + " +Ano:" + ano + " +Combustível:" + combustivel;
		
		if(zero)
			dados += "--É Zero\n";

		if(quatroPortas)
			dados += "--É Quatro Portas";

		return dados;
	}
}