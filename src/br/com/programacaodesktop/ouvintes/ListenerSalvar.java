package br.com.programacaodesktop.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.programacaodesktop.dao.DaoFactory;
import br.com.programacaodesktop.dao.ProdutoDao;
import br.com.programacaodesktop.entities.Produto;

public class ListenerSalvar implements ActionListener {

	private JTextField nome;
	private JTextField preco;

	private JDialog tela;

	public ListenerSalvar(JTextField nome, JTextField preco) {
		this.nome = nome;
		this.preco = preco;
		this.tela = null;
	}

	public ListenerSalvar(JTextField nome, JTextField preco, JDialog tela) {
		this.nome = nome;
		this.preco = preco;
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = "Nome: " + nome.getText() + "\nPreço: " + preco.getText();
		Produto p = new Produto(nome.getText(), Double.parseDouble(preco.getText()));
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		produtoDao.save(p);
		JOptionPane.showMessageDialog(this.tela, msg);
		this.tela.dispose();
	}

}
