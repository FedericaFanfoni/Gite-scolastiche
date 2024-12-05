import model.Classe;
import model.Docente;
import model.Gita;
import model.Programmazione;
import service.ClasseService;
import service.DocenteService;
import service.GitaService;
import service.ProgrammazioneService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        sceltaMenu();

    }

    public static void sceltaMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli in quale menù andare.");
        System.out.println("1. Docenti");
        System.out.println("2. Classi");
        System.out.println("3. Gita");
        System.out.println("4. Programmazioni");
        System.out.println("5. Exit");

        int choice = scanner.nextInt();

        avvioMenu(choice);
    }

    public static void avvioMenu(int choice) {
        Scanner scanner = new Scanner(System.in);
        if (choice == 1) {
            int select;
            do {
                System.out.println("***Menù Docenti***");
                System.out.println("1. Crea uno docente");
                System.out.println("2. Lista dei docenti");
                System.out.println("3. Modifica un docente");
                System.out.println("4. Elimina un docente");
                System.out.println("5. Torna alla selezione del menù");
                select = scanner.nextInt();

                switch (select) {
                    case 1:
                        createDocente();
                        break;
                    case 2:
                        readDocenti();
                        break;
                    case 3:
                        updateDocente();
                        break;
                    case 4:
                        deleteDocente();
                        break;
                    case 5:
                        sceltaMenu();
                    default:
                        System.out.println("Scelta non valida");
                        avvioMenu(choice);
                }

            } while (choice < 6);
            scanner.close();
        }else if(choice == 2){
            int select;
            do {
                System.out.println("***Menù Classe***");
                System.out.println("1. Crea una classe");
                System.out.println("2. Lista delle classi");
                System.out.println("3. Modifica una classe");
                System.out.println("4. Elimina una classe");
                System.out.println("5. Torna alla selezione del menù");
                select = scanner.nextInt();

                switch (select) {
                    case 1:
                        createClasse();
                        break;
                    case 2:
                        readClassi();
                        break;
                    case 3:
                        updateClasse();
                        break;
                    case 4:
                        deleteClasse();
                        break;
                    case 5:
                        sceltaMenu();
                    default:
                        System.out.println("Scelta non valida");
                        avvioMenu(choice);
                }

            } while (choice < 6);
            scanner.close();

        }else if(choice==3){
            int select;
            do {
                System.out.println("***Menù Gita***");
                System.out.println("1. Crea una gita");
                System.out.println("2. Lista delle gite");
                System.out.println("3. Modifica una gita");
                System.out.println("4. Elimina una Gita");
                System.out.println("5. Torna alla selezione del menù");
                select = scanner.nextInt();

                switch (select) {
                    case 1:
                        createGita();
                        break;
                    case 2:
                        readGite();
                        break;
                    case 3:
                        updateGita();
                        break;
                    case 4:
                        deleteGita();
                        break;
                    case 5:
                        sceltaMenu();
                    default:
                        System.out.println("Scelta non valida");
                        avvioMenu(choice);
                }

            } while (choice < 6);
            scanner.close();
        }else if(choice == 4){
            int select;
            do {
                System.out.println("***Programmazioni delle gite***");
                System.out.println("1. Crea una nuova programmazione");
                System.out.println("2. Lista delle programmazione");
                System.out.println("3. Modifica una programmazione");
                System.out.println("4. Elimina una programmazione");
                System.out.println("5. Torna alla selezione del menù");
                select = scanner.nextInt();

                switch (select) {
                    case 1:
                        createProgrammazione();
                        break;
                    case 2:
                        readProgrammazioni();
                        break;
                    case 3:
                        updateProgrammazione();
                        break;
                    case 4:
                        deleteProgrammazione();
                        break;
                    case 5:
                        sceltaMenu();
                    default:
                        System.out.println("Scelta non valida");
                        avvioMenu(choice);
                }

            } while (choice < 6);
            scanner.close();

        }
    }

    public static void createDocente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci nome del docente: ");
        String nome = scanner.nextLine();

        System.out.println("Inserisci il cognome");
        String cognome = scanner.nextLine();

        System.out.println("Inserisci la materia che insegna");
        String materia = scanner.nextLine();

        Docente docente = new Docente(nome, cognome, materia);

        DocenteService docenteService = new DocenteService();
        docenteService.createDocente(docente);

    }
    public static void readDocenti() {
        DocenteService docenteService = new DocenteService();

        for (Docente docente : docenteService.readDocenti()) {
            System.out.println(docente.toString());
        }
    }
    public static void updateDocente() {
        DocenteService docenteService = new DocenteService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scegli quale docente modificare");

        int select;
        ArrayList<Docente> listaDocenti = new ArrayList<>();

        for (int i = 0; i < docenteService.readDocenti().size(); i++) {
            System.out.println((i+1) + ")" + docenteService.readDocenti().get(i));
            listaDocenti.add(docenteService.readDocenti().get(i));
        }

        select = scanner.nextInt();

        for (int j = 0; j < listaDocenti.size(); j++) {

            if (select == (j + 1)) {

                scanner.nextLine();
                System.out.println("Inserisci il nuovo nome: ");
                String nome = scanner.nextLine();

                System.out.println("Inserisci il nuovo cognome");
                String cognome = scanner.nextLine();

                System.out.println("Inserisci la nuova materia");
                String materia = scanner.nextLine();

                Docente docente = new Docente(nome, cognome, materia);
                docenteService.updateDocente(docente, listaDocenti.get(j).getId());
            }
        }
    }
    public static void deleteDocente(){
        DocenteService docenteService = new DocenteService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scegli quale docente eliminare");

        int select;
        ArrayList<Docente> listaDocenti = new ArrayList<>();

        for (int i = 0; i < docenteService.readDocenti().size(); i++) {
            System.out.println((i+1) + ")" + docenteService.readDocenti().get(i));
            listaDocenti.add(docenteService.readDocenti().get(i));
        }

        select = scanner.nextInt();

        for (int j = 0; j < listaDocenti.size(); j++) {

            if (select == (j + 1)) {
                docenteService.deleteDocente(listaDocenti.get(j).getId());
            }
        }
    }

    public static void createClasse(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci la sezione: ");
        String sezione = scanner.nextLine();

        System.out.println("Scegli il docente della classe");
        DocenteService docenteService = new DocenteService();

        readDocenti();

        int idDocente = scanner.nextInt();
        Docente docente = docenteService.readDocenteById(idDocente);
        System.out.println(docente.toString());

        Classe classe = new Classe(sezione, docente);

        ClasseService classeService = new ClasseService();
        classeService.createClasse(classe);

    }
    public static void readClassi(){
        ClasseService classeService = new ClasseService();

        for (Classe classe : classeService.readClassi()) {
            System.out.println(classe.toString());
        }
    }
    public static void updateClasse(){
        ClasseService classeService = new ClasseService();
        DocenteService docenteService = new DocenteService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scegli quale classe modificare");

        readClassi();

        int idClasse = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Inserisci la nuova sezione: ");
        String sezione = scanner.nextLine();

        System.out.println("Inserisci il nuovo docente");
        readDocenti();
        int idDocente = scanner.nextInt();
        Docente docente = docenteService.readDocenteById(idDocente);

        Classe classe =  new Classe(sezione, docente);
        classeService.updateClasse(classe, idClasse);

    }
    public static void deleteClasse(){
        ClasseService classeService = new ClasseService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli quale classe eliminare");

        readClassi();

        int idClasse = scanner.nextInt();
        classeService.deleteClasse(idClasse);
    }

    public static void createGita(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci la destinazione: ");
        String destinazione = scanner.nextLine();

        System.out.println("Scegli il docente coordinatore per la gita");
        DocenteService docenteService = new DocenteService();

        readDocenti();

        int idDocente = scanner.nextInt();
        Docente docente = docenteService.readDocenteById(idDocente);
        System.out.println(docente.toString());

        Gita gita= new Gita(destinazione, docente);

        GitaService gitaService = new GitaService();
        gitaService.createGita(gita);
    }
    public static void readGite(){
        GitaService gitaService = new GitaService();

        for(Gita gita : gitaService.readGite()){
            System.out.println(gita.toString());
        }
    }
    public static void updateGita(){
        GitaService gitaService = new GitaService();
        DocenteService docenteService = new DocenteService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scegli quale gita modificare");

        readGite();

        int idGita = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Inserisci la nuova destinazione: ");
        String destinazione = scanner.nextLine();

        System.out.println("Inserisci il nuovo docente");
        readDocenti();
        int idDocente = scanner.nextInt();
        Docente docente = docenteService.readDocenteById(idDocente);

        Gita gita =  new Gita(destinazione, docente);
        gitaService.updateGita(gita, idGita);
    }
    public static void deleteGita(){
        GitaService gitaService = new GitaService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli quale gita eliminare");

        readClassi();

        int idGita = scanner.nextInt();
        gitaService.deleteGita(idGita);
    }

    public static void createProgrammazione(){
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        GitaService gitaService = new GitaService();
        ClasseService classeService = new ClasseService();

        System.out.println("Scegli la gita da programmare");
        readGite();
        int idGita = scanner.nextInt();
        Gita gita = gitaService.readGitaByID(idGita);

        System.out.println("Scegli la classe che farà la gita");
        readClassi();
        int idClasse = scanner.nextInt();
        Classe classe = classeService.readClasseByID(idClasse);

        scanner.nextLine();

        System.out.println("Inserisci la data di partenza");
        String dataPartenzaString = scanner.nextLine();
        LocalDate dataPartenza = LocalDate.parse(dataPartenzaString, dateFormatter);

        System.out.println("Inserisci la data di ritorno");
        String dataRitornoString = scanner.nextLine();
        LocalDate dataRitorno = LocalDate.parse(dataRitornoString, dateFormatter);

        Programmazione p = new Programmazione(gita, dataPartenza, dataRitorno, classe);
        ProgrammazioneService programmazioneService = new ProgrammazioneService();
        programmazioneService.createProgrammazione(p);

    }
    public static void readProgrammazioni(){
        ProgrammazioneService programmazioneService = new ProgrammazioneService();
        for(Programmazione p : programmazioneService.readProgrammazioni()){
            System.out.println(p.toString());
        }
    }
    public static void updateProgrammazione(){
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ProgrammazioneService programmazioneService =  new ProgrammazioneService();

        System.out.println("Scegli quale programmazione modificare");
        readProgrammazioni();
        int idP = scanner.nextInt();

        System.out.println("Scegli la nuova gita: ");
        readGite();
        int idGita = scanner.nextInt();

        System.out.println("Scegli la nuova classe");
        readClassi();
        int idClasse = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Inserisci la nuova data di partenza");
        String dataPartenzaString = scanner.nextLine();
        LocalDate dataPartenza = LocalDate.parse(dataPartenzaString, dateFormatter);

        System.out.println("Inserisci la nuova data di ritorno");
        String dataRitornoString = scanner.nextLine();
        LocalDate dataRitorno = LocalDate.parse(dataRitornoString, dateFormatter);

        programmazioneService.updateProgrammazione(idGita, idClasse, idP, dataPartenza, dataRitorno);
    }
    public static void deleteProgrammazione(){
        ProgrammazioneService programmazioneService = new ProgrammazioneService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scegli quale programmazione eliminare");

        readProgrammazioni();

        int idProgrammazione = scanner.nextInt();
        programmazioneService.deleteProgrammazione(idProgrammazione);
    }

}

