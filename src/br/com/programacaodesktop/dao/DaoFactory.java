package br.com.programacaodesktop.dao;

import br.com.programacaodesktop.dao.impl.ProdutoDaoJDBC;
import br.com.programacaodesktop.db.DB;

public class DaoFactory {

	public static ProdutoDao createProdutoDao() {
		return new ProdutoDaoJDBC(DB.getConnection());
	}
}
