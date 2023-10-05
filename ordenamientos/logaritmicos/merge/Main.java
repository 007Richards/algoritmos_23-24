/* Date: 02/10/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Implementacion del algoritmo de merge sort
*/

public class Main {
    public static void main(String[] args) throws Exception {
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
            int a = (int) (Math.random() * 2000000000);
            arr[i] = a;
        }
        return arr;
    }

    public static void tiempo(int arr[]) {
        long inicioI = System.nanoTime();
        mergeSort(arr, arr.length);
        long finI = System.nanoTime();

        System.out.println("  time: " + (finI - inicioI));
    }

    public static void prueba() {
        int arr[] = llenado(30);
        mergeSort(arr, arr.length);
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void mergeSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }
        int mitad = n / 2;
        int[] l = new int[mitad];
        int[] r = new int[n - mitad];

        for (int i = 0; i < mitad; i++) {
            l[i] = arr[i];
        }
        for (int i = mitad; i < n; i++) {
            r[i - mitad] = arr[i];
        }
        mergeSort(l, mitad);
        mergeSort(r, n - mitad);

        merge(arr, l, r, mitad, n - mitad);
    }

    public static void merge(int[] arr, int[] l, int[] r, int izq, int der) {
        int i = 0, j = 0, k = 0;
        while (i < izq && j < der) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        while (i < izq) {
            arr[k++] = l[i++];
        }
        while (j < der) {
            arr[k++] = r[j++];
        }
    }

}
