import java.util.Scanner;

public class Main {  

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();
        int[] datos = new int[n];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = entrada.nextInt();
        }
        entrada.close();

        bucketSort(datos);
    }

    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int n = arr.length;
        int bucketRange = 100;

        Lista[] list = new Lista[n];
        for (int i = 0; i < n; i++) {
            list[i] = new Lista();
        }

        for (int i = 0; i < list.length; i++) {
            int ind = arr[i] / bucketRange;
            list[ind].addFinal(arr[i]);
        }

        for (int i = 0; i < list.length; i++) {
            ordenar(list[i]);
        }

        int o = 0;
        for (int i = 0; i < list.length; i++) {
            nodo temp = list[i].inicio;
            for (int j = 0; j < list[i].longitud; j++) {
                arr[o] = temp.dato;
                temp = temp.siguiente;
                o++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();

    }

    public static void ordenar(Lista l){
        int[] arr = new int[l.longitud];
        nodo temp = l.inicio;
        for (int i = 0; i < l.longitud; i++) {
            arr[i] = temp.dato;
            temp = temp.siguiente;
        }
        mergeSort(arr, arr.length);
        nodo temp2 = l.inicio;
        for (int i = 0; i < arr.length; i++) {
            temp2.dato = arr[i];
            temp2 = temp2.siguiente;
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


class nodo{
    int dato;
    nodo siguiente;

    nodo(int  dato){
        this.dato = dato;
    }
}

class Lista{
    nodo inicio;
    nodo ultimo;
    int longitud = 0;

    Lista(){
        this.inicio = null;
        this.ultimo = null;
    }

    void addFinal(int i){
        nodo n = new nodo(i);
        if(inicio == null){
            inicio = n;
            ultimo = inicio;
            longitud ++;
        }
        else{
            ultimo.siguiente = n;
            ultimo = n;
            longitud ++;
        }
    }

}