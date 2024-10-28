package dto;

import java.time.LocalDate;

public class InscricaoDTO {
    private Long id;
    private Long matricula;
    private String nome;
    private int codigo;
    private String curso;
    private double nota;
    private int frequencia;
    private String status;
    private LocalDate dataDeInscricao;

    public InscricaoDTO() {
        
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataDeInscricao(LocalDate dataDeInscricao) {
        this.dataDeInscricao = dataDeInscricao;
    }

    
    public LocalDate getDataDeInscricao() {
        return dataDeInscricao;
    }

    @Override
    public String toString() {
        return "Inscricao [id=" + id + ", matricula=" + matricula + ", nome=" + nome + ", codigo=" + codigo
                + ", curso=" + curso + ", nota=" + nota + ", frequencia=" + frequencia + ", status=" + status
                + ", dataDeInscricao=" + dataDeInscricao + "]";
    }

    
}
