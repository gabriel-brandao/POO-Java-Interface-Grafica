package entidade;

public class Endereço {
	
	public enum Estado{AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG,PA, PB, PR, PE, PI, RR, RO, RJ, RN, RS, SC, SP, SE, TO};
        public static final Estado[] ESTADO = Estado.values(); //ESTADO passa a ser um vetor de Estado
        
	private Estado estado;
	private String cep, rua, complemento, bairro, cidade;
	private int número;
	
	//contrutor da classe inicializa todos os campos
	public Endereço(String cep, String rua, int número, String complemento,String bairro, Estado estado, String cidade) {
		this.cep = cep;
		this.rua = rua;
		this.número = número;
		this.complemento = complemento;
		this.bairro = bairro;
                this.estado = estado;
		this.cidade = cidade;		
	}

	public String getCep(){
		return cep;
	}
	
	public String getRua() {
		return rua;
	}

	public int getNumero() {
		return número;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public Estado getEstado() {
		return estado;
	}



	//converte os campos de Endereço para string
	public String toString() {
		
		String info = rua + " " + número;
		
		if (complemento != null)
		 info += " - " + complemento;
		
		info += " - Bairro: " + bairro + " - " + cidade + " - estado:" + estado;
		return info;
	}
}
