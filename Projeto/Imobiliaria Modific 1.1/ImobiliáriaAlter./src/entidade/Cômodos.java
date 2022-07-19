package entidade;

public class Cômodos {

	private String dormitorios;
	private String ambientes;
	private String servicos;
	private int bwc;

	public Cômodos (String dormitorios, String ambientes, String servicos, int bwc){
		this.dormitorios = dormitorios;
		this.ambientes = ambientes;
		this.servicos = servicos;
		this.bwc = bwc;
	}

	public String getDormitorios(){
		return dormitorios;
	}

	public String getAmbientes (){
		return ambientes;
	}

	public String getServicos(){
		return servicos;
	}

	public int getBwc(){
		return bwc;
	}

	public String toString(){
		String dados = "[Dormitórios]: " + dormitorios +
					   "[Ambientes]: " + ambientes + 
					   "[Serviços]: " + servicos +
					   "[BWC]: " + bwc;
		return dados;
	}
    
}
