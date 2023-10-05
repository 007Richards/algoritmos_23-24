/* Date: 02/10/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Preograma para la comparacion de los algoritmos de oprdenacion O(nlogn)
*/

public class Main {
    public static void main(String[] args) {
        int casos = 20;
        int pruebas = 0;
        int div = (30000 - 3000) / (casos);

        System.out.println("    Q   ,     M    ,    H");
        for (int i = 3000; i <= 30000; i += div) {
            System.out.print(i + "   ");
            int arr0[] = llenado(i);
            int arr1[] = new int[i];
            int arr2[] = new int[i];
            arr1 = java.util.Arrays.copyOfRange(arr0, 0, i);
            arr2 = java.util.Arrays.copyOfRange(arr0, 0, i);

            tiempoQ(arr0);
            tiempoM(arr1);
            tiempoH(arr2);
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

    public static void tiempoQ(int arr[]) {
        long inicioB = System.nanoTime();
        quick(arr, 0, arr.length - 1);
        long finB = System.nanoTime();

        System.out.print("Q " + (finB - inicioB) + "   ");
    }

    public static void tiempoM(int arr[]) {
        long inicioS = System.nanoTime();
        mergeSort(arr, arr.length);
        long finS = System.nanoTime();

        System.out.print("M " + (finS - inicioS) + "   ");
    }

    public static void tiempoH(int arr[]) {
        long inicioI = System.nanoTime();
        heapSort(arr, arr.length);
        long finI = System.nanoTime();

        System.out.println("H " + (finI - inicioI));
    }

    public static void quick(int A[], int izq, int der) {
        int pivote = A[izq];
        int i = izq;
        int j = der;
        int aux;

        while (i < j) {
            while (A[i] <= pivote && i < j)
                i++;
            while (A[j] > pivote)
                j--;
            if (i < j) {
                aux = A[i];
                A[i] = A[j];
                A[j] = aux;
            }
        }

        A[izq] = A[j];
        A[j] = pivote;

        if (izq < j - 1)
            quick(A, izq, j - 1);
        if (j + 1 < der)
            quick(A, j + 1, der);
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void heapSort(int a[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(a, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            heapify(a, i, 0);
        }
    }

    static void heapify(int a[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && a[left] > a[largest])
            largest = left;
        if (right < n && a[right] > a[largest])
            largest = right;
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            heapify(a, n, largest);
        }
    }

}