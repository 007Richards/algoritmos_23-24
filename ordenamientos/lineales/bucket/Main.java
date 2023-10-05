/* Date: 02/10/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Implementacion del algoritmo de bucket sort incluyendo como subalgoritmos de ordenacion a insertion y quick sort
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int casos = 20;
        int pruebas = 0;
        int div = (150000 - 30000) / (casos);
        for (int i = 30000; i <= 150000; i += div) {
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
            int a = (int) (Math.random() * 2000000); // dos millones
            arr[i] = a;
        }
        return arr;
    }

    public static void tiempo(int arr[]) {
        long inicioI = System.nanoTime();
        bucketSort(arr);
        long finI = System.nanoTime();

        System.out.println("  time: " + (finI - inicioI));
    }

    public static void prueba() {
        int arr[] = llenado(40);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n\n");
        bucketSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        tiempo(arr);
    }

    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int n = arr.length;
        int min = arr[0];
        int max = arr[0];

        // Primero encuentramos el valor mínimo y máximo en el arreglo
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Calculamos el rango de cada cubo
        int bucketRange = (max - min) / n + 1;

        // Creamos los cubos como arreglos
        ArrayList<int[]> buckets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            buckets.add(new int[0]);
        }

        // Colocamos cada elemento en su cubo correspondiente
        for (int i = 0; i < n; i++) {
            int bucketIndex = (arr[i] - min) / bucketRange;
            int[] bucket = buckets.get(bucketIndex);
            buckets.set(bucketIndex, Arrays.copyOf(bucket, bucket.length + 1));
            buckets.get(bucketIndex)[bucket.length] = arr[i];
        }

        // Se ordena cada cubo utilizando Insertion Sort & Quick Sort
        for (int i = 0; i < n; i++) {
            // insertionSort(buckets.get(i));
            quickSort(buckets.get(i), 0, buckets.get(i).length - 1);
        }

        // Pasamos todos los cubos ordenados en el arreglo original
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets.get(i).length; j++) {
                arr[index++] = buckets.get(i)[j];
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = quick(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    public static int quick(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        return i + 1;
    }

}
