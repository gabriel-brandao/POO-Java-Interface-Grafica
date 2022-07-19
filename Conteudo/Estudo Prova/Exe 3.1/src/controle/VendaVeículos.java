package controle;

import java.util.HashMap;
import java.util.ArrayList;
import entidade.Veículo;
import entidade.Caminhão;
import entidade.Caminhão.Capacidade;
import entidade.Carro;
import entidade.Carro.Combustivel;
import entidade.Moto;
import entidade.Cliente;
import entidade.Venda;
import util.Data;

public class VendaVeículos{

	private static HashMap <String, Veículo> hashVeiculos = new HashMap();
	private static HashMap <String, Cliente> hashClientes = new HashMap();
	private static ArrayList <Venda> listaVenda = new ArrayList();

	public static void main (String args[]){
		
		cadastrarVeiculo();
		cadastrarCliente();
		cadastrarVendas();

		imprimirVendas("Vendas Efetuadas:\n", listaVenda);
		imprimirVendas("\nFiltro de Veendas:\n", filtroVendas());
	}

	private static void inserirVeiculo(Veículo novoVeiculo){
		String chave = novoVeiculo.getModelo();

		if(hashVeiculos.get(chave) == null){
			hashVeiculos.put(chave, novoVeiculo);
			System.out.println("Veículo Cadastrado com Sucesso!!");
		}
		 else
		 	System.out.println("Veículo já Cadastrado!!");	 
	}

	private static void cadastrarVeiculo(){
		inserirVeiculo(new Carro ("Mobi", 23, 2017, true, false, Combustivel.Gasolina));
		inserirVeiculo(new Caminhão ("Mercedez 2365Hr", 2365, 2016, true, 4, Capacidade.Normal));
		inserirVeiculo(new Carro ("Uno", 14, 2015, true, true, Combustivel.Flex));
		inserirVeiculo(new Moto ("XT-400", 124, 2017, false, 50));
		inserirVeiculo(new Caminhão ("Benz-493", 425, 2017, false, 4, Capacidade.Bitrem));
		inserirVeiculo(new Moto ("Honda", 321, 2015, true, 27));
	}

	private static void inserirCliente(Cliente novoCliente){
		String chave = novoCliente.getCpf();

		if(hashClientes.get(chave) == null){
			hashClientes.put(chave, novoCliente);
			System.out.println("Cliente Cadastrado com Sucesso!!");
		}
		 else
		 	System.out.println("Cliente já Cadastrado!");
	}

	private static void cadastrarCliente(){
		inserirCliente(new Cliente ("Paulo", "976.235.124-19", "(67) 99384-9245"));
		inserirCliente(new Cliente ("Marcelo", "764.235.763-13", "(34) 99824-5373"));
		inserirCliente(new Cliente ("Jango", "214.235.123-53", "(32) 99203-2104"));
		inserirCliente(new Cliente ("Olivia", "921.765.873-45", "(56) 99418-1933"));
		inserirCliente(new Cliente ("Mara", "544.765.286-76", "(81) 99357-5227"));
	}

	private static void inserirVenda(String cpf, String descricao, float valor, Data data){
		Cliente novoCliente = hashClientes.get(cpf);
		Veículo novoVeiculo = hashVeiculos.get(descricao);

		if(novoCliente == null){
			System.out.println("Cliente Não Cadastrado!");
			return;
		}

		if(novoVeiculo == null){
			System.out.println("Veiculo Não Cadastrado!");
			return;
		}

		listaVenda.add(new Venda(novoCliente, novoVeiculo, valor, data));
		System.out.println("Venda Efetuada com Sucesso!");
	}

	private static void cadastrarVendas(){
		inserirVenda("764.235.763-13", "Benz-493", 596234.21f, new Data(23, 5, 2017));
		inserirVenda("764.235.263-13", "Benz-493", 596234.21f, new Data(23, 5, 2017));
		inserirVenda("544.765.286-76", "Hyundai", 56234.21f, new Data(20, 8, 2018));
		inserirVenda("976.235.124-19", "Mercedez 2365Hr", 56234.21f, new Data(3, 8, 2018));
		inserirVenda("921.765.873-45", "Uno", 56234.21f, new Data(14, 2, 2019));
		inserirVenda("544.765.286-76", "Benz-493", 56234.21f, new Data(13, 6, 2018));
		inserirVenda("976.235.124-19", "Mobi", 34234.21f, new Data(23, 9, 2018));
	}

	private static ArrayList <Venda> filtroVendas(){

		int anoMin = 2016;
		char éZero = 'T';
		Combustivel combustivel = Combustivel.Flex;
		int numMaxEixos = 24;
		int cilindradasMin = 12;

		float valorMin = 30000.00f;
		float valorMax = 70000.00f;

		System.out.println("\nAno Mínimo:" + anoMin + "\nZero:" + éZero + "\nCombustível:" + combustivel + "\nNúmero Máximo de Eixos:" + numMaxEixos + "\nMínimo de Cilindradas:" + cilindradasMin + "\nValor Mínimo:" + valorMin + "\nValor Máximo:" + valorMax);

		return selecionaVendas(anoMin, éZero, combustivel, numMaxEixos, cilindradasMin, valorMin, valorMax);
	}

	private static ArrayList <Venda> selecionaVendas(int anoMin, char éZero, Combustivel combustivel, int numMaxEixos, int cilindradasMin, float valorMin, float valorMax){

		ArrayList <Venda> selecionados = new ArrayList();

		for(Venda itemLista : listaVenda){
                    
                        Veículo itemV = itemLista.getVeiculo();
			//variaveis comuns a todas as subclasses
			int ItAnoMin  = itemV.getAno();
			boolean ItÉZero = itemV.isZero();
			float ItValor = itemLista.getValor();

			//compara as variaveis comuns a todas subclasses
			if(anoMin != -1 && anoMin > ItAnoMin) continue;
			if(éZero == 'T' && !ItÉZero) continue;
			if(éZero == 'F' && ItÉZero) continue;
			if(valorMin != -1 && valorMin > ItValor) continue;
			if(valorMax != -1 && valorMax < ItValor) continue;

			if(itemV instanceof Carro){
				Carro itemCarro = (Carro)itemV;

				Combustivel ItCombustivel = itemCarro.getCombustivel();
				if(combustivel != null && combustivel != ItCombustivel) continue;
				selecionados.add(itemLista);
			}
			 else
			 	if(itemV instanceof Caminhão){
			 		Caminhão itemCaminhao = (Caminhão)itemV;

			 		int ItNumMaxEixo = itemCaminhao.getNumeroEixos();
			 		if(numMaxEixos != -1 && numMaxEixos < ItNumMaxEixo) continue;
			 		selecionados.add(itemLista); 
			 	}
			 	 else
			 	 	if(itemV instanceof Moto){
			 	 		Moto itemMoto = (Moto)itemV;

			 	 		int ItCilindradasMin = itemMoto.getCilindradas();
			 	 		if(cilindradasMin != -1 && cilindradasMin > ItCilindradasMin) continue;
			 	 		selecionados.add(itemLista);
			 	 	}
		}
		return selecionados;
	}

	private static void imprimirVendas(String cabecalho, ArrayList<Venda> lista){
		
		System.out.println(cabecalho);

		for(Venda item : lista)
			System.out.println(item.toString());
	}
}