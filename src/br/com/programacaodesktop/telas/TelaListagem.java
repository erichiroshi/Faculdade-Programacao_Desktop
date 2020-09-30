package br.com.programacaodesktop.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import br.com.programacaodesktop.dao.DaoFactory;
import br.com.programacaodesktop.dao.ProdutoDao;
import br.com.programacaodesktop.db.DB;
import br.com.programacaodesktop.entities.Produto;

public class TelaListagem extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JPanel panel_botoes;

	private JButton bt_novo;
	private JButton bt_deletar;
	private JButton bt_sair;

	private JLabel label_title;

	private JList<Produto> lista;
	private JScrollPane scroll_lista;
	private ProdutoDao produtoDao;

	public TelaListagem() {
		this.produtoDao = DaoFactory.createProdutoDao();
		this.initialize();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	// inicialização
	public void initialize() {

		// botões
		bt_novo = new JButton("Novo");
		bt_deletar = new JButton("Apagar");
		bt_sair = new JButton("Sair");

		// título
		label_title = new JLabel("Listagem de Produtos");

		// painés
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
				DB.closeConnection();
				System.exit(0);
			}
		});

		bt_novo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCadastro();
			}
		});

		// configuracao da listagem
		// configura o painel
		lista = new JList<>();
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		lista.setLayoutOrientation(JList.VERTICAL);
		lista.setModel(produtoDao.list());
		lista.setVisibleRowCount(-1);
		scroll_lista = new JScrollPane(lista);
		panel.add(scroll_lista, BorderLayout.CENTER);
		panel.add(label_title, BorderLayout.PAGE_START);
		// adicao de elementos

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
