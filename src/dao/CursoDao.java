package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Curso;

public class CursoDao {
    private Connection con;

    public CursoDao(Connection con) {
        this.con = con;
    }

    public void cadastrar(Curso curso){
        String sql = "INSERT INTO curso(id, nome, descricao, data_inicio, data_fim, carga_horaria, vagas, modalidade) VALUES(?,?,?,?,?,?,?,?)";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setLong(1, curso.getId());
            pstm.setString(2, curso.getNome());
            pstm.setString(3, curso.getDescricao());
            pstm.setDate(4, java.sql.Date.valueOf(curso.getDataInicio()));
            pstm.setDate(5, java.sql.Date.valueOf(curso.getDataFim()));
            pstm.setInt(6, curso.getCargaHoraria());
            pstm.setInt(7, curso.getVagas());
            pstm.setString(8, curso.getModalidade().getValue());

            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void atualizar(Curso curso){
        String sql = "UPDATE curso SET" +
        "nome = ?, descricao = ?, data_inicio = ?, data_fim = ?," +
        "carga_horaria = ?, vagas = ?, modalidade = ?" +
        "WHERE id = ?";

        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, curso.getNome());
            pstm.setString(2, curso.getDescricao());
            pstm.setDate(3, java.sql.Date.valueOf(curso.getDataInicio()));
            pstm.setDate(4, java.sql.Date.valueOf(curso.getDataFim()));
            pstm.setInt(5, curso.getCargaHoraria());
            pstm.setInt(6, curso.getVagas());
            pstm.setString(7, curso.getModalidade().getValue());
            pstm.setLong(8, curso.getId());

            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void remover(long cursoId){
        String sql = "DELETE FROM curso WHERE curso.id = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setLong(1, cursoId);
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }

    public Curso visualizar(int idCurso){
        String sql = "SELECT * from curso WHERE id = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setInt(1, idCurso);
            try (ResultSet rs = pstm.getResultSet()) {
                Curso curso = new Curso();
                if(rs.next()){
                    curso.setId(rs.getInt("id_curso"));
                    curso.setNome(rs.getString("nome"));
                    curso.setDescricao(rs.getString("descricao"));
                    curso.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                    curso.setDataFim(rs.getDate("data_fim").toLocalDate());
                    curso.setCargaHoraria(rs.getInt("carga_horaria"));
                    curso.setVagas(rs.getInt("vagas"));
                    curso.setModalidade(rs.getString("modalidade"));
                }

                rs.close();
                pstm.close();
                return curso;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Curso> listar(){
        String sql = "SELECT * from curso";
        List<Curso> cursos = new ArrayList<>();
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            try (ResultSet rs = pstm.getResultSet()) {
                while(rs.next()){
                    Curso curso = new Curso();
                    curso.setId(rs.getInt("id"));
                    curso.setNome(rs.getString("nome"));
                    curso.setDescricao(rs.getString("descricao"));
                    curso.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                    curso.setDataFim(rs.getDate("data_fim").toLocalDate());
                    curso.setCargaHoraria(rs.getInt("carga_horaria"));
                    curso.setVagas(rs.getInt("vagas"));
                    curso.setModalidade(rs.getString("modalidade"));

                    cursos.add(curso);
                }

                rs.close();
                pstm.close();
                return cursos;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }    
    }
}
