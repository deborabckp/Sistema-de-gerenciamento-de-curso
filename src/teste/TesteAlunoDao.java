package teste;

import java.sql.Connection;

import dao.AlunoDao;
import factory.ConnectionFactory;
import entidades.Aluno;

public class TesteAlunoDao{
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection con = factory.recuperarConexao()) {
            AlunoDao alunoDao = new AlunoDao(con);
            
            //Testando método cadastrar e listar
            Aluno aluno1 = new Aluno(2017010000L, "Luiz Aires", "000.000.000-00", "(84)99600-0000", "luiz@ufersa.edu.br", "123456", "Engenharia de Computação");
            Aluno aluno2 = new Aluno(2017010001L, "Midhia Queiroz", "111.111.111-11", "(84)99611-1111", "midhia@ufersa.edu.br", "midhia", "Interdisciplinar em Tecnologia da Informação");
            Aluno aluno3 = new Aluno(2017010002L, "Debora Fonseca", "222.222.222-22", "(84)99622-2222", "debora@ufersa.edu.br", "654321", "Interdisciplinar em Tecnologia da Informação");
    
            alunoDao.cadastrar(aluno1);
            alunoDao.cadastrar(aluno2);
            alunoDao.cadastrar(aluno3);
            
            System.out.println("Lista de alunos cadastrados:");
            alunoDao.listar().forEach(System.out::println);

            //Testando métodos atualizar e visualizar
            System.out.println("\nAluno antes de atualizar:\n" + aluno1);

            aluno1.setCursoDeGraduacao("Ciência e Tecnologia");
            aluno1.setNome("Luiz Aires Silva");

            alunoDao.atualizar(aluno1);
            Aluno alunoAtualizado = alunoDao.visualizar(aluno1.getMatricula());
            System.out.println("\nAluno depois de atualizar:\n" + alunoAtualizado);
            
            //Testando método remover
            System.out.println("\nLista de alunos antes de remover:\n");
            alunoDao.listar().forEach(System.out::println);

            System.out.println("\nLista de alunos depois de remover:");
            alunoDao.remover(aluno2.getMatricula());
            alunoDao.listar().forEach(System.out::println);

            con.close();           
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}