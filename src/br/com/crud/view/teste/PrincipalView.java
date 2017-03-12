package br.com.crud.view.teste;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.crud.controle.Controller;
import br.com.crud.dao.ProdutoDao;
import br.com.crud.modelo.Produto;

public class PrincipalView {
	public static void main(String[] args) throws SQLException {
		int opcao = 0;
		Controller controle = new Controller();
		ProdutoDao dao = new ProdutoDao();
		Produto produto = new Produto();
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar novo Produto"
					+ "\n2 - Buscar produto por nome especifico" + "\n3 - Buscar produto por trechos do nome"));

			switch (opcao) {

			case 1:

				String nome = JOptionPane.showInputDialog("Nome do produto");

				String descricao = JOptionPane.showInputDialog("Descricao do produto");

				double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do produto"));

				int unidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade em estoque do produto"));

				controle.adicionaProduto(nome, descricao, valor, unidade, dao);

				break;

			case 2:
				String buscaNome = JOptionPane.showInputDialog("Digite o nome");
				controle.getProdutoNomeEspecifico(buscaNome, dao);
				break;

			case 3:
				String buscaPorNome = JOptionPane.showInputDialog("Digite o nome");

				controle.getProdutoTrechoNome(buscaPorNome, dao);
				break;
			case 4:
				controle.getListaProdutos(dao);
				break;
			}

		} while (opcao != 9);
	}
}
