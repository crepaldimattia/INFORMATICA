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
        ////variable declaration
        String r1, r2;
        int giocatore1, giocatore2;
        Random casuale1 = new Random();
        Scanner nome1 = new Scanner(System.in);

        //output
        System.out.println("SFIDA TRA DUE GIOCATORI");
        //I take the name as input of player 1
        System.out.println("Quel è il tuo nome? ");
        r1=nome1.nextLine();
        //random+output
        giocatore1 = casuale1.nextInt(0, 6) + 1;
        System.out.println(r1+ "=" + giocatore1);



        Random casuale2 = new Random();
        Scanner nome2=new Scanner(System.in);
        //I take the name as input of player 2
        System.out.println("Qual è il tuo nome? ");
        r2=nome2.nextLine();
        ////random+output
        giocatore2 = casuale2.nextInt(0, 6) + 1;
        System.out.println(r2+ "=" + giocatore2);

        //result
        if (giocatore1 > giocatore2) {
            System.out.println("IL VINCITORE E': " +r1);
        } else if (giocatore1 < giocatore2) {
            System.out.println("IL VINCITORE E': " +r2);
        } else if (giocatore1 == giocatore2) {
            System.out.println("PARITA'!");
        }
    }

    //method characteristics Random2
    private static void Random2() {
        //declaration of variabiles
        String r3;
        int giocatore3, giocatorePC;

        Random casuale3 = new Random();
        Scanner nome3=new Scanner(System.in);
        //output
        System.out.println("SFIDA CONTRO IL COMPUTER");
        giocatore3 = casuale3.nextInt(0, 6) + 1;

        //I take the name as input of player
        System.out.println("Qual è il tuo nome? ");
        r3=nome3.nextLine();
        //result player
        System.out.println(r3+ "=" + giocatore3);


        Random PC = new Random();
        //random number of PC
        giocatorePC = PC.nextInt(0, 6) + 1;
        System.out.println("Computer: " + giocatorePC);

        //result
        if (giocatore3 > giocatorePC) {
            System.out.println(r3+ ", hai vinto!");
        } else if (giocatore3 < giocatorePC) {
            System.out.println("HA VINTO IL COMPUTER!");
        } else if (giocatore3 == giocatorePC) {
            System.out.println("PARITA'!");
        }
    }


}