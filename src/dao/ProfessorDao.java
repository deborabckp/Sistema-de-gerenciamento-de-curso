package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Professor;

public class ProfessorDao {
    private Connection con;

    public ProfessorDao(Connection con) {
        this.con = con;
    }

    public void cadastrar(Professor professor){
        String sql = "INSERT INTO professor(matricula, nome, cpf, telefone, email, senha, formacao) VALUES(?,?,?,?,?,?,?)";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setLong(1, professor.getMatricula());
            pstm.setString(2, professor.getNome());
            pstm.setString(3, professor.getCpf());
            pstm.setString(4, professor.getTelefone());
            pstm.setString(5, professor.getEmail());
            pstm.setString(6, professor.getSenha());
            pstm.setString(7, professor.getFormacao());

            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void atualizar(Professor professor){
        String sql = "UPDATE professor SET " +
        "nome = ?, cpf = ?, telefone = ?, email = ?, " + 
        "senha = ?, formacao = ? "+ 
        "WHERE matricula = ?";

        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, professor.getNome());
            pstm.setString(2, professor.getCpf());
            pstm.setString(3, professor.getTelefone());
            pstm.setString(4, professor.getEmail());
            pstm.setString(5, professor.getSenha());
            pstm.setString(6, professor.getFormacao());
            pstm.setLong(7, professor.getMatricula());

            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void remover(long professorMatricula){
        String sql = "DELETE FROM professor WHERE professor.matricula = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setLong(1, professorMatricula);
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }

    public Professor visualizar(Long matriculaProfessor){
        String sql = "SELECT * FROM professor WHERE matricula = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setLong(1, matriculaProfessor);
            try (ResultSet rs = pstm.executeQuery()) {
                Professor professor = new Professor();
                if(rs.next()){
                    professor.setMatricula(rs.getLong("matricula"));
                    professor.setNome(rs.getString("nome"));
                    professor.setCpf(rs.getString("cpf"));
                    professor.setTelefone(rs.getString("telefone"));
                    professor.setEmail(rs.getString("email"));
                    professor.setSenha(rs.getString("senha"));
                    professor.setFormacao(rs.getString("formacao"));
                }

                rs.close();
                pstm.close();
                return professor;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Professor> listar(){
        String sql = "SELECT * FROM professor";
        List<Professor> professores = new ArrayList<>();
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            try (ResultSet rs = pstm.executeQuery()) {
                while(rs.next()){
                    Professor professor = new Professor();
                    professor.setMatricula(rs.getLong("matricula"));
                    professor.setNome(rs.getString("nome"));
                    professor.setCpf(rs.getString("cpf"));
                    professor.setTelefone(rs.getString("telefone"));
                    professor.setEmail(rs.getString("email"));
                    professor.setSenha(rs.getString("senha"));
                    professor.setFormacao(rs.getString("formacao"));
                    professores.add(professor);
                }

                rs.close();
                pstm.close();
                return professores;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
