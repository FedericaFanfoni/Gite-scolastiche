package service;

import model.Gita;
import repository.GitaRepository;

import java.util.ArrayList;

public class GitaService {
    GitaRepository gr = new GitaRepository();

    public void createGita(Gita gita){
        gr.createGita(gita);
    }
    public ArrayList<Gita> readGite(){
        return gr.readGite();
    }
    public Gita readGitaByID(int idGita){
        return gr.readGitaByID(idGita);
    }
    public void updateGita(Gita gita, int idGita){
        gr.updateGita(gita, idGita);
    }
    public void deleteGita(int idGita){
        gr.deleteGita(idGita);
    }
}
