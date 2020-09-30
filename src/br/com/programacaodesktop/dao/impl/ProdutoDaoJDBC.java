package br.com.programacaodesktop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.programacaodesktop.dao.ProdutoDao;
import br.com.programacaodesktop.db.DB;
import br.com.programacaodesktop.db.DbException;
import br.com.programacaodesktop.entities.Produto;

public class ProdutoDaoJDBC implements ProdutoDao {

	private Connection conn;

	public ProdutoDaoJDBC(Connection connection) {
		this.conn = connection;
	}

	@Override
	public void save(Produto obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO produto "
								+ "(nome, preco) "
								+ "VALUES "
								+ "(?, ?)");
			st.setString(1, obj.getNome());
			st.setDouble(2, obj.getPreco());
			
			st.execute();
			System.out.println("Salvo!");
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
