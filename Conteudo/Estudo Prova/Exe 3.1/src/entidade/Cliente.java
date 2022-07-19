package entidade;

public class Cliente{

	private String nome, cpf, telefone;

	public Cliente(String nome, String cpf, String telefone){
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
		String dados = " >Nome:" + nome + " >CPF:" + cpf + " >Telefone:" + telefone;

		return dados;
	}
}