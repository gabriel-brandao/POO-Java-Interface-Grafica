package entidade;

//expecificador extends que diz a subclasse Caminhao herdar campos da superclasse Veículoos
public class Caminhão extends Veículo{
    
    public enum Capacidade {normal, bitrem, treminhão};
    
    private int numeroDeEixos;
    private Capacidade capacidade;
    
    //construtor recebe inclusive os campos da super classe...
    public Caminhão(String modelo, float potencia, int ano, boolean zero, int numeroDeEixos, Capacidade capacidade){
        super(modelo, potencia, ano, zero); //super inicializa os campos da superclasse
        this.numeroDeEixos = numeroDeEixos;
        this.capacidade = capacidade;
    }
    
    public int getNumeroDeEixos(){
        return numeroDeEixos;
    }
    
    public Capacidade getCapacidade(){
        return capacidade;
    }
    
    //toString() mostra os dados da superclasse tambem
    public String toString(){
        String dados = "CAMINHÃO:\n" + " +Modelo: " + modelo + " +Potência: " + potencia + " +Ano: " + ano + " +Numero de Eixos: " + numeroDeEixos + " +Capacidade: " + capacidade;   
      
        if(zero)
            dados += "--**É Zero**";
        
        return dados;
    }
}