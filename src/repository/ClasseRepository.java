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

public class ClasseRepository {

    public void createClasse(Classe classe){
        String sql = "INSERT INTO classi (sezione, id_docente) VALUES (?, ?)";

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
        ) {
            pstmt.setString(1, classe.getSezione());
            pstmt.setInt(2, classe.getDocente().getId());
            pstmt.executeUpdate();
            System.out.println("Classe inserito con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public ArrayList<Classe> readClassi(){
        ArrayList<Classe> listaClassi = new ArrayList<>();
        DocenteRepository docenteRepository = new DocenteRepository();

        String sql = "SELECT * FROM classi";

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Docente docente = docenteRepository.readDocenteById(rs.getInt("id_docente"));
                Classe classe = new Classe(
                        rs.getString("sezione"),
                        docente
                );
                classe.setId(rs.getInt("id"));
                docente.setId(rs.getInt("id_docente"));
                listaClassi.add(classe);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return listaClassi;
    }
    public Classe readClasseByID(int idClasse){
        DocenteRepository docenteRepository = new DocenteRepository();
        Classe classe = null;
        String sql = "SELECT * FROM classi WHERE id = " + idClasse;

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Docente docente = docenteRepository.readDocenteById(rs.getInt("id_docente"));
                classe = new Classe(
                        rs.getString("sezione"),
                        docente
                );
                classe.setId(rs.getInt("id"));
                docente.setId(rs.getInt("id_docente"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return classe;
    }
    public void updateClasse(Classe classe, int idClasse){
        String sql = "UPDATE classi SET sezione = ?, id_docente = ? WHERE id = " + idClasse;
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql)
        ) {
            pstmt.setString(1, classe.getSezione());
            pstmt.setInt(2, classe.getDocente().getId());
            pstmt.executeUpdate();
            System.out.println("Classe modificato con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public void deleteClasse(int idClasse){
        String sql = "DELETE FROM classi WHERE id = " + idClasse;
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql)
        ) {
            pstmt.executeUpdate();
            System.out.println("Classe eliminata con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

}
