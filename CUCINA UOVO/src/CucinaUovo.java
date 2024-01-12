
import java.util.Scanner;

public class CucinaUovo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String _pause; // Character for pause


        //start
        System.out.println("Premere invio per cucnare l'uovo: ");
        System.out.println("""
                  ,'"`.
                 /     \\
                :       :
                :       :
                 `.___,'
                """);

        System.out.println();
        _pause = scanner.nextLine();

        //unboiled egg
        UovoNonBollito();{

                //method CrlScr
                ClrScr();
                //method Wait
                Wait();


        }

        //for loop
        for (int i = 180; i >=0; i--) {
            //boiling egg
            UovoCheBolle();

            System.out.println("\n\nTimer: " + i);
            //method Wait
            Wait(1000);
            //method CrlScr
            ClrScr();
        }

        //cooked egg
        UovoCotto();

        System.out.println("UOVO COTTO!!!!!");
    }

    //characteristics method UovoNonBollito
    private static void UovoNonBollito() {
    }

    //characteristics method UovoCheBolle
    private static void UovoCheBolle() {

        System.out.println("""
                  °  ,'"`. °   °
                °   /     \\ °
               °   :       :  °
                 ° :       : °
              °   ° `.___,' °   °
                """);

        /*

         */
    }

    //characteristics method UovoCotto
    private static void UovoCotto() {

        System.out.println("""
                   ,'"`.
                   /  _  \\
                  : /   \\ :
                  : \\___/ :
                   `.___,'
                """);
    }

    //characteristics method Wait
    private static void Wait(int milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    ////characteristics method ClrScr
    private static void ClrScr() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    //characteristics method Wait
    private static void Wait() {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
