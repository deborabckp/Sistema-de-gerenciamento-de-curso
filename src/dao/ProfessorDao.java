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

    public void cadastrar(Professor professor) {
        String sql = "INSERT INTO professor(matricula, nome, cpf, telefone, email, usuario, senha, formacao) VALUES(?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setLong(1, professor.getMatricula());
            pstm.setString(2, professor.getNome());
            pstm.setString(3, professor.getCpf());
            pstm.setString(4, professor.getTelefone());
            pstm.setString(5, professor.getEmail());
            pstm.setString(6, professor.getUsuario());
            pstm.setString(7, professor.getSenha());
            pstm.setString(8, professor.getFormacao());

            pstm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizar(Professor professor) {
        String sql = "UPDATE professor SET nome = ?, cpf = ?, telefone = ?, email = ?, usuario = ?, senha = ?, formacao = ? WHERE matricula = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setString(1, professor.getNome());
            pstm.setString(2, professor.getCpf());
            pstm.setString(3, professor.getTelefone());
            pstm.setString(4, professor.getEmail());
            pstm.setString(5, professor.getUsuario());
            pstm.setString(6, professor.getSenha());
            pstm.setString(7, professor.getFormacao());
            pstm.setLong(8, professor.getMatricula());

            pstm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(long professorMatricula) {
        String sql = "DELETE FROM professor WHERE matricula = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)) {
            pstm.setLong(1, professorMatricula);
            pstm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Professor> listar() {
        String sql = "SELECT * FROM professor";
        List<Professor> professores = new ArrayList<>();
        try (PreparedStatement pstm = con.prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                Professor professor = new Professor(
                    rs.getLong("matricula"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("usuario"),
                    rs.getString("senha"),
                    rs.getString("formacao")
                );
                professores.add(professor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return professores;
    }
}
