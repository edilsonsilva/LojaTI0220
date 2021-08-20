package br.com.projetoloja.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoloja.objeto.Cliente;
import br.com.projetoloja.objeto.Sexo;
import br.com.projetoloja.objeto.Usuario;
import br.com.projetoloja.objeto.Contato;
import br.com.projetoloja.objeto.Endereco;


public class ClienteDAO extends Conexao implements ICrud<Cliente> {

	@Override
	public String cadastrar(Cliente objeto) {
		String msg = "";
		try {
			abrirBanco();
			String sql = "insert into cliente(nomecliente,cpf,sexo,idusuario,idcontato,idendereco)values(?,?,?,?,?,?)";
			//preparação para execução da consulta
			pst = conectar.prepareStatement(sql);
			
			//passagem dos parametros para a execução da consulta. 
			//os parametros irão entrar no lugar dos ponto de interrogação
			pst.setString(1,objeto.getNomeCliente());
			pst.setString(2, objeto.getCpf());
			
			pst.setString(3,objeto.getSexo().toString());
			
			pst.setInt(4, objeto.getUsuario().getIdUsuario());
			pst.setInt(5, objeto.getContato().getIdContato());
			pst.setInt(6, objeto.getEndereco().getIdEndereco());
			
			int r = pst.executeUpdate();
			
			if(r>0)
				msg="Cadastro realizado com sucesso!";
			else
				msg="Não foi possível cadastrar o cliente";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar cadastrar o cliente. "+e.getMessage();
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
	public List<Cliente> listar() {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		try {
			abrirBanco();
			String sql = "Select * from cliente";
			pst = conectar.prepareStatement(sql);
			rs = pst.executeQuery();
			
			//adicionar os dados dos usuários na lista
			while(rs.next()) {
				listaCliente.add(
						new Cliente(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								Sexo.valueOf(rs.getString(4)),
								rs.getDate(5),
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
		
		return listaCliente;
	}

	@Override
	public List<Cliente> pesquisar(Cliente objeto) {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		try {
			abrirBanco();
			String sqlId = "Select * from cliente where idCliente = ?";
			
			String sqlNome = "Select * from cliente where nomecliente like ?";
			
			if(objeto.getNomeCliente()==null) {
				pst = conectar.prepareStatement(sqlId);
				pst.setInt(1, objeto.getIdCliente());
			}
			else{
				pst=conectar.prepareStatement(sqlNome);
				pst.setString(1, objeto.getNomeCliente());
			}
				
				rs = pst.executeQuery();
			
			//adicionar os dados dos usuários na lista
			while(rs.next()) {
				listaCliente.add(
						new Cliente(
								rs.getInt(0),
								rs.getString(1),
								rs.getString(2),
								(Sexo) rs.getObject(3),
								rs.getDate(4),
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
		
		return listaCliente;
	}

	@Override
	public String atualizar(Cliente objeto) {
		String msg = "";
		try {
			abrirBanco();
			String sql = "update cliente set nomecliente=? where idCliente = ?";
			//preparação para execução da consulta
			pst = conectar.prepareStatement(sql);
			
			//passagem dos parametros para a execução da consulta. 
			//os parametros irão entrar no lugar dos ponto de interrogação
			pst.setString(1,objeto.getNomeCliente());
			pst.setInt(2, objeto.getIdCliente());
			
			int r = pst.executeUpdate();
			
			if(r>0)
				msg="Atualização realizada com sucesso!";
			else
				msg="Não foi possível atualizar o cliente";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar atualizar o cliente. "+e.getMessage();
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
			String sql = "Delete from cliente where idCliente=?";
			pst = conectar.prepareStatement(sql);
			pst.setInt(1, id);
			int r = pst.executeUpdate();
			if(r > 0)
				msg = "Cliente apagado com sucesso!";
			else
				msg="Não foi possível apagar o cliente";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar apagar o cliente. "+e.getMessage();
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

















