package br.com.projetoloja.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.projetoloja.objeto.Venda;

public class VendaDAO extends Conexao implements ICrud<Venda>{

	@Override
	public String cadastrar(Venda objeto) {
		String msg = "";
		
		try {
			abrirBanco();
			String sql = "insert into venda(idcliente,idfuncionario)values(?,?)";
			pst = conectar.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			pst.setInt(1, objeto.getCliente().getIdCliente());
			pst.setInt(2, objeto.getFuncionario().getIdFuncionario());
			
			int r = pst.executeUpdate();
			
			rs = pst.getGeneratedKeys();
			
			if(r > 0) {
				if(rs.next())
					msg = String.valueOf(rs.getInt(1));
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
	public List<Venda> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venda> pesquisar(Venda objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String atualizar(Venda objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String apagar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
