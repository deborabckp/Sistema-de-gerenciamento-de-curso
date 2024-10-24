package teste;

import java.sql.Connection;

import dao.ProfessorDao;
import factory.ConnectionFactory;
import entidades.Professor;

public class TesteProfessorDao {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection con = factory.recuperarConexao()) {
            ProfessorDao professorDao = new ProfessorDao(con);
            
            //Método cadastrar
            Professor professor1 = new Professor(2015010001L, "Italo Assis", "000.000.000-11", "(83)99800-0000", "italo@ufersa.edu.br", "italo-assis", "Ciência da Computação");
            Professor professor2 = new Professor(2015020002L, "Mabel Fontes", "000.000.000-22", "(84)99800-2222", "mabel@ufersa.edu.br", "mabelBd", "Ciência da Computação");
            Professor professor3 = new Professor(2016010000L, "Nathalee Cavalcante", "000.000.000-33", "(84)98100-0000", "nathalee@ufersa.edu.br", "nathalee", "Ciência da Computação");
    
            professorDao.cadastrar(professor1);
            professorDao.cadastrar(professor2);
            professorDao.cadastrar(professor3);
            
            //Método listar
            System.out.println("Lista de profesores");
            professorDao.listar().forEach(System.out::println);

            //Método atualizar
            System.out.println("\nProfessor antes de atualizar:\n" + professor2);

            professor2.setNome("Laysa Mabel");
            professor2.setEmail("mabel-fontes@ufersa.edu.br");

            professorDao.atualizar(professor2);
            
            //Método visualizar
            System.out.println("\nProfessor depois de atualizar:");
            System.out.println(professorDao.visualizar(professor2.getMatricula()));
            
            //Método remover
            professorDao.remover(professor3.getMatricula());
            System.out.println("\nLista de professores depois de remover:");
            professorDao.listar().forEach(System.out::println);
            
            con.close();           
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}