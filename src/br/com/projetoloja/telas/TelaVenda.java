package br.com.projetoloja.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projetoloja.dao.ProdutoDAO;
import br.com.projetoloja.objeto.Produto;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtPreco;
	private JTextField txtQuantidade;


	/**
	 * Create the frame.
	 */
	public TelaVenda() {
		setTitle("Tela Venda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelecioneOCliente = new JLabel("Selecione o Cliente:");
		lblSelecioneOCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelecioneOCliente.setBounds(25, 12, 174, 15);
		contentPane.add(lblSelecioneOCliente);
		
		JLabel lblSelecioneOVendedor = new JLabel("Selecione o Vendedor:");
		lblSelecioneOVendedor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelecioneOVendedor.setBounds(25, 54, 174, 15);
		contentPane.add(lblSelecioneOVendedor);
		
		JLabel lblSelecioneUmProduto = new JLabel("Selecione um Produto:");
		lblSelecioneUmProduto.setBounds(25, 104, 174, 15);
		contentPane.add(lblSelecioneUmProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidade.setBounds(25, 442, 135, 15);
		contentPane.add(lblQuantidade);
		
		JLabel lblPrecoDoProduto = new JLabel("Preco do Produto:");
		lblPrecoDoProduto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecoDoProduto.setBounds(25, 403, 135, 15);
		contentPane.add(lblPrecoDoProduto);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(334, 403, 98, 15);
		contentPane.add(lblValorTotal);
		
		JComboBox cbxCliente = new JComboBox();
		cbxCliente.setBounds(201, 7, 368, 24);
		contentPane.add(cbxCliente);
		
		JComboBox cbxFuncionario = new JComboBox();
		cbxFuncionario.setBounds(201, 49, 368, 24);
		contentPane.add(cbxFuncionario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 131, 624, 249);
		contentPane.add(scrollPane);
		
		

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
	
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				txtPreco.setText(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
				
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
		
		
		
		scrollPane.setViewportView(table);
	
		txtPreco = new JTextField();
		txtPreco.setBounds(178, 401, 114, 19);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(178, 440, 114, 19);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblTotal = new JLabel("New label");
		lblTotal.setBounds(439, 403, 197, 97);
		contentPane.add(lblTotal);
		
		JButton btnFinalizarVenda = new JButton("Finalizar Venda");
		btnFinalizarVenda.setBounds(178, 515, 310, 25);
		contentPane.add(btnFinalizarVenda);
		setLocationRelativeTo(null);
	}
}
