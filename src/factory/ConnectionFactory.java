package factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
    public DataSource dataSource;
   
    public ConnectionFactory(){
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl("jdbc:postgresql://localhost:5433/postgres");
        cpds.setUser("postgres");
        cpds.setPassword("demeter");

        this.dataSource = cpds;
    }

    public Connection recuperarConexao(){
        try{
            return this.dataSource.getConnection();
        } catch(SQLException e){
            System.err.println("Erro ao tentar estabelecer conexão com o banco de dados");
            throw new RuntimeException(e);
        }
    }
}