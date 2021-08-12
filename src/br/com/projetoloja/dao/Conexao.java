package br.com.projetoloja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Esta classe será a classe pai(superclasse) de todas classes que se conectam
 * ao banco de dados.
 * Ela terá o método de abertura e fechamento do banco de dados.
 * Pelo fato de ser uma classe pai, ela não poderá ser instanciada. Assim
 * iremos defini-la como classe abstrata.
 * */
public abstract class Conexao {
	
//	vamos criar os atributos que permitirao a conexão com o banco de dados e
// a manipulação dos dados em relação ao banco
	
//	para estabelecer a conexão com o banco de dados iremos declarar um atributo
//	para a classe Connection do sql
	public Connection conectar = null;
	
//	para realizar as consultas no banco de dados iremos declarar um atributo
//	para a classe PreparedStatment(Statment -> Sentença|Sintaxe)
	public PreparedStatement pst = null;
	
//	para guardar dados que retornam de uma consulta Select, iremos usar o 
//	atributo da classe ResultSet
	public ResultSet rs = null;
	
//	Método para a abertura do banco de dados
	/**
	 * Método abrirBanco: <br><br>Realiza a abertura da conexão com o banco
	 * de dados <b>MySQL</b>
	 */
	public void abrirBanco() {
		
		try {
			
//			Registrar o driver comunicaçãc
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			//Instância da classe conectar
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojadb?useTimezone=true&serverTimezone=UTC","root","Alunos@123"); 
						
		}
		catch(ClassNotFoundException e) {
//			para tratar o erro e ser exibida toda a pilha de erro iremos usar
//			o comando printstacktrace
			e.printStackTrace();
		}
		catch(SQLException e) {
//			para tratar o erro de conexao com o mysql será exibida uma pilha
//			de erros para que possamos corrigir
			e.printStackTrace();
		}
		catch(Exception e) {
//			tratar os erros gerais
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Método fecharBanco:<br><br>
	 * Realiza o fechamento do banco de dados <b>MySQL</b>
	 */
	public void fecharBanco() {
	
		try {
//			realizar o fechamento do banco de dados
			conectar.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		
}












