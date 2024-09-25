package entidades;

enum SituacaoMatriculaEnum {
    REGULAR, FORMANDO 
}


public class Aluno extends Usuario{
    private String cursoDeGraduacao;
    private SituacaoMatriculaEnum situacaoMatricula;
    
    
    public Aluno(long matricula, String nome, String cpf, int telefone, String email, String usuario, String senha,
            String cursoDeGraduacao, SituacaoMatriculaEnum situacaoMatricula) {
        super(matricula, nome, cpf, telefone, email, usuario, senha);
        this.cursoDeGraduacao = cursoDeGraduacao;
        this.situacaoMatricula = situacaoMatricula;
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


    public void setSituacaoMatricula(SituacaoMatriculaEnum situacaoMatricula) {
        this.situacaoMatricula = situacaoMatricula;
    }

    
    @Override
    public String toString() {
        return "Aluno [" + super.toString()+"cursoDeGraduacao=" + cursoDeGraduacao + ", situacaoMatricula=" + situacaoMatricula + "]";
    }
}