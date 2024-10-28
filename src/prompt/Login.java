package prompt;

import java.sql.Connection;
import java.util.Scanner;

import controller.AlunoController;
import controller.ProfessorController;
import entidades.Aluno;
import entidades.Professor;
import entidades.Usuario;

public class Login {
    private Usuario usuarioLogado;
    public Scanner scan;
    public Connection con;
    public AlunoController alunoController;
    public ProfessorController professorController;
    public int opcaoLogin;

    public Login(Scanner scan, Connection con){
        this.scan = scan;
        this.con = con;
        this.alunoController= new AlunoController(con);
        this.professorController = new ProfessorController(con);
    }

    public void executar() { 
        do {
            System.out.println("----------LOGIN----------");
            System.out.println("1. Aluno");
            System.out.println("2. Professor");
            System.out.println("3. SAIR");
            System.out.println("Digite a opção de login: ");
            opcaoLogin = scan.nextInt();

            if(opcaoLogin == 1 || opcaoLogin == 2){
                System.out.println("\n----------LOGIN----------");
                System.out.println("1. ENTRAR");
                System.out.println("2. PRIMEIRO ACESSO");
                int primeiroAcesso = scan.nextInt();
                if(primeiroAcesso == 1){
                    efetuarLogin(opcaoLogin); 
                }else{
                    cadastrarUsuário(opcaoLogin);   
                }
            }else{
                System.out.println("Digite uma opção válida!");
            }
        } while (opcaoLogin != 3);

    }
    private void cadastrarUsuário(int opcaoUsuario){
        System.out.println("----------CADASTRO DE USUÁRIO----------");
        System.out.println("MATRÍCULA: ");
        Long matricula = scan.nextLong();
        System.out.println("CPF: ");
        String cpf = scan.next();
        System.out.println("NOME: ");
        scan.nextLine();
        String nome = scan.nextLine();
        System.out.println("SENHA: ");
        String senha = scan.next();
        if(opcaoUsuario == 1){
            Aluno aluno = new Aluno(matricula, nome, cpf, senha);
            alunoController.cadastrar(aluno);
        }else if(opcaoUsuario == 2){
            Professor professor = new Professor(matricula, nome, cpf, senha);
            professorController.cadastrar(professor);
        }
    }

    private void efetuarLogin(int opcaoUsuario){
        System.out.println("\n----------LOGIN----------");
        System.out.println("Digite a Matrícula: ");
        Long matricula = scan.nextLong();
        System.out.println("Digite a senha: ");
        String senha = scan.next();
        switch (opcaoUsuario) {
            case 1:
                try {
                    Aluno aluno = alunoController.visualizar(matricula);
                    if(aluno.logar(senha)){
                        System.out.println("Usuário Logado com sucesso");
                        this.usuarioLogado = aluno;
                        opcaoLogin = 3;
                    }          
                    
                } catch (Exception e) {
                    System.out.println("Falha ao logar");
                }
                break;
            case 2:
                try {
                    Professor professor = professorController.visualizar(matricula);
                    if(professor.logar(senha)){
                        this.usuarioLogado = professor;
                        System.out.println("Usuário Logado com sucesso");
                    }              
                } catch (Exception e) {
                    System.out.println("Falha ao logar");
                }
                break;
            default:
                break;
        }

    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    
}


