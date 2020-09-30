package br.com.programacaodesktop.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaListagem extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JPanel panel_botoes;

	private JButton bt_novo;
	private JButton bt_deletar;
	private JButton bt_sair;

	private JLabel label_title;

	public TelaListagem() {
		this.initialize();
		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}

	public void initialize() {
		bt_novo = new JButton("Novo");
		bt_deletar = new JButton("Apagar");
		bt_sair = new JButton("Sair");

		label_title = new JLabel("Listagem de Funcionários");

		panel = new JPanel();
		panel_botoes = new JPanel();

		panel.setLayout(new BorderLayout(5, 5));
		this.setBounds(250, 110, 600, 300);
		this.setPreferredSize(new Dimension(600, 300));

		panel.add(label_title, BorderLayout.PAGE_START);

		panel_botoes.setLayout(new GridLayout(6, 1, 10, 10));

		bt_sair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});

		bt_novo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCadastro();
			}
		});

		panel_botoes.add(bt_novo);
		panel_botoes.add(bt_deletar);
		panel_botoes.add(bt_sair);
		panel.add(panel_botoes, BorderLayout.LINE_END);
		this.add(panel);
		this.pack();
		this.setTitle("Cadastro de Produtos");

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
