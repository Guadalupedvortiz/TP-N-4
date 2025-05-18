import java.util.Arrays;
import java.util.Scanner;

public class OrdenamientoDeArreglos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese números enteros separados por espacios:");
        String[] entrada = scanner.nextLine().split(" ");

        int[] numeros = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            numeros[i] = Integer.parseInt(entrada[i]);
        }


        int[] bubbleSorted = Arrays.copyOf(numeros, numeros.length);
        bubbleSort(bubbleSorted);
        System.out.println("Ordenado con Bubble Sort: " + Arrays.toString(bubbleSorted));


        int[] sortedArray = Arrays.copyOf(numeros, numeros.length);
        Arrays.sort(sortedArray);
        System.out.println("Ordenado con Arrays.sort(): " + Arrays.toString(sortedArray));

        scanner.close();
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}