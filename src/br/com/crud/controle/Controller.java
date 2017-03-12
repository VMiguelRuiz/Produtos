package br.com.crud.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.crud.dao.ProdutoDao;
import br.com.crud.modelo.Produto;

public class Controller {
	Produto produto = new Produto();

	public void adicionaProduto(String nome, String descricao, double valor, int unidade, ProdutoDao dao)
			throws SQLException {
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setValor(valor);
		produto.setUnidade(unidade);

		dao.adiciona(produto);
	}

	public void buscaEspecifica(String nome, ProdutoDao dao) throws SQLException {

		produto.setNome(nome);

		dao.getProdutoEspecifico(produto);
		if (produto.getDescricao() == null && produto.getValor() == 0 && produto.getUnidade() == 0) {
			this.resetaProduto();
			System.out.println("Produto não encontrado \n");
		} else {
			produto.printProduto(produto);
			this.resetaProduto();
		}
		produto.setNome(null);
	}

	public void buscaProdutos(String nome, ProdutoDao dao) throws SQLException {
		nome = "%"+ nome + "%";
		produto.setNome(nome);
		List<Produto> produtos = dao.getProdutos(produto);
		for (Produto produto : produtos) {
			produto.printProduto(produto);
		}
	}
	
	//Metodo para resetar produto apos acao do metodo de buscaEspecifica
	public void resetaProduto(){
		produto.setNome(null);
		produto.setDescricao(null);
		produto.setValor(0);
		produto.setUnidade(0);
	}
}
