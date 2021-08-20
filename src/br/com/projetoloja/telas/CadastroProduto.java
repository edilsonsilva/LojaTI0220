package br.com.projetoloja.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.projetoloja.dao.ProdutoDAO;
import br.com.projetoloja.objeto.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class CadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeProduto;
	private JTextField txtPreco;
	private String caminhoFoto = null;//Guarda o caminho da foto
	

	/**
	 * Create the frame.
	 */
	public CadastroProduto() {
		setTitle("Cadastro de Produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do Produto:");
		lblNomeDoProduto.setBounds(12, 42, 145, 15);
		contentPane.add(lblNomeDoProduto);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setBounds(12, 96, 145, 15);
		contentPane.add(lblDescrio);
		
		JLabel lblPreo = new JLabel("Preço:");
		lblPreo.setBounds(12, 186, 145, 15);
		contentPane.add(lblPreo);
		
		JLabel lblFoto = new JLabel("Foto:");
		lblFoto.setBounds(357, 12, 145, 15);
		contentPane.add(lblFoto);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setBounds(12, 60, 317, 19);
		contentPane.add(txtNomeProduto);
		txtNomeProduto.setColumns(10);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(12, 202, 114, 19);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblFotoProduto = new JLabel("");
		lblFotoProduto.setIcon(new ImageIcon("/home/xopen/Pictures/brigitte-tohm-EAay7Aj4jbc-unsplash.jpg"));
		lblFotoProduto.setBounds(367, 42, 229, 203);
		contentPane.add(lblFotoProduto);
		
		JFileChooser arquivo = new JFileChooser();
		
		JButton btnSelecionarFoto = new JButton("Selecionar Foto");
		btnSelecionarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arquivo.setCurrentDirectory(new File(System.getProperty("user.home")));
				int r = arquivo.showOpenDialog(null);
				if(r == 0) {
					File selecionado = arquivo.getSelectedFile();
					
					ImageIcon img = new ImageIcon(selecionado.getAbsolutePath());
					
					lblFotoProduto.setIcon(new ImageIcon(img.getImage().getScaledInstance(lblFotoProduto.getWidth(), lblFotoProduto.getHeight(), Image.SCALE_SMOOTH)));					
					caminhoFoto = selecionado.getAbsolutePath();
				}
				
				
			}
		});
		btnSelecionarFoto.setBounds(412, 7, 184, 25);
		contentPane.add(btnSelecionarFoto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 114, 317, 68);
		contentPane.add(scrollPane);
		
		JTextArea txtDescricao = new JTextArea();
		scrollPane.setViewportView(txtDescricao);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produto pr = new Produto();
				pr.setNomeProduto(txtNomeProduto.getText());
				pr.setDescricao(txtDescricao.getText());
				pr.setPreco(Double.parseDouble(txtPreco.getText()));
				pr.setFoto(caminhoFoto);
				
				ProdutoDAO prdao = new ProdutoDAO();
				String r = prdao.cadastrar(pr);
				JOptionPane.showMessageDialog(null, r);
			}
		});
		btnCadastrar.setBounds(207, 199, 117, 25);
		contentPane.add(btnCadastrar);
		setLocationRelativeTo(null);
	}
}






