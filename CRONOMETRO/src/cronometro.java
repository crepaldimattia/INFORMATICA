//MODIFICARE COMMENDI E I/O

import java.util.Scanner;
public class cronometro {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        //variable declaration and initialization
        String partenza = "No";
        int secondi = 0;
        int minuti = 0;

        //written output
        System.out.print("Il cronometro arriva fino a 60 minuti");
        System.out.print("Scrivi 'Si' per partire: ");
        partenza = keyboard.nextLine();

        //method CrlScr
        ClrScr();

        //for loop
        for (int i=0; i<=3600; i++) {

            //if seconds =60
            if(secondi==60) {
                secondi = 0;
                minuti= minuti +1;
                System.out.println(minuti + ".0");
                //method CrlScr
                ClrScr();
                //method Wait
                Wait();
            } else {
                secondi = secondi + 1;
                System.out.println(minuti + "." + secondi);
                //method CrlScr
                ClrScr();
                //method Wait
                Wait();
            }
        }
    }

    //characteristics method Wait
    private static void Wait() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //characteristics method CrlScr
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
