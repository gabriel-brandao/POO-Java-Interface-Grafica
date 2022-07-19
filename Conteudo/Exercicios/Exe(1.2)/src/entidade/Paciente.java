package entidade;

public class Paciente{

	//definicao de uma nova variavel deve ser publica
	public enum Especialista {pediatria, cardiologia, psiquiatria, oftalmologia};

	//Campos
	private String nome;
	private int idade;
	private char sexo;
	private String dia;  //uso da classe Date ??
	private Especialista especialista;
	private boolean urgencia;

	//metodo Construtor
	public Paciente (String nome, int idade, char sexo, String dia, Especialista especialista, boolean urgencia){
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.dia = dia;
		this.especialista = especialista;
		this.urgencia = urgencia;
	}

	public String getNome(){
		return nome;
	}

	public int getIdade(){
		return idade;
	}

	public char getSexo(){
		return sexo;
	}

	public String getDia(){
		return dia;
	}

	public Especialista getEspecialista(){
		return especialista;
	}

	public boolean isUrgencia(){
		return urgencia;
	}

	public String toStringSexo(){
		if(sexo == 'F' || sexo == 'f') return "feminino";
		if(sexo == 'M' || sexo == 'm') return "masculino";
		return "indefinido";
	}
        
	private String toStringUrgencia(){
		if(urgencia) 
			return " POSSUI PRIORIDADE!";
		return "";
	}

	public String toString(){
		String dados_paciente = " *Nome:" + getNome() + " *Idade:" + getIdade() + " *Sexo:" + toStringSexo() + " *Dia:" + getDia() + " *Especialista: " + getEspecialista();

		String verifica_prioridade = toStringUrgencia(); 
		if(!verifica_prioridade.isEmpty())
			dados_paciente += " *" + verifica_prioridade;

		return dados_paciente;
	}
}
