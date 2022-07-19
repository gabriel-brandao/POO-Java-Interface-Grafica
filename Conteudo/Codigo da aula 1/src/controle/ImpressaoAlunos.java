package controle;

import entidade.Aluno; //importa a classe Aluno
import entidade.Aluno.EstadoCivil; //importa o tipo EstadoCivil da classe Aluno
import java.util.ArrayList;

//Objeto ImpressaoAlunos:
public class ImpressaoAlunos{

	/**Cria um Array de aluno Campo de classe (associado dentro da classe ImpressaoAluno, e nao a uma instancia dessa classe)
		por isso é estatico (so há uma copia dele)
		assim, fora da classe os metodos acessam esse campo com: ImpressaoAluno.listaAluno
	*/
	private static Aluno[] listaAluno;

	//Metodo principal é a main()
	public static void main(String[] args){
		listaAluno = criarAlunos();
		imprimirAlunos("Alunos cadastrados:", listaAluno);

		ArrayList <Aluno> selecionados_listaAluno = selecionarAlunos();					//tamanho do array de list
		imprimirAlunos("Alunos Selecionados:", selecionados_listaAluno.toArray(new Aluno[selecionados_listaAluno.size()]));

                
        }

	//Metodo de classe que retorna um array de aluno
	private static Aluno[] criarAlunos(){
		listaAluno = new Aluno[8];						//EstadoCivil é um enum, logo é assim que ele é atribuido
		listaAluno[0] = new Aluno ("Ana Julia", 1995, 'F', EstadoCivil.solteiro, false);
		listaAluno[1] = new Aluno ("Joaquim", 1990, 'M', EstadoCivil.casado, true);
		listaAluno[2] = new Aluno ("Ana Ligia", 1998, 'F', EstadoCivil.solteiro, false);
		listaAluno[3] = new Aluno ("Mateus", 1991, 'M', EstadoCivil.solteiro, false);
		listaAluno[4] = new Aluno ("Livia", 1985, 'F', EstadoCivil.casado, true);
		listaAluno[5] = new Aluno ("Roberto", 1990, 'M', EstadoCivil.casado, false);
		listaAluno[6] = new Aluno ("Ana Maria", 1991, 'F', EstadoCivil.solteiro, false);
		listaAluno[7] = new Aluno ("Sandro", 1992, 'M', EstadoCivil.solteiro, true);
		return listaAluno;
	}

	//Metodo de classe que retorna um ArrayList (array flexivel) do tipo Aluno retorna a chamada pra uma funcao que de acordo com os dados aqui sera filtrado pelo metodo chamado
	private static ArrayList <Aluno> selecionarAlunos(){
		int ano_inicial = 1990;
		int ano_final = 1995;
		EstadoCivil estado_civil = EstadoCivil.solteiro; //especifica a classe onde esta a variavel
		char estrangeiro = 'X';

		System.out.println("--Filtro de Selecao\n ano inicial: " + ano_inicial + "-ano final: " + ano_final + "-estado civil: " + estado_civil + "-estrangeiro: " + estrangeiro + "\n");

		return filtrarAlunos(ano_inicial, ano_final, estado_civil, estrangeiro);
	}

	//Metodo de classe que retorna um ArrayList (array flexivel) do tipo Aluno
	//estrangeiro é char poisńo filtro é muito mais facil o usuario degitar um caracter do que escrever 
	private static ArrayList <Aluno> filtrarAlunos(int ano_inicial, int ano_final, EstadoCivil estado_civil, char estrangeiro){
		//cria um array list do tipo alunos (ele é flexivel)
		ArrayList <Aluno> selecionados_listaAluno = new ArrayList();
		
		//metodo API de array: retorna o tamanho do array
		for(int i = 0; i < listaAluno.length; i++){
			//encapsulamento, por isso chama um metodo get para acessar o campo do objeto;
			int ano_nascimento = listaAluno[i].getAnoNascimento();
			EstadoCivil estado_civil_aluno = listaAluno[i].getEstadoCivil();
			boolean é_estrangeiro = listaAluno[i].isEstrangeiro();
			
			if((ano_inicial > -1) && (ano_inicial > ano_nascimento)) continue;
			if((ano_final > -1) && (ano_final < ano_nascimento)) continue;			
			if((estrangeiro == 'T') && (!é_estrangeiro)) continue;
			if((estrangeiro == 'F') && (é_estrangeiro)) continue;
			//metodo para adicionar elemento ao array list
			selecionados_listaAluno.add(listaAluno[i]);		
		}		 

		return selecionados_listaAluno;
	}

	//Metodo de Classe 
	private static void imprimirAlunos(String cabecalho, Aluno[] listaAluno){
		System.out.println("--- " + cabecalho);
		//(laço especializado) executa seu corpo uma vez para cada elemento do conjunto (serve pra array e arrayList)
		for(Aluno itemAluno : listaAluno)
			System.out.println(itemAluno.toString());
		
		System.out.println();
	}
}
