package entidade;

public class Endereço {

	private String rua, complemento, bairro, cidade, cep;
	private int numero;
	
	public Endereço (String rua, int numero, String complemento, String bairro, String cidade, String cep){
		this.rua = rua;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.numero = numero;
	}

	public String getRua(){
		return rua;
	}

	public String getComplemento(){
		return complemento;
	}

	public String getBairro(){
		return bairro;
	}

	public String getCidade(){
		return cidade;
	}

	public String getCep(){
		return cep;
	}

	public int getNumero(){
		return numero;
	}


	public String toString(){
		String dados = " +Cep: " + cep + " +Cidade: " + cidade + " +Bairro: " + bairro + " +Rua: " + rua + ", "+ numero;

		if(getComplemento() != "")
			dados += " +Complemento: " + complemento;
		
		return dados;
	}
}