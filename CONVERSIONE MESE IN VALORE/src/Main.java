import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //variable declaration
        Scanner tastiera=new Scanner(System.in);
        String mese;

        //month entry
        System.out.println("Inserisci un mese: ");
        mese=tastiera.nextLine();

        //link to the method ToStrMese and output
        System.out.println(ToStrMese(mese));
    }

    //method characteristics ToStrMese
    private static int ToStrMese(String mese){
        /*I check if the month is written in lowercase or uppercase.
        If it is lowercase I transform it into uppercase, if it is uppercase I skip to the next instruction*/
        if(!mese.equals(mese.toLowerCase())){
            mese=mese.toUpperCase();
        }

        //switch-case
        switch(mese){
            //JANUARY
            case "GENNAIO":
                //return 1
                return 1;
            //FEBRARY
            case "FEBBRAIO":
                //return 2
                return 2;
            //MARCH
            case "MARZO":
                //return 3
                return 3;
            //APRIL
            case "APRILE":
                //return 4
                return 4;
            //MAY
            case "MAGGIO":
                //return 5
                return 5;
            //JUNE
            case "GIUNGNO":
                //return 6
                return 6;
            //JULY
            case "LUGLIO":
                //return 7
                return 7;
            //AUGUST
            case "AGOSTO":
                //return 8
                return 8;
            //SEPTEMBER
            case "SETTEMBRE":
                //return 9
                return 9;
            //OCTOBER
            case "OTTOBRE":
                //return 10
                return 10;
            //NOVEMBER
            case "NOVEMBRE":
                //return 11
                return 11;
            //DECEMBER
            case "DICEMBRE":
                //return 12
                return 12;
            //if the option is not among those proposed
            default:
                //return -1
                return -1;
        }
    }
}