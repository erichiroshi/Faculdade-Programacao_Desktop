package br.com.programacaodesktop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

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
		}
	}

	@Override
	public DefaultListModel<Produto> list() {
		DefaultListModel<Produto> model = new DefaultListModel<>();

		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("SELECT * FROM produto ");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				model.addElement(new Produto(rs.getString("nome"), rs.getDouble("preco")));
			}
			return model;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

}
