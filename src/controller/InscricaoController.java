package controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import dao.AlunoDao;
import dao.CursoDao;
import dao.InscricaoDao;
import dto.InscricaoDTO;
import enums.StatusInscricaoEnum;
import entidades.Aluno;
import entidades.Curso;
import entidades.Inscricao;

public class InscricaoController {
    private Connection con;
    private InscricaoDao inscricaoDao;

    public InscricaoController(Connection con){
        this.con = con;
        this.inscricaoDao =  new InscricaoDao(con);
    }

    public void realizarInscricao(long idInscricao, long matricula, int idCurso){
        CursoDao cursoDao = new CursoDao(con);
        Curso curso = cursoDao.visualizar(idCurso);
        int numeroDEInscritos = getNumeroDeInscritos(idCurso);
        int numeroDeVagas = curso.getVagas();
        LocalDate dataDeInicio = curso.getDataInicio();
        LocalDate dataDeInscricao = LocalDate.now();
      
        if(numeroDEInscritos <= numeroDeVagas){
            if(dataDeInscricao.isBefore(dataDeInicio)){
                inscricaoDao.realizarInscricao(idInscricao, matricula, idCurso);
            }else{
                System.out.println("Não foi possível realizar inscrição! Prazo encerrado.");
            }
        }else{
            System.out.println("Não foi possível realizar inscrição! Não há mais vagas disponíveis para o curso.");
        }
    }

    public void cadastrarNota(double nota, long id){
        if (nota >= 0.0 && nota < 10.0) {
            inscricaoDao.cadastrarNota(nota, id);           
       } else {
            System.out.println("Nota inválida! Digite um valor positivo menor ou igual a 10");
        }
    }

    public void cadastrarFrequencia(int frequencia, long id){
        inscricaoDao.cadastrarFrequencia(frequencia, id);
    }
    
    public void atualizarStatus(Long id, StatusInscricaoEnum status){
        inscricaoDao.atualizarStatus(id, status);
    }

    public void remover(long id){
        inscricaoDao.remover(id);
    }

    public Inscricao visualizar(Long id){
        return inscricaoDao.visualizar(id);
    }

    public List<InscricaoDTO> listar(){
        return inscricaoDao.listar();
    }

    public List<InscricaoDTO> visualizarHistoricoAluno(Long matricula){
        List<InscricaoDTO> historicoInscricoes = listar().stream()
            .filter(inscricao -> inscricao.getMatricula() == matricula)
            .collect(Collectors.toList());

        return historicoInscricoes;
    }

    public List<Aluno> listarAlunosInscritos(int idCurso){
        AlunoDao dao = new AlunoDao(con);
        List<Aluno> alunosInscritos = listar().stream()
            .filter(inscricao -> inscricao.getCodigo() == idCurso)
            .mapToLong(inscricao -> inscricao.getMatricula())
            .mapToObj(matricula -> dao.visualizar(matricula))
            .collect(Collectors.toList());
        return alunosInscritos;
    }

    public List<Curso> listarCursosInscritos(Long matricula){
        CursoDao dao = new CursoDao(con);
        List<Curso> cursosInscritos = listar().stream()
            .filter(inscricao -> inscricao.getMatricula() == matricula)
            .mapToInt(inscricao -> inscricao.getCodigo())
            .mapToObj(idCurso -> dao.visualizar(idCurso))
            .collect(Collectors.toList());
        return cursosInscritos;
    }

    public int getNumeroDeInscritos(int idCurso){
        int numeroDeInscritos = (int) listar().stream()
            .filter(inscricao -> inscricao.getCodigo() == idCurso)
            .count();
        return numeroDeInscritos;
    }
}
