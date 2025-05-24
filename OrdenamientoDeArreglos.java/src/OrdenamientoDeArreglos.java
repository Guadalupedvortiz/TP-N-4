import java.util.*;

class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambiar elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}

class SortingComparison {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);

            long startBubble = System.nanoTime();
            BubbleSort.bubbleSort(arr.clone());
            long endBubble = System.nanoTime();

            long startArrays = System.nanoTime();
            Arrays.sort(arr.clone());
            long endArrays = System.nanoTime();

            System.out.println("Tamaño: " + size);
            System.out.println("Bubble Sort: " + (endBubble - startBubble) + " ns");
            System.out.println("Arrays.sort(): " + (endArrays - startArrays) + " ns");
            System.out.println("-----------------------------");
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }
}

class Producto implements Comparable<Producto> {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    @Override
    public int compareTo(Producto otro) {
        return Double.compare(this.precio, otro.precio);
    }

    @Override
    public String toString() {
        return nombre + " - Precio: $" + precio + " - Stock: " + stock;
    }
}

class NombreComparator implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2) {
        return p1.getNombre().compareTo(p2.getNombre());
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Laptop", 1200.99, 5));
        productos.add(new Producto("Mouse", 25.50, 20));
        productos.add(new Producto("Teclado", 45.99, 10));
        productos.add(new Producto("Monitor", 250.75, 8));

        System.out.println("Ordenado por precio (Comparable):");
        Collections.sort(productos);
        productos.forEach(System.out::println);

        System.out.println("\nOrdenado por nombre (Comparator):");
        Collections.sort(productos, new NombreComparator());
        productos.forEach(System.out::println);
    }
}