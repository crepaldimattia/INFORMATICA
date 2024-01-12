import java.util.Scanner;
import java.lang.Math;

public class Byte {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        String numeroBinario = ""; // input
        double numeroDecimale = 0; // output

        //declaration and initialization of variables
        double carattere = 0;
        double pow = 0;
        boolean flagBinario = true;

        System.out.println("Conversione numero binario in numero decimale\n");

        //I ask for the binary number as input
        System.out.println("Inserisci un numero binario: ");
        numeroBinario = tastiera.next();

        //for loop
        for (int i = numeroBinario.length(); i > 0; i--) {

            carattere = (double)numeroBinario.charAt(i - 1) - 48;

            //check if the number consists of digits 0 and 1
            // If yes then I calculate the number
            if (numeroBinario.charAt(i - 1) == '1' || numeroBinario.charAt(i - 1) == '0') {
                // FORMULA: DecimalNumber = DecimalNumber + (int)char * 10**pow
                numeroDecimale = numeroDecimale + carattere * Math.pow(2.0, pow);
            }

            // if the character is invalid
            else {
                System.out.println("Numero non valido");
                flagBinario= false;
                break;
            }

            // Update the exponent
            pow++;
        }

        // if the number is valid then I print the result
        if (flagBinario)
            System.out.println(numeroDecimale);
    }
}
