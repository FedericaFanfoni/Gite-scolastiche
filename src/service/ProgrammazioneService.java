package service;

import model.Programmazione;
import repository.ProgrammazioneRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProgrammazioneService {
    ProgrammazioneRepository pr = new ProgrammazioneRepository();

    public void createProgrammazione(Programmazione p){
        pr.createProgrammazione(p);
    }
    public ArrayList<Programmazione> readProgrammazioni(){
        return pr.readProgrammazioni();
    }
    public void updateProgrammazione(int idGita, int idClasse, int idP, LocalDate dataPartenza, LocalDate dataRitorno){
        pr.updateProgrammazione(idGita, idClasse, idP, dataPartenza, dataRitorno);}
    public void deleteProgrammazione(int idP){ pr.deleteProgrammazione(idP);}
}
