import java.util.Arrays;
import java.util.Scanner;

public class BusquedaBinariaEnArreglo {
    public static void main(String[] args) {

        String[] nombres = {"Ana", "Carlos", "Beatriz", "David", "Elena", "Gabriel"};
        Arrays.sort(nombres); // Aseguramos que esté ordenado antes de la búsqueda

        System.out.println("Arreglo ordenado: " + Arrays.toString(nombres));


        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un nombre para buscar en el arreglo:");
        String nombreBuscado = scanner.nextLine();


        int posicion = Arrays.binarySearch(nombres, nombreBuscado);


        if (posicion >= 0) {
            System.out.println("El nombre '" + nombreBuscado + "' fue encontrado en la posición " + posicion + ".");
        } else {
            System.out.println("El nombre '" + nombreBuscado + "' no fue encontrado en el arreglo.");
        }

        scanner.close();
    }
}