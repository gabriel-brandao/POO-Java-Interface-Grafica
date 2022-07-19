package controle;

import entidade.Veículo;
import entidade.Carro;
import entidade.Carro.Combustivel;
import entidade.Caminhão;
import entidade.Caminhão.Capacidade;
import entidade.Moto;
import java.util.ArrayList;

public class VendaVeículos{

    //cria lista de veiculos
    private static ArrayList <Veículo> listaVeiculo = new ArrayList();

    public static void main (String args[]){
        criaVeiculos();
        
        imprimirVeiculos("Veículos Cadastrados:\n", listaVeiculo);
        imprimirVeiculos("\nResultado Filtro:\n", selecionaVeiculos());

    }

    private static void criaVeiculos(){
    	listaVeiculo.add(new Caminhão ("Volvo - L2356", 26, 2001, false, 2, Capacidade.normal));
    	listaVeiculo.add(new Carro ("Uno", 1.6f, 2017, true, Combustivel.flex, true));
    	listaVeiculo.add(new Moto ("CB - 300 R", 26, 2008, false, 291));
    }

    private static ArrayList <Veículo> selecionaVeiculos(){
    	int ano_minimo = 2001;
    	char zero = 'X';
    	Capacidade capacidade = null;
    	Combustivel combustivel = null;
    	char quatro_portas = 'F';
    	int cilindradas = -1;

    	System.out.println("\nFiltro de veículo:\n" + "Ano Mínimo: " + ano_minimo + "\nZero: " + zero + "\nCapacidade: " + capacidade + "\nCombustível: " + combustivel + "\nQuatro Portas: " + quatro_portas + "\nCilidradas Mínimas: " + cilindradas);

    	return filtraVeiculos(ano_minimo,zero, capacidade, combustivel, quatro_portas, cilindradas);
    }

    private static ArrayList <Veículo> filtraVeiculos(int ano_minimo, char zero, Capacidade capacidade, Combustivel combustivel, char quatro_portas, int cilindradas){

    	ArrayList <Veículo> listaSelecionados = new ArrayList();

    	for (Veículo itemVeiculo : listaVeiculo){

    		//Campos comuns a todas as subclasses
    		if((ano_minimo != -1) && (itemVeiculo.getAno() < ano_minimo)) continue;
    		if((zero == 'F') && itemVeiculo.isZero()) continue;
    		if((zero == 'T') && !itemVeiculo.isZero()) continue;

    		//Verifica qual objeto é:
    		if(itemVeiculo instanceof Caminhão){
    			Caminhão itemCaminhao = (Caminhão)itemVeiculo;	//converte para a subclasse
    			if((capacidade != null) && (capacidade != itemCaminhao.getCapacidade())) continue;
    		}
	    	 else if(itemVeiculo instanceof Carro){
	    	 	Carro itemCarro = (Carro)itemVeiculo;  //converte para a subclasse
	    	 	if ((combustivel != null) && (combustivel != itemCarro.getCombustivel())) continue;
	    	 	if ((quatro_portas == 'F') && itemCarro.isQuatroPortas()) continue;
	    	 	if ((quatro_portas == 'T') && itemCarro.isQuatroPortas()) continue;
	    	 }
	    	  else if(itemVeiculo instanceof Moto){
	    	  	Moto itemMoto = (Moto)itemVeiculo; //converte para a subclasse
	    	  	 if ((cilindradas != -1) && (cilindradas > itemMoto.getCilindradas())) continue;
	    	  }
    		
    		listaSelecionados.add(itemVeiculo);
    	}
    	return listaSelecionados;
    }

    private static void imprimirVeiculos(String cabecalho, ArrayList <Veículo> listaVeiculo){
    	System.out.println(cabecalho);

    	for(Veículo itemVeiculo : listaVeiculo)
    		System.out.println(itemVeiculo.toString());
    }

    
}