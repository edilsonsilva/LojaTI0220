package br.com.projetoloja.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoloja.objeto.Usuario;

public class UsuarioDAO extends Conexao implements ICrud<Usuario>{

	@Override
	public String cadastrar(Usuario objeto) {
		
		String msg = "";
		try {
			abrirBanco();
			String sql = "insert into usuario(nomeusuario,senha,foto)values(?,?,?)";
			//preparação para execução da consulta
			pst = conectar.prepareStatement(sql);
			
			//passagem dos parametros para a execução da consulta. 
			//os parametros irão entrar no lugar dos ponto de interrogação
			pst.setString(1,objeto.getNomeUsuario());
			pst.setString(2, objeto.getSenha());
			pst.setString(3,objeto.getFoto());
			
			int r = pst.executeUpdate();
			
			if(r>0)
				msg="Cadastro realizado com sucesso!";
			else
				msg="Não foi possível cadastrar o usuário";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar cadastrar o usuário. "+e.getMessage();
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
	public List<Usuario> listar() {
		
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			abrirBanco();
			String sql = "Select * from usuario";
			pst = conectar.prepareStatement(sql);
			rs = pst.executeQuery();
			
			//adicionar os dados dos usuários na lista
			while(rs.next()) {
				listaUsuario.add(
						new Usuario(
								rs.getInt(0),
								rs.getString(1),
								rs.getString(2),
								rs.getString(3)
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
		
		return listaUsuario;
	}

	@Override
	public List<Usuario> pesquisar(Usuario objeto) {

		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			abrirBanco();
			String sqlId = "Select * from usuario where idUsuario=?";
			String sqlUsuario = "Select * from usuario where nomeusuario=?";
			
			if(objeto.getNomeUsuario()==null) {
				pst = conectar.prepareStatement(sqlId);
				pst.setInt(1, objeto.getIdUsuario());
			}
			else {
				pst = conectar.prepareStatement(sqlUsuario);
				pst.setString(1, objeto.getNomeUsuario());
			}
			rs = pst.executeQuery();
			//adicionar os dados dos usuários na lista
			while(rs.next()) {
				listaUsuario.add(
						new Usuario(
								rs.getInt(0),
								rs.getString(1),
								rs.getString(2),
								rs.getString(3)
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
		
		return listaUsuario;

	}

	@Override
	public String atualizar(Usuario objeto) {
		String msg = "";
		try {
			abrirBanco();
			String sql = "update usuario set nomeusuario=?,senha=?,foto=? where idUsuario=?";
			//preparação para execução da consulta
			pst = conectar.prepareStatement(sql);
			
			//passagem dos parametros para a execução da consulta. 
			//os parametros irão entrar no lugar dos ponto de interrogação
			pst.setString(1,objeto.getNomeUsuario());
			pst.setString(2, objeto.getSenha());
			pst.setString(3,objeto.getFoto());
			pst.setInt(4, objeto.getIdUsuario());
			
			int r = pst.executeUpdate();
			
			if(r>0)
				msg="Atualização realizada com sucesso!";
			else
				msg="Não foi possível atualizar o usuário";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar atualizar o usuário. "+e.getMessage();
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
			String sql = "Delete from usuario where idUsuario=?";
			pst = conectar.prepareStatement(sql);
			pst.setInt(1, id);
			int r = pst.executeUpdate();
			if(r > 0)
				msg = "Usuário apagado com sucesso!";
			else
				msg="Não foi possível apagar o usuário";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar apagar o usuário. "+e.getMessage();
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








