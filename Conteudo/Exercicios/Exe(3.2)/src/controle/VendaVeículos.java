package controle;

import java.util.HashMap;
import java.util.ArrayList;
import util.Data;
import entidade.Venda;
import entidade.Veículos;
import entidade.Clientes;
import entidade.Caminhão;
import entidade.Caminhão.Capacidade;
import entidade.Carro;
import entidade.Carro.Combustivel;
import entidade.Moto;

public class VendaVeículos{

	private static HashMap <String, Veículos> hashVeiculos = new HashMap(); //indexacao pelo modelo
	private static HashMap <String, Clientes> hashClientes = new HashMap(); //indexacao pelo CPF
	private static ArrayList <Venda> listaVenda = new ArrayList();

	public static void main(String args[]){
		cadastrarVeículos();
		cadastrarClientes();
		cadastrarVendas();
		
		imprimirVendas("Lista de Vendas:\n", listaVenda);
	}

	private static void inserirVeículos(Veículos veiculo){
		String chave_veiculo = veiculo.getModelo();
		if (hashVeiculos.get(chave_veiculo) == null){
			hashVeiculos.put(chave_veiculo, veiculo);
			System.out.println("VEÍCULO CADASTRADO COM SUCESSO!!");
		}
		 else
			System.out.println("VEÍCULO JÁ CADASTRADO!!");
	}

	private static void cadastrarVeículos(){
		inserirVeículos(new Caminhão ("Volvo - L2356", 26, 2001, false, 2, Capacidade.normal));
		inserirVeículos(new Carro ("Uno", 1.6f, 2017, true, Combustivel.Flex, true));
		inserirVeículos(new Moto ("CB - 300 R", 26, 2008, false, 291));
	}

	private static void inserirClientes(Clientes cliente){
		String chave_cliente = cliente.getCpf();
		if(hashClientes.get(chave_cliente) == null){
			hashClientes.put(chave_cliente, cliente);
			System.out.println("CLIENTE CADASTRADO COM SUCESSO!!");
		}
		 else
		 	System.out.println("CLIENTE JA CADASTRADO!!");
	}

	private static void cadastrarClientes(){
		inserirClientes(new Clientes ("Ronaldo Jean", "032.567.211-76", "(67)99862-1245"));
		inserirClientes(new Clientes ("Fábio Amaral", "762.327.814-88", "(81)99345-1931"));
		inserirClientes(new Clientes ("Magda Rosa", "934.861.726-28", "(17)98553-1691"));
		inserirClientes(new Clientes ("Júnior Silva", "927.827.038-85", "(11)98826-8304"));
	}

	private static void inserirvendas(float valor, Data data, String cpf, String nomeVeiculo){
		Clientes cliente = hashClientes.get(cpf); //retorna null se nao achar um objeto na taela indexada pelo cpf
		Veículos veiculo = hashVeiculos.get(nomeVeiculo); //retorna null se nao achar um objeto na taela indexada pelo nome

		if(cliente == null){
			System.out.println("\nCLIENTE NÃO POSSUI CADASTRO!!");
			return;
		}

		if(veiculo == null){
			System.out.println("\nVEÍCULO NÃO DISPONÍVEL!!");
			return;
		}
		listaVenda.add(new Venda (valor, data, cliente, veiculo));
		System.out.println("VENDA BEM SUCEDIDA!!");
	}

	private static void cadastrarVendas(){
		inserirvendas(20198.23f, new Data(02, 07, 2018), "032.567.211-76", "Uno");
        inserirvendas(1022.21f, new Data(11, 9, 2018), "762.327.814-88", "Volvo - L2356");
		inserirvendas(29348.15f, new Data(11, 10, 2018), "761.327.814-88", "Volvo - L2356"); //cliente nao cadastrado
		inserirvendas(20198.23f, new Data(2, 07, 2018), "032.567.211-76", "Kia"); //veiculo nao cadastrado
	}

	private static void imprimirVendas(String cabecalho, ArrayList <Venda> listaVenda){
		System.out.println(cabecalho);

		for(Venda itemVenda : listaVenda){
			System.out.println(" +Cliente:" + itemVenda.getCliente().toString() + " +Veículo:" + itemVenda.getVeiculo().toString() + " +Preço:" + itemVenda.getValor() + " +Data:" + itemVenda.getData());
		}
	}

}