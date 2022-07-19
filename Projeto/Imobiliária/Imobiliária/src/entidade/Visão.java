
package entidade;

//<T> é um tipo generico que sera definido na chamada, pode assumir qualquer outro tipo 
public class Visão <T> {
    T chave;
    String dados;

    public Visão (T chave, String dados){
    	this.chave = chave;
    	this.dados = dados; //nome no caso de cliente 
    }

    public T getChave(){
    	return chave;
    }

    public String getDados(){
    	return dados;
    }

    public void setDados(String dados){
        this.dados = dados;
    }
    
    @Override
    public String toString(){
    	return chave + " - " + dados;
    }
}
