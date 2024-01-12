import java.util.*;



public class Main {
    public static void main(String[] args) {
        String studente;

        //RANDOM
        Random casuale = new Random();
        /*for(int i=0; i<10; i++){
            System.out.println(casuale.nextInt(0, 20)+1); //nextInt() --> ORIGIN, BOUNT

        }*/

        //SWITCH CASE
        //Generiamo un valore casuale (1-20) corrispondente al numero assegnato agli studenti della classe 3E --> We generate a random value (1-20) corresponding to the number assigned to the students of class 3E
        //System.out.println(casuale.nextInt(0, 20)+1);
        switch (casuale.nextInt(0, 9) + 1) { //selettore= variabile all'interno del costruttore   //Posso definire byte, short, chat, int, string e i numeratori;
            //SEMPRE DA O AL NUMERO +1 DEL NUMERO STABILITO E POI +1 --> ALWAYS FROM OR TO THE NUMBER +1 OF THE ESTABLISHED NUMBER AND THEN +1

            case 1:         //Con il case non si posono definire espressioni booleane --> //Boolean expressions cannot be defined with case
                studente = "Mattia Albieri";
                break;

            case 2:
                studente = "Filippo Barchi";
                break;

            case 3:
                studente = "Noemi Basaglia";
                break;

            case 4:
                studente = "Francesco Bego";
                break;

            case 5:
                studente = "Stefano Boscolo";
                break;

            case 6:
                studente = "Daniele Chiarion";
                break;


            case 7:
                studente = "Eleonora Cosmi";
                break;

            case 8:
                studente = "Mattia Crepaldi";
                break;


            default:
                studente = "Oggi non interroghiamo";
                break;

        }

        //name of the student who left
        System.out.println("E' uscito il nome di: " + studente);
    }

}


