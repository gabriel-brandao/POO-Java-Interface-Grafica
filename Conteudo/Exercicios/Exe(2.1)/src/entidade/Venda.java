package entidade;

import util.Data;

public class Venda{

	private Cliente cliente;
	private Produto produto;
	private Data data;
	private boolean entregaRapida;

	public Venda (Cliente cliente, Produto produto, Data data, boolean entregaRapida){
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
		String dados_venda = "\nCliente:\n" + cliente.toString() + "\nProduto:\n" + produto.toString() + " - " + data.toString();	
		if(isEntregaRapida())
			dados_venda += " - ENTREGA RAPIDA";
		return dados_venda;
	}
}