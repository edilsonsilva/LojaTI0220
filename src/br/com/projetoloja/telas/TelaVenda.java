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

import br.com.projetoloja.dao.ClienteDAO;
import br.com.projetoloja.dao.DetalheVendaDAO;
import br.com.projetoloja.dao.FuncionarioDAO;
import br.com.projetoloja.dao.ProdutoDAO;
import br.com.projetoloja.dao.VendaDAO;
import br.com.projetoloja.objeto.Cliente;
import br.com.projetoloja.objeto.DetalheVenda;
import br.com.projetoloja.objeto.Produto;
import br.com.projetoloja.objeto.Venda;
import br.com.projetoloja.objeto.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtPreco;
	private JTextField txtQuantidade;
	private int idCliente = 0, idFuncionario = 0, idvenda=0,idproduto=0;

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
		
		
		ClienteDAO cdao = new ClienteDAO();
		FuncionarioDAO fdao = new FuncionarioDAO();
		
		
		
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
		cbxCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				idCliente = cbxCliente.getSelectedIndex()+1;
				
				
			}
		});
		cbxCliente.setBounds(201, 7, 368, 24);
		contentPane.add(cbxCliente);
		
		
		for( int i = 0 ; i < cdao.listar().size() ; i++) {		
			cbxCliente.addItem(cdao.listar().get(i).getNomeCliente());	
		}
		
		
		JComboBox cbxFuncionario = new JComboBox();
		cbxFuncionario.setBounds(201, 49, 368, 24);
		contentPane.add(cbxFuncionario);
		
		cbxFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				idFuncionario = cbxFuncionario.getSelectedIndex()+1;
				
				
			}
		});
		
		for(int i =0 ; i < fdao.listar().size(); i++)
			cbxFuncionario.addItem(fdao.listar().get(i).getNomeFuncionario());
		
		
		
		JLabel lblTotal = new JLabel("New label");
		lblTotal.setForeground(new Color(139, 0, 0));
		lblTotal.setFont(new Font("Arial", Font.BOLD, 26));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setBounds(439, 403, 197, 97);
		contentPane.add(lblTotal);
		
		
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
				
				txtQuantidade.setText("1");
				txtPreco.setText(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
				
				Double valor = Double.parseDouble(txtQuantidade.getText())*Double.parseDouble(txtPreco.getText()); 
				
				lblTotal.setText("R$ "+valor.toString());
				
				
				idproduto = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
				
				
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
		txtPreco.setEditable(false);
		txtPreco.setBounds(178, 401, 114, 19);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		txtQuantidade = new JTextField();
		
		txtQuantidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				
				if(txtQuantidade.getText()==null || txtQuantidade.getText()=="" || txtQuantidade.getText().isEmpty()) {

					return;
				}
				else {
					Double valor = Double.parseDouble(txtPreco.getText())*Double.parseDouble(txtQuantidade.getText());
					lblTotal.setText(valor.toString());
					
				}
				
				
			}
		});
		txtQuantidade.setBounds(178, 440, 114, 19);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		
		
		JButton btnFinalizarVenda = new JButton("Finalizar Venda");
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Venda v = new Venda();
				v.setCliente(new Cliente(idCliente,null,null,null,null,null,null,null));
				v.setFuncionario(new Funcionario(idFuncionario,null,null,null,null,null,null,null));
				
				VendaDAO vdao = new VendaDAO();
				idvenda = Integer.parseInt(vdao.cadastrar(v));
				
				DetalheVenda dv = new DetalheVenda();
				v.setIdVenda(idvenda);
				
				dv.setVenda(v);
				
				Produto p = new Produto();
				p.setIdProduto(idproduto);
				
				dv.setProduto(p);
				
				dv.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
				
				DetalheVendaDAO dtdao = new DetalheVendaDAO();
				
				
				JOptionPane.showMessageDialog(null, dtdao.cadastrar(dv));
				
			}
		});
		btnFinalizarVenda.setBounds(178, 515, 310, 25);
		contentPane.add(btnFinalizarVenda);
		setLocationRelativeTo(null);
	}
}




















