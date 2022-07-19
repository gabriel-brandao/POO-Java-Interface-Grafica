package entidade;

// Objeto Aluno:
public class Aluno {

	//define um tipo PUBLICO (pois sera acessado por outro pacote posteriormente) de tipo enumeracao fixo, (por padrao posicao inicial é 0)
	public enum EstadoCivil {solteiro, casado, separado, viuvo};
	//campos de instancias PRIVADAS (so a classe as conhece)
	private String nome;
	private int ano_nascimento;
	private char sexo;
	//campo de instancia de tipo EstadoCivil, recebe um dos 4 valores possiveis 
	private EstadoCivil estado_civil;
	private boolean estrangeiro;

	//Metodo construtor
	public Aluno (String nome, int ano_nascimento, char sexo, EstadoCivil estado_civil, boolean estrangeiro){
		//this.variavel (auto-referencia this. se refere a variavel da classe) - variavel da classe recebe o artibuto do parametro do metodo
		this.nome = nome;
		this.ano_nascimento = ano_nascimento;
		this.sexo = sexo;
		this.estado_civil = estado_civil;
		this.estrangeiro = estrangeiro;
	}
	//Metodos de instancia para retorno, sao encapsulamentos (pegar atributo do objeto) e alteracao (do atributo do abjeto) 
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}

	public int getAnoNascimento(){
		return ano_nascimento;
	}
	public void setAnoNascimento(int ano_nascimento){
		this.ano_nascimento = ano_nascimento;
	}

	public char getSexo(){
		return sexo;
	}
	public void setSexo(char sexo){
		this.sexo = sexo;
	}

	public EstadoCivil getEstadoCivil(){
		return estado_civil;
	}
	public void setEstadoCivil(EstadoCivil estado_civil){
		this.estado_civil = estado_civil;
	}
	//para valores booleanos nao se usa get (pegar) ou é ou noa é..
	public boolean isEstrangeiro(){
		return estrangeiro;
	}
	public void setEstrangeiro(boolean estrangeiro){
		this.estrangeiro = estrangeiro;
	}
	
	//Metodo PRIVADO para pro usuario é mais facil digitar letras do que escrever, essa funcao transforma para string
	private String toStringSexo(){
		if(sexo == 'M' || sexo == 'm')
			return "masculino";
		if (sexo == 'F' || sexo == 'f')
			return "feminino";

		return "indefinido";
	}
	
	// Metodo PRIVADO para converte estado civil de enum para string e distingue mulher de homem
	private String toStringEstadoCivil(){
		//converte sexo para string, essa variavel so existe dentro do metodo
		String sexo_string = toStringSexo();

		if(sexo_string.equals("masculino"))
			return estado_civil + ""; //concatenando cm uma string esta_civil é convertido para string tambem

		if(sexo_string.equals("feminino")){
			switch(estado_civil){
				case solteiro:
					return "solteira";
				case casado:
					return "casada";
				case separado:
					return "separada";
				case viuvo:
					return "viuva";
				default:
					return "indefinido";
			}
		}
		
		return "indefinido";
	}

	//Metodo de instancia PUBLICO (sera usado fora da classe) para converte estrangeiro de booleano para string e distingue mulher de homem
	public String toStringEstrangeiro(){
		//se nao for nao tem o que converter, retorna cadeia vazia;
		if(!estrangeiro) 
			return "";  
		String sexo_string = toStringSexo();
		
		if(sexo_string.equals("masculino"))
			return "estrangeiro";
		if(sexo_string.equals("feminino"))
			return "estrangeira";

		return "indefinido";
	}

	//Metodo de instancia PUBLICO (sera usado fora da classe)  que retorna os campos do objeto Aluno
	public String toString(){
		String dados_aluno;

		dados_aluno = "nome: " + getNome() + "--ano de nascimento: " + getAnoNascimento() + "--sexo: " + toStringSexo() + "--estado civil: " + toStringEstadoCivil();

		String estrangeiro = toStringEstrangeiro();
		//metodo da API de string
		if(!estrangeiro.isEmpty())
			dados_aluno += "--" + estrangeiro;

		return dados_aluno;
	}










}


/**

poderia haver mais classes aqui: (novo arquivo > Java > Classes...)

public class [nome da classe]{
	
	[....]

}

*/