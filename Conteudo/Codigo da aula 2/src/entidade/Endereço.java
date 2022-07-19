package entidade;

	public class Endereço {
	private String logradouro, complemento, bairro, cidade, cep;
	private int número;
	
	//contrutor da classe inicializa todos os campos
	public Endereço(String logradouro, int número, String complemento,String bairro, String cidade, String cep) {
		this.logradouro = logradouro;
		this.número = número;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro){
		this.logradouro = logradouro;
	}

	public int getNúmero() {
		return número;
	}

	public void setNúmero(int número) {
		this.número = número;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	//converte os campos de Endereço para string
	public String toString() {
	String info = logradouro + " " + número;
	
	if (complemento != null)
	 info += " - " + complemento;
	
	info += " - Bairro: " + bairro + " - " + cidade + " - CEP:" + cep;
	return info;
	}
}
