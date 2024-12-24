package br.com.dao.jdbc;

import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection;

    private ConnectionFactory(Connection connection) {

    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = initConnection();
        } else if (connection.isClosed()) {
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/Teste",
                    "postgres",
                    "$SENHA"
            );} catch (SQLException e) {
            // Se for uma SQLException geral (não PSQLException)
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}