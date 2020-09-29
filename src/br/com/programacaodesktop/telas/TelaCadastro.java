package br.com.programacaodesktop.telas;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCadastro extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	
	private JLabel label_nome;
	private JLabel label_preco;
	private JLabel label_categoria;
	
	private JTextField text_nome;
	private JTextField text_preco;
	private JTextField text_categoria;
	
	private JButton bt_ok;
	private JButton bt_cancela;
	
	public TelaCadastro() {
		this.initialize();
		this.setExtendedState(NORMAL);
	}
	
	public void initialize() {
		
		panel = new JPanel();
		
		GridLayout gl = new GridLayout(4, 2, 10, 10);
		panel.setLayout(gl);
		
		this.setBounds(250, 110, 400, 200);
		
		label_nome = new JLabel("NOME: ");
		label_preco = new JLabel("PRECO: ");
		label_categoria = new JLabel("CATEGORIA: ");
		
		text_nome = new JTextField();
		text_preco = new JTextField();
		text_categoria = new JTextField();
		
		bt_ok = new JButton("CADASTRAR");
		bt_cancela = new JButton("CANCELAR");
		
		panel.add(label_nome);
		panel.add(text_nome);
		panel.add(label_preco);
		panel.add(text_preco);
		panel.add(label_categoria);
		panel.add(text_categoria);
		panel.add(bt_ok);
		panel.add(bt_cancela);
		
		this.add(panel);
		this.setPreferredSize(new Dimension(400, 200));
		this.setTitle("Cadastro de Produto");
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
