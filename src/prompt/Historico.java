package prompt;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.InscricaoController;
import dto.InscricaoDTO;
import entidades.Usuario;

public class Historico {
    public Scanner scan;
    public Connection con;
    public Usuario usuario;
    public InscricaoController inscricaoController;

    public Historico(Scanner scan, Connection con, Usuario usuario){
        this.scan = scan;
        this.con = con;
        this.usuario = usuario;
        this.inscricaoController = new InscricaoController(con);
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println("----------HISTORICO----------");
            exibirHistorico(usuario);
            opcao = 2;
        } while (opcao != 2);
    }

    public void exibirHistorico(Usuario usuario){
        List<InscricaoDTO> historico = new ArrayList<>();
        historico = inscricaoController.visualizarHistoricoAluno(usuario.getMatricula());
        
        String format = "|%-5s|%-30s|%-5s|%-7s|%-12s|\n";
        System.out.format(format, "ID", "CURSO", "NOTA", "FREQUENCIA");
        for(InscricaoDTO inscricao: historico){
            System.out.format(format,
                inscricao.getCodigo(),
                inscricao.getCurso(),
                inscricao.getNota(),
                inscricao.getFrequencia());
        }     
    }
}
