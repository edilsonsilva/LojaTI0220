package br.com.projetoloja.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoloja.objeto.Cliente;
import br.com.projetoloja.objeto.Contato;
import br.com.projetoloja.objeto.Endereco;
import br.com.projetoloja.objeto.Funcionario;
import br.com.projetoloja.objeto.Sexo;
import br.com.projetoloja.objeto.Usuario;

public class FuncionarioDAO extends Conexao implements ICrud<Funcionario> {

	@Override
	public String cadastrar(Funcionario objeto) {
		String msg = "";
		try {
			abrirBanco();
			String sql = "insert into funcionario(nomefuncionario,cpf,sexo,cargo,idusuario,idcontato,idendereco)values(?,?,?,?,?,?,?)";
			//preparação para execução da consulta
			pst = conectar.prepareStatement(sql);
			
			//passagem dos parametros para a execução da consulta. 
			//os parametros irão entrar no lugar dos ponto de interrogação
			pst.setString(1,objeto.getNomeFuncionario());
			pst.setString(2, objeto.getCpf());
			pst.setObject(3,objeto.getSexo());
			pst.setString(4, objeto.getCargo());
			pst.setInt(5, objeto.getUsuario().getIdUsuario());
			pst.setInt(6, objeto.getContato().getIdContato());
			pst.setInt(7, objeto.getEndereco().getIdEndereco());
			
			int r = pst.executeUpdate();
			
			if(r>0)
				msg="Cadastro realizado com sucesso!";
			else
				msg="Não foi possível cadastrar o funcionário";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar cadastrar o funcionário. "+e.getMessage();
		}
		catch (Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
		}
		finally {
			fecharBanco();
		}
		
		return msg;
	}

	@Override
	public List<Funcionario> listar() {
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		try {
			abrirBanco();
			String sql = "Select * from funcionario";
			pst = conectar.prepareStatement(sql);
			rs = pst.executeQuery();
			
			//adicionar os dados dos usuários na lista
			while(rs.next()) {
				listaFuncionario.add(
						new Funcionario(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								Sexo.valueOf(rs.getString(4)),
								rs.getString(5),
								new Usuario(rs.getInt(6),null,null,null),
								new Contato(rs.getInt(7),null,null),
								new Endereco(rs.getInt(8),null,null,null,null,null)
								
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
		
		return listaFuncionario;
	}

	@Override
	public List<Funcionario> pesquisar(Funcionario objeto) {
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		try {
			abrirBanco();
			String sqlId = "Select * from funcionario where idFuncionario = ?";
			
			String sqlNome = "Select * from funcionario where nomefuncionario like ?";
			
			if(objeto.getNomeFuncionario()==null) {
				pst = conectar.prepareStatement(sqlId);
				pst.setInt(1, objeto.getIdFuncionario());
			}
			else{
				pst=conectar.prepareStatement(sqlNome);
				pst.setString(1, objeto.getNomeFuncionario());
			}
				
				rs = pst.executeQuery();
			
			//adicionar os dados dos usuários na lista
			while(rs.next()) {
				listaFuncionario.add(
						new Funcionario(
								rs.getInt(0),
								rs.getString(1),
								rs.getString(2),
								(Sexo) rs.getObject(3),
								rs.getString(4),
								(Usuario) rs.getObject(5),
								(Contato) rs.getObject(6),
								(Endereco) rs.getObject(7)
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
		
		return listaFuncionario;
	}

	@Override
	public String atualizar(Funcionario objeto) {
		String msg = "";
		try {
			abrirBanco();
			String sql = "update funcionario set nomefuncionario=?, cargo=? where idFuncionario = ?";
			//preparação para execução da consulta
			pst = conectar.prepareStatement(sql);
			
			//passagem dos parametros para a execução da consulta. 
			//os parametros irão entrar no lugar dos ponto de interrogação
			pst.setString(1,objeto.getNomeFuncionario());
			pst.setString(2,objeto.getCargo());
			pst.setInt(3, objeto.getIdFuncionario());
			
			int r = pst.executeUpdate();
			
			if(r>0)
				msg="Atualização realizada com sucesso!";
			else
				msg="Não foi possível atualizar o funcionário";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar atualizar o funcionário. "+e.getMessage();
		}
		catch (Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
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
			String sql = "Delete from funcionario where idfuncionario=?";
			pst = conectar.prepareStatement(sql);
			pst.setInt(1, id);
			int r = pst.executeUpdate();
			if(r > 0)
				msg = "Funcionário apagado com sucesso!";
			else
				msg="Não foi possível apagar o funcionário";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar apagar o funcionário. "+e.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado. "+e.getMessage();
		}
		finally {
			fecharBanco();
		}
		
		return msg;
	}

}










