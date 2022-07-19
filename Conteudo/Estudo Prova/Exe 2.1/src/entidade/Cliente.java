package entidade;

import entidade.Endereço;

public class Cliente{

	private String nome, cpf, cnpj, email;
	private Endereço endereco;

	public Cliente (String nome, String cpf, String cnpj, String email, Endereço endereco){
		this.nome = nome;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.email = email;
		this.endereco = endereco;
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

	public Endereço getEndereco(){
		return endereco;
	}

	public String toString(){
		String dados = ">Nome: " + nome + " >CPF: " + cpf;

		if(getCnpj() != null)
			dados += " >CNPJ: " + cnpj;

		dados += " >Email: " + email + " >Endereço: " + endereco.toString();
		return dados;
 	}

}