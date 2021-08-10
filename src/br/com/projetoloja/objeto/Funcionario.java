package br.com.projetoloja.objeto;

public class Funcionario {
//Atributos da classe Funcionario
	private int idFuncionario;
	private String nomeFuncionario;
	private String cpf;
	private Sexo sexo;
	private String cargo;
	private Usuario usuario;
	private Contato contato;
	private Endereco endereco;
	
	
	public Funcionario() {}


	public Funcionario(int idFuncionario, String nomeFuncionario, String cpf, Sexo sexo, String cargo, Usuario usuario,
			Contato contato, Endereco endereco) {
		this.idFuncionario = idFuncionario;
		this.nomeFuncionario = nomeFuncionario;
		this.cpf = cpf;
		this.sexo = sexo;
		this.cargo = cargo;
		this.usuario = usuario;
		this.contato = contato;
		this.endereco = endereco;
	}


	public int getIdFuncionario() {
		return idFuncionario;
	}


	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}


	public String getNomeFuncionario() {
		return nomeFuncionario;
	}


	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Sexo getSexo() {
		return sexo;
	}


	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Contato getContato() {
		return contato;
	}


	public void setContato(Contato contato) {
		this.contato = contato;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
	
	
	
}
