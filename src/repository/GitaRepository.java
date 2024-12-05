package repository;

import config.DbConnection;
import model.Classe;
import model.Docente;
import model.Gita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GitaRepository {

    public void createGita(Gita gita){
        String sql = "INSERT INTO gite (destinazione, id_docente) VALUES (?, ?)";

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
        ) {
            pstmt.setString(1, gita.getDestinazione());
            pstmt.setInt(2, gita.getDocente().getId());
            pstmt.executeUpdate();
            System.out.println("Gita inserita con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public ArrayList<Gita> readGite(){
        ArrayList<Gita> listaGite = new ArrayList<>();
        DocenteRepository docenteRepository = new DocenteRepository();

        String sql = "SELECT * FROM gite";

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Docente docente = docenteRepository.readDocenteById(rs.getInt("id_docente"));
                Gita gita = new Gita(
                        rs.getString("destinazione"),
                        docente
                );
                gita.setId(rs.getInt("id"));
                docente.setId(rs.getInt("id_docente"));
                listaGite.add(gita);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return listaGite;
    }
    public Gita readGitaByID(int idGita){
        DocenteRepository docenteRepository = new DocenteRepository();
        Gita gita = null;
        String sql = "SELECT * FROM gite WHERE id = " + idGita;

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if(rs.next()) {
                Docente docente = docenteRepository.readDocenteById(rs.getInt("id_docente"));
                gita = new Gita(
                        rs.getString("destinazione"),
                        docente
                );
                gita.setId(rs.getInt("id"));
                docente.setId(rs.getInt("id_docente"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return gita;
    }
    public void updateGita(Gita gita, int idGita){
        String sql = "UPDATE gite SET destinazione = ?, id_docente = ? WHERE id = " + idGita;
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql)
        ) {
            pstmt.setString(1, gita.getDestinazione());
            pstmt.setInt(2, gita.getDocente().getId());
            pstmt.executeUpdate();
            System.out.println("Gita modificato con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public void deleteGita(int idGita){
        String sql = "DELETE FROM gite WHERE id = " + idGita;
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql)
        ) {
            pstmt.executeUpdate();
            System.out.println("Gita eliminata con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
