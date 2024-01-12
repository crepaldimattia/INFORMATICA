import java.util.Scanner;

public class esercizioQuasiNatalizio {
    public static void main(String[] args) {
        Scanner keyboard= new Scanner(System.in);

        //declaration of the variable
        int scelta;

        //do-while loop
        do {
            //method PrintMenu
            PrintMenu();

            //I acquire what work the program must do
            System.out.print("Inserire il lavoro che vuoi svolgere: ");
            scelta=keyboard.nextInt();

        } while (scelta<1 || scelta>3);

        //choice of work
        switch (scelta) {
            case 1:
                Lavoro1(); break;
            case 2:
                Lavoro2(); break;
            case 3:
                Lavoro3(); break;
        }
    }

    //characteristics method PrintMenu()
    private static void PrintMenu() {

        // I print the menu on the screen
        System.out.println("""
                \n\n
                |*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|
                *                ~ BENVENUTI ~                  *
                |    Lavoro 1 = UOVA            - Scrivi '1'    |
                *    Lavoro 2 = HAMBURGHERIA    - Scrivi '2'    *
                |    Lavoro 3 = INCASSI         - Scrivi '3'    |
                *                                               *
                |*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|
                """
        );

    }

    //characteristics method Lavoro1()
    private static int Lavoro1() {
        Scanner in = new Scanner(System.in);

        //declaration and initialization of variables
        int prezzoUovo = 4;
        int incasso = 0;
        String _pause;

        System.out.println("hai scelto lavoro 1");

        //do-while loop
        do {
            //I update the collection
            incasso = incasso + prezzoUovo;

            System.out.println("Premere invio se vuoi continuare oppure premere q per uscire");
            _pause = in.nextLine();

            // if the user presses q then the last loop is not counted
            if (_pause.equals("q")) incasso -= prezzoUovo;
        }
        while(!_pause.equals("q"));

        return incasso;
    }

    //characteristics method Lavoro2()
    private static int Lavoro2() {
        Scanner scanner = new Scanner(System.in);

        ///declaration of the variable
        int totaleScontato;
        int numeroHamburgerVegani = 13, numeroHamburgerRenna = 26, numeroBevandeAnalcoliche = 2, numeroBevandeAlcoliche = 4;
        int prezzoTot = 0;

        // I'll have the number of vegan burgers entered
        System.out.print("Inserisci il numero di hamburger vegani: ");
        numeroHamburgerVegani = scanner.nextInt();

        // I'll have the number of reindeer burgers entered
        System.out.print("Inserisci il numero di hamburger di renna: ");
        numeroHamburgerRenna = scanner.nextInt();

        // Let me enter the number of alcoholic drinks
        System.out.print("Inserisci il numero di bevande analcoliche: ");
        numeroBevandeAnalcoliche = scanner.nextInt();

        // I have the number of non-alcoholic drinks entered
        System.out.print("Inserisci il numero di bevande alcoliche: ");
        numeroBevandeAlcoliche = scanner.nextInt();

        // Calculation of the price to pay
        prezzoTot = (numeroHamburgerVegani * 13) + (numeroHamburgerRenna * 26) + (numeroBevandeAnalcoliche * 2) + (numeroBevandeAlcoliche * 5);

        // If the price is greater than 10 euros I apply the discount
        if (prezzoTot > 10.0) {
            double sconto = prezzoTot * 0.15;
            prezzoTot -= sconto;
            System.out.println("Totale scontato: " + prezzoTot + " euro");
        }
        else {
            System.out.println("Totale: " + prezzoTot + " euro");
        }

        return prezzoTot;
    }

    //characteristics method Lavoro3()
    private static void Lavoro3() {

        int totale = Lavoro1() + Lavoro2();

        // I print the receipt
        System.out.println("Il totale da pagare e': " + totale);
    }

}