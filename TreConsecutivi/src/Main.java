public class Main {
    public static void main(String[] args) {
        //creating the array
        int[] numeri = {1, 2, 3, 3, 3, 6, 7, 8, 9, 0};
        //declaration of variables
        boolean triplo=false;
        //for loop
        for (int i = 0; i < numeri.length-2; i++) {
            //check after each number if there are two consecutive identical ones
            if (numeri[i] == numeri[i + 1] && numeri[i] == numeri[i + 2]) {
                //I assign the variable true
                triplo = true;
            }
        }
        if (triplo) {
            //output
            System.out.println("Tre valori consecutivi uguali");
        } else {
            //output
            System.out.println("NO");
        }
    }
}







