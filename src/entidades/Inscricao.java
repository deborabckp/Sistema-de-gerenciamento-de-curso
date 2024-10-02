package entidades;

import java.time.LocalDate;

enum Status {
    APROVADO, CANCELADO
}

public class Inscricao {
    private long id;
    private LocalDate dataDeInscricao;
    private double nota;
    private int frequencia;
    private Status status;

    public Inscricao(long id, LocalDate dataDeInscricao, double nota, int frequencia, Status status) {
        this.id = id;
        this.dataDeInscricao = dataDeInscricao;
        this.nota = nota;
        this.frequencia = frequencia;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Inscricao [id=" + id + ", dataDeInscricao=" + dataDeInscricao + ", nota=" + nota + ", frequencia="
                + frequencia + ", status=" + status + "]";
    }
    
}
