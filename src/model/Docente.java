package model;

public class Docente {

    private int id;
    private String nome;
    private String cognome;
    private String materia;
    private Classe classe;
    private Gita gita;

    public Docente(String nome, String cognome, String materia){
        this.nome = nome;
        this.cognome = cognome;
        this.materia = materia;
    }

    public Docente(String nome, String cognome, String materia, Classe classe){
        this.nome = nome;
        this.cognome = cognome;
        this.materia = materia;
        this.classe = classe;
    }

    public Docente(String nome, String cognome, String materia, Classe classe, Gita gita){
        this.nome = nome;
        this.cognome = cognome;
        this.materia = materia;
        this.classe = classe;
        this.gita = gita;
    }
    // GETTER

    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCognome(){
        return this.cognome;
    }

    public String getMateria(){
        return this.materia;
    }

    public Classe getClasse(){
        return this.classe;
    }

    public Gita getGita(){
        return this.gita;
    }

    public String toString(){
        return  getNome() + " " + getCognome() + " ID: " + getId();
    }

    // SETTER

    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public void setMateria(String materia){
        this.materia = materia;
    }

    public void setClasse(Classe classe){
        this.classe = classe;
    }

    public void setGita(Gita gita){
        this.gita = gita;
    }

}
