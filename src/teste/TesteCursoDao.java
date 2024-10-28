package teste;

import java.sql.Connection;

import dao.CursoDao;
import entidades.Curso;
import enums.ModalidadeEnum;
import factory.ConnectionFactory;

public class TesteCursoDao {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection con = factory.recuperarConexao()) {
            CursoDao cursoDao = new CursoDao(con);
            
            Curso curso1 = new Curso(100, "Introdução ao Java", "Conceitos iniciais de POO usando java", "2024-06-01", "2024-08-01", 30, 20, ModalidadeEnum.PRESENCIAL);
            Curso curso2 = new Curso(101, "Modelagem de Banco de Dados", "Modelagem conceitual, lógico e físico de um banco de dados", "2024-07-01", "2024-08-01", 15, 30, ModalidadeEnum.SEMIPRESENCIAL);
            Curso curso3 = new Curso(200, "Algoritmos: abordagem prática", "Algoritmos ensinado por meio de desafios", "2024-09-23", "2024-10-15", 10, 15, ModalidadeEnum.REMOTO);
            
            //Método cadastrar
            cursoDao.cadastrar(curso1);
            cursoDao.cadastrar(curso2);
            cursoDao.cadastrar(curso3);

            //Método definirProfessor
            cursoDao.definirProfessor(2015010001L, 100);
            cursoDao.definirProfessor(2015020002L, 100);
            
            //Método listar
            System.out.println("Lista de Cursos:");
            cursoDao.listar().forEach(System.out::println);

            //Método atualizar
            System.out.println("\nCurso antes de atualizar:\n" + curso3);

            curso3.setNome("Algoritmos");
            curso3.setVagas(30);

            cursoDao.atualizar(curso3);
            
            //Método visualizar
            System.out.println("\nCurso após atualização:");
            System.out.println(cursoDao.visualizar(curso3.getId()));
            
            //Método remover
            cursoDao.remover(curso3.getId());
            System.out.println("\nLista de cursos após remoção:");
            cursoDao.listar().forEach(System.out::println);
            
            con.close();           
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}