package entidades;

public class Professor extends Usuario{
    private String formacao;

    public Professor(long matricula, String nome, String cpf, String telefone, String email, String senha,
            String formacao) {
        super(matricula, nome, cpf, telefone, email, senha);
        this.formacao = formacao;
    }

    public Professor(long matricula, String nome, String cpf, String senha) {
        super(matricula, nome, cpf, senha);
    }
    
    public Professor(){

    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "Professor [" + super.toString() + ", formacao=" + formacao + "]";
    }

}