package entidades;

import java.time.LocalDate;

import enums.StatusInscricaoEnum;

public class Inscricao {
    private long id;
    private LocalDate dataDeInscricao;
    private double nota;
    private int frequencia;
    private StatusInscricaoEnum status;
    private Long matriculaAluno;
    private int idCurso;

    public Inscricao(long id, LocalDate dataDeInscricao, StatusInscricaoEnum status) {
        this.id = id;
        this.dataDeInscricao = dataDeInscricao;
        this.status = status;
    }

    public Inscricao(){
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataDeInscricao() {
        return dataDeInscricao;
    }

    public void setDataDeInscricao(LocalDate dataDeInscricao) {
        this.dataDeInscricao = dataDeInscricao;
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
        return status.getValue();
    }

    public void setStatus(String status) {

        if(status.equalsIgnoreCase("Deferida")){
            this.status = StatusInscricaoEnum.DEFERIDA;
        }else if(status.equalsIgnoreCase("Indeferida")){
            this.status = StatusInscricaoEnum.INDEFERIDA;
        }else {
            this.status = StatusInscricaoEnum.EMPROCESSAMENTO;
        }
    }
    
    public Long getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(Long matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }
    
    public int getIdCurso() {
        return idCurso;
    }
    
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public String toString() {
        return "Inscricao [id=" + id + ", dataDeInscricao=" + dataDeInscricao + ", nota=" + nota + ", frequencia="
                + frequencia + ", status=" + status + ", matriculaAluno=" + matriculaAluno + ", idCurso=" + idCurso
                + "]";
    }
}
