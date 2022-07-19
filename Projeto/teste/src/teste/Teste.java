
package teste;

public class Teste {
    /*   
    public enum Estado{AC, AL, AP, AM, BA, CE, DF, ES, GO, MA, MT, MS, MG,PA, PB, PR, PE, PI, RR, RO, RJ, RN, RS, SC, SP, SE, TO};
    
    public static final Estado[] ESTADO = Estado.values();
    private Estado estado;
    */
    enum Tipo {A, B};

    public static void main(String[] args) {
      boolean venda = true, aluguel = true;
      Float v;
      String s = null;
      
      v = Float.parseFloat(s);
      System.out.println(v);
      
      
      Tipo tipo = null;
      
      System.out.println(tipo);
      
      if(v == -1)
       System.out.println("ok");
      
      if(venda != aluguel)
          System.out.println("Diferente");
      else
          System.out.println("Iguais");

       
    }
    
    
    
    
}
