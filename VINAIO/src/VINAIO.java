import java.util.Scanner;

public class VINAIO {
    public static void main(String[] args) {
        System.out.println("Calcolo prezzo totale del vino: ");
        Scanner scanner= new Scanner(System.in);

        //declaration and initialization of variables
        double euroLitro = 1;
        double Capacità = 1.5;
        int numeroBottiglioni=0;
        double prezzoTotale=0;
        double iva=0;

        //insert number of bottles
        System.out.println("Scrivi il numero dei bottiglioni: ");
        numeroBottiglioni= scanner .nextInt();


        //calculations
        prezzoTotale = numeroBottiglioni * Capacità * euroLitro;
        iva = prezzoTotale / 100 * 21;

        //final receipt
        System.out.println("Numero bottiglioni acquistati: \n" + numeroBottiglioni);
        System.out.println("Il prezzo totale di vendita: \n" + prezzoTotale);
        System.out.println("L'iva: \n" + iva);
        System.out.println("Prezzo totale con iva: " + prezzoTotale);

    }
}
