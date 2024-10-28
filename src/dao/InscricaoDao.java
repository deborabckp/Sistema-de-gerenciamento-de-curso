package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.InscricaoDTO;
import entidades.Inscricao;
import enums.StatusInscricaoEnum;

public class InscricaoDao {
    private Connection con;

    public InscricaoDao(Connection con) {
        this.con = con;
    }

    public void realizarInscricao(long idInscricao, long matricula, int idCurso){
        String sql = "INSERT INTO inscricao(id_inscricao, data_de_inscricao, matricula_aluno, id_curso, status) VALUES(?,?,?,?,?)";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setLong(1, idInscricao);
            pstm.setDate(2, java.sql.Date.valueOf(LocalDate.now()));
            pstm.setLong(3, matricula);
            pstm.setInt(4, idCurso);
            pstm.setString(5, StatusInscricaoEnum.EMPROCESSAMENTO.getValue());

            pstm.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastrarNota(double nota, long idInscricao){
        String sql = "UPDATE inscricao SET nota = ? WHERE id_inscricao = ?";

        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setDouble(1, nota);
            pstm.setLong(2, idInscricao);

            pstm.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarFrequencia(int frequencia, long idInscricao){
        String sql = "UPDATE inscricao SET frequencia = ? WHERE id_inscricao = ?";

        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setDouble(1, frequencia);
            pstm.setLong(2, idInscricao);
            pstm.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarStatus(Long idInscricao, StatusInscricaoEnum status){
        String sql = "UPDATE inscricao " +
        "SET status = ? " +
        "WHERE id_inscricao = ?";

        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, status.getValue());
            pstm.setLong(2, idInscricao);

            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void remover(long id){
        String sql = "DELETE FROM inscricao WHERE id_inscricao = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setLong(1, id);
            pstm.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }

    public Inscricao visualizar(Long id){
        String sql = "SELECT * from inscricao WHERE id_inscricao = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setLong(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                Inscricao inscricao = new Inscricao();
                if(rs.next()){
                    inscricao.setId(rs.getInt("id_inscricao"));
                    inscricao.setDataDeInscricao(rs.getDate("data_de_inscricao").toLocalDate());
                    inscricao.setNota(rs.getDouble("nota"));
                    inscricao.setFrequencia(rs.getInt("frequencia"));
                    inscricao.setStatus(rs.getString("status"));
                    inscricao.setMatriculaAluno(rs.getLong("matricula_aluno"));
                    inscricao.setIdCurso(rs.getInt("id_curso"));

                }

                rs.close();
                pstm.close();
                return inscricao;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<InscricaoDTO> listar(){
        String sql = "SELECT id_inscricao, matricula_aluno, a.nome, c.id_curso, c.nome  AS curso, nota, frequencia, status, data_de_inscricao \n" +
            "FROM aluno a, curso c, inscricao i \n" + //
            "WHERE i.matricula_aluno = a.matricula AND i.id_curso = c.id_curso;";
        List<InscricaoDTO> inscricoes = new ArrayList<>();
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            try (ResultSet rs = pstm.executeQuery()) {
                while(rs.next()){
                    InscricaoDTO inscricao = new InscricaoDTO();
                    inscricao.setId(rs.getLong("id_inscricao"));
                    inscricao.setMatricula(rs.getLong("matricula_aluno"));
                    inscricao.setNome(rs.getString("nome"));
                    inscricao.setCodigo(rs.getInt("id_curso"));
                    inscricao.setCurso(rs.getString("curso"));
                    inscricao.setNota(rs.getDouble("nota"));
                    inscricao.setFrequencia(rs.getInt("frequencia"));
                    inscricao.setStatus(rs.getString("status"));
                    inscricao.setDataDeInscricao(rs.getDate("data_de_inscricao").toLocalDate());

                    inscricoes.add(inscricao);
                }

                rs.close();
                pstm.close();
                return inscricoes;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }
}