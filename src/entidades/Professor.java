package entidades;

public class Professor {
    private String departamento;
    private String especialidade;

    public Professor(String departamento, String especialidade) {
        this.departamento = departamento;
        this.especialidade = especialidade;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Professor [departamento=" + departamento + ", especialidade=" + especialidade + "]";
    }   
}
