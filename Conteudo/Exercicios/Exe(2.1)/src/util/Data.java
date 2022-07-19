package util;
import java.util.Calendar;

import java.util.GregorianCalendar;

public class Data {
	private int dia, mês, ano;
	
	public Data(int dia, int mês, int ano) {
		this.dia = dia;
		this.mês = mês;
		this.ano = ano;
	}

	public int getDia() {
		return dia;
	}

	public int getMês() {
		return mês;
	}

	public int getAno() {
		return ano;
	}

	public int calcularIdade (){
		GregorianCalendar data_atualGregorianCalendar = new GregorianCalendar();
		int dia_atual = data_atualGregorianCalendar.get(Calendar.DAY_OF_MONTH); //pega o dia atual 
		int mês_atual = data_atualGregorianCalendar.get(Calendar.MONTH) + 1; // GregorianCalendar: mês varia de 0 a 11
		int ano_atual = data_atualGregorianCalendar.get(Calendar.YEAR);
		int idade = ano_atual - ano;
		
		if ((mês_atual < mês) || ((mês_atual == mês) && (dia_atual < dia))) idade--;
			return idade;
		}

		public int compareTo(Data outraData) {
			if (ano > outraData.getAno()) return 1;
			if (ano < outraData.getAno()) return -1;
			if (mês > outraData.getMês()) return 1;
			if (mês < outraData.getMês()) return -1;
			if (dia > outraData.getDia()) return 1;
			if (dia < outraData.getDia()) return -1;
		return 0;
		}

		public String toString(){
		 String data;
			if (dia < 10) data = "0" + dia; 
                            else data = "" + dia;
			if (mês < 10) data += "/0" + mês + "/"; 
                            else data += "/" + mês + "/";
	    	return data += ano;
		}
}
