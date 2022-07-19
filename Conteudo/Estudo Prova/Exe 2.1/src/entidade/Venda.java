package entidade;

import entidade.Cliente;
import entidade.Produto;
import util.Data;

public class Venda{


	private Cliente cliente;
	private Produto produto;
	private Data data;
	private boolean entregaRapida;

	public Venda(Cliente cliente, Produto produto, Data data, boolean entregaRapida){
		this.cliente = cliente;
		this.produto = produto;
		this.data = data;
		this.entregaRapida = entregaRapida;
	}

	public Cliente getCliente(){
		return cliente;
	}

	public Produto getProduto(){
		return produto;
	}

	public Data getData(){
		return data;
	}

	public boolean isEntregaRapida(){
		return entregaRapida;
	}

	public String toString(){
		String dados = ">Cliente: " + cliente.toString() + " >Produto: " + produto.toString() + " >Data: " + data;

		if(isEntregaRapida())
			dados += "--Entrega Rapida!!";

		return dados;
	}

}



