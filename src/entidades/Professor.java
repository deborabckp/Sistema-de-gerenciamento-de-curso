package entidades;

public class Professor extends Usuario{
    private String formacao;

    public Professor(long matricula, String nome, String cpf, int telefone, String email, String usuario, String senha,
            String formacao) {
        super(matricula, nome, cpf, telefone, email, usuario, senha);
        this.formacao = formacao;
    }

    public String getFormacao() {
        return formacao;
    }


    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "Professor [" + super.toString() + "formacao=" + formacao + "]";
    }

}