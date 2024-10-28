import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import entidades.Usuario;
import factory.ConnectionFactory;
import prompt.Login;
import prompt.Menu;

public class App {
    public static Scanner scan = new Scanner(System.in);
    public static ConnectionFactory factory = new ConnectionFactory();
    public static Connection con = factory.recuperarConexao();
    public static void main(String[] args) {
        Login login = new Login(scan, con);
        login.executar();
        Usuario usuario = login.getUsuarioLogado();
        Menu menu = new Menu(scan, con, usuario);
        if(usuario != null){
            menu.executar();
        }

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
