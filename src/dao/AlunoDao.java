package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Aluno;

public class AlunoDao {
    private Connection con;

    public AlunoDao(Connection con) {
        this.con = con;
    }

    public void cadastrar(Aluno aluno){
        String sql = "INSERT INTO aluno(matricula, nome, cpf, telefone, email, senha, curso_de_graduacao) VALUES(?,?,?,?,?,?,?)";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setLong(1, aluno.getMatricula());
            pstm.setString(2, aluno.getNome());
            pstm.setString(3, aluno.getCpf());
            pstm.setString(4, aluno.getTelefone());
            pstm.setString(5, aluno.getEmail());
            pstm.setString(6, aluno.getSenha());
            pstm.setString(7, aluno.getCursoDeGraduacao());

            pstm.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void atualizar(Aluno aluno){
        String sql = "UPDATE aluno SET " +
                     "nome = ?, cpf = ?, telefone = ?, email = ?, " + 
                     "senha = ?, curso_de_graduacao = ?, "+ 
                     "WHERE matricula = ?";

        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCpf());
            pstm.setString(3, aluno.getTelefone());
            pstm.setString(4, aluno.getEmail());
            pstm.setString(5, aluno.getSenha());
            pstm.setString(6, aluno.getCursoDeGraduacao());
            pstm.setLong(7, aluno.getMatricula());


            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void remover(long matriculaAluno){
        String sql = "DELETE FROM aluno WHERE aluno.matricula = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setLong(1, matriculaAluno);
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }    
    }

    public Aluno visualizar(Long matriculaAluno){
        String sql = "SELECT * from aluno WHERE matricula = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setLong(1, matriculaAluno);
            try (ResultSet rs = pstm.executeQuery()) {
                Aluno aluno = new Aluno();
                if(rs.next()){
                    aluno.setMatricula(rs.getLong("matricula"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setCpf(rs.getString("cpf"));
                    aluno.setTelefone(rs.getString("telefone"));
                    aluno.setEmail(rs.getString("email"));
                    aluno.setSenha(rs.getString("senha"));
                    aluno.setCursoDeGraduacao(rs.getString("curso_de_graduacao"));
                }

                rs.close();
                pstm.close();
                return aluno;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Aluno> listar(){
        String sql = "SELECT * from aluno";
        List<Aluno> alunos = new ArrayList<>();
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            
            try (ResultSet rs = pstm.executeQuery()) {
                while(rs.next()){
                    Aluno aluno = new Aluno();
                    aluno.setMatricula(rs.getLong("matricula"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setCpf(rs.getString("cpf"));
                    aluno.setTelefone(rs.getString("telefone"));
                    aluno.setEmail(rs.getString("email"));
                    aluno.setSenha(rs.getString("senha"));
                    aluno.setCursoDeGraduacao(rs.getString("curso_de_graduacao"));

                    alunos.add(aluno);
                }
                rs.close();
                pstm.close();
                return alunos;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }
}
