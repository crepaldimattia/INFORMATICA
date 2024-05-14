import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Array lengths to test
        int[] arrayLengths = {10, 100, 1000, 10000, 100000, 1000000};

        // Iterate through each array length
        for (int length : arrayLengths) {
            System.out.println("Test con la lunghezza dell'array " + length + ":");
            // Generate random array
            int[] array = generateRandomArray(length);

            // Duplicate the array for both sorting algorithms
            int[] duplicatedArraySelectionSort = duplicateArray(array);
            int[] duplicatedArrayBubbleSort = duplicateArray(array);

            // Perform Selection Sort and count the number of operations
            int selectionSortOperations = selectionSort(duplicatedArraySelectionSort);
            System.out.println("Numero di operazioni eseguite con Selection Sort: " + selectionSortOperations);

            // Perform Bubble Sort and count the number of operations
            int bubbleSortOperations = bubbleSort(duplicatedArrayBubbleSort);
            System.out.println("Numero di operazioni eseguite con Bubble Sort: " + bubbleSortOperations);
            System.out.println();
        }
    }

    // Generate a random array of a specified length
    static int[] generateRandomArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 1000); // Generate random numbers between 0 and 999
        }
        return array;
    }

    // Duplicate an array
    static int[] duplicateArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    // Perform Selection Sort and return the number of operations
    static int selectionSort(int[] array) {
        int operations = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                operations++;
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return operations;
    }

    // Perform Bubble Sort and return the number of operations
    static int bubbleSort(int[] array) {
        int operations = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                operations++;
            }
        }
        return operations;
    }
}
