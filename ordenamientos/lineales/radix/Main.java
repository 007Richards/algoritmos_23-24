/* Date: 02/10/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Implementacion del algoritmo de radix sort
*/

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
            int a = (int) (Math.random() * 2000000);
            arr[i] = a;
        }
        return arr;
    }

    public static void tiempo(int arr[]) {
        long inicioI = System.nanoTime();
        radixSort(arr);
        long finI = System.nanoTime();

        System.out.println("  time: " + (finI - inicioI));
    }

    public static void prueba() {
        int arr[] = llenado(15);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
        int[] salida = radixSort(arr);
        for (int i = 0; i < salida.length; i++) {
            System.out.print(salida[i] + " ");
        }
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

    public static int cifrasNum(int c) {
        int count = 0;
        if (c == 0) {
            count = 1;
        } else {
            int n = Math.abs(c);
            while (n > 0) {
                n = n / 10;
                count++;
            }
        }
        return count;
    }

}
