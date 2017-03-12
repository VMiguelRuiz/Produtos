package br.com.crud.modelo;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private double valor;
	private int unidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	public void printProduto(Produto produto){
		
		System.out.println("Nome: " + produto.nome);
		System.out.println("Descricao: " + produto.descricao);
		System.out.println("Valor " + produto.valor);
		System.out.println("Unidade " + produto.unidade +"\n");
	}
}
