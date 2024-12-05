package model;

import javax.print.Doc;

public class Gita {

    private int id;
    private String destinazione;
    private Docente docente;

    public Gita(String destinazione, Docente docente){
        this.destinazione = destinazione;
        this.docente = docente;
    }

    // GETTER

    public int getId(){
        return this.id;
    }

    public String getDestinazione(){
        return this.destinazione;
    }

    public Docente getDocente(){
        return this.docente;
    }

    public String toString(){
        return "ID gita: " + getId() + ", destinazione: " + getDestinazione() + ". Docente: " + getDocente().getNome() + " " + getDocente().getNome();
    }

    // SETTER

    public void setId(int id){
        this.id = id;
    }

    public void setDestinazione(String destinazione){
        this.destinazione = destinazione;
    }

    public void setDocente(Docente docente){
        this.docente = docente;
    }
}
