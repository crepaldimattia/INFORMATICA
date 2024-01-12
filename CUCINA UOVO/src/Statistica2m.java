import java.util.Random;
public class Statistica2m {
    public static void main(String[] args)
    {
        int [] frequenze  = new int[6];   //Il vettore è una collezione di dati dello stesso tipo. --> //The vector is a collection of data of the same type.


        /*for(int i=0; i<frequenze.length;i++)
         {
             System.out.println(frequenze[i]);
         }
        */

        int valore=0;
        for( int i=0; i<100; i++) {
            valore = valoreRandom(0, 6);
            // System.out.printf("Valore %d \n ",valore);  //%d vuoldire variabile di tipo intero. --> System.out.printf("Value %d \n ",value); //%d means integer type variable.
            //%f vuoldire float --> %f means float
            // %s vuoldire stringa --> %s means string
            // %c vuoldire char (carattere) --> %c means char (character)
            // Printf serve per formattare il testo. --> Printf is used to format text.
            FacceDado(valore);

            //to "delete the switch-case"
            frequenze[valore-1]++;


            }
            //for loop
            for(int index=0; index<frequenze.length; index++)
            {
                System.out.println("Faccia"+(index+1)+"="+frequenze[index]);
            }
        }

          /* System.out.printf(" Faccia1: %d,Faccia2: %d,Faccia3: %d,Faccia4: %d,Faccia5: %d,Faccia6: %d ",faccia1,faccia2,faccia3,
                    faccia4,faccia5,faccia6);*/


    //valoreRandom
    private static int valoreRandom(int minValue, int maxValue)
    {
        Random casuale = new Random(); //Metodo che non ha nessun parametro, si chiama costruttore. --> //Method that has no parameters, it is called constructor.

        return  casuale.nextInt(minValue,maxValue)+1;

    }
    //FacceDado
    private static void FacceDado(int valoreFaccia1)
    {
        //ALT + 201 ╔
        //ALT + 188 ╝
        //ALT + 187 ╗
        //ALT + 200 ╚
        //ALT + 205 ═
        //ALT + 186 ║

        //switch-case
        switch (valoreFaccia1) {
            case 1 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ╚═════════╝");

                break;
            }

            case 2 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");

                break;
            }

            case 3 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 4 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 5 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 6 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }
        }
    }
}

