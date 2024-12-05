package repository;

import config.DbConnection;
import model.Docente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DocenteRepository {

    public void createDocente(Docente docente){
        String sql = "INSERT INTO docenti (nome, cognome, materia) VALUES (?, ?, ?)";

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
        ) {
            pstmt.setString(1, docente.getNome());
            pstmt.setString(2, docente.getCognome());
            pstmt.setString(3, docente.getMateria());
            pstmt.executeUpdate();
            System.out.println("Docente inserito con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<Docente> readDocenti(){

        ArrayList<Docente> listaDocenti = new ArrayList<>();

        String sql = "SELECT * FROM docenti";

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Docente docente = new Docente(
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("materia")
                );
                docente.setId(rs.getInt("id"));
                listaDocenti.add(docente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return listaDocenti;
    }

    public Docente readDocenteById(int idDocente){
        String sql = "SELECT * FROM docenti WHERE id = " + idDocente;
        Docente docente = null;

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if(rs.next()) {
                docente = new Docente(
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("materia")
                );
                docente.setId(rs.getInt("id"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return docente;
    }

    public void updateDocente(Docente docente, int idDocente){
        String sql = "UPDATE docenti SET nome = ?, cognome = ?, materia = ? WHERE id = " + idDocente;
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql)
        ) {
            pstmt.setString(1, docente.getNome());
            pstmt.setString(2, docente.getCognome());;
            pstmt.setString(3, docente.getMateria());
            pstmt.executeUpdate();
            System.out.println("Docente modificato con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public  void deleteDocente(int idDocente){
        String sql = "DELETE FROM docenti WHERE id = " +idDocente;
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql)
        ) {
            pstmt.executeUpdate();
            System.out.println("Docente eliminato con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
