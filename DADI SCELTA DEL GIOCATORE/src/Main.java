import java.util.*;

public class Main {
    public static void main(String[] args) {

        //dichiarazione e inizializzazione delle variabili
        int scelta = 0;
        Scanner keyboard = new Scanner(System.in);
        boolean exit = true;

        //do-while loop
        do {
            //method Menu
            Menu();
            //input
            scelta = keyboard.nextInt();

            //switch-case
            switch (scelta) {
                //case 1
                case 1: {

                    //output
                    System.out.println("SFIDA TRA DUE GIOCATORI");
                    //method Random
                    Random();

                    break;
                }

                //case 2
                case 2: {
                    //output
                    System.out.println("SFIDA CONTRO IL PC");

                    //method Random2
                    Random2();

                    break;

                }
                //case 3
                case 3: {
                    exit = false;
                    break;
                }
                //if the choices are wrong
                default:
                    System.out.println("Scelta errata ");
                    break;
            }
        } while (exit);

        //method CrlScr
        ClrScr();

    }

    //method characteristics menu
    private static void Menu() {
        System.out.println("=== APP Gara Dadi ===");
        System.out.println("\n");
        System.out.println("[1] Sfida tra due giocatori");
        System.out.println("[2]-Sfida contro il computer");
        System.out.println("[3]-Fine");

    }

    //method characteristics CrlScr
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method characteristics Random
    private static void Random(){
        int giocatore1, giocatore2;
        Random casuale1 = new Random();

        giocatore1 = casuale1.nextInt(0, 6) + 1;
        System.out.println("GIOCATORE 1: " +giocatore1);

        Random casuale2 = new Random();

        giocatore2 = casuale2.nextInt(0, 6) + 1;
        System.out.println("GIOCATORE 2: " +giocatore2);


        if (giocatore1 > giocatore2) {
            System.out.println("HA VINTO IL GIOCATORE 1!");
        } else if (giocatore1 < giocatore2) {
            System.out.println("HA VINTO IL GIOCATORE 2!");
        } else if (giocatore1 == giocatore2) {
            System.out.println("PARITA'!");
        }
    }

    //method characteristics Random2
    private static void Random2(){
        int giocatore3, giocatorePC;
        Random casuale3 = new Random();
        giocatore3 = casuale3.nextInt(0, 6) + 1;
        System.out.println("GIOCATORE: " +giocatore3);


        Random PC = new Random();
        giocatorePC = PC.nextInt(0, 6) + 1;
        System.out.println("PC: " +giocatorePC);

        if (giocatore3 > giocatorePC) {
            System.out.println("HAI VINTO!");
        } else if (giocatore3 < giocatorePC) {
            System.out.println("HA VINTO IL PC!");
        } else if (giocatore3 == giocatorePC) {
            System.out.println("PARITA'!");
        }
    }

}