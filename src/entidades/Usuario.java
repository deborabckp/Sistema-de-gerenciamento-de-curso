package entidades;

public class Usuario{
    private long matricula;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;

    public Usuario(long matricula, String nome, String cpf, String telefone, String email, String senha) {
        validarInstancia(nome, cpf, telefone, email, senha);
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(long matricula, String nome, String cpf, String senha){
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Usuario() {
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean logar(String senha){
        return (this.cpf.equals(cpf) && this.senha.equals(senha));
    }

    public void validarInstancia(String nome, String cpf, String telefone, String email, String senha){
        //Nome
        if(!nome.matches(".*//s.*")){
            throw new IllegalArgumentException("Informe pelo menos um nome e sobrenome");
        //CPF
        }else if(!cpf.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}")){
            throw new IllegalArgumentException("CPF informado está em um formato inválido");
        //Telefone
        }else if(!telefone.matches("([0-9]{2})9[8-9][0-9]{3}-[0-9]{4}")){
            throw new IllegalArgumentException("Telefone informado está em um formato inválido");
        //E-mail
        }else if(!email.matches("(.*@ufersa.edu.br")){
            throw new IllegalArgumentException("E-mail deve pertencer ao domínio ufersa.edu.br");
        //Senha
        }else if(!(senha.length() >= 6)){
            throw new IllegalArgumentException("Campo senha deve ter pelo menos 6 caracteres");
        }
    }

    public void validarInstancia(String nome, String cpf, String senha){
        //Nome
        if(!nome.matches(".*//s.*")){
            throw new IllegalArgumentException("Informe pelo menos um nome e sobrenome");
        //CPF
        }else if(!cpf.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}")){
            throw new IllegalArgumentException("CPF informado está em um formato inválido");
        }else if(!(senha.length() >= 6)){
            throw new IllegalArgumentException("Campo senha deve ter pelo menos 6 caracteres");
        }
    }
    
    @Override
    public String toString() {
        return "matricula=" + matricula + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone
                + ", email=" + email + ", senha=" + senha;
    }
}