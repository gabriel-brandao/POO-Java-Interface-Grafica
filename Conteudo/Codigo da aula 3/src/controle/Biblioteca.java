package controle;

import entidade.Livro;
import entidade.Obra;
import entidade.RelatórioTécnico;
import entidade.RelatórioTécnico.GrauSigilo;
import entidade.Tese;
import java.util.ArrayList;
import util.Data;

public class Biblioteca {

	private static ArrayList<Obra> listaObra = new ArrayList();

	public static void main(String[] args) {
		criarObras ();
		imprimirObras ("Obras Cadastradas:", listaObra);
		imprimirObras ("Obras Selecionadas:", selecionarObras());
	}

	private static void criarObras () {
		listaObra.add(new Livro ("Core Java", "Horstman - Cornell", "Sun Microsystems Press", 2, 1999));
		listaObra.add(new Tese ("Desenvolvimento de Aplicações Críticas", "Paulo Oliveira", "Unicamp", "Roberto Sobral", new Data(29,3,2007)));		
		listaObra.add(new RelatórioTécnico ("Java para Software Embarcado", "Adriana Messias", "Software Design", GrauSigilo.público, new Data(30,9,2012)));
	}

	public static ArrayList<Obra> selecionarObras() {
		String string_inicial_título = null;
		int menor_edição = -1;
		int menor_ano_publicação = -1;
		GrauSigilo grau_sigilo = null;
		String string_inicial_orientador = null;
		Data menorData = null;

		System.out.println("Filtros de Obras:" + "\n - string inicial do título da obra: " + string_inicial_título + "\n - menor edição do livro: " + menor_edição + "\n - menor ano de publicação do livro: " + menor_ano_publicação + "\n - grau de sigilo do relatório técnico: " + grau_sigilo + "\n - string inicial do nome do orientador da tese: " + string_inicial_orientador + "\n - menor data da tese ou relatório técnico: " + menorData + "\n");
		
		return filtrarObras(string_inicial_título, menor_edição, menor_ano_publicação,
		grau_sigilo, string_inicial_orientador, menorData);
	}

	private static ArrayList<Obra> filtrarObras(String string_inicial_título, int menor_edição, int menor_ano_publicação, GrauSigilo grau_sigilo, String string_inicial_orientador, Data menorData) {
		ArrayList<Obra> selecionadas_listaObra = new ArrayList();
		
		for (Obra itemObra : listaObra) {
			if ((string_inicial_título != null) && !itemObra.getTítulo().startsWith(string_inicial_título)) continue;
			
			if (itemObra instanceof Livro) {
				Livro itemLivro = (Livro) itemObra;
				if ((menor_edição != -1) && (itemLivro.getEdição() < menor_edição)) continue;
				if ((menor_ano_publicação != -1) && (itemLivro.getAnoPublicação() < menor_ano_publicação)) continue;
			}else 
			  if (itemObra instanceof RelatórioTécnico) {
				RelatórioTécnico itemRelatórioTécnico = (RelatórioTécnico) itemObra;
				if ((grau_sigilo != null) && (itemRelatórioTécnico.getGrauSigilo() != grau_sigilo)) continue;
				if ((menorData != null) && (itemRelatórioTécnico.getData().compareTo(menorData) < 0)) continue;
			}else 
			  if (itemObra instanceof Tese) {
				Tese itemTese = (Tese) itemObra;
				if ((string_inicial_orientador != null) && !itemTese.getOrientador().startsWith(string_inicial_orientador))continue;
				if ((menorData != null) && (itemTese.getData().compareTo(menorData) < 0)) continue;
			  }

			selecionadas_listaObra.add(itemObra);
		}
		return selecionadas_listaObra;
	}
	

	private static void imprimirObras (String cabeçalho, ArrayList<Obra> listaObra) {
		System.out.println(cabeçalho);

		for (Obra itemObra : listaObra)
			System.out.println (itemObra. toString());		
		System.out.println();
	}
}
