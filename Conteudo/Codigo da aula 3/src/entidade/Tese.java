package entidade;

import util.Data;

public class Tese extends Obra {
	
	private String universidade, orientador;
	private Data teseData;
	
	public Tese(String título, String autor, String universidade, String orientador, Data teseData) {
		super(título, autor);
		this.universidade = universidade;
		this.orientador = orientador;
		this.teseData = teseData;
	}

	public String getUniversidade() {
		return universidade;
	}

	public String getOrientador() {
		return orientador;
	}

	public Data getData() {
		return teseData;
	}

	public String toString () {
		return "Tese: " + título + "\n Autor: " + autor	+ "\n Universidade: " + universidade + "\n Orientador: " + orientador + "\n Data: " + teseData;
	}
}
