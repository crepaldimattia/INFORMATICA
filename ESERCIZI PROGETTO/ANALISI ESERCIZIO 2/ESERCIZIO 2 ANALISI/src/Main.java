import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int lunghezza = 0;
        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.print("Quanti elementi vuoi inserire? ");
            lunghezza = keyboard.nextInt();
        } while (lunghezza < 10 || lunghezza > 11);

        int[] arr = new int[lunghezza];

        for (int i = 0; i < lunghezza; i++) {
            System.out.printf("Inserisci il %d° elemento: ", i + 1);
            arr[i] = keyboard.nextInt();
        }

        ordinaPari(arr);
        printArray(arr);
    }

    private static void ordinaPari(int[] arr) {
        // Ordinare i numeri pari
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] % 2 == 0) {
                for (int j = i + 1; j < arr.length - 1; j++) {
                    if (arr[j] % 2 == 0 && arr[i] > arr[j]) {
                        // Scambio dei numeri pari
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
