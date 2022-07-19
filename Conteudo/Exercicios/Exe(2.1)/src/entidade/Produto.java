package entidade;

public class Produto{
	public enum Tipo {eletrodoméstico, eletrônico, roupa};
	
	private String descrição;
	private Tipo tipo;

	public Produto(String descrição, Tipo tipo){
		this.descrição = descrição;
		this.tipo = tipo;
	}

	public String getDescrição(){
		return descrição;
	}

	public Tipo getTipo(){
		return tipo;
	}

	public String toString(){
		String dados_produto;
		return dados_produto = "Descrição: " + descrição + " -Tipo: " + tipo;
	}
}