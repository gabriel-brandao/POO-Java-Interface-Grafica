
package controle;

import entidade.Apartamento;
import entidade.Casa;
import entidade.Imóvel;

public class ControladorCadastroImóvel {
    
    public String inserirImovel (Imóvel imovel) {

		Imóvel imovel1 = Imóvel.buscarImovel(imovel.getEndereco());
		
		if (imovel1 == null)
			return Imóvel.inserirImovel(imovel);
		 else 
			return "Imovel já cadastrado";
    }
    
    
  
}
