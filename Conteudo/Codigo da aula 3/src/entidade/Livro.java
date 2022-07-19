package entidade;

public class Livro extends Obra {
	
	private String editora;
	private int edição;
	private int ano_publicação;
	
	public Livro(String título, String autor, String editora, int edição, int ano_publicação) {
		super(título, autor);
		this.editora = editora;
		this.edição = edição;
		this.ano_publicação = ano_publicação;
	}

	public String getEditora() {
		return editora;
	}

	public int getEdição() {
		return edição;
	}

	public int getAnoPublicação() {
		return ano_publicação;
	}

	public String toString () {
		return "Livro: " + título + "\n Autor: " + autor + "\n Editora: " + editora
		+ "\n Edição: " + edição + "\n Ano de Publicação: " + ano_publicação;
	}
}
