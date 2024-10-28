package controller;

import java.sql.Connection;
import java.util.List;
import dao.CursoDao;
import entidades.Curso;

public class CursoController {
    @SuppressWarnings("unused")
    private Connection con;
    private CursoDao cursoDao;

    public CursoController(Connection con){
        this.con = con;
        this.cursoDao =  new CursoDao(con);
    }
    
    public void cadastrar(Curso curso){
        cursoDao.cadastrar(curso);
    }

    public void atualizar(Curso curso){
        cursoDao.atualizar(curso);
    }

    public void remover(int id){
        cursoDao.remover(id);
    }

    public Curso visualizar(int id){
        return cursoDao.visualizar(id);
    }

    public List<Curso> listar(){
        return cursoDao.listar();
    }

    public List<Curso> listarCursosPorProfessor(Long matricula){
        List <Curso> cursos = listar();
        for(Curso curso:cursos){
            if(curso.getMatriculaProfessor() == matricula){
                cursos.add(curso);
            }
        }
        return cursos;
    }

    public void definirProfessor(long matricula, int id){
        cursoDao.definirProfessor(matricula, id);
    }
}
