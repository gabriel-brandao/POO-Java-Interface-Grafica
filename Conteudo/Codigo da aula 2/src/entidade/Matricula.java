package entidade;

import util.Data;

public class Matricula {
	public enum Bolsa {completa, parcial, nenhuma};

	private Aluno matrículaAluno;
	private Curso matrículaCurso;
	private Bolsa bolsa;
	private Data inícioData;
	private float nota_final;
	
	public Matricula(Aluno matrículaAluno, Curso matrículaCurso, Bolsa bolsa, Data inícioData) {
		this.matrículaAluno = matrículaAluno;
		this.matrículaCurso = matrículaCurso;
		this.bolsa = bolsa;
		this.inícioData = inícioData;
		nota_final = -1.0f;
	}

	public Aluno getAluno() {
		return matrículaAluno;
	}

	public Curso getCurso() {
		return matrículaCurso;
	}

	public Bolsa getBolsa() {
		return bolsa;
	}

	public Data getDataInício() {
		return inícioData;
	}

	public float getNotaFinal() {
		return nota_final;
	}

	public void setNotaFinal(float nota_final) {
		this.nota_final = nota_final;
	}

	public String toString() {
		String dados = "\nAluno: " + matrículaAluno.toString() + "\nCurso: " + matrículaCurso.toString() + "\ndata início: " +inícioData;
		
		if (bolsa != Bolsa.nenhuma)
		  dados += " - bolsa: " + bolsa;
		if (nota_final >= 0)
		  dados += " - nota final: " + nota_final;
	 return dados;
	}
}
