package br.com.programacaodesktop.telas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.programacaodesktop.ouvintes.ListenerSalvar;

public class TelaCadastro extends JDialog {
	private static final long serialVersionUID = 1L;

	private JPanel panel;

	private JLabel label_nome;
	private JLabel label_preco;

	private JTextField text_nome;
	private JTextField text_preco;

	private JButton bt_ok;
	private JButton bt_cancela;

	public TelaCadastro() {
		this.initialize();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	public void initialize() {

		panel = new JPanel();

		GridLayout gl = new GridLayout(4, 2, 10, 10);
		panel.setLayout(gl);

		this.setBounds(250, 110, 400, 200);

		label_nome = new JLabel("NOME: ");
		label_preco = new JLabel("PRECO: ");

		text_nome = new JTextField();
		text_preco = new JTextField();

		bt_ok = new JButton("CADASTRAR");
		bt_cancela = new JButton("CANCELAR");

		bt_ok.addActionListener(new ListenerSalvar(text_nome, text_preco, this));

		bt_cancela.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});

		panel.add(label_nome);
		panel.add(text_nome);
		panel.add(label_preco);
		panel.add(text_preco);
		panel.add(bt_ok);
		panel.add(bt_cancela);

		this.add(panel);
		this.setPreferredSize(new Dimension(400, 200));
		this.setTitle("Cadastro de Produto");
		this.pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
