package entidade;

public class Cliente{

	private String nome, cpf, cnpj, email;
	private Endereço endereço;	//é um objeto com campos especificos

	public Cliente (String nome, String cpf, String cnpj, String email, Endereço endereço){
		this.nome = nome;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.email = email;
		this.endereço = endereço;
	}

	public String getNome(){
		return nome;
	}

	public String getCpf(){
		return cpf;
	}

	public String getCnpj(){
		return cnpj;
	}

	public String getEmail(){
		return email;
	}

	public Endereço getEndereço(){
		return endereço;
	}


	public String toString(){
		String dados_cliente;
		return dados_cliente = "Nome: " + nome + " -CPF:" + cpf + " -CNPJ:" + cnpj + " -Email:" + email + " -Endereço:" + endereço.toString();
	}

}