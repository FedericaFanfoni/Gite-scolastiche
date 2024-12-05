package model;

import javax.print.Doc;
import java.time.LocalDate;

public class Programmazione {

    private int id;
    private Gita gita;
    private LocalDate dataPartenza;
    private LocalDate dataArrivo;
    private Classe classe;

    public Programmazione(Gita gita, LocalDate dataPartenza, LocalDate dataArrivo, Classe classe){
        this.gita = gita;
        this.dataPartenza = dataPartenza;
        this.dataArrivo = dataArrivo;
        this.classe = classe;
    }

    public int getId(){
        return this.id;
    }

    public Gita getGita(){
        return this.gita;
    }

    public LocalDate getDataPartenza(){
        return  this.dataPartenza;
    }

    public LocalDate getDataArrivo(){
        return  this.dataArrivo;
    }

    public Classe getClasse(){
        return this.classe;
    }

    public String toString(){
        return "ID: " + getId() + ". Destinazione: " + getGita().getDestinazione() + " " + "Classe: " + getClasse().getSezione() + ". Data partenza: " + getDataPartenza() + ". Data arrivo " + getDataArrivo();
    }

    public void setId(int id){
        this.id = id;
    }

    public void setGita(Gita gita){
        this.gita = gita;
    }

    public void setDataPartenza(LocalDate dataPartenza){
        this.dataPartenza = dataPartenza;
    }

    public void setDataArrivo(LocalDate dataArrivo){
        this.dataArrivo = dataArrivo;
    }

    public void setClasse(Classe classe){
        this.classe = classe;
    }
}
