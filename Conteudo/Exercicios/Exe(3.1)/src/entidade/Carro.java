package entidade;

//modificador extends [expecifica que é uma subclasse que herda campos da superclass]
public class Carro extends Veículo{
    public enum Combustivel {Gasolina, Álcool, flex};
    
    private Combustivel combustivel;
    private boolean quatroPortas;
    
    //contrutor recebe inclusive os campos da superclasse
    public Carro (String modelo, float potencia, int ano, boolean zero, Combustivel combustivel, boolean quatro_portas){
        //inicializa os campos da superclasse
        super(modelo, potencia, ano, zero);
        this.combustivel = combustivel;
        this.quatroPortas = quatro_portas;
    } 
    
    public Combustivel getCombustivel(){
        return combustivel;
    }
    
    public boolean isQuatroPortas (){
        return quatroPortas;
    }
    
    //toString() mostra os dados da superclasse tambem
    public String toString(){
        String dados = "CARRO:\n" + " +Modelo: " + modelo + " +Potência: " + potencia + " +Ano: " + ano + " +Combustivel: " + combustivel;
       
        if(quatroPortas)
            dados += "\n--**QUATRO PORTAS**\n";
        
        if(zero)
            dados += "--**É Zero**";
        
        return dados;
    }
}