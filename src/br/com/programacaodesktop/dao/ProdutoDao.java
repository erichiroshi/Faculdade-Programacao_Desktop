package br.com.programacaodesktop.dao;

import javax.swing.DefaultListModel;

import br.com.programacaodesktop.entities.Produto;

public interface ProdutoDao {

	void save(Produto obj);
	DefaultListModel<Produto> list();

}
