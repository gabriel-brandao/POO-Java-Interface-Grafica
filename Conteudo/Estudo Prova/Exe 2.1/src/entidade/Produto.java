package entidade;

public class Produto{

	public enum Tipo {Eletrodoméstico, Eletrônico, Roupa};

	private String descricao;
	private Tipo tipo;

	public Produto (String descricao, Tipo tipo){
		this.descricao = descricao;
		this.tipo = tipo;
	}

	public String getDescricao(){
		return descricao;
	}

	public Tipo getTipo(){
		return tipo;
	}

	public String toString(){
		String dados = " +Descrição: " + descricao + " +Tipo: " + tipo;

		return dados;
	}



}