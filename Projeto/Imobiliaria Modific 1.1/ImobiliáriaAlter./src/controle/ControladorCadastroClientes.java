package controle;

import interfaces.JanelaCadastroClientes;
import entidade.Cliente;

public class ControladorCadastroClientes {
    
    //abre a janela de cadastro
    public ControladorCadastroClientes(){
        new JanelaCadastroClientes(this).setVisible(true);
    }

    public String inserirCliente(Cliente cliente){
      
        Cliente verifica = Cliente.buscarCliente(cliente.getCpf());
        
        if(verifica == null)
            return Cliente.inserirCliente(cliente);
        else
            return "Cliente Já Cadastrado !!";        
    }

    public String alterarCliente(Cliente cliente) {
       
        Cliente verifica = Cliente.buscarCliente(cliente.getCpf());
       
        if(verifica != null)
           return Cliente.alterarCliente(cliente);
        else
            return "Cliente Não Cadastrado !!";        
    }

    public String removerCliente(String cpf) {
       
        Cliente verifica = Cliente.buscarCliente(cpf);
        
        if(verifica != null)
            return Cliente.removerCliente(cpf);
        else
            return null;
    }

}
