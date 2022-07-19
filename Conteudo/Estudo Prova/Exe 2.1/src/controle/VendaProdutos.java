package controle;

import entidade.Cliente;
import entidade.Produto;
import entidade.Produto.Tipo;
import entidade.Venda;
import entidade.Endereço;
import util.Data;
import java.util.HashMap;
import java.util.ArrayList;


public class VendaProdutos{

	private static HashMap <String ,Cliente> hashCliente = new HashMap(); //armazena dados do cliente em hash table
	private static HashMap <String, Produto> hashProduto = new HashMap(); //armazena dados do produto em hash table

	private static ArrayList <Venda> listaVendas = new ArrayList(); //armazena em uma lista os dados de cadastros

	public static void main (String args[]){	
		cadastrarProdutos();
		cadastrarClientes();
		cadastrarVendas();

		imprimirVendas("Vendas Realizadas:\n", listaVendas);
		ArrayList<Venda> selecionados = selecionaVendas();
		imprimirVendas("Vendas Selecionadas:\n", selecionados);
	}

	private static void inserirProdutos(Produto novoProduto){
		String chave = novoProduto.getDescricao();

		if(hashProduto.get(chave) == null){
			hashProduto.put(chave, novoProduto);
			System.out.println("Produto Cadastrado com Sucesso!!");
		}
		 else
		 	System.out.println("Produto ja Cadastrado!!");
	}

	private static void cadastrarProdutos(){
		inserirProdutos(new Produto("Notebook Acer Aspire-V5", Tipo.Eletrônico));
		inserirProdutos(new Produto("Fone Meizu", Tipo.Eletrônico));
		inserirProdutos(new Produto("Geladeira Froz-Free", Tipo.Eletrodoméstico));
		inserirProdutos(new Produto("Short National Adventure", Tipo.Roupa));
		inserirProdutos(new Produto("Meia Puma", Tipo.Roupa));
		inserirProdutos(new Produto("Fogão Dako", Tipo.Eletrodoméstico));
	}


	private static void inserirClientes(Cliente novoCliente){
		String chave = novoCliente.getCpf();

		if(hashCliente.get(chave) == null){
			hashCliente.put(chave, novoCliente);
			System.out.println("Cliente Cadastrado com sucesso!!");
		}
		 else
		 	System.out.println("Cliente ja Cadastrado!!");
	}

	private static void cadastrarClientes(){
		inserirClientes(new Cliente ("Roberto", "054.394.611-83", "", "roob@hotmail.com", new Endereço ("Rua Jeba", 23, "", "Jardim Global", "Piratininga", "79820-456")));
		inserirClientes(new Cliente ("Khalifa", "344.814.901-12", "", "Kaah@hotmail.com", new Endereço ("Rua Mia", 14, "ao lado do bar da preta", "Pq. rio branco", "Aracatuba", "79832-521")));
		inserirClientes(new Cliente ("Pedrina", "129.372.618-54", "", "Peeh@hotmail.com", new Endereço ("Rua Guapa", 982, "", "Belo Monte", "Cajuzeiro", "79345-537")));
		inserirClientes(new Cliente ("Mariana", "890.234.632-49", "", "maahri@hotmail.com", new Endereço ("Rua Presidente amelio", 8923, "Atras do baile da gaiola", "rio azul", "Jardim", "75423-345")));
	}


	private static void inserirVendas(String cpfCliente, String DescProduto, Data data, boolean entrega){

		Produto novoProduto = hashProduto.get(DescProduto);
		Cliente novoCliente = hashCliente.get(cpfCliente);

		if(novoProduto == null){
			System.out.println("Produto Não Disponível");
			return;
		}

		if(novoCliente == null){
			System.out.println("Cliente Não Cadastrado");
			return;
		}

		listaVendas.add(new Venda (novoCliente, novoProduto, data, entrega));
		System.out.println("Venda Realizada com Sucesso");
	}

	private static void cadastrarVendas(){
		inserirVendas("034.928.812-23", "Fogão Dako", new Data(23, 4, 2018), true);
		inserirVendas("054.394.611-83", "Fogão Dako", new Data(12, 8, 2018), true);
		inserirVendas("054.394.611-83", "Ventilador Mondial", new Data(3, 12, 2018), false);
		inserirVendas("129.372.618-54", "Notebook Acer Aspire-V5", new Data(13, 5, 2019), false);
		inserirVendas("890.234.632-49", "Meia Puma", new Data(9, 10, 2018), true);
		inserirVendas("344.814.901-12", "Fone Meizu", new Data(15, 2, 2019), false);
		inserirVendas("344.814.901-12", "Geladeira Froz-Free", new Data(7, 06, 2018), true);
	}

	private static ArrayList <Venda> selecionaVendas(){
		String cidade = null;
		Tipo tipo = null;
		char entregaRapida = 'T';
                
                System.out.println("Filtro:\n" + "Cidade: " + cidade + "\nTipo:" + tipo + "\nEntrega Rapida:" + entregaRapida);

		return filtroVendas(cidade, tipo, entregaRapida);
	}

	private static ArrayList<Venda> filtroVendas(String filtroCidade, Tipo filtroTipo, char filtroEntrega){
		ArrayList<Venda> selecionado = new ArrayList();

		for(Venda itemVenda : listaVendas){

			String cidadeItem = itemVenda.getCliente().getEndereco().getCidade();
			Tipo tipoItem = itemVenda.getProduto().getTipo();
			boolean entregaItem = itemVenda.isEntregaRapida();

			if(filtroCidade != null && !filtroCidade.equals(cidadeItem)) continue;
			if(filtroTipo != null && filtroTipo != tipoItem) continue;
			if(filtroEntrega == 'T' && !entregaItem) continue;
			if(filtroEntrega == 'F' && entregaItem) continue;

			selecionado.add(itemVenda);
		}

		return selecionado;
	}

	private static void imprimirVendas(String cabecalho, ArrayList <Venda> lista){
		System.out.println(cabecalho);

		for(Venda itemVenda : lista)
			System.out.println(" > CLIENTE:" + itemVenda.toString());	
	}

}