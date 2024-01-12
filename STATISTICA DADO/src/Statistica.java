import java.util.Random;
public class Statistica {
    public static void main(String[] args)
    {
        //variable declaration and initialization
        int faccia1=0;
        int faccia2=0;
        int faccia3=0;
        int faccia4=0;
        int faccia5=0;
        int faccia6=0;
        int valore=0;
        //for loop
        for( int i=0; i<100; i++) {
            valore = valoreRandom(0, 6);
            // System.out.printf("Valore %d \n ",valore);  //%d vuoldire variabile di tipo intero. --> System.out.printf("Value %d \n ",value); //%d means integer type variable.
            //%f vuoldire float --> %f means float
            // %s vuoldire stringa --> %s means string
            // %c vuoldire char (carattere) --> %c means char (character)
            // Printf serve per formattare il testo. --> Printf is used to format text.
            FacceDado(valore);
            //switch-case
            switch (valore) {
                case 1: {
                    faccia1++;
                }
                case 2: {
                    faccia2++;
                }
                case 3: {
                    faccia3++;
                }
                case 4: {
                    faccia4++;
                }
                case 5: {
                    faccia5++;
                }
                case 6: {
                    faccia6++;
                }

            }
        }

        //output faccia
        System.out.printf(" Faccia1: %d \n,Faccia2: %d \n,Faccia3: %d \n,Faccia4: %d \n,Faccia5: %d \n,Faccia6: %d ",faccia1,faccia2,faccia3,
                faccia4,faccia5,faccia6);


    }
valoreRandom
    private static int valoreRandom(int minValue, int maxValue)
    {
        Random casuale = new Random(); //Metodo che non ha nessun parametro, si chiama costruttore.

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