import static tools.utility.*;
import java.util.Scanner;
import java.io.*;   //serve per il file
public class Main {
    public static void main(String[] args) {
        String[] operazioni = {
                "VODAFONE",
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
                "[11] Carica file",
                "[12] Fine"
        };

        boolean Sitel = true;
        final int nMax = 3;
        int contrattiVenduti = 0, contrattiVendutiNascosti=0;
        int posizione;
        int ordinamento=0;
        Contatto[] gestore = new Contatto[nMax];
        int contaElementi=0;
        String password, passwordUtente;
        int cnon=0, visualizzaContattiNascosti=0;

        Contatto[] nascosti=new Contatto[100];

        Scanner keyboard = new Scanner(System.in);

        double saldoInserito=0;
        boolean fine = true;


        System.out.println("Inserisci la password: ");
        password= keyboard.nextLine();

        do {
            switch (menu(operazioni, keyboard)) {
                case 1:
                    if (contrattiVenduti < nMax) {
                        System.out.println("Vuoi mettere il tuo contatto come nascosto? Digita 1 per SI o un altro numero per NO");
                        cnon = keyboard.nextInt();
                        keyboard.nextLine(); // Consuma newline lasciato da nextInt()
                        if (cnon == 1) {
                            nascosti[contrattiVendutiNascosti] = leggiPersona(Sitel, keyboard);
                            contrattiVendutiNascosti++;
                        } else {
                            gestore[contrattiVenduti] = leggiPersona(Sitel, keyboard);
                            contrattiVenduti++;
                        }
                    } else {
                        System.out.println("Non ci sono più contratti da vendere");
                    }
                    break;

                case 2: {
                    if (contrattiVenduti != 0 || contrattiVendutiNascosti != 0) {
                        System.out.println("Vuoi vedere i contatti nascosti? Se si digita 1: ");
                        visualizzaContattiNascosti = keyboard.nextInt();
                        keyboard.nextLine();

                        if (visualizzaContattiNascosti == 1) {
                            System.out.println("Inserisci la password: ");
                            passwordUtente = keyboard.nextLine();

                            if (password.equals(passwordUtente)) {
                                visualizzaNascosti(nascosti, contrattiVendutiNascosti);
                            } else {
                                System.out.println("La password è errata!");
                            }
                        }

                        visualizza(gestore, contrattiVenduti);
                    } else {
                        System.out.println("Non ci sono contratti\n");
                    }
                    break;
                }


                case 3: {
                    if (contrattiVenduti != 0 || contrattiVendutiNascosti != 0) {
                        // Ci sono contratti venduti o nascosti
                        // lettura, ricerca, visualizzazione
                        System.out.println("Vuoi vedere i contatti nascosti? Se si digita 1: ");
                        visualizzaContattiNascosti = keyboard.nextInt();
                        keyboard.nextLine(); // Consuma il newline dopo l'intero

                        if (visualizzaContattiNascosti == 1) {
                            System.out.println("Inserisci la password: ");
                            passwordUtente = keyboard.nextLine();
                            if (password.equals(passwordUtente)) {
                                if (ricerca(nascosti, leggiPersona(false, keyboard), contrattiVendutiNascosti)) {
                                    System.out.println("Il contatto nascosto esiste");
                                } else {
                                    System.out.println("Il contatto nascosto non esiste");
                                }
                            } else {
                                System.out.println("La password è errata!");
                            }
                        } else {
                            if (ricerca(gestore, leggiPersona(false, keyboard), contrattiVenduti)) {
                                System.out.println("Il contatto esiste");
                            } else {
                                System.out.println("Il contatto non esiste");
                            }
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti o nascosti");
                    }
                    break;
                }

                case 4: {
                    if (contrattiVenduti != 0 || contrattiVendutiNascosti != 0) {
                        // Ci sono contratti venduti o nascosti
                        System.out.println("Vuoi vedere i contatti nascosti? Se si digita 1: ");
                        visualizzaContattiNascosti = keyboard.nextInt();
                        keyboard.nextLine(); // Consuma il newline dopo l'intero

                        if (visualizzaContattiNascosti == 1) {
                            System.out.println("Inserisci la password: ");
                            passwordUtente = keyboard.nextLine();
                            if (password.equals(passwordUtente)) {
                                posizione = RicercaIndex(nascosti, leggiPersona(false, keyboard), contrattiVendutiNascosti);
                                if (posizione != -1) {
                                    System.out.println(nascosti[posizione].cognome + " " + nascosti[posizione].nome + ": " + nascosti[posizione].telefono);
                                } else {
                                    System.out.println("Contatto nascosto inesistente");
                                }
                            } else {
                                System.out.println("La password è errata!");
                            }
                        } else {
                            posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                            if (posizione != -1) {
                                System.out.println(gestore[posizione].cognome + " " + gestore[posizione].nome + ": " + gestore[posizione].telefono);
                            } else {
                                System.out.println("Contatto inesistente");
                            }
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti o nascosti");
                    }
                    break;
                }


                case 5:
                    Contatto numero = new Contatto();
                    int scelta;
                    if (contrattiVenduti != 0 || contrattiVendutiNascosti != 0) {
                        System.out.println("Vuoi modificare un contatto nascosto? Se si digita 1: ");
                        int modificaContattoNascosto = keyboard.nextInt();
                        keyboard.nextLine(); // Consuma il newline dopo l'intero

                        if (modificaContattoNascosto == 1) {
                            System.out.println("Inserisci la password: ");
                            passwordUtente = keyboard.nextLine();
                            if (password.equals(passwordUtente)) {
                                posizione = RicercaIndex(nascosti, leggiPersona(false, keyboard), contrattiVendutiNascosti);
                                if (posizione != -1) {
                                    System.out.println("Vuoi modificare il numero telefonico (si = 1 | no = 0): ");
                                    scelta = keyboard.nextInt();
                                    keyboard.nextLine();
                                    if (scelta == 1) {
                                        System.out.println("Modifica numero telefonico: ");
                                        numero.telefono = keyboard.nextLine();
                                        nascosti[posizione].telefono = numero.telefono;
                                    } else {
                                        System.out.println("Numero telefonico non modificato");
                                    }
                                } else {
                                    System.out.println("Contatto nascosto inesistente");
                                }
                            } else {
                                System.out.println("La password è errata!");
                            }
                        } else {
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
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti o nascosti");
                    }
                    break;
                case 6:
                    if (contrattiVenduti != 0 || contrattiVendutiNascosti != 0) {
                        System.out.println("Vuoi cancellare un contatto nascosto? Se si digita 1: ");
                        int cancellaContattoNascosto = keyboard.nextInt();
                        keyboard.nextLine(); // Consuma il newline dopo l'intero

                        if (cancellaContattoNascosto == 1) {
                            System.out.println("Inserisci la password: ");
                            passwordUtente = keyboard.nextLine();
                            if (password.equals(passwordUtente)) {
                                posizione = RicercaIndex(nascosti, leggiPersona(false, keyboard), contrattiVendutiNascosti);
                                if (posizione != -1) {
                                    contrattiVendutiNascosti = cancellazione(nascosti, posizione, contrattiVendutiNascosti);
                                } else {
                                    System.out.println("Contatto nascosto inesistente");
                                }
                            } else {
                                System.out.println("La password è errata!");
                            }
                        } else {
                            posizione = RicercaIndex(gestore, leggiPersona(false, keyboard), contrattiVenduti);
                            if (posizione != -1) {
                                contrattiVenduti = cancellazione(gestore, posizione, contrattiVenduti);
                            } else {
                                System.out.println("Contatto inesistente");
                            }
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti o nascosti");
                    }
                    break;

                case 7:
                    if (contrattiVenduti != 0 || contrattiVendutiNascosti != 0) {
                        System.out.println("Vuoi caricare il saldo su un contatto nascosto? Se sì, digita 1: ");
                        int saldoContattoNascosto = keyboard.nextInt();
                        keyboard.nextLine(); // Consuma il newline dopo l'intero

                        if (saldoContattoNascosto == 1) {
                            System.out.println("Inserisci la password: ");
                            passwordUtente = keyboard.nextLine();
                            if (password.equals(passwordUtente)) {
                                System.out.println("Inserisci il saldo telefonico: ");
                                saldoInserito = keyboard.nextDouble();
                                keyboard.nextLine();
                                saldoTelefonico(nascosti, saldoInserito, contrattiVendutiNascosti, keyboard);
                            } else {
                                System.out.println("La password è errata!");
                            }
                        } else {
                            System.out.println("Inserisci il saldo telefonico: ");
                            saldoInserito = keyboard.nextDouble();
                            keyboard.nextLine();
                            saldoTelefonico(gestore, saldoInserito, contrattiVenduti, keyboard);
                        }
                    } else {
                        System.out.println("Non ci sono contratti da caricare.");
                    }
                    break;


                case 8:
                    if (contrattiVenduti != 0 || contrattiVendutiNascosti != 0) {
                        System.out.println("Vuoi telefonare a un contatto nascosto? Se sì, digita 1: ");
                        int telefonaContattoNascosto = keyboard.nextInt();
                        keyboard.nextLine(); // Consuma il newline dopo l'intero

                        if (telefonaContattoNascosto == 1) {
                            System.out.println("Inserisci la password: ");
                            passwordUtente = keyboard.nextLine();
                            if (password.equals(passwordUtente)) {
                                telefona(keyboard, contrattiVendutiNascosti, nascosti);
                            } else {
                                System.out.println("La password è errata!");
                            }
                        } else {
                            telefona(keyboard, contrattiVenduti, gestore);
                        }
                    } else {
                        System.out.println("Non ci sono contatti da chiamare.");
                    }
                    break;


                case 9:
                    System.out.println("Con quale ordinamento vuoi ordinare i contatti? ");
                    System.out.println("[1] SELECTION SORT");
                    System.out.println("[2] INSERTION SORT");
                    System.out.println("[3] BUBBLE SORT");
                    ordinamento = keyboard.nextInt();
                    keyboard.nextLine(); // Consuma newline

                    switch (ordinamento) {
                        case 1:
                            System.out.println("METODO DI ORDINAMENTO SELECTION SORT");
                            if (contrattiVenduti > 0) {
                                selectionSort(gestore, contrattiVenduti);
                                System.out.println("Contatti visibili ordinati:");
                                visualizza(gestore, contrattiVenduti);
                            }
                            if (contrattiVendutiNascosti > 0) {
                                System.out.println("Inserisci la password per ordinare i contatti nascosti:");
                                passwordUtente = keyboard.nextLine();
                                if (password.equals(passwordUtente)) {
                                    selectionSort(nascosti, contrattiVendutiNascosti);
                                    System.out.println("Contatti nascosti ordinati:");
                                    visualizzaNascosti(nascosti, contrattiVendutiNascosti);
                                } else {
                                    System.out.println("Password errata. Impossibile ordinare i contatti nascosti.");
                                }
                            }
                            break;
                        case 2:
                            System.out.println("METODO DI ORDINAMENTO INSERTION SORT");
                            if (contrattiVenduti > 0) {
                                insertionSort(gestore, contrattiVenduti);
                                System.out.println("Contatti visibili ordinati:");
                                visualizza(gestore, contrattiVenduti);
                            }
                            if (contrattiVendutiNascosti > 0) {
                                System.out.println("Inserisci la password per ordinare i contatti nascosti:");
                                passwordUtente = keyboard.nextLine();
                                if (password.equals(passwordUtente)) {
                                    insertionSort(nascosti, contrattiVendutiNascosti);
                                    System.out.println("Contatti nascosti ordinati:");
                                    visualizzaNascosti(nascosti, contrattiVendutiNascosti);
                                } else {
                                    System.out.println("Password errata. Impossibile ordinare i contatti nascosti.");
                                }
                            }
                            break;
                        case 3:
                            System.out.println("METODO DI ORDINAMENTO BUBBLE SORT");
                            if (contrattiVenduti > 0) {
                                bubbleSort(gestore, contrattiVenduti);
                                System.out.println("Contatti visibili ordinati:");
                                visualizza(gestore, contrattiVenduti);
                            }
                            if (contrattiVendutiNascosti > 0) {
                                System.out.println("Inserisci la password per ordinare i contatti nascosti:");
                                passwordUtente = keyboard.nextLine();
                                if (password.equals(passwordUtente)) {
                                    bubbleSort(nascosti, contrattiVendutiNascosti);
                                    System.out.println("Contatti nascosti ordinati:");
                                    visualizzaNascosti(nascosti, contrattiVendutiNascosti);
                                } else {
                                    System.out.println("Password errata. Impossibile ordinare i contatti nascosti.");
                                }
                            }
                            break;
                        default:
                            System.out.println("Scelta non valida");
                            break;
                    }
                    break;





                case 10:{
                    try{
                        scriviFile("archivio.csv", gestore, contrattiVenduti);
                    }catch (IOException ex){
                        System.out.println(ex.toString());
                    }

                    break;
                }

                case 11:{
                    try{
                        contaElementi=leggiFile("archivio.csv", gestore, contrattiVenduti);
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

    private static void visualizzaNascosti(Contatto [] nascosti, int contrattiVendutiNascosti){

        for(int i=0 ; i<contrattiVendutiNascosti; i++){
            System.out.println(nascosti[i].stampa());
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

    private static void telefona(Scanner keyboard, int contrattiVenduti, Contatto[] contatti) {
        String numeroDaTelefonare;
        double saldoPerTelefonare;
        boolean verifica = false; // Modificato a false per indicare se il contatto è stato trovato

        System.out.println("Inserisci il numero da telefonare: ");
        numeroDaTelefonare = keyboard.nextLine();

        System.out.println("Inserisci il prezzo con cui vuoi telefonare: ");
        saldoPerTelefonare = keyboard.nextDouble();
        keyboard.nextLine(); // Consuma il newline dopo il double

        for (int i = 0; i < contrattiVenduti; i++) {
            if (numeroDaTelefonare.equals(contatti[i].telefono)) {
                verifica = true;

                if (contatti[i].saldo >= saldoPerTelefonare) {
                    contatti[i].saldo -= saldoPerTelefonare;
                    System.out.println("Chiamata in corso...");
                    System.out.println("Il tuo saldo rimanente è: " + contatti[i].saldo + "💶");
                } else {
                    System.out.println("Il saldo non è sufficiente!");
                }
                break; // Esce dal ciclo dopo aver trovato il contatto
            }
        }

        if (!verifica) {
            System.out.println("Il contatto non è presente");
        }
    }



    private static void selectionSort(Contatto[] array, int lunghezza) {
        for (int i = 0; i < lunghezza - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < lunghezza; j++) {
                if (array[j].cognome.compareTo(array[minIndex].cognome) < 0 ||
                        (array[j].cognome.equals(array[minIndex].cognome) && array[j].nome.compareTo(array[minIndex].nome) < 0)) {
                    minIndex = j;
                }
            }
            Contatto temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    private static void insertionSort(Contatto[] array, int lunghezza) {
        for (int i = 1; i < lunghezza; i++) {
            Contatto key = array[i];
            int j = i - 1;
            while (j >= 0 && (array[j].cognome.compareTo(key.cognome) > 0 ||
                    (array[j].cognome.equals(key.cognome) && array[j].nome.compareTo(key.nome) > 0))) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    private static void bubbleSort(Contatto[] array, int lunghezza) {
        boolean swapped;
        for (int i = 0; i < lunghezza - 1; i++) {
            swapped = false;
            for (int j = 0; j < lunghezza - i - 1; j++) {
                if (array[j].cognome.compareTo(array[j + 1].cognome) > 0 ||
                        (array[j].cognome.equals(array[j + 1].cognome) && array[j].nome.compareTo(array[j + 1].nome) > 0)) {
                    // Scambia array[j] e array[j + 1]
                    Contatto temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
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

        out.flush();    //svuoto il buffer e carico i dati sul disco
        out.close();    //chiudo il file
    }

    public static int leggiFile(String fileName, Contatto[] gestore, int contaElementi) throws IOException {
        FileReader reader = new FileReader(fileName);
        Scanner input = new Scanner(reader);

        while (input.hasNextLine() && contaElementi < gestore.length) {
            String lineIn = input.nextLine();
            String[] vettAttributi = lineIn.split(",");

            Contatto persona = new Contatto();
            persona.nome = vettAttributi[0];
            persona.cognome = vettAttributi[1];
            persona.telefono = vettAttributi[2];

            switch (vettAttributi[3]) {
                case "abitazione":
                    persona.tipo = tipoContratto.abitazione;
                    break;
                case "cellulare":
                    persona.tipo = tipoContratto.cellulare;
                    break;
                case "aziendale":
                    persona.tipo = tipoContratto.aziendale;
                    break;
                default:
                    // Handle invalid contract type (optional)
                    break;
            }

            persona.saldo = Double.parseDouble(vettAttributi[4]);
            gestore[contaElementi++] = persona;
        }

        return contaElementi; // Return the actual number of contacts read
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