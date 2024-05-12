import java.util.*;

public class Main {
    public static void main(String[] args) {
        //declaration and initialization of variables
        int lunghezza = 0;
        Scanner keyboard = new Scanner(System.in);

        //ask the user how many elements he wants to insert
        System.out.println("Quanti elementi vuoi inserire? ");
        lunghezza = keyboard.nextInt();

        //creating the array
        int[] array = new int[lunghezza];

        //for loop to insert elements into the array
        for (int i = 0; i < lunghezza; i++) {
            //entering numbers
            System.out.printf("Inserisci il %d° numero: ", i + 1);
            array[i] = keyboard.nextInt();
        }

        //original array
        System.out.println("Array originale:");
        //link to the method stampaArray
        stampaArray(array);

        //sorting the array with merge sort
        mergeSort(array, 0, array.length - 1);

        //output
        System.out.println("Array in ordine crescente con tutti gli elementi dell'array e duplicati:");
        //link to the method stampaArray
        stampaArray(array);

        //creating the array and variables
        int[] arrayDispariPariConDuplicati = new int[array.length];
        int indexDispari = 0;
        int indexPari = array.length - 1;

        //for loop
        for (int num : array) {
            //if number is even or shots
            if (num % 2 == 0) {
                arrayDispariPariConDuplicati[indexPari--] = num;
            } else {
                arrayDispariPariConDuplicati[indexDispari++] = num;
            }
        }

        //sorting odd and even arrays with duplicates
        mergeSort(arrayDispariPariConDuplicati, 0, indexDispari - 1);
        mergeSort(arrayDispariPariConDuplicati, indexDispari, array.length - 1);

        //output
        System.out.println("Array con duplicati: numeri dispari crescenti e pari crescenti:");
        stampaArray(arrayDispariPariConDuplicati);

        int[] arraySenzaDuplicati = eliminaDuplicati(arrayDispariPariConDuplicati);

        //output
        System.out.println("Array senza duplicati: numeri dispari crescenti e numeri pari crescenti:");
        stampaArray(arraySenzaDuplicati);
    }

    //method characteristics stampaArray
    private static void stampaArray(int[] array) {
        //for loop
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //method characteristics mergeSort
    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    //method characteristics merge
    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[mid + 1 + j];

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    //method characteristics eliminaDuplicati
    private static int[] eliminaDuplicati(int[] array) {
        int lunghezzaUnica = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                lunghezzaUnica++;
            }
        }

        int[] arraySenzaDuplicati = new int[lunghezzaUnica];
        arraySenzaDuplicati[0] = array[0];
        int j = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                arraySenzaDuplicati[j] = array[i];
                j++;
            }
        }
        return arraySenzaDuplicati;
    }
}
