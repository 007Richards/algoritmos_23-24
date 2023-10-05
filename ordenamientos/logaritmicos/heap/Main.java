/* Date: 02/10/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Implementacion del algoritmo de heap sort
*/

public class Main {
    public static void main(String[] args) {
        int casos = 20;
        int pruebas = 0;
        int div = (30000 - 3000) / (casos);
        for (int i = 3000; i <= 30000; i += div) {
            System.out.print("i: " + i);
            int arr[] = llenado(i);
            tiempo(arr);
            pruebas++;
        }
        System.out.println("pruebas: " + pruebas);
    }

    public static int[] llenado(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * 200);// *2000000000);
            arr[i] = a;
        }
        return arr;
    }

    public static void tiempo(int arr[]) {
        final long inicioI = System.nanoTime();
        heapSort(arr, arr.length);
        final long finI = System.nanoTime();

        System.out.println("  time: " + (finI - inicioI));
    }

    public static void prueba() {
        int arr[] = llenado(30);
        heapSort(arr, arr.length);
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void heapSort(int arr[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            heapback(arr, n, i);
        for (int i = n - 1; i >= 0; i--) { // uno a uno se extrae el elemento del monton
            int aux = arr[0]; // moviendo el elemento de la raiz al final
            arr[0] = arr[i];
            arr[i] = aux;

            heapback(arr, i, 0);
        }
    }

    public static void heapback(int arr[], int n, int i) {
        int ultimo = i;
        int izq = 2 * i + 1;
        int der = 2 * i + 2;
        if (izq < n && a[izq] > a[ultimo])
            ultimo = izq;
        if (der < n && a[der] > a[ultimo])
            ultimo = der;

        if (ultimo != i) {
            int temp = arr[i];
            arr[i] = arr[ultimo];
            arr[ultimo] = temp;

            heapback(arr, n, ultimo);
        }
    }

}