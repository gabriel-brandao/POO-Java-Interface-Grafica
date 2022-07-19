package controle;

import entidade.Negócio;
import interfaces.JanelaCadastroNegócios;

public class ControladorCadastroNegócios {
    
    public ControladorCadastroNegócios(){
       new JanelaCadastroNegócios(this).setVisible(true);
    }

    public String inserirNegocio(Negócio negocio) {        
       
        Negócio verifica = Negócio.buscarNegocio1(negocio.getImovel().getSequencial());//Passar apenas Cpf e Sequencial
        
        if(verifica == null)
            return Negócio.inserirNegocio(negocio);
        else
            return "Negócio Já Cadastrado ou Imóvel Já Negociado !!";
    }

    public String removerNegocio(Integer sequencial) {
        
        Negócio verifica = Negócio.buscarNegocio2(sequencial);
        
        if(verifica != null)
            return Negócio.removerNegocio(sequencial);
        else
            return "Negócio Não Encontrado !!";
    }
    
    public String alterarNegocio(Negócio negocio){
        
        Negócio verifica = Negócio.buscarNegocio2(negocio.getSequencial());
        
        if(verifica != null)
            return Negócio.alterarNegocio(negocio);
        else
            return "Negócio Não Encontrado !!";
    }

}
