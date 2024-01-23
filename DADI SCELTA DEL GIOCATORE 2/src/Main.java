import java.util.*;

public class Main {
    public static void main(String[] args) {
        //creation keyboard
        Scanner keyboard = new Scanner(System.in);

        //initial output
        String[] opzioni = {"=== Gioco Dadi === ", "[1]-Sfida tra due giocatori", "[2] Sfida contro il computer", "[3] Exit "};
        //method Menu
        System.out.println(Menu(opzioni, keyboard));

    }

    //characteristics method Menu
    private static int Menu(String opzioni[], Scanner keyboard) {
        //variable declaration and initialization
        int scelta=0;
        //do-while loop
        do {
            //method ClrScr
            ClrScr();

            //output
            System.out.println("-----------------------------");
            System.out.println(opzioni[0]);
            System.out.println("-----------------------------");
            //for loop to see the options menu
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            //input
            scelta = keyboard.nextInt();

            //result
            if (scelta == 1) {
                Random();
            } else if (scelta == 2) {
                Random2();
            }else if(scelta==3){
                System.out.println("Chiusura...");
            }
            else if ((scelta < 1) || (scelta > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
            }
        }
        while (scelta<1 || scelta>4);

        return scelta;
    }


    //method characteristics CrlScr
    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method characteristics Random
    private static void Random() {
        int giocatore1, giocatore2;
        Random casuale1 = new Random();

        System.out.println("SFIDA TRA DUE GIOCATORI");

        giocatore1 = casuale1.nextInt(0, 6) + 1;
        System.out.println("GIOCATORE 1: " + giocatore1);

        Random casuale2 = new Random();

        giocatore2 = casuale2.nextInt(0, 6) + 1;
        System.out.println("GIOCATORE 2: " + giocatore2);


        if (giocatore1 > giocatore2) {
            System.out.println("HA VINTO IL GIOCATORE 1!");
        } else if (giocatore1 < giocatore2) {
            System.out.println("HA VINTO IL GIOCATORE 2!");
        } else if (giocatore1 == giocatore2) {
            System.out.println("PARITA'!");
        }
    }

    //method characteristics Random2
    private static void Random2() {
        int giocatore3, giocatorePC;
        Random casuale3 = new Random();
        System.out.println("SFIDA CONTRO IL COMPUTER");
        giocatore3 = casuale3.nextInt(0, 6) + 1;
        System.out.println("GIOCATORE: " + giocatore3);


        Random PC = new Random();
        giocatorePC = PC.nextInt(0, 6) + 1;
        System.out.println("PC: " + giocatorePC);

        if (giocatore3 > giocatorePC) {
            System.out.println("HAI VINTO!");
        } else if (giocatore3 < giocatorePC) {
            System.out.println("HA VINTO IL PC!");
        } else if (giocatore3 == giocatorePC) {
            System.out.println("PARITA'!");
        }
    }
}