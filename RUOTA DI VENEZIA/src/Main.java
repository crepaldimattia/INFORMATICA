import java.util.*;

public class Main {
    public static void main(String[] args) {
        //creation of array numbers with indication to the method array
        int [] numeri  = array();
        //initial output
        System.out.println("I numeri estratti dalla Ruota di Venezia:");

        //for loop
        for(int index=0; index<numeri.length; index++) {
            //outut number
            System.out.println("NUMERO=" + numeri[index]);
        }
    }

    //method array
    private static int[] array(){
        //variable declaration and initialization
        int[] numeri=new int[5];
        int min=1, max=90;
        //for loop
        for(int i=0; i<numeri.length; i++){
            //indication to the method valoreRandom
            numeri[i]=valoreRandom(min, max);

            //indication to the method valoreRandom
            if(i>0)valueChecker(numeri, i, min, max);
        }
        //return array
        return numeri;
    }

    //method valoreRandom
    private static int valoreRandom(int min, int max)
    {
        //create random value
        Random casuale = new Random(); //Metodo che non ha nessun parametro, si chiama costruttore. --> Method that has no parameters, it is called constructor.

        //return array
        return  casuale.nextInt(min,max)+1;
    }

    //method valueChecker
    private static void valueChecker(int array[], int i, int min, int max) {
        //for loop
        for (int k = 0; k < i; k++) {
            // If the value is already in the array, reassign it and recheck all array
            if (array[i] == array[k]) {
                // Assign another random value to array[i]
                array[i] = valoreRandom(min, max);
                // Restart the check
                k = -1;
            }
        }
    }
}