package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.connectionFactory.ConnectionFactory;
import br.com.crud.modelo.Produto;

public class ProdutoDao {
	private Connection connection;

	public ProdutoDao() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Produto produto) {
		String scriptSQL = "insert into produto (nome, descricao, valor, quantidade) values(?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(scriptSQL);

			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.setDouble(3, produto.getValor());
			stmt.setInt(4, produto.getQuantidade());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produto> getProdutoTrechoNome(Produto prod) {
		String scriptSQL = "select * from produto where nome like ?";
		try {
			List<Produto> produtos = new ArrayList<Produto>();

			PreparedStatement stmt = this.connection.prepareStatement(scriptSQL);

			stmt.setString(1, prod.getNome());
			stmt.execute();

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));
				produto.setQuantidade(rs.getInt("quantidade"));

				produtos.add(produto);
			}
			rs.close();
			stmt.close();
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produto> getProdutoNomeEspecifico(Produto produto) {
		String scriptSQL = "select * from Produto where nome = ?";
		try {
			List<Produto> produtos = new ArrayList<Produto>();
			PreparedStatement stmt = this.connection.prepareStatement(scriptSQL);
			stmt.setString(1, produto.getNome());
			stmt.execute();

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produtoList = new Produto();
				produtoList.setNome(rs.getString("nome"));
				produtoList.setDescricao(rs.getString("descricao"));
				produtoList.setValor(rs.getDouble("valor"));
				produtoList.setQuantidade(rs.getInt("quantidade"));

				produtos.add(produtoList);
			}

			rs.close();
			stmt.close();
			return produtos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produto> getListaProdutos() throws SQLException {
		String scriptSQL = "select * from produto order by nome";
		PreparedStatement stmt = this.connection.prepareStatement(scriptSQL);
		List<Produto> produtos = new ArrayList<Produto>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Produto produto = new Produto();
			produto.setId(rs.getInt("id"));
			produto.setNome(rs.getString("nome"));
			produto.setDescricao(rs.getString("descricao"));
			produto.setValor(rs.getDouble("valor"));
			produto.setQuantidade(rs.getInt("quantidade"));

			produtos.add(produto);
		}
		rs.close();
		stmt.close();
		return produtos;
	}

	public void removeProduto(Produto produto) throws SQLException {
		String scriptSQL = "delete from produto where id = ?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(scriptSQL);
			stmt.setInt(1, produto.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alteraProduto(Produto produto) throws SQLException{
		String scriptSQL = "update produto set nome = ?, descricao = ?, valor = ?, quantidade = ? where id = ?";
		try{
			PreparedStatement stmt = this.connection.prepareStatement(scriptSQL);
			
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.setDouble(3, produto.getValor());
			stmt.setInt(4, produto.getQuantidade());
			stmt.setInt(5, produto.getId());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException (e);
		}
		
	}
}
