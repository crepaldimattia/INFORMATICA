import java.util.*;

public class Main {
    public static void main(String[] args) {
        //declaration and initialization of variables/arrays
        int[] data = new int[8];
        int numero = 0, giorno = 0, mese = 0, anno = 0;
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;
        char scelta;

        //while loop
        while(continua){
            //output for enter the date
            System.out.println("Inserisci un numero intero nel formato ggmmaaaa per determinare la data: ");
            //insertion of the date
            numero = scanner.nextInt();

            //count of the day, month, year
            giorno = numero / 1000000;
            mese = (numero / 10000) % 100;
            anno = numero % 10000;

          //call the method dataCorretta
          boolean dataCorretta=verificaData(giorno, mese, anno);

          //if dataCorretta is correct
          if(dataCorretta) {
              //output with value
              System.out.println("Giorno: " + giorno);
              System.out.println("Mese: " + mese);
              System.out.println("Anno: " + anno);

              System.out.println("--------------------------------------------------------------------------");

              System.out.println("Giorno: " + giorno);
              stringa(mese);
              System.out.println("Anno: " + anno);

              System.out.println("Vuoi inserire un'altra data? (S/N). Altri caratteri verranno considerati come NO");
              scelta=scanner.next().charAt(0);

              //is scelta==S
              if(scelta=='S'){
                  continua=true;
              }
              //altrimenti
              else{
                  continua=false;
              }

          }
        }
    }
//characteristics method stringa
    private static void stringa(int mese){
        //switch-case
        switch(mese){
            //January
            case 1: {
                System.out.println("Mese: GENNAIO");
                break;
            }
            //February
            case 2: {
                System.out.println("Mese: FEBBRAIO");
                break;
            }
            //March
            case 3:{
                System.out.println("Mese: MARZO");
                break;
            }
            //April
            case 4:{
                System.out.println("Mese: APRILE");
                break;
            }
            //May
            case 5:{
                System.out.println("Mese: MAGGIO");
                break;
            }
            //June
            case 6:{
                System.out.println("Mese: GIUGNO");
                break;
            }
            //July
            case 7:{
                System.out.println("Mese: LUGLIO");
                break;
            }
            //August
            case 8:{
                System.out.println("Mese: AGOSTO");
                break;
            }
            //September
            case 9:{
                System.out.println("Mese: SETTEMBRE");
                break;
            }
            //October
            case 10:{
                System.out.println("Mese: OTTOBRE");
                break;
            }
            //November
            case 11:{
                System.out.println("Mese: NOVEMBRE");
                break;
            }
            //December
            case 12:{
                System.out.println("Mese: DICEMBRE");
                break;
            }
            //default
            default:{
                System.out.println("DATO NON VALIDO");
            }
        }
    }
    //characteristics method verificaData
    private static boolean verificaData(int giorno, int mese, int anno){
        ////declaration and initialization of variable
        int giorniMese=0;
        //if moths
        if(mese<1||mese>12){
            return false;
        }

        //switch-case
        switch(mese){
            //months with 30 days
            case 4: case 6: case 9: case 11:{
                giorniMese=30;
                break;
            }
            //months with 29 days
            case 2:{
                if((anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0)) {
                    giorniMese=29;
                }
                //months with 28 days
                else{
                    giorniMese=28;
                }
                break;
            }
            //default
            default:{
                giorniMese=31;
                break;
            }

        }
        return giorno >=1 && giorno<=giorniMese;
    }
}