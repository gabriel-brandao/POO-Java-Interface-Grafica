package controle;

import entidade.Paciente;
import entidade.Paciente.Especialista;
import java.util.ArrayList;
import java.lang.String;

public class ImpressaoPaciente{

	//declara array de paciente 
	private static Paciente [] lista_paciente;

	public static void main (String args[]){	
		System.out.println("\t\t\t###### CADASTROS DE PACIENTES ######\n\n");
		
		lista_paciente = criaLista();
		imprimePaciente("#Pacientes Cadastrados#:\n", lista_paciente);

		ArrayList <Paciente> seleciona_pacientes = selecaoPacientes();
		imprimePaciente("#Resultado do Filtro#:\n", seleciona_pacientes.toArray(new Paciente [seleciona_pacientes.size()]));
	} 

	private static Paciente[] criaLista(){
		//inicializa cada indice com valores default do objeto paciente
		lista_paciente = new Paciente[5];
        
        lista_paciente[0] = new Paciente ("Maria de Fátima", 25, 'F', "23/07/18", Especialista.oftalmologia, true);
        lista_paciente[1] = new Paciente ("kléber Pereira", 45, 'm', "30/04/17", Especialista.cardiologia, true);
        lista_paciente[2] = new Paciente ("Enzo Gabriel", 12, 'M', "15/06/18", Especialista.pediatria, false);
        lista_paciente[3] = new Paciente ("Alcides João", 34, 'm', "24/07/18", Especialista.psiquiatria, true);
        lista_paciente[4] = new Paciente ("Cláudia Valentina", 26, 'f', "9/10/17",Especialista.oftalmologia, false);
        return lista_paciente;
	}

	private static ArrayList <Paciente> selecaoPacientes(){
		String str_faixa_idade = "[23,34]"; //faixa de idade ou [X]
		//quebra o intervalo de string em inteiro:
		int [] int_faixa_idade = converteStrParaInt(str_faixa_idade); 
		char sexo = 'X';
		//dia ???
		String especialista = "psiquiatria";
		char urgencia = 'X';

		System.out.println("#Filtro#:\n" + " *faixa de idade:" + str_faixa_idade + " *sexo:" + sexo + " *especialista:" + especialista + " *urgência:" + urgencia + "\n");

		return filtroPacientes(int_faixa_idade, sexo, especialista, urgencia);
	}

	private static ArrayList <Paciente> filtroPacientes(int[] int_faixa_idade, char sexo, String especialista, char urgencia){
		//declara e inicializa arrayList cm metodo construtor
		ArrayList <Paciente> seleciona_pacientes = new ArrayList();

		for(int i = 0; i < lista_paciente.length; i++){
			
			int _pidade = lista_paciente[i].getIdade();
			String _psexo = lista_paciente[i].toStringSexo();
            String _pespecialista = lista_paciente[i].getEspecialista() + ""; //converte enum para String
            boolean _purgencia = lista_paciente[i].isUrgencia();
                        
			if((int_faixa_idade[0] != -1) && (int_faixa_idade[0] > _pidade)) continue;
			if((int_faixa_idade[1] != -1) && (int_faixa_idade[1] < _pidade)) continue; //*****
            if(sexo != 'X'){
                if((sexo == 'F') && _psexo.equals("masculino")) continue;
                if((sexo == 'M') && _psexo.equals("feminino")) continue;
            }
            if((!especialista.equals("X")) && (!especialista.equals(_pespecialista))) continue;
            if((urgencia == 'F') && (_purgencia)) continue;
            if((urgencia == 'T') && (!_purgencia)) continue;

            seleciona_pacientes.add(lista_paciente[i]);
		}
			return seleciona_pacientes;
	}

	private static void imprimePaciente (String cabecalho, Paciente [] lista_paciente){
		System.out.println(cabecalho);

		for(Paciente it_Paciente : lista_paciente)
			System.out.println(it_Paciente.toString());
		System.out.println("\n");
	}

	private static int[] converteStrParaInt (String str_faixa_idade){

		int tamanho = str_faixa_idade.length();
		int [] int_faixa_idade = new int[2];

		if(str_faixa_idade.charAt(1) != 'X'){			
			if(str_faixa_idade.contains(",")){
				int index_virgula = str_faixa_idade.indexOf(',');

				int_faixa_idade[0] = Integer.parseInt(str_faixa_idade.substring(1, index_virgula));
				int_faixa_idade[1] = Integer.parseInt(str_faixa_idade.substring(index_virgula+1, tamanho-1));
			}
             else
			 	int_faixa_idade[0] = int_faixa_idade[1] = Integer.parseInt(str_faixa_idade.substring(1, tamanho-1));                       
		}
         else
           int_faixa_idade[0] = int_faixa_idade[1] = -1; 

        return int_faixa_idade;
	}
}