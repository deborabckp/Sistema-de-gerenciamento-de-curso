package entidades;

public class Aluno extends Usuario {
    public Aluno(int matricula) {
        super(matricula);
        System.out.println("Aluno criado com matrícula: " + matricula);
    }

    public void atualizarAluno(int novaMatricula) {
        setId(novaMatricula);
        System.out.println("Aluno atualizado. Nova matrícula: " + novaMatricula);
    }

    public void lerAluno() {
        System.out.println("Dados do Aluno: Matrícula = " + getId());
    }

    public void deletarAluno() {
        System.out.println("Aluno com matrícula " + getId() + " deletado.");
    }
}
