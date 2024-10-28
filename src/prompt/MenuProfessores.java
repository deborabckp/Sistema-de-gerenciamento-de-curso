package prompt;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.ProfessorController;
import entidades.Professor;

public class MenuProfessores {
    public Scanner scan;
    public Connection con;
    public ProfessorController professorController; 
    public MenuProfessores(Scanner scan, Connection con){
        this.scan = scan;
        this.con = con;
        this.professorController = new ProfessorController(con);
    }

    public void executar() {
        do {
            MenuOpcoes();
        } while (true);
    }

    public void ExibirListaDeProfessores(){
        List<Professor> lista = new ArrayList<>();
        lista = professorController.listar();
        String format = "|%-10s|%-20s|%-14s|%-14s|%-15s|%-20s|\n";
        System.out.format(format, "MATRÍCULA", "NOME", "CPF", "TELEFONE", "E-MAIL", "FORMAÇÃO");
        for(Professor professor: lista){
            System.out.format(format,
                professor.getMatricula(),
                professor.getNome(), 
                professor.getCpf(),
                professor.getTelefone(),
                professor.getEmail(),
                professor.getFormacao());
        } 
    }
    public void MenuOpcoes(){
        int opcao = 0;
        Long matricula;
        Professor professor;
        do {
            System.out.println("\n----------PROFESSORES----------");
            System.out.println("1.LISTAR");
            System.out.println("2.ATUALIZAR");
            System.out.println("3.REMOVER");
            System.out.println("4.SAIR\n");
            System.out.println("Digite a opcao: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nLISTA DE PROFESSORES: ");
                    ExibirListaDeProfessores();
                    break;
                case 2:
                    System.out.println("\nDigite a matricula do professor que deseja atualizar: ");
                    matricula = scan.nextLong();
                    professor = professorController.visualizar(matricula);
                    atualizar(professor);
                    break;
                case 3:
                    System.out.println("\nDigite a matricula do professor que deseja remover: ");
                    matricula = scan.nextLong();
                    try {
                        professorController.remover(matricula);
                    } catch (Exception e) {
                        System.out.println("\nFalha ao remover professor!");
                    }
                    break;
                default:
                    break;
            }
        } while (opcao != 4);
    }

    public void atualizar(Professor professor){
            int opcao = 0;
            do {
                System.out.println("1. NOME");
                System.out.println("2. CPF");
                System.out.println("3. TELEFONE");
                System.out.println("4. E-MAIL");
                System.out.println("5. FORMAÇÃO");
                System.out.println("6. ATUALIZAR");
                System.out.println("7. ATUALIZAR");
                System.out.println("\nDigite a opção: ");
                opcao = scan.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Atualizar NOME: ");
                        scan.nextLine();
                        String nome = scan.nextLine();
                        professor.setNome(nome);
                        break;
                    case 2:
                        System.out.println("Atualizar CPF: ");
                        scan.nextLine();
                        String cpf = scan.nextLine();
                        professor.setCpf(cpf);
                        break;
                    case 3:
                        System.out.println("Atualizar TELEFONE: ");
                        scan.nextLine();
                        String telefone = scan.nextLine();
                        professor.setTelefone(telefone);
                        break;
                    case 4:
                        System.out.println("Atualizar E-MAIL: ");
                        scan.nextLine();
                        String email = scan.nextLine();
                        professor.setEmail(email);
                        break;
                    case 5:
                        System.out.println("Atualizar FORMAÇÃO: ");
                        scan.nextLine();
                        String formacao = scan.nextLine();
                        professor.setFormacao(formacao);
                        break;
                    case 6:
                        professorController.atualizar(professor);
                        break;
                    default:
                        break;
                }
                
            } while (opcao != 7);

    }
}
