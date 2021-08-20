package br.com.projetoloja.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.ls.LSProgressEvent;

import br.com.projetoloja.dao.ProdutoDAO;
import br.com.projetoloja.objeto.Produto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListarProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField txtPesquisa;
	private JTable table;

	

	/**
	 * Create the frame.
	 */
	public ListarProdutos() {
		setTitle("Listar Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 698, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPesquisarProdutoPor = new JLabel("Pesquisar produto por nome:");
		lblPesquisarProdutoPor.setBounds(12, 12, 334, 15);
		contentPane.add(lblPesquisarProdutoPor);
		
		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(12, 33, 566, 29);
		contentPane.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JButton btnBucar = new JButton("Bucar");
		btnBucar.setBounds(587, 35, 97, 25);
		contentPane.add(btnBucar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 70, 430, 265);
		contentPane.add(scrollPane);
		
		JLabel lblFotoProduto = new JLabel("");
		lblFotoProduto.setBounds(460, 98, 224, 237);
		contentPane.add(lblFotoProduto);
		
		
		String[] colunas = {"Id do Produto","Nome do Produto","Descrição","Preço","Foto"};
		
		ProdutoDAO prDAO = new ProdutoDAO();
		List<Produto> lstproduto = new ArrayList<Produto>();
		
		lstproduto = prDAO.listar();
		
		DefaultTableModel modelo = new DefaultTableModel(colunas,0);
		
		Object[] dados = new Object[5];
		for(int i = 0 ; i < lstproduto.size() ; i++) {
			
			dados[0] = lstproduto.get(i).getIdProduto();
			dados[1] = lstproduto.get(i).getNomeProduto();
			dados[2] = lstproduto.get(i).getDescricao();
			dados[3] = lstproduto.get(i).getPreco();
			dados[4] = lstproduto.get(i).getFoto();
			
			modelo.addRow(dados);			
		}
		
		
		
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				System.out.println(table.getModel().getValueAt(table.getSelectedRow(), 4));
				
				ImageIcon img = new ImageIcon(table.getModel().getValueAt(table.getSelectedRow(), 4).toString());
				
				lblFotoProduto.setIcon(new ImageIcon(img.getImage().getScaledInstance(lblFotoProduto.getWidth(), lblFotoProduto.getHeight(),Image.SCALE_SMOOTH)));
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		JLabel lblProdutoSelecionado = new JLabel("Produto Selecionado");
		lblProdutoSelecionado.setBounds(460, 74, 224, 15);
		contentPane.add(lblProdutoSelecionado);
		
		
		setLocationRelativeTo(null);
	}
}
