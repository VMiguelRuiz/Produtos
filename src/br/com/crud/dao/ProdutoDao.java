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
		String scriptSQL = "insert into produto (nome, descricao, valor, unidade) values(?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(scriptSQL);

			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.setDouble(3, produto.getValor());
			stmt.setInt(4, produto.getUnidade());

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
				produto.setUnidade(rs.getInt("unidade"));

				produtos.add(produto);
			}
			rs.close();
			stmt.close();
			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Produto getProdutoNomeEspecifico(Produto produto) {
		String scriptSQL = "select * from Produto where nome = ?";
		try {
			
			PreparedStatement stmt = this.connection.prepareStatement(scriptSQL);
			stmt.setString(1, produto.getNome());
			stmt.execute();
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {	
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));
				produto.setUnidade(rs.getInt("unidade"));

			}
			
			rs.close();
			stmt.close();
			return produto;
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Produto> getListaProdutos() throws SQLException{
		String scriptSQL = "select * from produto";
		PreparedStatement stmt = this.connection.prepareStatement(scriptSQL);
		List<Produto> produtos = new ArrayList<Produto>();
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			Produto produto = new Produto();
			produto.setId(rs.getInt("id"));
			produto.setNome(rs.getString("nome"));
			produto.setDescricao(rs.getString("descricao"));
			produto.setValor(rs.getDouble("valor"));
			produto.setUnidade(rs.getInt("unidade"));
			
			produtos.add(produto);
		}
		rs.close();
		stmt.close();
		return produtos;
	}
}
