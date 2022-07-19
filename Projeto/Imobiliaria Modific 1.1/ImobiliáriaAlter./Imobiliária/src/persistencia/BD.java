
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BD {

        static final String URL_BD = "jdbc:mysql://localhost/Imobiliária";
	static final String USUARIO = "root";
	static final String SENHA = "root";

	//metodos e variaveis estaticas pois sao exclusivos da classe e nao de um objeto 
	public static Connection conexao = null; 
	
	//sera chamada antes da execução de um sql
	public static void criaConexao () {
		try {
			conexao = DriverManager.getConnection (URL_BD, USUARIO, SENHA);
		} catch (SQLException exceção_sql) {
			exceção_sql.printStackTrace ();
		}
	}

	//sera chamado após a execução de um sql
	public static void fechaConexao () {
		try {
			conexao.close();
		} catch (SQLException exceção_sql) {
			exceção_sql.printStackTrace ();
		}
	}


}
