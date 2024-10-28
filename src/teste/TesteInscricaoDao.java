package teste;

import java.sql.Connection;

import dao.InscricaoDao;
import entidades.Inscricao;
import enums.StatusInscricaoEnum;
import factory.ConnectionFactory;

public class TesteInscricaoDao {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection con = factory.recuperarConexao()) {
            InscricaoDao inscricaoDao = new InscricaoDao(con);
            
            //Testando método realizarMatricula definirProfessor e listar              
            inscricaoDao.realizarInscricao(1L, 2017010001, 100);
            inscricaoDao.realizarInscricao(2L, 2017010001, 101);
            inscricaoDao.realizarInscricao(3L, 2017010002, 100);
            inscricaoDao.realizarInscricao(4L, 2017010002, 200);
            inscricaoDao.realizarInscricao(5L, 2017010003, 100);
            
            System.out.println("Lista de inscrições:");
            inscricaoDao.listar().forEach(System.out::println);

            //Testando métodos atualizar, cadastrarNota, cadastrarFrquencia e visualizar
            Inscricao inscricao = inscricaoDao.visualizar(2L);
            System.out.println("\nInscricao antes de atualizar:\n" + inscricao);

            inscricaoDao.atualizarStatus(inscricao.getId(), StatusInscricaoEnum.DEFERIDA);
            Inscricao inscricaoAtualizado = inscricaoDao.visualizar(inscricao.getId());
            System.out.println("\nInscrição depois de atualizar:\n" + inscricaoAtualizado);
            
            //Testando método remover
            System.out.println("\nLista de inscricoes antes de remover:\n");
            inscricaoDao.listar().forEach(System.out::println);

            System.out.println("\nLista de inscricoes depois de remover:");
            inscricaoDao.remover(3L);
            inscricaoDao.listar().forEach(System.out::println);

            con.close();           
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}