package br.com.projetoloja.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;

import br.com.projetoloja.dao.ContatoDAO;
import br.com.projetoloja.objeto.Contato;
import br.com.projetoloja.objeto.Sexo;
import br.com.projetoloja.objeto.TipoEndereco;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CadastroClienteFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtCPFCliente;
	private JTextField txtNomeFuncionario;
	private JTextField txtCPFFuncionario;
	private JTextField txtCargo;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtCEP;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtNomeUsuario;
	private JPasswordField txtSenha;
	private JPasswordField txtConfirmarSenha;

		/**
	 * Create the frame.
	 */
	public CadastroClienteFuncionario() {
			
		setTitle("Cadastro | Cliente | Funcionário");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 998, 664);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlEscolha = new JPanel();
		pnlEscolha.setBounds(12, 12, 972, 58);
		contentPane.add(pnlEscolha);
		pnlEscolha.setLayout(null);
		
		JLabel lblSelecioneOTipo = new JLabel("Selecione o tipo de cadastro");
		lblSelecioneOTipo.setBounds(407, 12, 203, 15);
		pnlEscolha.add(lblSelecioneOTipo);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setBounds(407, 32, 75, 23);
		pnlEscolha.add(rdbtnCliente);
		
		JRadioButton rdbtnFuncionario = new JRadioButton("Funcionário");	
		rdbtnFuncionario.setBounds(502, 32, 108, 23);
		pnlEscolha.add(rdbtnFuncionario);
		
		JPanel pnlCliente = new JPanel();
		pnlCliente.setBackground(Color.WHITE);
		pnlCliente.setBounds(12, 73, 972, 139);
		contentPane.add(pnlCliente);
		pnlCliente.setLayout(null);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeCompleto.setFont(new Font("Arial", Font.BOLD, 16));
		lblNomeCompleto.setBounds(57, 23, 165, 15);
		pnlCliente.add(lblNomeCompleto);
		
		JLabel lblCpfDoCliente = new JLabel("CPF do Cliente:");
		lblCpfDoCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpfDoCliente.setFont(new Font("Arial", Font.BOLD, 16));
		lblCpfDoCliente.setBounds(57, 61, 165, 15);
		pnlCliente.add(lblCpfDoCliente);
		
		JLabel lblSelecioneOSexo = new JLabel("Selecione o Sexo:");
		lblSelecioneOSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelecioneOSexo.setFont(new Font("Arial", Font.BOLD, 16));
		lblSelecioneOSexo.setBounds(57, 99, 165, 15);
		pnlCliente.add(lblSelecioneOSexo);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(240, 12, 541, 30);
		pnlCliente.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		txtCPFCliente = new JTextField();
		txtCPFCliente.setBounds(240, 54, 383, 30);
		pnlCliente.add(txtCPFCliente);
		txtCPFCliente.setColumns(10);
		
		JComboBox cbxSexoCliente = new JComboBox();
		cbxSexoCliente.setModel(new DefaultComboBoxModel(Sexo.values()));
		cbxSexoCliente.setBounds(240, 96, 183, 30);
		pnlCliente.add(cbxSexoCliente);
		
		JPanel pnlFuncionario = new JPanel();
		pnlFuncionario.setBackground(Color.WHITE);
		pnlFuncionario.setBounds(12, 73, 972, 139);
		contentPane.add(pnlFuncionario);
		pnlFuncionario.setLayout(null);
		
		JLabel lblNomeCompleto_1 = new JLabel("Nome Completo:");
		lblNomeCompleto_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeCompleto_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNomeCompleto_1.setBounds(12, 12, 248, 15);
		pnlFuncionario.add(lblNomeCompleto_1);
		
		JLabel lblCpfDoFuncionrio = new JLabel("CPF do Funcionário:");
		lblCpfDoFuncionrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpfDoFuncionrio.setFont(new Font("Arial", Font.BOLD, 16));
		lblCpfDoFuncionrio.setBounds(12, 42, 248, 15);
		pnlFuncionario.add(lblCpfDoFuncionrio);
		
		JLabel lblSelecioneOSexo_1 = new JLabel("Selecione o Sexo:");
		lblSelecioneOSexo_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelecioneOSexo_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblSelecioneOSexo_1.setBounds(12, 80, 248, 15);
		pnlFuncionario.add(lblSelecioneOSexo_1);
		
		JLabel lblCargoDoFuncionrio = new JLabel("Cargo do Funcionário:");
		lblCargoDoFuncionrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCargoDoFuncionrio.setFont(new Font("Arial", Font.BOLD, 16));
		lblCargoDoFuncionrio.setBounds(12, 107, 248, 15);
		pnlFuncionario.add(lblCargoDoFuncionrio);
		
		txtNomeFuncionario = new JTextField();
		txtNomeFuncionario.setBounds(275, 7, 610, 25);
		pnlFuncionario.add(txtNomeFuncionario);
		txtNomeFuncionario.setColumns(10);
		
		txtCPFFuncionario = new JTextField();
		txtCPFFuncionario.setBounds(275, 39, 373, 25);
		pnlFuncionario.add(txtCPFFuncionario);
		txtCPFFuncionario.setColumns(10);
		
		JComboBox cbxSexoFuncionario = new JComboBox();
		cbxSexoFuncionario.setModel(new DefaultComboBoxModel(Sexo.values()));
		cbxSexoFuncionario.setBounds(275, 71, 229, 25);
		pnlFuncionario.add(cbxSexoFuncionario);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(275, 103, 373, 25);
		pnlFuncionario.add(txtCargo);
		txtCargo.setColumns(10);
		
		JPanel pnlEndereco = new JPanel();
		pnlEndereco.setBackground(Color.WHITE);
		pnlEndereco.setBounds(12, 219, 972, 171);
		contentPane.add(pnlEndereco);
		pnlEndereco.setLayout(null);
		
		JLabel lblSelecioneOTipo_1 = new JLabel("Selecione o Tipo de Endereço:");
		lblSelecioneOTipo_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblSelecioneOTipo_1.setBounds(26, 22, 823, 15);
		pnlEndereco.add(lblSelecioneOTipo_1);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setFont(new Font("Arial", Font.BOLD, 16));
		lblLogradouro.setBounds(271, 22, 578, 15);
		pnlEndereco.add(lblLogradouro);
		
		JLabel lblNmeroDaResidncia = new JLabel("Número da Residência:");
		lblNmeroDaResidncia.setFont(new Font("Arial", Font.BOLD, 16));
		lblNmeroDaResidncia.setBounds(26, 96, 823, 15);
		pnlEndereco.add(lblNmeroDaResidncia);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Arial", Font.BOLD, 16));
		lblComplemento.setBounds(271, 96, 578, 15);
		pnlEndereco.add(lblComplemento);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Arial", Font.BOLD, 16));
		lblCep.setBounds(762, 96, 87, 15);
		pnlEndereco.add(lblCep);
		
		JComboBox cbxTipo = new JComboBox();
		cbxTipo.setModel(new DefaultComboBoxModel(TipoEndereco.values()));
		cbxTipo.setBounds(26, 42, 217, 30);
		pnlEndereco.add(cbxTipo);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(269, 43, 676, 30);
		pnlEndereco.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(26, 116, 217, 30);
		pnlEndereco.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(271, 116, 468, 30);
		pnlEndereco.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		txtCEP = new JTextField();
		txtCEP.setBounds(755, 116, 190, 30);
		pnlEndereco.add(txtCEP);
		txtCEP.setColumns(10);
		
		JPanel pnlContato = new JPanel();
		pnlContato.setBackground(Color.WHITE);
		pnlContato.setBounds(12, 400, 972, 81);
		contentPane.add(pnlContato);
		pnlContato.setLayout(null);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefone.setBounds(25, 33, 156, 15);
		pnlContato.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 16));
		lblEmail.setBounds(351, 33, 108, 15);
		pnlContato.add(lblEmail);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(107, 27, 226, 30);
		pnlContato.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(421, 27, 525, 30);
		pnlContato.add(txtEmail);
		txtEmail.setColumns(10);
		
		JPanel pnlUsuario = new JPanel();
		pnlUsuario.setBackground(Color.WHITE);
		pnlUsuario.setBounds(12, 490, 972, 94);
		contentPane.add(pnlUsuario);
		pnlUsuario.setLayout(null);
		
		JLabel lblNomeDeUsurio = new JLabel("Nome de usuário:");
		lblNomeDeUsurio.setFont(new Font("Arial", Font.BOLD, 16));
		lblNomeDeUsurio.setBounds(12, 22, 152, 15);
		pnlUsuario.add(lblNomeDeUsurio);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 16));
		lblSenha.setBounds(236, 22, 94, 15);
		pnlUsuario.add(lblSenha);
		
		JLabel lblConfirmarASenha = new JLabel("Confirmar  a Senha:");
		lblConfirmarASenha.setFont(new Font("Arial", Font.BOLD, 16));
		lblConfirmarASenha.setBounds(409, 22, 183, 15);
		pnlUsuario.add(lblConfirmarASenha);
		
		JLabel lblFoto = new JLabel("Foto:");
		lblFoto.setFont(new Font("Arial", Font.BOLD, 16));
		lblFoto.setBounds(618, 22, 152, 15);
		pnlUsuario.add(lblFoto);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setBounds(12, 49, 201, 30);
		pnlUsuario.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(234, 49, 160, 30);
		pnlUsuario.add(txtSenha);
		
		txtConfirmarSenha = new JPasswordField();
		txtConfirmarSenha.setBounds(419, 49, 160, 30);
		pnlUsuario.add(txtConfirmarSenha);
		
		JLabel lblFotoUsuario = new JLabel("New label");
		lblFotoUsuario.setIcon(new ImageIcon("/home/xopen/Pictures/andrew-neel-cckf4TsHAuw-unsplash.jpg"));
		lblFotoUsuario.setBounds(814, 12, 94, 67);
		pnlUsuario.add(lblFotoUsuario);
		
		
		
		JFileChooser arquivo = new JFileChooser();
		
		
		JButton btnSelecioneUmaFoto = new JButton("Selecione uma foto");
		btnSelecioneUmaFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arquivo.setCurrentDirectory(new File(System.getProperty("user.home")));
				int r = arquivo.showOpenDialog(null);
				if( r == 0) {
					File selecionado = arquivo.getSelectedFile();
					System.out.println(selecionado.getAbsolutePath());
					lblFotoUsuario.setIcon(new javax.swing.ImageIcon(selecionado.getAbsolutePath()));
				}
				
				
			}
		});
		btnSelecioneUmaFoto.setBounds(609, 49, 170, 25);
		pnlUsuario.add(btnSelecioneUmaFoto);
		
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			if(rdbtnCliente.isSelected()) {
				System.out.println("Cliente selecionado");
				
				//Realizar ao cadastro do contato. Para isso precisamos parssar 
				//Os dados do formulário para a casa de objetos
				Contato ct = new Contato();
				ContatoDAO ctdao = new ContatoDAO();
				
				
				ct.setTelefone(txtTelefone.getText());
				ct.setEmail(txtEmail.getText());
				
				String r = ctdao.cadastrar(ct);
				
				
				JOptionPane.showMessageDialog(null, r);			
				
				
			}
			
			
			
			}
		});
		btnCadastrar.setBounds(420, 596, 117, 25);
		contentPane.add(btnCadastrar);
		
		pnlCliente.setVisible(false);
		pnlFuncionario.setVisible(false);
		
		
		
		rdbtnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnCliente.setSelected(true);
				rdbtnFuncionario.setSelected(false);
				
				pnlCliente.setVisible(true);
				pnlFuncionario.setVisible(false);
				
				
			}
		});
		
		rdbtnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnCliente.setSelected(false);
				rdbtnFuncionario.setSelected(true);
				
				pnlCliente.setVisible(false);
				pnlFuncionario.setVisible(true);
			}
		});
		
		
	}
}
