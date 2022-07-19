package controle;

import entidade.Disciplina;
import entidade.Disciplina.Tipo;
import java.util.ArrayList;

public class ImpressaoDisciplina {

    //array declarado mas nao inicializado
	private static Disciplina[] listaDisciplina; 
	
	public static void main(String args[]){
		listaDisciplina = criarListaDisciplina();
		imprimir("Disciplinas Disponiveis:\n", listaDisciplina);

		ArrayList <Disciplina> disciplinas_selecionadas = criterio();   //converte ArrayList para array 
		imprimir("Disciplinas Selecionadas:\n", disciplinas_selecionadas.toArray(new Disciplina[disciplinas_selecionadas.size()]));
	}

	//cria um array de disciplinas
	private static Disciplina[] criarListaDisciplina(){
		listaDisciplina = new Disciplina[6]; //inicializa um array de objetos disciplina com cada indice sendo um objeto (com campos iniciados com valores default)

		listaDisciplina[0] = new Disciplina ("Laboratório de Programação IV", 256, 108, Tipo.obrigatoria, false);
		listaDisciplina[1] = new Disciplina ("Cálculo Diferencial e Integral III", 72, 0, Tipo.obrigatoria, true);
		listaDisciplina[2] = new Disciplina ("Tópicos em Programação", 72, 58, Tipo.optativa, true);
		listaDisciplina[3] = new Disciplina ("Insetos Sociais", 144, 56, Tipo.eletiva, false);
		listaDisciplina[4] = new Disciplina ("Análise de Circuitos Elétricos", 349, 128, Tipo.obrigatoria, false);
		listaDisciplina[5] = new Disciplina ("Engenharia de Software II", 143, 37, Tipo.optativa, true); 
		return listaDisciplina;
	}

	//estabelece os criterios para o filtro
	private static ArrayList <Disciplina> criterio (){
		int carga_teorica_minima = 14;
		Tipo tipo = Tipo.optativa;
		char reuni = 'T'; 

		System.out.println("##Filtro: \n" + " ##Carga Teoria Minima:" + carga_teorica_minima + " ##Tipo:" + tipo + " ##Reuni:" + reuni + "\n");
		return filtrarDisciplina(carga_teorica_minima, tipo, reuni);
	}

	//filtra
	private static ArrayList <Disciplina> filtrarDisciplina(int carga_teorica_minima, Tipo tipo, char reuni){
		ArrayList <Disciplina> disciplina_selecionadas = new ArrayList();
	
		for(int i = 0; i < listaDisciplina.length; i++){
			
			int teorica_minima = listaDisciplina[i].getCargaHorariaTotal() - listaDisciplina[i].getCargaHorariaPratica();
			Tipo tipo_discip = listaDisciplina[i].getTipo();
			boolean reuni_discip = listaDisciplina[i].isReuni();

			if((carga_teorica_minima != -1) && (teorica_minima < carga_teorica_minima)) continue;
			if(tipo_discip != tipo) continue;
			if((reuni == 'T') && (!reuni_discip)) continue;
			if((reuni == 'F') && (reuni_discip)) continue;

			disciplina_selecionadas.add(listaDisciplina[i]);
		}
		return disciplina_selecionadas;
	}

	//imprimi listaDisciplina passado por parametro
	private static void imprimir (String cabecalho, Disciplina[] listaDisciplina){
        System.out.println(cabecalho);
            
		for(Disciplina item_lista : listaDisciplina)
			System.out.println(item_lista.toString());
		
		System.out.println("\n");
	}
}