package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Inscricao;

public class InscricaoDao {
    private Connection con;

    public InscricaoDao(Connection con) {
        this.con = con;
    }

    public void cadastrar(Inscricao inscricao){
        String sql = "INSERT INTO inscricao(id_inscricao, data_de_inscricao, nota, frequencia, status) VALUES(?,?,?,?,?)";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setLong(1, inscricao.getId());
            pstm.setDate(5, java.sql.Date.valueOf(inscricao.getDataDeInscricao()));
            pstm.setDouble(6, inscricao.getNota());
            pstm.setInt(7, inscricao.getFrequencia());
            pstm.setString(8, inscricao.getStatus().getValue());

            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void atualizar(Inscricao inscricao){
        String sql = "UPDATE inscricao SET" +
        "data_de_inscricao = ?, nota = ?, frequencia = ?, status = ?" +
        "WHERE id_inscricao = ?";

        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setDate(1,  java.sql.Date.valueOf(inscricao.getDataDeInscricao()));
            pstm.setDouble(2, inscricao.getNota());
            pstm.setInt(3, inscricao.getFrequencia());
            pstm.setString(4, inscricao.getStatus().getValue());
            pstm.setLong(5, inscricao.getId());

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
            pstm.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }

    public Inscricao visualizar(Long id){
        String sql = "SELECT * from inscricao WHERE id_inscricao = ?";
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setLong(1, id);
            try (ResultSet rs = pstm.getResultSet()) {
                Inscricao inscricao = new Inscricao();
                if(rs.next()){
                    inscricao.setId(rs.getInt("id_inscricao"));
                    inscricao.setDataDeInscricao(rs.getDate("data_de_inscricao").toLocalDate());
                    inscricao.setNota(rs.getDouble("nota"));
                    inscricao.setFrequencia(rs.getInt("frequencia"));
                    inscricao.setStatus(rs.getString("status"));
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

    public List<Inscricao> listar(){
        String sql = "SELECT * from inscricao";
        List<Inscricao> inscricoes = new ArrayList<>();
        try(PreparedStatement pstm = con.prepareStatement(sql)){
            try (ResultSet rs = pstm.getResultSet()) {
                while(rs.next()){
                    Inscricao inscricao = new Inscricao();
                    inscricao.setId(rs.getInt("id_inscricao"));
                    inscricao.setDataDeInscricao(rs.getDate("data_de_inscricao").toLocalDate());
                    inscricao.setNota(rs.getDouble("nota"));
                    inscricao.setFrequencia(rs.getInt("frequencia"));
                    inscricao.setStatus(rs.getString("status"));

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