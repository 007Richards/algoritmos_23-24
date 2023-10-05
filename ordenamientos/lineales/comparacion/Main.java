/* Date: 02/10/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Programa para la comparacion de los algoritmos de ordenacion O(n)
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int casos = 20;
        int pruebas = 0;
        int div = (300000 - 30000) / (casos);

        System.out.println("    C   ,     R    ,    B");
        for (int i = 30000; i <= 300000; i += div) {
            System.out.println(i + "   ");
            int arr0[] = llenado(i);
            int arr1[] = new int[i];
            int arr2[] = new int[i];
            arr1 = java.util.Arrays.copyOfRange(arr0, 0, i);
            arr2 = java.util.Arrays.copyOfRange(arr0, 0, i);

            tiempoC(arr0);
            tiempoR(arr1);
            tiempoB(arr2);
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

    public static void tiempoC(int arr[]) {
        long inicioB = System.nanoTime();
        countingSort(arr);
        long finB = System.nanoTime();

        System.out.print("C " + (finB - inicioB) + "   ");
    }

    public static void tiempoR(int arr[]) {
        long inicioS = System.nanoTime();
        radixSort(arr);
        long finS = System.nanoTime();

        System.out.print("R " + (finS - inicioS) + "   ");
    }

    public static void tiempoB(int arr[]) {
        long inicioI = System.nanoTime();
        bucketSort(arr);
        long finI = System.nanoTime();

        System.out.println("B " + (finI - inicioI));
    }

    // ****** Algoritmos de Ordenacion*******

    public static int[] countingSort(int[] arr) {
        int rango = 2000000;
        int[] count = new int[rango];
        int[] salida = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] += 1;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < salida.length; i++) {
            salida[count[arr[i]] - 1] = arr[i];
            count[arr[i]] -= 1;
        }
        return salida;
    }

    public static int[] radixSort(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        int k = 1;
        while (max / k > 0) {
            radixCounting(arr, k);
            k *= 10;
        }
        return arr;

    }

    public static void radixCounting(int[] arr, int k) {
        int n = arr.length;
        int[] count = new int[10];
        int[] salida = new int[n];

        for (int i = 0; i < n; i++) {
            int j = arr[i] / k;
            count[j % 10] += 1;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int j = arr[i] / k;
            salida[count[j % 10] - 1] = arr[i];
            count[j % 10] -= 1;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = salida[i];
        }
    }

    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int n = arr.length;
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        int bucketRange = (max - min) / n + 1;

        ArrayList<int[]> buckets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            buckets.add(new int[0]);
        }

        for (int i = 0; i < n; i++) {
            int bucketIndex = (arr[i] - min) / bucketRange;
            int[] bucket = buckets.get(bucketIndex);
            buckets.set(bucketIndex, Arrays.copyOf(bucket, bucket.length + 1));
            buckets.get(bucketIndex)[bucket.length] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            quickSort(buckets.get(i), 0, buckets.get(i).length - 1);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets.get(i).length; j++) {
                arr[index++] = buckets.get(i)[j];
            }
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
