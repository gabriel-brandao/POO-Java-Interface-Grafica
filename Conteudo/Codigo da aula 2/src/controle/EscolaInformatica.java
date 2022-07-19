package controle;

import entidade.Aluno;
import entidade.Curso;
import entidade.Endereço;
import entidade.Matricula;
import entidade.Matricula.Bolsa; //importa o tipo criado em outro pacote
import java.util.ArrayList;
import java.util.HashMap;
import util.Data;

public class EscolaInformatica{
	//hashMap permite o acesso direto ao indice do conteudo sem a necessidade de uma busca (ajuda na verificacao da existencia de um conteudo) - NOme dos Aluno e dos cursos sao armazenados no hash table pra facilitar o acesso direto 
	private static HashMap<String, Curso> hashCurso = new HashMap(); //<[tipo da chave], [tipo do valor a ser armazenado]>,  inicializa com default
	// indexação pelo título
	private static HashMap<String, Aluno> hashAluno = new HashMap();
	// indexação pelo CPF
	private static ArrayList<Matricula> listaMatricula = new ArrayList();

	public static void main(String[] args) {

		cadastrarCursos(); //cursos ofertados e seus respectivos pre requisitos
		cadastrarAlunos();
		cadastrarMatrículas();

		imprimirMatrículas("Alunos cadastrados:",listaMatricula);
        imprimirMatrículas("Filtro:", selecionarMatrículas());
	}

	private static void inserirCurso (Curso novoCurso) {
		String chave_curso = novoCurso.getTítulo();
		if (hashCurso.get(chave_curso) == null)	   //pega o conteudo do indice dado pela funcao hash resultado de chave_curso se nao houver nada retorna null
		 	hashCurso.put(chave_curso, novoCurso); //insere o novocurso no resultado da funcao hash dado por chave_curso
		else 
			System.out.println("Curso já cadastrado");
	}

	private static void inserirAluno (Aluno novoAluno) {
		String chave_aluno = novoAluno.getCpf();
		if (hashAluno.get(chave_aluno) == null)  //pega o conteudo do indice dado pela funcao hash resultado de chave_aluno se nao houver nada retorna null
			hashAluno.put(chave_aluno, novoAluno); //insere o novoaluno no resultado da funcao hash dado por chave_aluno
		else 
			System.out.println("Aluno já cadastrado");
	}

	private static void inserirMatrícula(String cpf_aluno, String título_curso, Matricula.Bolsa bolsa, Data inícioData) {
		Aluno matrículaAluno = hashAluno.get(cpf_aluno); //pega conteudo do aluno no hash indexado pelo cpf
		Curso matrículaCurso = hashCurso.get(título_curso); //pega conteudo do curso no hash indexado pelo titulo
		
		if (matrículaAluno == null) {
			System.out.println("Matrícula mal sucedida: aluno não cadastrado");
			return;
		}
		if (matrículaCurso == null) {
			System.out.println("Matrícula mal sucedida: curso não cadastrado");
			return;
		}
		listaMatricula.add(new Matricula(matrículaAluno, matrículaCurso, bolsa, inícioData));
	}

	//cadastra as materia ofertadas e seus respectivos pré-requisitos
	private	static void cadastrarCursos() {
		inserirCurso(new Curso("Java Básico", 8, 10));
		inserirCurso(new Curso("Java Aplicações Locais", 8, 10));
		inserirCurso(new Curso("Java Aplicações Web", 8, 10));
		inserirCurso(new Curso("Banco de Dados Básico", 8, 8));
		inserirCurso(new Curso("Banco de Dados Avançado", 8, 8));
		//pega os dados de curso apartir da chave passada
		Curso novo1Curso = hashCurso.get("Java Básico");
		Curso novo2Curso = hashCurso.get("Java Aplicações Locais");
		Curso novo3Curso = hashCurso.get("Java Aplicações Web");
		Curso novo4Curso = hashCurso.get("Banco de Dados Básico");
		Curso novo5Curso = hashCurso.get("Banco de Dados Avançado");
		//insercao de pré requisitos
		novo2Curso.inserirPréRequisito(novo1Curso);
		novo2Curso.inserirPréRequisito(novo4Curso);
		novo3Curso.inserirPréRequisito(novo2Curso);
		novo5Curso.inserirPréRequisito(novo4Curso);
	}

	//cadastra apenas os alunos interessados (ainda nao serao matriculados em nada)
	private static void cadastrarAlunos() {
		inserirAluno(new Aluno("Ana Julia Parra", "31.845.917", "212.234.571-32", new Data(15, 10, 1982), 'F', new Endereço("Rua Arco Verde", 171, "apto 301", "Água Boa", "Dourados", "79810-015")));
		inserirAluno(new Aluno("Ana Ligia Silveira", "32.870.923", "312.434.775-30", new Data(8, 8, 1985), 'F', new Endereço("Rua Chapéu Velho", 303, "", "Rouxinol", "Dourados", "79820-017")));
		inserirAluno(new Aluno("André Oliveira", "41.825.341", "531.331.740-71", new Data(20, 3, 1993), 'M', new Endereço("Rua Sino da Mata", 303, "", "Brejão", "Carapó", "733100-000")));
	}

	//cadastra o curso, bolsa e data de inicio, na funcao inserir verifica se o aluno fo cadastrado, se sim realiza a matricula de fato, chamando o construtor de matricula que passara como parametro os dados do tipo aluno e do tipo curso (chamados pelo hash table de cada)
	private static void cadastrarMatrículas() {
		inserirMatrícula("212.234.571-32", "Java Básico", Bolsa.completa, new Data(1, 3, 2013));
		inserirMatrícula("312.434.775-30", "Java Básico", Bolsa.parcial, new Data(1, 3, 2013));
		inserirMatrícula("212.234.571-32", "Java Aplicações Locais", Bolsa.parcial, new Data(1, 6, 2013));
		inserirMatrícula("312.434.775-30", "Java Aplicações Locais", Bolsa.nenhuma, new Data(1, 6, 2013));
		inserirMatrícula("212.234.571-32", "Java Aplicações Web", Bolsa.parcial, new Data(1, 9, 2013));
		inserirMatrícula("312.434.775-30", "Java Aplicações Web", Bolsa.nenhuma, new Data(1, 9, 2013));
		inserirMatrícula("212.234.571-32", "Banco de Dados Básico", Bolsa.nenhuma, new Data(1, 3, 2013));
		inserirMatrícula("312.434.775-30", "Banco de Dados Básico", Bolsa.nenhuma, new Data(1, 3, 2013));
		inserirMatrícula("531.331.740-71", "Banco de Dados Básico", Bolsa.nenhuma, new Data(1, 3, 2013));
		inserirMatrícula("212.234.571-32", "Banco de Dados Avançado", Bolsa.nenhuma, new Data(1, 6, 2013));
		inserirMatrícula("531.331.740-71", "Banco de Dados Avançado", Bolsa.nenhuma, new Data(1, 6, 2013));
	}

	private static ArrayList<Matricula> selecionarMatrículas() {
		int idade_mínima_aluno = 34;
		String cidade_aluno = "Dourados";
		char curso_sem_prérequisitos = 'X';
		int mínimo_semanas_curso = 10;
		Bolsa bolsa_matrícula = Bolsa.parcial;
		System.out.println("\nFiltros de Matrícula:" + "\n - idade mínima do aluno: " + idade_mínima_aluno + "\n - cidade do aluno: " + cidade_aluno + "\n - curso sem prérequisitos: " + curso_sem_prérequisitos + "\n - mínimo de semanas do curso: " + mínimo_semanas_curso + "\n - bolsa da matrícula: " + bolsa_matrícula);

		return filtrarMatrículas(idade_mínima_aluno, cidade_aluno, curso_sem_prérequisitos, mínimo_semanas_curso, bolsa_matrícula);
	}

	private static ArrayList<Matricula> filtrarMatrículas (int idade_mínima_aluno, String cidade_aluno, char curso_sem_prérequisitos, int mínimo_semanas_curso, Bolsa bolsa_matrícula) {
		
		ArrayList<Matricula> selecionadas_listaMatrícula = new ArrayList();
		
		for (Matricula itemMatrícula : listaMatricula) {
			Aluno matrículaAluno = itemMatrícula.getAluno(); //pega todos os campos da classe Aluno
			Curso matrículaCurso = itemMatrícula.getCurso(); //pega todos os campos da classe Curso
			//campos do Aluno / Endereco / Data de acordo com necessidade:
			int idade_aluno = matrículaAluno.getDataNascimento().calcularIdade();
			String cidade_aluno1 = matrículaAluno.getEndereço().getCidade();

			int n_pré_requisitos = matrículaCurso.getPréRequisitos().size();			
			int duração_semanas_curso = matrículaCurso.getDuraçãoSemanas();
			Bolsa bolsa_matrícula1 = itemMatrícula.getBolsa();

			if ((idade_mínima_aluno != -1) && (idade_aluno < idade_mínima_aluno)) continue;
			if ((cidade_aluno != null) && !cidade_aluno.equals(cidade_aluno1)) continue;
			if ((curso_sem_prérequisitos == 'T') && (n_pré_requisitos > 0)) continue;
			if ((curso_sem_prérequisitos == 'F') && (n_pré_requisitos == 0)) continue;
			if ((mínimo_semanas_curso != -1) && (duração_semanas_curso < mínimo_semanas_curso)) continue;
			if ((bolsa_matrícula != null) && (bolsa_matrícula != bolsa_matrícula1)) continue;
			
			selecionadas_listaMatrícula.add(itemMatrícula);
		}
		return selecionadas_listaMatrícula;
	}

	private static void imprimirMatrículas(String cabeçalho, ArrayList<Matricula> listaMatricula) {
		System.out.println("\n" + cabeçalho);

		for (Matricula itemMatrícula : listaMatricula) 
			System.out.println(itemMatrícula.toString());
	}

 }

