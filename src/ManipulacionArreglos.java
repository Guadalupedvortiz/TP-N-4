import java.util.Arrays;
import java.util.Scanner;

public class ManipulacionArreglos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una serie de números enteros separados por espacios:");
        String[] entrada = scanner.nextLine().split(" ");

        int[] numeros = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            try {
                numeros[i] = Integer.parseInt(entrada[i]);
            } catch (NumberFormatException e) {
                System.out.println("Error: Asegúrate de ingresar solo números enteros.");
                return;
            }
        }

        System.out.println("Números ingresados: " + Arrays.toString(numeros));


        System.out.println("Suma de los elementos: " + calcularSuma(numeros));


        int[] mayorMenor = encontrarMayorMenor(numeros);
        System.out.println("Número mayor: " + mayorMenor[1]);
        System.out.println("Número menor: " + mayorMenor[0]);


        System.out.println("Arreglo invertido: " + Arrays.toString(invertirArreglo(numeros)));

        scanner.close();
    }

    public static int calcularSuma(int[] arreglo) {
        int suma = 0;
        for (int num : arreglo) {
            suma += num;
        }
        return suma;
    }

    public static int[] encontrarMayorMenor(int[] arreglo) {
        int menor = arreglo[0], mayor = arreglo[0];
        for (int num : arreglo) {
            if (num < menor) menor = num;
            if (num > mayor) mayor = num;
        }
        return new int[]{menor, mayor};
    }

    public static int[] invertirArreglo(int[] arreglo) {
        int[] invertido = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            invertido[i] = arreglo[arreglo.length - 1 - i];
        }
        return invertido;
    }
}