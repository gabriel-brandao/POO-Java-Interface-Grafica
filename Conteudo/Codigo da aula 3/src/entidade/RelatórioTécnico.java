package entidade;

import util.Data;

public class RelatórioTécnico extends Obra {
	
	public enum GrauSigilo {confidencial, reservado, público};
	String empresa;
	GrauSigilo grau_sigilo;
	Data relatórioData;

	public RelatórioTécnico(String título, String autor, String empresa, GrauSigilo grau_sigilo, Data relatórioData) {
		super(título, autor);
		this.empresa = empresa;
		this.grau_sigilo = grau_sigilo;
		this.relatórioData = relatórioData;
	}

	public String getEmpresa() {
		return empresa;
	}

	public GrauSigilo getGrauSigilo() {
		return grau_sigilo;
	}

	public Data getData() {
		return relatórioData;
	}

	public String toString () {
		return "Relatório Técnico: " + título + "\n Autor: " + autor + "\n Empresa: " + empresa + "\n Grau de Sigilo: " + grau_sigilo + "\n Data: " + relatórioData;
	}
}