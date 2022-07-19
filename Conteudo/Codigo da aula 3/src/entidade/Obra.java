package entidade;

public class Obra {
	
	protected String título;
	protected String autor;

	public Obra(String título, String autor) {
		this.título = título;
		this.autor = autor;
	}

	public String getTítulo() {
		return título;
	}

	public String getAutor() {
		return autor;
	}

	public String toString () {
		return "Livro: " + título + "\n Autor: " + autor;
	}
}

