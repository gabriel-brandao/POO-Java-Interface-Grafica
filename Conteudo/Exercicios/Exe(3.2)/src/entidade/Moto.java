package entidade;

public class Moto extends Veículos{
	private int cilindradas;

	public Moto(String modelo, float potencia, int ano, boolean zero, int cilindradas){
		super(modelo, potencia, ano, zero);
		this.cilindradas = cilindradas;
	}

	public int getCilindradas(){
		return cilindradas;
	}

	public String toSring(){
		String dados = ">MOTO:\n" + " +Modelo:" + modelo + " +Potência:" + potencia + " +Ano:" + ano + " +Cilindradas:" + cilindradas;
        
        if(zero)
            dados +=  "--É Zero";
        
        return dados;
	}
}