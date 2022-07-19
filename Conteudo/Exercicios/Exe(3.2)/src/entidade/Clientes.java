package entidade;

public class Clientes{

	private String nome, cpf, telefone;


	public Clientes (String nome, String cpf, String telefone){
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public String getNome(){
		return nome;
	}

	public String getCpf(){
		return cpf;
	}

	public String getTelefone(){
		return telefone;
	}

	public String toString(){
		String dados;
		return dados = " +Nome:" + nome + " +CPF:" + cpf + " +Tel:" + telefone;
	}
}