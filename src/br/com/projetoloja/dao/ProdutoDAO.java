package br.com.projetoloja.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoloja.objeto.Cliente;
import br.com.projetoloja.objeto.Contato;
import br.com.projetoloja.objeto.Endereco;
import br.com.projetoloja.objeto.Produto;
import br.com.projetoloja.objeto.Sexo;
import br.com.projetoloja.objeto.Usuario;

public class ProdutoDAO extends Conexao implements ICrud<Produto> {

	@Override
	public String cadastrar(Produto objeto) {
		String msg = "";
		try {
			abrirBanco();
			String sql = "insert into produto(nomeproduto,descricao,preco,foto)values(?,?,?,?)";
			//preparação para execução da consulta
			pst = conectar.prepareStatement(sql);
			
			//passagem dos parametros para a execução da consulta. 
			//os parametros irão entrar no lugar dos ponto de interrogação
			pst.setString(1,objeto.getNomeProduto());
			pst.setString(2, objeto.getDescricao());
			pst.setDouble(3,objeto.getPreco());
			pst.setString(4, objeto.getFoto());
			
			int r = pst.executeUpdate();
			
			if(r>0)
				msg="Cadastro realizado com sucesso!";
			else
				msg="Não foi possível cadastrar o produto";			
		}
		catch(SQLException e) {
			msg = "Erro ao tentar cadastrar o produto. "+e.getMessage();
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
	public List<Produto> listar() {
		List<Produto> listaProduto = new ArrayList<Produto>();
		try {
			abrirBanco();
			String sql = "Select * from produto";
			pst = conectar.prepareStatement(sql);
			rs = pst.executeQuery();
			
			//adicionar os dados dos usuários na lista
			while(rs.next()) {
				listaProduto.add(
						new Produto(
								rs.getInt(0),
								rs.getString(1),
								rs.getString(2),
								rs.getDouble(3),
								rs.getString(4)
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
		
		return listaProduto;
	}

	@Override
	public List<Produto> pesquisar(Produto objeto) {
		List<Produto> listaProduto = new ArrayList<Produto>();
		try {
			abrirBanco();
			String sqlId = "Select * from produto where idProduto = ?";
			
			String sqlNome = "Select * from produto where nomeproduto like ?";
			
			if(objeto.getNomeProduto()==null) {
				pst = conectar.prepareStatement(sqlId);
				pst.setInt(1, objeto.getIdProduto());
			}
			else{
				pst=conectar.prepareStatement(sqlNome);
				pst.setString(1, objeto.getNomeProduto());
			}
			rs = pst.executeQuery();
			
			//adicionar os dados dos usuários na lista
			while(rs.next()) {
				listaProduto.add(
						new Produto(
								rs.getInt(0),
								rs.getString(1),
								rs.getString(2),
								rs.getDouble(3),
								rs.getString(4)
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
		
		return listaProduto;
	}

	@Override
	public String atualizar(Produto objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String apagar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
