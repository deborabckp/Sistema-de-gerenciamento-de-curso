package entidades;

public class Aluno extends Usuario{
    private String cursoDeGraduacao;
    
    
    public Aluno(long matricula, String nome, String cpf, String telefone, String email, String senha,
            String cursoDeGraduacao) {
        super(matricula, nome, cpf, telefone, email, senha);
        this.cursoDeGraduacao = cursoDeGraduacao;
    }

    public Aluno(long matricula, String nome, String cpf, String senha) {
        super(matricula, nome, cpf, senha);
    }

    public Aluno(){
        
    }

    
    public String getCursoDeGraduacao() {
        return cursoDeGraduacao;
    }


    public void setCursoDeGraduacao(String cursoDeGraduacao) {
        this.cursoDeGraduacao = cursoDeGraduacao;
    }

    
    @Override
    public String toString() {
        return "Aluno [" + super.toString()+", cursoDeGraduacao=" + cursoDeGraduacao + "]";
    }
}