import java.util.Scanner;
import java.util.Random;

public class FacceDado {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random faccia = new Random();

        //declaration and initialization of variables
        int valoreFaccia1=0;
        int valoreFaccia2=0;
        int valoreFaccia;

        //PLAYER 1
        System.out.println("GIOCATORE 1");
        //ciclo for
        for(int i = 1; i <= 7; i++){
            if (i == 7) {
                Wait();
                ClrScr();
                System.out.println("E' uscito: ");
                valoreFaccia1 = faccia.nextInt(0, 6) + 1;
            } else {
                Wait();
                ClrScr();
                valoreFaccia1 = i;
            }
            valoreFaccia=valoreFaccia1;
            FacceDado(valoreFaccia1);
        }

        //PLAYER 2
        System.out.println("GIOCATORE 2");
        //for loop
        for(int n = 1; n <= 7; n++){
            if (n == 7) {
                Wait();
                ClrScr();
                System.out.println("E' uscito: ");
                valoreFaccia2 = faccia.nextInt(0, 6) + 1;
            } else {
                Wait();
                ClrScr();
                valoreFaccia2 = n;
            }
            valoreFaccia=valoreFaccia2;
            FacceDado(valoreFaccia2);
        }

        //if for determine the winner between the two players
        if(valoreFaccia2>valoreFaccia1){
            System.out.println("HA VINTO IL GIOCATORE 2");
        }
        else if (valoreFaccia2<valoreFaccia1){
            System.out.println("HA VINTO IL GIOCATORE 1");
        }
        if(valoreFaccia2==valoreFaccia1){
            System.out.println("PARITA'");
        }
    }

    //SIDES OF THE DICE
    private static void FacceDado(int valoreFaccia) {
        //ALT + 201 ╔
        //ALT + 188 ╝
        //ALT + 187 ╗
        //ALT + 200 ╚
        //ALT + 205 ═
        //ALT + 186 ║

        switch (valoreFaccia) {
            case 1 : {
                valoreFaccia=1;
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 2 : {
                valoreFaccia=2;
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 3 : {
                valoreFaccia=3;
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 4 : {
                valoreFaccia=4;
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 5 : {
                valoreFaccia=5;
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 6 : {
                valoreFaccia=6;
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

        }
    }

    //method CrlScr
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //method Wait
    private static void Wait() {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
