package entidade;

import entidade.Veículos;
import entidade.Clientes;
import util.Data;

public class Venda{

	private float valor;
	private Data data;
	private Clientes cliente;
	private Veículos veiculo;
	
	public Venda (float valor, Data data, Clientes cliente, Veículos veiculo){
		this.valor = valor;
		this.data = data;
		this.cliente = cliente;
		this.veiculo = veiculo;
	}

	public float getValor(){
		return valor;
	}

	public Data getData(){
		return data;
	}

	public Clientes getCliente(){
		return cliente;
	}

	public Veículos getVeiculo(){
		return veiculo;
	}

	public String toString(){
		String dados;

		return dados = " +Cliente:" + cliente.toString() + " +Veículo:" + veiculo.toString() + " +Valor:" + valor + " +Data:" + data.toString();
	}

}