package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "Demeter";

    public Connection getConnection(){
        try(Connection conn = DriverManager.getConnection(jdbcUrl, user, password)){
            return conn;
        } catch(SQLException e){
            System.err.println("Erro ao tentar estabelecer conexão com o banco de dados");
            throw new RuntimeException(e);
        }
    }
}