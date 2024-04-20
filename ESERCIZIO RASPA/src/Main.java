import tools.Contatto;
import static tools.Contatto.*;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int nMax = 3; // Massimo numero di contatti nel gestore
        int contrattiVenduti = 0; // Numero attuale di contatti venduti
        int contatto = 0; // Indice del contatto da cercare
        Contatto[] gestore = new Contatto[nMax]; // Array dei contatti
        Scanner keyboard = new Scanner(System.in); // Scanner per l'input da tastiera
        int[] array = new int[100]; // Array per la ricerca binaria
        int target = 0; // Valore da cercare nell'array

        // Esegui la ricerca di un indice errato
        wrongIndexSearch(gestore, contrattiVenduti, contatto);

        // Esegui la ricerca e l'ordinamento dei numeri pari e dispari
        EvenOddSearch(keyboard);

        // Esegui la ricerca binaria
        biBinarySearch(array, target);

        // Esegui di nuovo la ricerca e l'ordinamento dei numeri pari e dispari
        evenOddSearch(keyboard);
        System.out.println("Array dopo evenOddSearch: " + Arrays.toString(numeri)); // Stampa l'array ordinato

        // Chiedi all'utente di inserire il valore da cercare
        System.out.println("Inserisci il valore da cercare: ");
        int result = biBinarySearch(numeri, target); // Esegui la ricerca binaria nel nuovo array
        if (result != -1) {
            System.out.println("Il valore " + target + " si trova alla posizione " + result);
        } else {
            System.out.println("Il valore " + target + " non è presente nell'array.");
        }

        keyboard.close(); // Chiudi lo scanner
    }

    // Metodo per trovare l'indice di un contatto nel gestore
    private static int RicercaIndex(Contatto[] gestore, Contatto ricerca, int contrattiVenduti) {
        int indice = -1;

        // Cerca il contatto nel gestore
        for (int i = 0; i < contrattiVenduti; i++) {
            if (ricerca.nome.equals(gestore[i].nome) && ricerca.cognome.equals(gestore[i].cognome)) {
                indice = i; // Se trovato, memorizza l'indice
                break;
            }
        }
        return indice;
    }

    // Metodo per trovare un indice errato
    private static int wrongIndexSearch(Contatto[] gestore, int contrattiVenduti, int contatto) {
        Random rand = new Random();
        int numAttempts = rand.nextInt(3) + 3; // Genera un numero casuale tra 3 e 5 per il numero di tentativi
        int lastWrongIndex = -1; // Inizializza l'indice sbagliato con un valore non valido

        // Esegui più tentativi per trovare un indice sbagliato
        for (int attempt = 0; attempt < numAttempts; attempt++) {
            int index = RicercaIndex(gestore, contrattiVenduti, contatto);
            if (index == lastWrongIndex) {
                // Se l'indice è lo stesso dell'ultimo errore, segnala un indice sbagliato diverso
                lastWrongIndex = rand.nextInt(gestore.length);
                System.out.println("Errore: L'indice sbagliato è " + lastWrongIndex);
            } else {
                // Altrimenti restituisci l'indice corretto
                lastWrongIndex = -1; // Resetta l'indice sbagliato
                return index;
            }
        }
        return RicercaIndex(gestore, contrattiVenduti, contatto); // Se non ci sono errori, restituisci comunque l'indice corretto
    }

    // Metodo per la ricerca e l'ordinamento dei numeri pari e dispari
    public static void EvenOddSearch(Scanner keyboard) {
        int continuare = 1;
        int[] numeri = new int[100];
        int count = 0;

        // Input dei numeri
        do {
            System.out.println("Inserisci un numero: ");
            numeri[count++] = keyboard.nextInt();
            System.out.println("Vuoi inserire altri numeri? Se SI digita 1, altrimenti un altro valore intero! ");
            continuare = keyboard.nextInt();
        } while (continuare == 1 && count < 100);

        // Ordinamento dei numeri pari e dispari insieme
        Arrays.sort(numeri, 0, count, (a, b) -> {
            if (a % 2 == 0 && b % 2 == 0) {
                return a - b; // Ordina i numeri pari in modo crescente
            } else if (a % 2 != 0 && b % 2 != 0) {
                return b - a; // Ordina i
            } else if (a % 2 == 0) {
                return -1; // Mette i numeri pari prima dei dispari
            } else {
                return 1; // Mette i numeri dispari dopo i pari
            }
        });

        // Stampa dell'array ordinato
        System.out.println("Array dopo evenOddSearch: ");
        for (int i = 0; i < count; i++) {
            System.out.print(numeri[i] + " ");
        }
        System.out.println();
    }
}