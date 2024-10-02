package entidades;

import java.time.LocalDate;

import enums.ModalidadeEnum;

public class Curso {
    private int id;
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int cargaHoraria;
    private int vagas;
    private ModalidadeEnum modalidade;

    
    public Curso(int id, String nome, String descricao, LocalDate dataInicio, LocalDate dataFim, int cargaHoraria,
            int vagas, ModalidadeEnum modalidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.cargaHoraria = cargaHoraria;
        this.vagas = vagas;
        this.modalidade = modalidade;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public ModalidadeEnum getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = ModalidadeEnum.valueOf(modalidade);
    }

    public String toString() {
        return "Curso [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", dataInicio=" + dataInicio
                + ", dataFim=" + dataFim + ", cargaHoraria=" + cargaHoraria + ", vagas=" + vagas + ", modalidade="
                + modalidade + "]";
    }
}