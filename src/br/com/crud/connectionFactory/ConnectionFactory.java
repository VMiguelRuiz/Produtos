package br.com.crud.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection()throws SQLException{
		try{
			//"jdbc:mysql://localhost/Geral", "root", "senha"
			return DriverManager.getConnection("jdbc:mysql://localhost/Geral", "root", "1234");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
