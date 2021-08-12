package br.com.projetoloja.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.projetoloja.objeto.Contato;

public class ContatoDAO extends Conexao implements ICrud<Contato>{

	@Override
	public String cadastrar(Contato objeto) {
		
		String msg = "";
		
//		Vamos tentar cadastrar o contato no banco de dados.
		try {
			
			abrirBanco();
						
//			vamos preparar o banco para realizar a consulta de inserção
			pst = conectar.prepareStatement("insert into contato(telefone,email) values (?,?)");
			
//			Os dados que serão cadastrados no banco de dados devem ser parametrizados.
//			isso evita a tentativa de sqlinject
			pst.setString(1, objeto.getTelefone());
			pst.setString(2, objeto.getEmail());
			
//			vamos executar a consulta com o comando executeUpdate
//			ele retorna um número. Quando retorna 0(Zero), significa que não
//			houve cadastro.
//			para pegar o retorno iremos criar uma variável do tipo int e testá-la
			int r = pst.executeUpdate();
			
			if(r > 0)
				msg = "Contato cadastrado com sucesso!";
			else
				msg = "Não foi possível cadastrar.";
		}
		catch(SQLException e) {
			msg = "Erro ao tentar cadastrar o contato. "+e.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
		}
		
		finally {
			fecharBanco();
		}
		
		return msg;
	}

	
	
	
	@Override
	public List<Contato> listar() {
	
		List<Contato> listaContatos = new ArrayList<Contato>();
		try {
			abrirBanco();
			String consulta = "Select * from contato";
			
//			preparar o banco de dados para a consulta select de contato
			pst = conectar.prepareStatement(consulta);
			
//			Vamos executar a consulta e o retorno, ou seja, os dados que 
//			foram encontrados serão alocacos no atributo rs
			rs = pst.executeQuery();
			
//			vamos organizar os dados que retornam do banco de dados na lista
//			de contato. Iremos usar um laço para ler todo o conteúdo de dados
//			que agora está em rs.
			while(rs.next()) {
				listaContatos.add(
						new Contato(
								rs.getInt(0), 
								rs.getString(1), 
								rs.getString(2))
						);
			}
			
		}
		catch(SQLException e) {
//			vamos imprimir a pilha de errors do sql, caso ocorra
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			fecharBanco();
		}
				
		return listaContatos;
	}

	@Override
	public List<Contato> pesquisar(Contato objeto) {
		
		List<Contato> listaContatos = new ArrayList<Contato>();
		 
		try {
			abrirBanco();
			
			String sqlId = "Select * from contato where idcontato=?";
			
			String sqlTel = "Select * from contato where telefone like ?";
			
			String sqlEmail = "Select * from contato where email=?";
			
			if(objeto.getEmail()==null && objeto.getTelefone()==null) {
				pst = conectar.prepareStatement(sqlId);
				pst.setInt(1, objeto.getIdContato());
			}
			else if(objeto.getEmail()==null) {
				pst = conectar.prepareStatement(sqlTel);
				pst.setString(1, objeto.getTelefone());
			}
			else {
				pst = conectar.prepareStatement(sqlEmail);
				pst.setString(1, objeto.getEmail());
			}
			
			rs = pst.executeQuery();
			while(rs.next()) {
				listaContatos.add(
						new Contato(
								rs.getInt(0),
								rs.getString(1),
								rs.getString(2)
								)
						);
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			fecharBanco();
		}	
		
		return listaContatos;
	}

	@Override
	public String atualizar(Contato objeto) {
		
		String msg = "";
		try {
			abrirBanco();
			String sql = "update contato set telefone=?,email=? where idContato=?";
			pst = conectar.prepareStatement(sql);
			
			pst.setString(1, objeto.getTelefone());
			pst.setString(2, objeto.getEmail());
			pst.setInt(3, objeto.getIdContato());
			
			int r = pst.executeUpdate();
			
			if( r > 0)
				msg = "Contato atualizado com sucesso!";
			else
				msg = "Contato não atualizado.";
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			fecharBanco();
		}
		
		return msg;
	}

	@Override
	public String apagar(int id) {
		String msg = "";
		try {
			abrirBanco();
			String sql = "delete from contato where idcontato=?";
			pst = conectar.prepareStatement(sql);
			pst.setInt(1, id);
			int r = pst.executeUpdate();
			if( r > 0)
				msg = "O contato foi apagado.";
			else
				msg = "Contato não apagado";
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			fecharBanco();
		}
		return msg;
	}

}





























