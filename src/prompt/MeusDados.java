package prompt;

import java.sql.Connection;
import java.util.Scanner;

import entidades.Usuario;


public class MeusDados {
    public Scanner scan;
    public Connection con;
    Usuario usuario;

    public MeusDados(Scanner scan, Connection con, Usuario usuario){
        this.scan = scan;
        this.con = con;
        this.usuario = usuario;
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println("----------MEUS DADOS----------");
            exibirMeusDados(usuario);
            opcao = 2;
        } while (opcao != 2);
    }

    public void exibirMeusDados(Usuario usuario){
            System.out.println("MATRICULA: " + usuario.getMatricula());
            System.out.println("NOME: " + usuario.getNome());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("TELEFONE: " + usuario.getTelefone());
            System.out.println("E-MAIL: " + usuario.getEmail());
    }
}
