package entidade;

import entidade.Cliente;
import entidade.Veículo;
import util.Data;

public class Venda{
	
	private Cliente cliente;
	private Veículo veiculo;
	private float valor;
	private Data data;

	public Venda(Cliente cliente, Veículo veiculo, float valor, Data data){
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.valor = valor;
		this.data = data;
	}

	public float getValor(){
		return valor;
	}

	public Data getData(){
		return data;
	}

	public Cliente getCliente(){
		return cliente;
	}

	public Veículo getVeiculo(){
		return veiculo;
	}

	public String toString(){
		String dados = " +VENDA:\n" + " >Cliente:" + cliente.toString() + " >Veículo:" + veiculo.toString() + " >Data:" + data + " >Valor:" + valor;

		return dados;
	}


}