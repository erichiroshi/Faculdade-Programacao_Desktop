package br.com.programacaodesktop.application;

import javax.swing.JOptionPane;

import br.com.programacaodesktop.entities.Produto;

public class Principal {

	public static void main(String[] args) {

		String nome;
		double preco;

		nome = (String) JOptionPane.showInputDialog(null, "Nome do Produto", JOptionPane.QUESTION_MESSAGE);
		preco = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Nome do Produto", JOptionPane.QUESTION_MESSAGE));

		Produto p1 = new Produto(nome, preco);

		JOptionPane.showMessageDialog(null, p1, "Produto cadastrado com sucesso", JOptionPane.INFORMATION_MESSAGE);
	}
}
