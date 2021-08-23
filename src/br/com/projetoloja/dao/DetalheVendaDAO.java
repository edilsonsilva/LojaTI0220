package br.com.projetoloja.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.projetoloja.objeto.DetalheVenda;

public class DetalheVendaDAO extends Conexao implements ICrud<DetalheVenda> {

	@Override
	public String cadastrar(DetalheVenda objeto) {
String msg = "";
		
		try {
			abrirBanco();
			String sql = "insert into detalhevenda(idvenda,idproduto,quantidade)values(?,?,?)";
			pst = conectar.prepareStatement(sql);
			
			pst.setInt(1, objeto.getVenda().getIdVenda());
			pst.setInt(2, objeto.getProduto().getIdProduto());
			pst.setInt(3, objeto.getQuantidade());
			
			
			int r = pst.executeUpdate();
			
			if(r > 0) {
				msg = "Venda registrada com sucesso!";
			}
			else {
				msg = "Não foi possível cadastrar";
			}
		}
		catch(SQLException e) {
			msg = "Erro ao tentar cadastrar "+e.getMessage();
			
		}
		catch(Exception e) {
			msg = "Erro inesperado "+e.getMessage();
		}
		finally {
			fecharBanco();
		}		
		return msg;
	}

	@Override
	public List<DetalheVenda> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalheVenda> pesquisar(DetalheVenda objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String atualizar(DetalheVenda objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String apagar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
