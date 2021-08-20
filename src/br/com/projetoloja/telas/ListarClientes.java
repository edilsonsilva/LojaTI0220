package br.com.projetoloja.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.projetoloja.dao.ClienteDAO;
import br.com.projetoloja.objeto.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListarClientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtPesquisa;
	private JTable tblClientes;

	
	/**
	 * Create the frame.
	 */
	public ListarClientes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 853, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPesquisarClientesPor = new JLabel("Pesquisar Clientes por Nome ou CPF:");
		lblPesquisarClientesPor.setFont(new Font("Arial", Font.BOLD, 16));
		lblPesquisarClientesPor.setBounds(12, 24, 321, 15);
		contentPane.add(lblPesquisarClientesPor);
		
		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(312, 18, 422, 30);
		contentPane.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(746, 17, 93, 30);
		contentPane.add(btnBuscar);
		
		
		
		String[] tblCabecalho = {"Id do Cliente","Nome do Cliente","CPF","Sexo","Data Cadastro","Id do Contato","Id do Usuário","Id do Endereço"};
		
		
		ClienteDAO clidao = new ClienteDAO();
		DefaultTableModel modelo = new DefaultTableModel(tblCabecalho,0);
		
		Object[] dados = new Object[8];
		
		List<Cliente> lstCli = new ArrayList<Cliente>();
		lstCli = clidao.listar();
		
		for(int i = 0 ; i < lstCli.size();i++) {
			dados[0] = lstCli.get(i).getIdCliente();
			dados[1] = lstCli.get(i).getNomeCliente();
			dados[2] = lstCli.get(i).getCpf();
			dados[3] = lstCli.get(i).getSexo();
			dados[4] = lstCli.get(i).getCadastro();
			dados[5] = lstCli.get(i).getContato().getIdContato();
			dados[6] = lstCli.get(i).getUsuario().getIdUsuario();
			dados[7] = lstCli.get(i).getEndereco().getIdEndereco();
			
			modelo.addRow(dados);
		}
		
		
		JScrollPane scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setBounds(12, 75, 827, 530);
		contentPane.add(scrollPaneClientes);
		
		tblClientes = new JTable(modelo);
		scrollPaneClientes.setViewportView(tblClientes);
		setLocationRelativeTo(null);
	}
}














