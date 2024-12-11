import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        //RETTANGOLO
        //dichiarazione variabili
        double base, altezza;

        //inserimento dati
        do {
            System.out.println("Inserisci la base del rettangolo: ");
            base = keyboard.nextDouble();
            System.out.println("Inserisci l'altezza del rettangolo: ");
            altezza = keyboard.nextDouble();

            if(base<0 || altezza<0)
                System.out.println("I dati devono essere positivi");
        }while (base<0||altezza<0);

        //creazione oggetto
        Rettangolo rettangolo=new Rettangolo(base,altezza);
        //stampa dell'area
        System.out.println("Area rettangolo: "+rettangolo.calcolaArea());
        //stampa perimetro
        System.out.println("Perimetro rettangolo: "+rettangolo.calcolaPerimetro());


        //QUADRATO
        //dichiarazione variabile
        double lato;
        do {
            //inserimento dati
            System.out.println("\n\nInserisci la lato del quadrato: ");
            lato = keyboard.nextDouble();

            if(lato<0)
                System.out.println("I dati devono essere positivi");
        }while (lato<0);

        //creazione oggetto
        Quadrato quadrato=new Quadrato(lato);
        //stampa dell'area
        System.out.println("Area quadrato: "+quadrato.calcolaArea());

        //TRIANGOLO RETTANGOLO
        //dichiarazione variabili
        double baseTriangolo, altezzaTriangolo;
        do {
            //inserimento dati
            System.out.println("\n\nInserisci la base del triangolo: ");
            baseTriangolo = keyboard.nextDouble();
            System.out.println("Inserisci l'altezza del triangolo: ");
            altezzaTriangolo = keyboard.nextDouble();

            if(baseTriangolo<0 || altezzaTriangolo<0)
                System.out.println("I dati devono essere positivi");
        }while (baseTriangolo<0||altezzaTriangolo<0);

        //creazione oggetto
        TriangoloRettangolo triangoloRettangolo=new TriangoloRettangolo(baseTriangolo,altezzaTriangolo);
        //stampa dell'area
        System.out.println("Area triangolo: "+triangoloRettangolo.calcolaArea());


        //CIRCONFERENZA
        //dichiarazione variabile
        double raggio;
        do {
            //inserimento dati
            System.out.println("\n\nInserisci la raggio della circonferenza: ");
            raggio = keyboard.nextDouble();

            if(raggio<0)
                System.out.println("I dati devono essere positivi");
        }while (raggio<0);

        //creazione oggetto
        Circonferenza circonferenza=new Circonferenza(raggio);
        //stampa area
        System.out.println("Area circonferenza: "+circonferenza.calcolaArea());



        //------------------------PUNTO---------------------------------------------------------------------------------
        //dichiarazione delle variabili
        double x, y;

        //inserimento dati
        System.out.println("Insrisci la x del punto");
        x=keyboard.nextDouble();
        System.out.println("Insrisci la y del punto");
        y=keyboard.nextDouble();

        //creazione degli oggetti
        Punto punto1 = new Punto(x, y);
        Punto punto2 = new Punto(2,3);



        //-------------------------------POLIGONO-----------------------------------------------------------------------
        int numeroLati;
        double lunghezzaLato;

        System.out.println("Inserisci il numero dei lati del poligono: ");
        numeroLati=keyboard.nextInt();
        System.out.println("Inserisci il lunghezza del lato del poligono: ");
        lunghezzaLato=keyboard.nextDouble();

        Poligono poligono=new Poligono(numeroLati, lunghezzaLato);
        System.out.println(poligono.toString());
    }
}