package repository;

import config.DbConnection;
import model.Classe;
import model.Docente;
import model.Gita;
import model.Programmazione;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProgrammazioneRepository {

    public void createProgrammazione(Programmazione p){
        String sql = "INSERT INTO programmazioni (id_gita, data_partenza, data_ritorno, id_classe) VALUES (?, ?, ?, ?)";

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
        ) {
            pstmt.setInt(1, p.getGita().getId());
            pstmt.setDate(2, Date.valueOf(p.getDataPartenza()));
            pstmt.setDate(3, Date.valueOf(p.getDataArrivo()));
            pstmt.setInt(4, p.getClasse().getId());
            pstmt.executeUpdate();
            System.out.println("Programmazione inserita con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public ArrayList<Programmazione> readProgrammazioni(){
        ArrayList<Programmazione> listaProgrammazioni =  new ArrayList<>();
        GitaRepository gitaRepository = new GitaRepository();
        ClasseRepository classeRepository =  new ClasseRepository();

        String sql = "SELECT * FROM programmazioni";

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Gita gita = gitaRepository.readGitaByID(rs.getInt("id_gita"));
                Classe classe = classeRepository.readClasseByID(rs.getInt("id_classe"));
                Programmazione p = new Programmazione(
                        gita,
                        rs.getDate("data_partenza").toLocalDate(),
                        rs.getDate("data_ritorno").toLocalDate(),
                        classe
                );
                p.setId(rs.getInt("id"));
                listaProgrammazioni.add(p);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }


        return listaProgrammazioni;
    }
    public void updateProgrammazione(
            int idGita,
            int idClasse,
            int idP,
            LocalDate dataPartenza,
            LocalDate dataRitorno)
    {
        String sql = "UPDATE programmazioni SET id_gita = ?, data_partenza = ?, data_ritorno = ?, id_classe = ? WHERE id = " + idP;
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql)
        ) {
            pstmt.setInt(1,idGita );
            pstmt.setDate(2,Date.valueOf(dataPartenza));
            pstmt.setDate(3,Date.valueOf(dataRitorno));
            pstmt.setInt(4, idClasse);
            pstmt.executeUpdate();
            System.out.println("Programmazione modificata con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public void deleteProgrammazione(int idP){
        String sql = "DELETE FROM programmazioni WHERE id = " + idP;
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql)
        ) {
            pstmt.executeUpdate();
            System.out.println("Programmazione gita eliminata con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
