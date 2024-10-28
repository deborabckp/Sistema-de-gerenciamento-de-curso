package prompt;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.CursoController;
import entidades.Curso;

public class MenuCursos {
    public Scanner scan;
    public Connection con;
    public CursoController cursoController;

    public MenuCursos(Scanner scan, Connection con){
        this.scan = scan;
        this.con = con;
        this.cursoController = new CursoController(con);
    }

    
    public void executar(){
        int id;
        Curso curso;
        int opcao;
        System.out.println(cursoController);
        do {
            System.out.println("\n----------CURSOS----------");
            System.out.println("1.CADASTRAR");
            System.out.println("2.LISTAR");
            System.out.println("3.ATUALIZAR");
            System.out.println("4.REMOVER");
            System.out.println("5.DEFINIR PROFESSOR");
            System.out.println("6.SAIR\n");
    
            System.out.println("Digite a opcao: ");  
            opcao = scan.nextInt();
    
            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    System.out.println("LISTA DE CURSOS: ");
                    ExibirListaDeCursos();
                    break;
                case 3:
                    System.out.println("Digite o ID do curso que deseja atualizar: ");
                    id = scan.nextInt();
                    curso = cursoController.visualizar(id);
                    atualizar(curso);
                    break;
                case 4:
                    System.out.println("Digite o ID do curso que deseja remover: ");
                    id = scan.nextInt();
                    cursoController.remover(id);
                    break;
                case 5:
                    definirProfessor();
                    break;
                default:
                    break;
            }
        } while (opcao != 6);
    }

    public void cadastrar(){
        System.out.println("----------CADASTRAR CURSO----------");
        Curso curso =  new Curso();

        System.out.println("1.ID: ");
        int id = scan.nextInt();
        curso.setId(id);

        System.out.println("1.NOME: ");
        scan.nextLine();       
        String nome = scan.nextLine();
        curso.setNome(nome);

        System.out.println("2.DESCRIÇÃO: ");
        String descricao = scan.nextLine();
        curso.setDescricao(descricao);

        System.out.println("4.DATA DE INÍCIO: ");
        String dataDeInicio = scan.nextLine();
        curso.setDataInicio(LocalDate.parse(dataDeInicio));

        System.out.println("5.DATA DE FIM: ");
        String dataDeFim = scan.nextLine();
        curso.setDataFim(LocalDate.parse(dataDeFim));

        System.out.println("6.CARGA HORÁRIA: ");
        int ch = scan.nextInt();
        curso.setCargaHoraria(ch);

        System.out.println("7.VAGAS: ");
        int vagas = scan.nextInt();
        curso.setVagas(vagas);

        System.out.println("8.MODALIDADE: ");
        scan.nextLine();
        String modalidade = scan.nextLine();
        curso.setModalidade(modalidade);

        System.out.println(curso);
        cursoController.cadastrar(curso);
    }

    public void ExibirListaDeCursos(){
        List<Curso> lista = new ArrayList<>();
        lista = cursoController.listar();
        String format = "|%-5s|%-20s|%-30s|%-15s|%-15s|%-5s|%-5s|%-15s|\n";
        System.out.format(format, "ID", "NOME", "DESCRIÇÃO", "DATA DE INÍCIO", "DATA DE FIM", "CH", "VAGAS", "MODALIDADE");
        for(Curso curso: lista){
            System.out.format(format,
                curso.getId(),
                curso.getNome(), 
                curso.getDescricao(),
                curso.getDataInicio(),
                curso.getDataFim(),
                curso.getCargaHoraria(),
                curso.getVagas(),
                curso.getModalidade());
        } 
    }

    public void atualizar(Curso curso){
            int opcao = 0;
            do {
                System.out.println("----------ATUALIZAR CURSOS----------");
                System.out.println("1.NOME");
                System.out.println("2.DESCRIÇÃO");
                System.out.println("4.DATA DE INÍCIO");
                System.out.println("5.DATA DE FIM");
                System.out.println("6.CARGA HORÁRIA");
                System.out.println("7.VAGAS");
                System.out.println("8.MODALIDADE");
                System.out.println("9.ATUALIZAR\n");
                System.out.println("Digite a opção: ");
                opcao = scan.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Atualizar ID: ");
                        int id = scan.nextInt();
                        curso.setId(id);
                        break;
                    case 2:
                        System.out.println("Atualizar NOME: ");
                        scan.nextLine();
                        String nome = scan.nextLine();
                        curso.setNome(nome);
                        break;
                    case 3:
                        System.out.println("Atualizar Descricao: ");
                        scan.nextLine();
                        String descricao = scan.nextLine();
                        curso.setDescricao(descricao);
                        break;
                    case 4:
                        System.out.println("Atualizar DATA DE INÍCIO: ");
                        scan.nextLine();
                        String dataDeInicio = scan.nextLine();
                        curso.setDataInicio(LocalDate.parse(dataDeInicio));
                        break;
                    case 5:
                        System.out.println("Atualizar DATA DE FIM: ");
                        scan.nextLine();
                        String dataDeFim = scan.nextLine();
                        curso.setDataFim(LocalDate.parse(dataDeFim));
                        break;
                    case 6:
                        System.out.println("Atualizar CARGA HORÁRIA: ");
                        int ch = scan.nextInt();
                        curso.setCargaHoraria(ch);
                    case 7:
                        System.out.println("Atualizar VAGAS: ");
                        int vagas = scan.nextInt();
                        curso.setVagas(vagas);
                    case 8:
                        System.out.println("Atualizar MODALIDADE: ");
                        scan.nextLine();
                        String modalidade = scan.nextLine();
                        curso.setModalidade(modalidade);

                    default:
                        break;
                }
                
            } while (opcao != 9);

            cursoController.atualizar(curso);
    }

    public void definirProfessor(){
        System.out.println("\nInforme o ID docurso para o qual deseja definir um professor: ");
        int id = scan.nextInt();
        System.out.println("\nLista de Professores: ");
        new MenuProfessores(scan, con).ExibirListaDeProfessores();
        System.out.println("\nInforme a matricula do professor para o qual deseja atribuir o curso: ");
        Long matricula =  scan.nextLong();
        cursoController.definirProfessor(matricula, id);
    }
}