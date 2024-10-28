package prompt;

import java.sql.Connection;
import java.util.Scanner;

import entidades.Usuario;

public class Menu {
    public Scanner scan;
    public Connection con;
    public Usuario usuario;

    public Menu(Scanner scan, Connection con, Usuario usuario){
        this.scan = scan;
        this.con = con;
        this.usuario = usuario;
    }
    
    public void executar() {
        int opcao = 0;
        do {
            System.out.println("\n----------MENU----------");
            System.out.println("1.MEUS DADOS");
            System.out.println("2.CURSOS");
            System.out.println("3.PROFESSORES");
            System.out.println("4.INSCRIÇÕES");
            System.out.println("5.ALUNOS INCRITOS");
            System.out.println("6.HISTÓRICO");
            System.out.println("7.SAIR\n");

            System.out.println("Digite a opção ");
            opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    new MeusDados(scan, con, usuario).executar();
                    break;
                case 2:
                    new MenuCursos(scan, con).executar();
                    break;
                case 3:
                    new MenuProfessores(scan, con).executar();
                    break;
                case 4:
                    new MenuInscricoes(scan, con, usuario).executar();
                    break;
                case 5:
                    break;
                case 6:
                    new Historico(scan, con, usuario).executar();
                    break;
                default:
                    break;
            }

        } while (opcao != 7);
    }
    
}