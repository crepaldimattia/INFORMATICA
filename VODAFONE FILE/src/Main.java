import static tools.utility.*;
import java.util.Scanner;
import java.io.*;   //serve per il file
public class Main {
    public static void main(String[] args) {
        String[] operazioni = {"VODAFONE",
                "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca",
                "[4] Ricerca Numero telefonico",
                "[5] Modifica contatto",
                "[6] Cancellazione",
                "[7] Carica saldo telefonico",
                "[8] Telefona",
                "[9] Ordina (Selection sort, Insertion sort, Bubble sort)",
                "[10] Salva file",
                "[11] Fine"
        };

        boolean Sitel = true;
        final int nMax = 3;
        int contrattiVenduti = 0;
        int posizione;
        int ordinamento=0;
        Contatto[] gestore = new Contatto[nMax];

        Scanner keyboard = new Scanner(System.in);

        double saldoInserito=0;
        boolean fine = true;
        do {
            switch (menu(operazioni, keyboard)) {
                case 1:

                    if (contrattiVenduti < nMax) {
                        //firma contratto
                        gestore[contrattiVenduti]=leggiPersona(Sitel,keyboard);
                        contrattiVenduti++;
                    } else {
                        System.out.println("Non ci sono più contratti da vendere");
                    }
                    break;
                case 2: {
                    if(contrattiVenduti!=0)
                        visualizza(gestore, contrattiVenduti);
                    else
                        System.out.println("Non ci sono contratti\n");
                    break;
                }

                case 3: {
                    if (contrattiVenduti != 0) {
                        //Ci sono contratti venduti
                        //lettura, ricerca, visualizzazione
                        if (ricerca(gestore, leggiPersona(false, keyboard), contrattiVenduti)) {
                            System.out.println("Il contatto esiste");

                        } else {
                            System.out.println("Il contatto non esiste");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                }

                case 4:
                    if (contrattiVenduti != 0) {
                        posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                        if (posizione != -1) {
                            System.out.println(gestore[posizione].cognome + " " + gestore[posizione].nome + ": " + gestore[posizione].telefono);
                        } else {
                            System.out.println("Contatto inesistente");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;

                case 5:
                    Contatto numero = new Contatto();
                    int scelta;
                    if (contrattiVenduti != 0) {
                        posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                        if (posizione != -1) {
                            System.out.println("Vuoi modificare il numero telefonico (si = 1 | no = 0): ");
                            scelta = keyboard.nextInt();
                            keyboard.nextLine();
                            if (scelta == 1) {
                                System.out.println("Modifica numero telefonico: ");
                                numero.telefono = keyboard.nextLine();
                                gestore[posizione].telefono = numero.telefono;
                            } else {
                                System.out.println("Numero telefonico non modificato");
                            }
                        } else {
                            System.out.println("Contatto inesistente");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                case 6:
                    if (contrattiVenduti != 0)
                    {
                        posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                        if (posizione != -1)
                        {
                            contrattiVenduti = cancellazione(gestore, posizione, contrattiVenduti);
                        }
                        else
                        {
                            System.out.println("Contatto inesistente");
                        }

                    } else
                        System.out.println("Non sono ancora presenti contratti venduti");

                    break;

                case 7:
                    if(contrattiVenduti!=0){
                        System.out.println("Inserisci il saldo telefonico: ");
                        saldoInserito= keyboard.nextDouble();
                        keyboard.nextLine();

                        saldoTelefonico(gestore, saldoInserito, contrattiVenduti, keyboard);
                    }
                    break;

                case 8:
                    if(contrattiVenduti!=0){
                        telefona(keyboard, contrattiVenduti, gestore);
                    }
                    break;

                case 9:
                    if(contrattiVenduti != 0) {
                        System.out.println("Con quale ordinamento vuoi ordinare i contatti? ");
                        System.out.println("[1] SELECTION SORT");
                        System.out.println("[2] INSERTION SORT");
                        System.out.println("[3] BUBBLE SORT");
                        ordinamento = keyboard.nextInt();
                        keyboard.nextLine(); // Consuma newline

                        switch (ordinamento) {
                            case 1:
                                System.out.println("METODO DI ORDINAMENTO SELECTION SORT");
                                selectionSort(gestore, contrattiVenduti);
                                visualizza(gestore, contrattiVenduti);
                                break;
                            case 2:
                                System.out.println("METODO DI ORDINAMENTO INSERTION SORT");
                                insertionSort(gestore, contrattiVenduti);
                                visualizza(gestore, contrattiVenduti);
                                break;
                            case 3:
                                System.out.println("METODO DI ORDINAMENTO BUBBLE SORT");
                                bubbleSort(gestore, contrattiVenduti);
                                visualizza(gestore, contrattiVenduti);
                                break;
                            default:
                                System.out.println("Scelta non valida");
                                break;
                        }
                    }
                    break; // Aggiungi il break qui


                case 10:{
                    try{
                        scriviFile("archivio.csv", gestore, contrattiVenduti);
                    }catch (IOException ex){
                        System.out.println(ex.toString());
                    }

                    break;
                }
                default:
                    fine = false;
                    break;
            }
        } while (fine);
    }

    private static Contatto leggiPersona(boolean Sitel, Scanner keyboard) {
        //Sitel è true quando dobbiamo leggere
        String[] tipoC = {"Telefono","1]abitazione", "2]cellulare", "3]aziendale"};
        //Istanziato un oggetto di tipo contatto:
        Contatto persona = new Contatto();
        System.out.println("\nInserisci il nome: ");
        persona.nome = keyboard.nextLine();
        System.out.println("\nInserisci il cognome: ");
        persona.cognome = keyboard.nextLine();

        if (Sitel) {
            System.out.println("\nInserisci il numero di telefono: ");
            persona.telefono = keyboard.nextLine();  //Vado a leggere il numero di telefono
            //I valori assegnati all'attributo sono compresi nel range
            switch (menu(tipoC, keyboard)) {
                case 1 -> persona.tipo = tipoContratto.abitazione;
                case 2 -> persona.tipo = tipoContratto.cellulare;
                default -> persona.tipo = tipoContratto.aziendale;

            }
        }

        return persona;
    }

    private static boolean ricerca(Contatto[] gestore, Contatto contatto, int contrattiVenduti) {
        //Controllo se il nome e il cognome del contatto e ugale al nome e cogome del gestore
        boolean ricerca = false;

        for (int i = 0; i < contrattiVenduti; i++) {
            if (contatto.nome.equals(gestore[i].nome) && contatto.cognome.equals(gestore[i].cognome)) {
                ricerca = true;
            }
        }
        return ricerca;
    }

    private static int RicercaIndex(Contatto[] gestore, Contatto ricerca, int contrattiVenduti) {

        int indice = -1;

        for (int i = 0; i < contrattiVenduti; i++) {
            if (ricerca.nome.equals(gestore[i].nome) && ricerca.cognome.equals(gestore[i].cognome)) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    private static void visualizza(Contatto [] gestore, int contrattiVenduti){

        for(int i=0 ; i<contrattiVenduti; i++){
            System.out.println(gestore[i].stampa());
        }

    }

    public static int cancellazione(Contatto[] gestore, int posizione, int contrattiVenduti) {
        if (posizione != gestore.length - 1)
            for (int i = posizione; i < contrattiVenduti - 1; i++)
                gestore[i] = gestore[i+1];
        return --contrattiVenduti;
    }

    private static void saldoTelefonico(Contatto[] gestore, double saldoInserito, int contrattiVenduti, Scanner keyboard){
        String nomeSaldo, cognomeSaldo;
        boolean verifica=false;

        System.out.println("Inserisci il nome del contatto: ");
        nomeSaldo= keyboard.nextLine();
        System.out.println("Inserisci il cognome del contatto: ");
        cognomeSaldo= keyboard.nextLine();

        for (int i = 0; i < contrattiVenduti; i++) {
            verifica=true;

            if (nomeSaldo.equals(gestore[i].nome) && cognomeSaldo.equals(gestore[i].cognome)) {
                gestore[i].saldo= gestore[i].saldo+saldoInserito;
                System.out.println("Il tuo saldo è: "+gestore[i].saldo+"💶");
            }
        }

        if (!verifica) {
            System.out.println("Il contatto non è presente");
        }
    }

    private static void telefona(Scanner keyboard, int contrattiVenduti, Contatto[] gestore) {
        String numeroDaTelefonare;
        double saldoPerTelefonare;
        boolean verifica = true;

        System.out.println("Inserisci il numero da telefonare: ");
        numeroDaTelefonare = keyboard.nextLine();

        System.out.println("Inserisci il prezzo con cui vuoi telefonare: ");
        saldoPerTelefonare = keyboard.nextInt();

        for (int i = 0; i < contrattiVenduti; i++) {
            verifica = true;

            if (numeroDaTelefonare.equals(gestore[i].telefono)) {
                gestore[i].saldo = gestore[i].saldo - saldoPerTelefonare;
                if (gestore[i].saldo < 0) {
                    System.out.println("Il saldo non è sufficiente!");
                    break;
                } else {
                    System.out.println("Chiamata in corso...");
                    System.out.println("Il tuo saldo rimanente è: " + gestore[i].saldo + "💶");
                }
            }
        }

        if (!verifica) {
            System.out.println("Il contatto non è presente");
        }
        keyboard.nextLine();
    }


    private static void selectionSort(Contatto[] gestore, int contrattiVenduti) {
        for (int i = 0; i < contrattiVenduti - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < contrattiVenduti; j++) {
                if (gestore[j].cognome.compareTo(gestore[minIdx].cognome) < 0 ||
                        (gestore[j].cognome.equals(gestore[minIdx].cognome) && gestore[j].nome.compareTo(gestore[minIdx].nome) < 0)) {
                    minIdx = j;
                }
            }
            // Scambia l'elemento minimo con l'elemento corrente
            Contatto temp = gestore[minIdx];
            gestore[minIdx] = gestore[i];
            gestore[i] = temp;
        }
    }


    private static void insertionSort(Contatto[] gestore, int contrattiVenduti) {
        for (int i = 1; i < contrattiVenduti; i++) {
            Contatto key = gestore[i];
            int j = i - 1;
            while (j >= 0 && (gestore[j].cognome.compareTo(key.cognome) > 0 ||
                    (gestore[j].cognome.equals(key.cognome) && gestore[j].nome.compareTo(key.nome) > 0))) {
                gestore[j + 1] = gestore[j];
                j = j - 1;
            }
            gestore[j + 1] = key;
        }
    }




    private static void bubbleSort(Contatto[] gestore, int contrattiVenduti) {
        boolean swapped;
        for (int i = 0; i < contrattiVenduti - 1; i++) {
            swapped = false;
            for (int j = 0; j < contrattiVenduti - i - 1; j++) {
                if (gestore[j].cognome.compareTo(gestore[j + 1].cognome) > 0 ||
                        (gestore[j].cognome.equals(gestore[j + 1].cognome) && gestore[j].nome.compareTo(gestore[j + 1].nome) > 0)) {
                    // Scambia gestore[j] e gestore[j + 1]
                    Contatto temp = gestore[j];
                    gestore[j] = gestore[j + 1];
                    gestore[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Se non ci sono stati scambi, l'array è già ordinato
        }
    }



    private static void scriviFile(String fileName, Contatto[] gestore, int contrattivenduti)throws IOException{
        FileWriter out=new FileWriter(fileName);    //out è come se fosse una variabile

        for(int i=0; i<contrattivenduti; i++)
            out.write(gestore[i].toString()+"\r\n");    //\r\n serve per mettere i dati nelle righe     //ovviamente out.write() è all'interno del for. Non ho messo le {} perchè il for contiene una sola istruzione

        out.flush();    //svuoto il buffer
        out.close();    //chiudo il file
    }

    private static void leggiFile(){

    }

}

/*
PER IMPORTARE E CREARE COLONNE DIVERSE PER I DATI:
DATI
DA TESTO
ANDARE SULLA CARTELLA DEL FILE JAVA
CLICCARE SUL FILE EXCEL
IMPORTA
SCEGLIERE DAI DUE CERCHIETTI Delimitato
AVANTI
TRAI I QUADRATINI TOGLIERE TABULAZIONE (di default) E SELEZIONARE VIRGOLA
AVANTI
FINE
SELEZIONARE LA CELLA A1
 */
/*
Questo programma, realizzato in Java, gestisce un elenco di contatti per un'azienda telefonica. Si possono inserire nuovi contatti con nome, 
cognome e numero di telefono. E' possibile anche visualizzare, cercare e modificare i contatti esistenti. Inoltre, si ha la possibilità di 
cancellare i contatti, gestire il saldo telefonico e effettuare chiamate telefoniche. Il programma offre anche la funzionalità di
ordinare i contatti per nome e cognome utilizzando diversi algoritmi di ordinamento. Infine, si può salvare l'elenco dei contatti 
su file per il recupero futuro.*/