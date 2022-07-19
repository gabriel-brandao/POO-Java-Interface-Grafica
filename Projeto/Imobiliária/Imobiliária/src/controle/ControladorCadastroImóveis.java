
package controle;

import entidade.Imóvel;
import interfaces.JanelaCadastroImóveis;

public class ControladorCadastroImóveis {
    
    //abre a janela de cadastro de imoveis
    public ControladorCadastroImóveis(){
        new JanelaCadastroImóveis(this).setVisible(true);
    }
    
    public String inserirImovel(Imóvel imovel){
        
        Imóvel verifica = Imóvel.buscarImovel(imovel.getEndereco().getCep(),imovel.getEndereco().getComplemento());
        
        if(verifica == null)
            return Imóvel.inserirImovel(imovel);
        else
            return "Imóvel Já Cadastrado !!";
    }

    public String alterarImovel(Imóvel imovel) {
        Imóvel verifica = Imóvel.buscarImovel(imovel.getEndereco().getCep(),imovel.getEndereco().getComplemento());
        
        if(verifica != null)
            return Imóvel.alterarImovel(imovel);
        else
            return "Imóvel Não Cadastrado !!";
            
    }
    
    
    
    
}
