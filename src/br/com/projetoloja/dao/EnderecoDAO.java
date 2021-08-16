package br.com.projetoloja.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoloja.objeto.Endereco;
import br.com.projetoloja.objeto.TipoEndereco;

public class EnderecoDAO extends Conexao implements ICrud<Endereco>{

	@Override
	public String cadastrar(Endereco objeto) {
		String msg = "";
		try {
			abrirBanco();
			String sql = "insert into endereco(tipo,logradouro,numero,complemento,cep)values(?,?,?,?,?)";
			//preparação para execução da consulta
			pst = conectar.prepareStatement(sql);
			
			//passagem dos parametros para a execução da consulta. 
			//os parametros irão entrar no lugar dos ponto de interrogação
			pst.setObject(1,objeto.getTipo());
			pst.setString(2, objeto.getLogradouro());
			pst.setString(3,objeto.getNumero());
			pst.setString(4, objeto.getComplemento());
			pst.setString(5, objeto.getCep());
			
			int r = pst.executeUpdate();
			
			if(r>0)
				msg="Cadastro realizado com sucesso!";
			else
				msg="Não foi possível cadastrar o endereço";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar cadastrar o endereço. "+e.getMessage();
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
	public List<Endereco> listar() {
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		try {
			abrirBanco();
			String sql = "Select * from endereco";
			pst = conectar.prepareStatement(sql);
			rs = pst.executeQuery();
			
			//adicionar os dados dos usuários na lista
			while(rs.next()) {
				listaEndereco.add(
						new Endereco(
								rs.getInt(0),
								(TipoEndereco) rs.getObject(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5)
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
		
		return listaEndereco;
	}

	@Override
	public List<Endereco> pesquisar(Endereco objeto) {
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		try {
			abrirBanco();
			String sqlId = "Select * from endereco where idendereco=?";
			String sqlLog = "Select * from endereco where logradouro like ?";
			
			if(objeto.getLogradouro()==null) {
				pst = conectar.prepareStatement(sqlId);
				pst.setInt(1, objeto.getIdEndereco());
			}
			else {
				pst = conectar.prepareStatement(sqlLog);
				pst.setString(1,objeto.getLogradouro());
			}			
				
			rs = pst.executeQuery();
			
			//adicionar os dados dos usuários na lista
			while(rs.next()) {
				listaEndereco.add(
						new Endereco(
								rs.getInt(0),
								(TipoEndereco) rs.getObject(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5)
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
		
		return listaEndereco;
	}

	@Override
	public String atualizar(Endereco objeto) {
		String msg = "";
		try {
			abrirBanco();
			String sql = "update endereco set tipo=?,logradouro=?,numero=?,complemento=?,cep=? where idEndereco=?";
			//preparação para execução da consulta
			pst = conectar.prepareStatement(sql);
			
			//passagem dos parametros para a execução da consulta. 
			//os parametros irão entrar no lugar dos ponto de interrogação
			pst.setObject(1,objeto.getTipo());
			pst.setString(2, objeto.getLogradouro());
			pst.setString(3,objeto.getNumero());
			pst.setString(4, objeto.getComplemento());
			pst.setString(5, objeto.getCep());
			pst.setInt(6, objeto.getIdEndereco());
			
			int r = pst.executeUpdate();
			
			if(r>0)
				msg="Atualização realizada com sucesso!";
			else
				msg="Não foi possível atualizar o endereço";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar atualizar o endereço. "+e.getMessage();
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
			String sql = "Delete from endereco where idEndereco=?";
			pst = conectar.prepareStatement(sql);
			pst.setInt(1, id);
			int r = pst.executeUpdate();
			if(r > 0)
				msg = "Endereço apagado com sucesso!";
			else
				msg="Não foi possível apagar o endereço";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar apagar o endereço. "+e.getMessage();
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









