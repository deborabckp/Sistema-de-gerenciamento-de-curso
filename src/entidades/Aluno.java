package entidades;

import enums.SituacaoMatriculaEnum;

public class Aluno extends Usuario{
    private String cursoDeGraduacao;
    private SituacaoMatriculaEnum situacaoMatricula;
    
    
    public Aluno(long matricula, String nome, String cpf, String telefone, String email, String usuario, String senha,
            String cursoDeGraduacao, SituacaoMatriculaEnum situacaoMatricula) {
        super(matricula, nome, cpf, telefone, email, usuario, senha);
        this.cursoDeGraduacao = cursoDeGraduacao;
        this.situacaoMatricula = situacaoMatricula;
    }

    public Aluno(){

    }

    
    public String getCursoDeGraduacao() {
        return cursoDeGraduacao;
    }


    public void setCursoDeGraduacao(String cursoDeGraduacao) {
        this.cursoDeGraduacao = cursoDeGraduacao;
    }


    public SituacaoMatriculaEnum getSituacaoMatricula() {
        return situacaoMatricula;
    }


    public void setSituacaoMatricula(String situacaoMatricula) {
        this.situacaoMatricula = SituacaoMatriculaEnum.valueOf(situacaoMatricula);
    }

    
    @Override
    public String toString() {
        return "Aluno [" + super.toString()+"cursoDeGraduacao=" + cursoDeGraduacao + ", situacaoMatricula=" + situacaoMatricula + "]";
    }
}