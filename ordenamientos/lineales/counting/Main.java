/* Date: 02/10/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Implementacion del algoritmo de counting sort
*/

public class Main {
    public static void main(String[] args) {
        int casos = 20;
        int pruebas = 0;
        int div = (150000 - 30000) / (casos);
        for (int i = 30000; i <= 150000; i += div) {
            System.out.println("i: " + i);
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
        counting(arr);
        long finI = System.nanoTime();

        System.out.println("  time: " + (finI - inicioI) + "");
    }

    public static void prueba() {
        int arr[] = llenado(40);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
        int[] salida = counting(arr);
        for (int i = 0; i < salida.length; i++) {
            System.out.print(salida[i] + " ");
        }
    }

    public static int[] counting(int[] arr) {
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

}
