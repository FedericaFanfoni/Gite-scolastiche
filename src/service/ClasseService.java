package service;

import model.Classe;
import repository.ClasseRepository;

import java.util.ArrayList;

public class ClasseService {
    ClasseRepository cr = new ClasseRepository();

    public void createClasse(Classe classe){
        cr.createClasse(classe);
    }

    public ArrayList<Classe> readClassi(){
        return cr.readClassi();
    }
    public Classe readClasseByID(int idClasse){
        return cr.readClasseByID(idClasse);
    }
    public void updateClasse(Classe classe, int idClasse){
        cr.updateClasse(classe, idClasse);
    }
    public void deleteClasse(int idClasse){ cr.deleteClasse(idClasse); }
}
