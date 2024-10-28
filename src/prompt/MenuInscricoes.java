package prompt;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.InscricaoController;
import dto.InscricaoDTO;
import entidades.Usuario;
import enums.StatusInscricaoEnum;

public class MenuInscricoes {
    public Scanner scan;
    public Connection con;
    public InscricaoController inscricaoController; 
    public int opcao;
    public Usuario usuario;

    public MenuInscricoes(Scanner scan, Connection con, Usuario usuario){
        this.scan = scan;
        this.con = con;
        this.usuario = usuario;
        this.inscricaoController = new InscricaoController(con);
    }

    public void executar() {
        do {
            MenuOpcoes();
        } while (opcao != 7);
    }

    public void MenuOpcoes(){
        do {
            System.out.println("----------INSCRICOES----------");
            System.out.println("1.REALIZAR INSCRIÇÕES");
            System.out.println("2.LISTAR");
            System.out.println("3.ATUALIZAR STATUS");
            System.out.println("4.CADASTRAR NOTA");
            System.out.println("5.CADASTRAR FREQUÊNCIA");
            System.out.println("6.REMOVER");
            System.out.println("7.SAIR\n");
            System.out.println("Digite uma opção: ");
            opcao = scan.nextInt();
            
            switch (opcao) {
                case 1:
                    inscrever();
                    break;
                case 2:
                    exibirListaDeinscricoes();
                    break;
                case 3:
                    atualizar();
                    break;
                case 4:
                    System.out.println("\nDigite o id da inscrição para o qual deseja cadastrar um nota: ");
                    Long id1 = scan.nextLong();
                    System.out.println("\nDigite a nota: ");
                    double nota = scan.nextDouble();
                    inscricaoController.cadastrarNota(nota, id1);
                    break;
                case 5:
                    System.out.println("\nDigite o id da inscrição para o qual deseja cadastrar frequencia: ");
                    Long id2 = scan.nextLong();
                    System.out.println("\nDigite a frequencia: ");
                    int frequencia = scan.nextInt();
                    inscricaoController.cadastrarFrequencia(frequencia, id2);
                    break;
                case 6:
                    System.out.println("\nDigite o id da inscrição a ser removida: ");
                    Long id3 = scan.nextLong();
                    inscricaoController.remover(id3);
                default:
                    break;
            }
        } while (opcao != 7);
    }

    public void exibirListaDeinscricoes(){
        List<InscricaoDTO> lista = new ArrayList<>();
        lista = inscricaoController.listar();
        lista.forEach(System.out::println);
    }

    public void atualizar(){
        System.out.println("\nDigite o id da inscrição que deseja atualizar o status:");
        Long id = scan.nextLong();
        System.out.println("\nDigite o novo status da inscrição: ");
        System.out.println("1.DEFERIDA\n2.INDEFERIDA\n3.EM PROCESSAMENTO");
        int statusId = scan.nextInt();
        StatusInscricaoEnum status;
        if(statusId == 1){
            status = StatusInscricaoEnum.DEFERIDA;
        }else if(statusId == 2){
            status = StatusInscricaoEnum.INDEFERIDA;
        }else{
            status = StatusInscricaoEnum.EMPROCESSAMENTO;
        }
        inscricaoController.atualizarStatus(id, status);
    }

    public void inscrever(){
        System.out.println("Informe um id para inscrição: ");
        long id = scan.nextInt();
        System.out.println("Lista de cursos: ");
        new MenuCursos(scan, con).ExibirListaDeCursos();
        System.out.println("Informe o id do curso que deseja se inscrever: ");
        int curso = scan.nextInt();
        try { 
            inscricaoController.realizarInscricao(id, usuario.getMatricula(), curso);
        } catch (Exception e) {
            System.out.println("Não foi possível realizar inscrição");
            e.printStackTrace();
        }
    }
}
