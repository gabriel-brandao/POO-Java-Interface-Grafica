package entidade;

public class Endereço{

	private String rua, complemento, cep, bairro, cidade;
	private int numero;

	public Endereço (String rua, String complemento, String cep, String bairro, String cidade, int numero){
		this.rua = rua;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
	}

	public String getRua(){
		return rua;
	}

	public String getComplemento(){
		return complemento;
	} 

	public String getCep(){
		return cep;
	}

	public String getBairro(){
		return bairro;
	}

	public String getCidade(){
		return cidade;
	}

	public int getNumero(){
		return numero;
	}

	public String toString(){
		String Rua = "Rua: " + rua + " - " + numero + ", " + bairro + " -Cidade: " + cidade + " -CEP:" + cep;
		if(complemento.length() != 0)
			Rua += " -Complemento:" + complemento;
		return Rua;
	}

}