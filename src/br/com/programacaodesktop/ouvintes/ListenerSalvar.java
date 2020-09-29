package br.com.programacaodesktop.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ListenerSalvar implements ActionListener {

	private JTextField nome;
	private JTextField preco;
	private JTextField categoria;
	
	
	public ListenerSalvar(JTextField nome, JTextField preco, JTextField categoria) {
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = "Nome: " + nome.getText() + "\nPreço: " + preco.getText() + "\nCategoria: " + categoria.getText();
		JOptionPane.showMessageDialog(null, msg);

	}

}
