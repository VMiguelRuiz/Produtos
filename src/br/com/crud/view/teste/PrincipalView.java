package br.com.crud.view.teste;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.crud.controle.Controller;
import br.com.crud.dao.ProdutoDao;

public class PrincipalView {
	public static void main(String[] args) throws SQLException {
		int opcao = 0;
		Controller controle = new Controller();
		ProdutoDao dao = new ProdutoDao();

		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar novo Produto"
					+ "\n2 - Buscar produto por nome especifico" + "\n3 - Buscar produto por trechos do nome"
					+ "\n4 - Listar todos os produtos" +  "\n5 - Alterar produto" + "\n6 - Remover Produto" + "\n9 - Sair"));

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
				
			case 5:
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do produto que será alterado"));
				nome = JOptionPane.showInputDialog("Nome do produto");
				descricao = JOptionPane.showInputDialog("Descricao do produto");
				valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do produto"));
				unidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade em estoque do produto"));
				controle.alteraProduto(id, dao, nome, descricao, valor, unidade);
				break;
				
			case 6:
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do produto que será alterado"));
				controle.removeProduto(id, dao);
				break;
			}

		} while (opcao != 9);
	}
}
