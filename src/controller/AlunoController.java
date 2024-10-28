package controller;

import java.sql.Connection;
import java.util.List;

import dao.AlunoDao;
import entidades.Aluno;

public class AlunoController{
    @SuppressWarnings("unused")
    private Connection con;
    private AlunoDao alunoDao;

    public AlunoController(Connection con){
        this.con = con;
        this.alunoDao =  new AlunoDao(con);
    }

    public void cadastrar(Aluno aluno){
        alunoDao.cadastrar(aluno);    
    }

    public void atualizar(Aluno aluno){
        alunoDao.atualizar(aluno);
    }

    public void remover(Long matricula){
        alunoDao.remover(matricula);
    }

    public Aluno visualizar(Long matricula){
        return alunoDao.visualizar(matricula);
    }

    public List<Aluno> listar(){
        return alunoDao.listar();
    }
}