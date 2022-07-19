
package entidade;


public class Apartamento extends Imóvel{
   
    private String ap;
    private float taxa;


    public Apartamento(String endereco, float valor, String ap, float taxa){
    	super(endereco, valor);
    	this.ap = ap;
    	this.taxa = taxa;
    }

    public String getAp(){
    	return ap;
    }

    public float getTaxa(){
    	return taxa;
    }
}
