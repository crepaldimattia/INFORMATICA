import java.util.Scanner;

public class modificaVinaio{
    public static void main(String[] args) {
        System.out.println("Calcolo prezzo totale del vino: ");
        Scanner scanner= new Scanner(System.in);

        //declaration and initialization of variables
        double euroLitro = 1;
        double Capacità = 1.5;
        int numeroBottiglioni=0;
        double prezzoTotale=0;
        double iva=0;
        int cliente=0;
        String risposta;
        double euroLitroBarbera=1.5;
        double euroLitroMerlot=2;
        double euroLitroLugana=1;
        int scelta=0;

        //do-while loop
        do{
            cliente=cliente+1;
            System.out.println("Digita 1 per Barbera, 2 Lugana e 3 Merlot. Altri caratteri non valgono! ");
            scelta= scanner.nextInt();


            //choice types of wine
            //if choice =1
            if(scelta==1){
                System.out.println("Hai scelto Barbera!");

                //insert number of bottles
                System.out.println("Inserisci il numero dei bottiglioni: ");
                numeroBottiglioni= scanner .nextInt();

                //calculations
                prezzoTotale = numeroBottiglioni * Capacità * euroLitroBarbera;
                iva = prezzoTotale / 100 * 21;
            }

            //if choice=2
            if(scelta==2){
                System.out.println("Hai scelto Lugana!");

                //insert number of bottles
                System.out.println("Inserisci il numero dei bottiglioni: ");
                numeroBottiglioni= scanner .nextInt();

                //calculations
                prezzoTotale = numeroBottiglioni * Capacità * euroLitroLugana;
                iva = prezzoTotale / 100 * 21;
            }

            //if choice =3
            if(scelta==3){
                System.out.println("Hai scelto Merlot!");

                //insert number of bottles
                System.out.println("Inserisci il numero dei bottiglioni: ");
                numeroBottiglioni= scanner .nextInt();

                //calculations
                prezzoTotale = numeroBottiglioni * Capacità * euroLitroMerlot;
                iva = prezzoTotale / 100 * 21;
            }

            else{
                System.out.println("Carattere non valido! \n");
            }




            //final receipt
            System.out.println("Numero bottiglioni acquistati: \n" + numeroBottiglioni);
            System.out.println("Il prezzo totale di vendita: \n" + prezzoTotale);
            System.out.println("L'iva: \n" + iva);
            System.out.println("Prezzo totale con iva: " + prezzoTotale);


            System.out.println("C'è un'altro cliente? Digita S/N");
            risposta=scanner.nextLine().toUpperCase();
            risposta=scanner.nextLine().toUpperCase();

        }while(risposta.equals("S"));

        //output number of customers
        System.out.println("Numero clienti: "+cliente);
    }

}

