package entidade;

public class Disciplina{
	
	public enum Tipo {obrigatoria, optativa, eletiva}; //defini um tipo, Tipo.[alguma coisa], precisa ser publica pois o metodo get ira retornar esse campo
	
    //campos em minusculo (Disciplina.campo)
	private String titulo;
	private int carga_horaria_total;
	private int carga_horaria_pratica;
	private Tipo tipo;
	private boolean reuni;

	//Metodo construtor
	public Disciplina(String titulo, int carga_horaria_total, int carga_horaria_pratica, Tipo tipo, boolean reuni){
		this.titulo = titulo;
		this.carga_horaria_total = carga_horaria_total;
		this.carga_horaria_pratica = carga_horaria_pratica;
		this.tipo = tipo;
		this.reuni = reuni;
	}

	public String getTitulo (){
		return titulo;
	}

	public void setTitulo (String titulo){
		this.titulo = titulo;
	}

	public int getCargaHorariaTotal (){
		return carga_horaria_total;
	}

	public void setCargaHorariaTotal (int carga_horaria_total){
		this.carga_horaria_total = carga_horaria_total;
	}

	public int getCargaHorariaPratica (){
		return carga_horaria_pratica;
	}

	public void setCargaHorariaPratica (int carga_horaria_pratica){
		this.carga_horaria_pratica = carga_horaria_pratica;
	}

	public Tipo getTipo (){
		return tipo;
	}

	public void setTipo (Tipo tipo){
		this.tipo = tipo;
	}

	public boolean isReuni (){
		return reuni;
	}

	public void setReuni (boolean reuni){
		this.reuni = reuni;
	}

	//passa reuni de boolean para string
	private String toStringReuni (){
		if(reuni)
			return "é reuni";
		return "";
	}

	// converte campos para mostra de forma mais amigavel ao usuario
	public String toString(){
        
        String dados_disciplina = "##Titulo:" + getTitulo() + " ##Carga Horaria Total:" + getCargaHorariaTotal() + " ##Carga Horaria Pratica:" + getCargaHorariaPratica() + " ##Tipo:" + getTipo();

		String verifica_reuni = toStringReuni();

		if(!verifica_reuni.isEmpty())
			dados_disciplina += " ##" + verifica_reuni;

		return dados_disciplina;
	}
}