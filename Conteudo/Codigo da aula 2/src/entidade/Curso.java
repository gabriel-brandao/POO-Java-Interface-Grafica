package entidade;
import java.util.ArrayList;

public class Curso {
	private String título;
	private int carga_horária_semanal, duração_semanas;
	//arrayList de Curso tera apenas os campos titulo, carga_horaria_semanal e duracao_semanas
	private ArrayList<Curso> pré_requisitos_listaCurso = new ArrayList();
	
	//construtor de Curso so inicializa os campos obrigatorios
	public Curso(String título, int carga_horária_semanal, int duração_semanas) {
		this.título = título;
		this.carga_horária_semanal = carga_horária_semanal;
		this.duração_semanas = duração_semanas;
	}

	public String getTítulo() {
		return título;
	}

	public int getCargaHoráriaSemanal() {
		return carga_horária_semanal;
	}

	public int getDuraçãoSemanas() {
		return duração_semanas;
	}

	//retorna null se ele nao tiver pre requisitos
	public ArrayList<Curso> getPréRequisitos() {
		return pré_requisitos_listaCurso;
	}

	public boolean inserirPréRequisito(Curso pré_requisitoCurso) {
		if (!pré_requisitos_listaCurso.contains(pré_requisitoCurso)) {
			pré_requisitos_listaCurso.add(pré_requisitoCurso);
			return true;
		} else 
			return false;
	}

	public boolean removePréRequisito(Curso pré_requisitoCurso) {
		//metodo so remove se houver o item de interesse e retorna verdadeiro, caso contrario retorna false
		return pré_requisitos_listaCurso.remove(pré_requisitoCurso);
	}

	//transforma em string os campos da classe
	public String toString() {
		String dados = título + " - " + carga_horária_semanal + " horas semanais - " + duração_semanas + " semanas";
		int n_pré_requisitos = pré_requisitos_listaCurso.size();
		//lista os prerequisitos 
		if (n_pré_requisitos > 0) {
			dados += "\npré-requisitos: " + pré_requisitos_listaCurso.get(0).getTítulo(); //arrayList.get(n) para acessar o indice n do arraylist
			for (int n = 1; n < n_pré_requisitos; n++) 
				dados += " - " + pré_requisitos_listaCurso.get(n).getTítulo(); //se fosse um array seria: array[n].getTitulo()
		}
		return dados;
	}
}
