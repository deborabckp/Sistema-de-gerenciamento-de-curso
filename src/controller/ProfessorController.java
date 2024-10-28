package controller;

import java.sql.Connection;
import java.util.List;

import dao.ProfessorDao;
import entidades.Professor;

public class ProfessorController {
    @SuppressWarnings("unused")
    private Connection con;
    private ProfessorDao professorDao;

    public ProfessorController(Connection con){
        this.con = con;
        this.professorDao =  new ProfessorDao(con);
    }

    public void cadastrar(Professor professor){
        professorDao.cadastrar(professor);
    }

    public void atualizar(Professor professor){
        professorDao.atualizar(professor);
    }

    public void remover(Long matricula){
        professorDao.remover(matricula);
    }

    public Professor visualizar(Long matricula){
        return professorDao.visualizar(matricula);
    }

    public List<Professor> listar(){
        return professorDao.listar();
    }
}
