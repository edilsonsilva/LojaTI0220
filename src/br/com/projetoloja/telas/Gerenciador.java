package br.com.projetoloja.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Gerenciador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gerenciador frame = new Gerenciador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gerenciador() {
		setExtendedState(this.MAXIMIZED_BOTH);
		setTitle("Gerenciador Loja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(tela.width);
		
		
		
		JMenuBar jmbGerenciar = new JMenuBar();
		jmbGerenciar.setBounds(0, 0,tela.width, 21);
		contentPane.add(jmbGerenciar);
		
		JMenu mnuAcao = new JMenu("Ação");
		jmbGerenciar.add(mnuAcao);
		
		JMenuItem mnuItemCadastro = new JMenuItem("Cadastro");
		mnuItemCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new CadastroClienteFuncionario().setVisible(true);
				
			}
		});
		mnuAcao.add(mnuItemCadastro);
		
		JMenuItem mnuItemCadastroProduto = new JMenuItem("Cadastro Produto");
		mnuItemCadastroProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new CadastroProduto().setVisible(true);
				
			}
		});
		mnuAcao.add(mnuItemCadastroProduto);
		
		JMenuItem mnuItemCadastroVenda = new JMenuItem("Cadastro Venda");
		mnuItemCadastroVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TelaVenda().setVisible(true);
				
			}
		});
		mnuAcao.add(mnuItemCadastroVenda);
		
		JMenu mnuVisualizar = new JMenu("Visualizar");
		jmbGerenciar.add(mnuVisualizar);
		
		JMenuItem mnuItemListarClientes = new JMenuItem("Listar Clientes");
		mnuItemListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ListarClientes().setVisible(true);
				
			}
		});
		mnuVisualizar.add(mnuItemListarClientes);
		
		JMenuItem mnuItemListarProdutos = new JMenuItem("Listar Produtos");
		mnuItemListarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListarProdutos().setVisible(true);
			}
		});
		mnuVisualizar.add(mnuItemListarProdutos);
	}
}








