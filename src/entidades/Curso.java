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
    private Long matriculaProfessor;

    public Curso(int id, String nome, String descricao, String dataInicio, String dataFim, int cargaHoraria,
            int vagas, ModalidadeEnum modalidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = LocalDate.parse(dataInicio);
        this.dataFim = LocalDate.parse(dataFim);
        this.cargaHoraria = cargaHoraria;
        this.vagas = vagas;
        this.modalidade = modalidade;
    }

    public Curso(){
        
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

    public String getModalidade() {
        return modalidade.getValue();
    }

    public void setModalidade(String modalidade) {
        if(modalidade.equalsIgnoreCase("remoto")){
            this.modalidade = ModalidadeEnum.REMOTO;
        }else if(modalidade.equalsIgnoreCase("semi-presencial")){
            this.modalidade = ModalidadeEnum.SEMIPRESENCIAL;
        }else{
            this.modalidade = ModalidadeEnum.PRESENCIAL;
        }     
    }

    public Long getMatriculaProfessor() {
        return matriculaProfessor;
    }
    
    public void setMatriculaProfessor(Long matriculaProfessor) {
        this.matriculaProfessor = matriculaProfessor;
    }

    @Override
    public String toString() {
        return "Curso [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", dataInicio=" + dataInicio
                + ", dataFim=" + dataFim + ", cargaHoraria=" + cargaHoraria + ", vagas=" + vagas + ", modalidade="
                + modalidade + ", matriculaProfessor="+matriculaProfessor+"]";
    }
}