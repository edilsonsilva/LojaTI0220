package br.com.projetoloja.objeto;

public class DetalheVenda {
//Atributos da Classe DetalheVenda
	private int idDetalheVenda;
	private Venda venda;
	private Produto produto;
	private int quantidade;
	public DetalheVenda() {
	}
	public DetalheVenda(int idDetalheVenda, Venda venda, Produto produto, int quantidade) {
		this.idDetalheVenda = idDetalheVenda;
		this.venda = venda;
		this.produto = produto;
		this.quantidade = quantidade;
	}
	public int getIdDetalheVenda() {
		return idDetalheVenda;
	}
	public void setIdDetalheVenda(int idDetalheVenda) {
		this.idDetalheVenda = idDetalheVenda;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
