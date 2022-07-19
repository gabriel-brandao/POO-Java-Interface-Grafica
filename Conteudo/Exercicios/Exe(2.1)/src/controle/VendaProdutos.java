package controle;

import java.util.ArrayList;
import java.util.HashMap;
import entidade.Produto;
import entidade.Produto.Tipo;
import entidade.Cliente;
import entidade.Venda;
import entidade.Endereço;
import util.Data;

public class VendaProdutos{

	private static HashMap <String, Produto> hashProduto = new HashMap(); //armazenara o cadastro de produtos. hash indexado pelo nome do produto
	private static HashMap <String, Cliente> hashCliente = new HashMap(); //armazena o cadastro de clientes. hash indexado pelo cpf
	
	//armazana lista das vendas realizadas:
	private static ArrayList<Venda> listaVendas = new ArrayList();

	public static void main(String args[]){
		cadastrarProdutos();
		cadastrarClientes();
		cadastrarVendas(); //faz a conexao entre os clientes e os produtos
		
		imprimirVendas("\n#### Vendas Realizadas: ####", listaVendas);
		imprimirVendas("\n#### RESULTADO DO FILTRO: ####", selecionaVendas());
	}

	//insere produtos no hash se ja nao estiverem cadastrados
	private static void inserirProdutos(Produto novoProduto){
		String chave_produto = novoProduto.getDescrição(); //pega a descricao do produto (que funciona como chave no hashtable para verificar se existe esse objeto nela)
		if(hashProduto.get(chave_produto) == null){
			hashProduto.put(chave_produto, novoProduto); //se o objeto ja nao for cadastrado realiza o cadastro, senao informa ao usuario que nao foi possivel
			System.out.println("PRODUTO CADASTRADO COM SUCESSO!");
		}
		 else
		 	System.out.println("PRODUTO JÁ CADASTRADO!");
	}

	//construtor para cada objeto
	private static void cadastrarProdutos(){
		inserirProdutos(new Produto ("TV - Samsung 32''", Tipo.eletrônico));
		inserirProdutos(new Produto ("Barbeador eletrico", Tipo.eletrônico));
		inserirProdutos(new Produto ("Geladeira frost-free", Tipo.eletrodoméstico));
		inserirProdutos(new Produto ("Brastemp 12kg", Tipo.eletrodoméstico));
		inserirProdutos(new Produto ("Barbeador eletrico", Tipo.eletrônico));
		inserirProdutos(new Produto ("Touca Benie - P", Tipo.roupa));
		inserirProdutos(new Produto ("Brastemp 12kg", Tipo.eletrodoméstico));
	}

	//insere os clientes no hash se nao estiverem no cadastro
	private static void inserirClientes(Cliente novoCliente){
		String chave_cliente = novoCliente.getCpf(); //pega o CPF do cliente (que funciona como chave no hashtable para verificar se existe esse objeto nela)
		if(hashCliente.get(chave_cliente) == null){
			hashCliente.put(chave_cliente, novoCliente);//se o objeto ja nao for cadastrado realiza o cadastro, senao informa ao usuario que nao foi possivel
			System.out.println("CLIENTE CADASTRADO COM SUCESSO!!");
		}
		 else
		 	 System.out.println("CLIENTE JA CADASTRADO!!");
	}

	//construtor para cada objeto
	private static void cadastrarClientes(){
		inserirClientes(new Cliente ("Joaquim Texeira", "054.234.645-12", "03.847.655/0001-98", "Joaquin32@hotmail.com", new Endereço ("Rua Arco Verde","apto 301", "79810-015", "Água Boa", "Dourados",171)));
		inserirClientes(new Cliente ("Rosa Aquino", "321.562.841-67", "15.647.905/0321-26", "RosaAq@gmail.com", new Endereço("Rua Chapéu Velho", "", "79820-017", "Rouxinol", "Dourados", 303)));
		inserirClientes(new Cliente ("Elisa Samudio", "648.562.863-34", "76.382.962/6381-81", "Picadinho57@hotmail.com", new Endereço ("Rua Sino da Mata", "", "733100-000", "Brejão", "Carapó", 303)));
		inserirClientes(new Cliente ("Romão", "321.562.841-67", "15.647.905/0321-26", "RosaAq@gmail.com", new Endereço("Rua Chapéu Velho", "", "79820-017", "Rouxinol", "Dourados", 303)));
	}

	//cria os objetos da classe venda que sao compostos por clientes e produtos
	private static void inserirVendas(String cpf_cliente, String produto, Data data, boolean entregaRapida){
		Cliente clienteVendas = hashCliente.get(cpf_cliente); //retorna null se nao houver o indice da chave passada
		Produto produtoVendas = hashProduto.get(produto);   //retorna null se nao houver o indice da chave passada

		if(clienteVendas == null){
			System.out.println("CLIENTE NAO POSSUI CADASTRO NO SISTEMA!!");
			return;
		}
		if(produtoVendas == null){
			System.out.println("PRODUTO NAO CADASTRADO NO ESTOQUE!!");
			return;
		}
		System.out.println("VENDA BEM SUCEDIDA!!");
		listaVendas.add(new Venda (clienteVendas, produtoVendas, data, entregaRapida));
	}

	//faz a linkacao entre produto e cliente, passa os paramentros da classe venda, para a funcao inserirVendas criar os objetos
	private static void cadastrarVendas(){
		inserirVendas("054.234.645-12", "TV - Samsung 32''", new Data(2, 4, 2018), true);
		inserirVendas("321.562.851-67", "Brastemp 12kg", new Data(5, 06, 2018), false); //nao possui cadastro
		inserirVendas("648.562.863-34", "Brastemp 12kg", new Data(05, 11, 2018), true);
		inserirVendas("321.562.841-67", "Touca Benie - P", new Data(11, 12, 2018), false);
		inserirVendas("321.562.841-67", "Touca Benie - M", new Data(29, 02, 2019), false); //produto nao cadastrado
	}

	//escolhe como sera feita a selecao das vendas
	private static ArrayList<Venda> selecionaVendas(){
		String cidade = "CARAPÓ"; //transformar par miniuscula
		Tipo tipo = Tipo.eletrodoméstico;
		char entrega_rapida = 'F';

		System.out.println("\n## FILTRO: ##\nCidade: " +  cidade + " -Tipo: " + tipo + " -entrega rapida: " + entrega_rapida);
		return filtroVendas(cidade.toLowerCase(), tipo, entrega_rapida);
	}

	private static ArrayList<Venda> filtroVendas(String selecao_cidade, Tipo selecao_tipo, char selecao_entrega_rapida){
		ArrayList<Venda> vendasSelecionadas = new ArrayList();

		for(Venda iVendas : listaVendas){
			String cidade = (iVendas.getCliente().getEndereço().getCidade()).toLowerCase();
			Tipo tipo = iVendas.getProduto().getTipo();
			boolean entrega_rapida = iVendas.isEntregaRapida();

			if(!selecao_cidade.isEmpty() && !cidade.equals(selecao_cidade)) continue;
			if(selecao_tipo != tipo) continue;
			if((selecao_entrega_rapida == 'T') && (!entrega_rapida)) continue;
			if((selecao_entrega_rapida == 'F') && (entrega_rapida)) continue;

			vendasSelecionadas.add(iVendas); //adiciona o item da lista de vendas nos selecionados
		}
		return vendasSelecionadas;
	}

	//imprimi o ArrayList de vendas receida como parametro:
	private static void imprimirVendas(String cabeçalho, ArrayList listaVendas){
		System.out.println(cabeçalho);
		
		for(int i = 0; i < listaVendas.size(); i++){
			System.out.println(listaVendas.get(i).toString());
		}
	}
}