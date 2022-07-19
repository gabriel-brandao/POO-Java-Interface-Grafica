
package controle;

import entidade.Imóvel;
import interfaces.JanelaCadastroImóveis;

public class ControladorCadastroImóveis {
    
    //abre a janela de cadastro de imoveis
    public ControladorCadastroImóveis(){
        new JanelaCadastroImóveis(this).setVisible(true);
    }
    
    public String inserirImovel(Imóvel imovel){
        
        Imóvel verifica = Imóvel.buscarImovel1(imovel.getEndereco().getCep(),imovel.getEndereco().getComplemento());
        
        if(verifica == null)
            return Imóvel.inserirImovel(imovel);
        else
            return "Imóvel Já Cadastrado !!";
    }

    public String alterarImovel(Imóvel imovel) {
        
        Imóvel verifica = Imóvel.buscarImovel2(imovel.getSequencial());
        
        if(verifica != null)
            return Imóvel.alterarImovel(imovel);
        else
            return "Imóvel Não Cadastrado !!";     
    }

    public String removerImovel(Integer chave) {
       
        Imóvel verifica = Imóvel.buscarImovel2(chave);
        
        if(verifica != null)
            return Imóvel.removerImovel(chave);
        else
            return "Imóvel Não Cadastrado !!";
    }
 
}
