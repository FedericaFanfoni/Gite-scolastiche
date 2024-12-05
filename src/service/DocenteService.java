package service;

import model.Docente;
import repository.DocenteRepository;

import java.util.ArrayList;

public class DocenteService {
    DocenteRepository dr = new DocenteRepository();

    public void createDocente(Docente docente){
        dr.createDocente(docente);
    }
    public ArrayList<Docente> readDocenti() {
        return dr.readDocenti();
    }
    public Docente readDocenteById(int idDocente){ return dr.readDocenteById(idDocente); }
    public void updateDocente(Docente docente, int idDocente){
        dr.updateDocente(docente, idDocente);
    }
    public void deleteDocente(int idDocente){ dr.deleteDocente(idDocente);}
}
