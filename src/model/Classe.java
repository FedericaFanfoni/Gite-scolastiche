package model;

import javax.print.Doc;

public class Classe {

    private int id;
    private String sezione;
    private Docente docente;

    public Classe(String sezione, Docente docente){
        this.sezione = sezione;
        this.docente = docente;
    }

    // GETTER

    public int getId(){
        return this.id;
    }

    public String getSezione(){
        return this.sezione;
    }

    public Docente getDocente(){
        return this.docente;
    }

    public String toString(){
        return "Classe: " + getSezione() + ", ID: " + getId() +  " Docente: " + getDocente().getNome() + " " + getDocente().getCognome();
    }

    // SETTER

    public void setId(int id){
        this.id = id;
    }
    public void setSezione(String sezione){
        this.sezione = sezione;
    }

    public void setDocente(Docente docente){
        this.docente = docente;
    }
}
