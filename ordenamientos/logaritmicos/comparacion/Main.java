public class Main{ 
    public static void main(String[] args){
        int casos = 20;
        int pruebas = 0;
        int div = (30000-3000)/(casos);
    
        //System.out.println("    Q   ,     M    ,    H");    
        for(int i = 3000; i <= 30000; i += div){
            //System.out.print(i+"   ");
            int arr0[] = llenado(i);
            int arr1[] = new int[i];
            int arr2[] = new int[i];
            arr1 = java.util.Arrays.copyOfRange(arr0, 0, i);
            arr2 = java.util.Arrays.copyOfRange(arr0, 0, i);
          
            tiempoQ(arr0);
            tiempoM(arr1);
            tiempoH(arr2);
            pruebas ++;
            }
        //System.out.println("pruebas: "+pruebas);
    }
            
    public static int[] llenado(int n){   
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
                int a = (int)(Math.random()*2000000000);
                arr[i] = a;
        }
        return arr;
    }
                    

    public static void tiempoQ(int arr[]){
        long inicioB = System.nanoTime();
                quick(arr, 0 , arr.length-1);
        long finB = System.nanoTime();
        
        System.out.print("Q "+(finB - inicioB)+"   ");
    }


    public static void tiempoM(int arr[]){
        long inicioS = System.nanoTime();
                mergeSort(arr, arr.length);
        long finS = System.nanoTime();
                        
        System.out.print("M "+(finS - inicioS)+"   ");
    }


    public static void tiempoH(int arr[]){  
        long inicioI = System.nanoTime();
                heapSort(arr, arr.length);
        long finI = System.nanoTime();
                        
        System.out.println("H "+(finI - inicioI)+"");
    }

    public static void quick(int A[], int izq, int der) {
        int pivote=A[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        int aux;
       
        while(i < j){                          // mientras no se crucen las búsquedas                                   
            while(A[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while(A[j] > pivote) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado                      
                aux= A[i];                      // los intercambia
                A[i]=A[j];
                A[j]=aux;
            }
        }
         
        A[izq]=A[j];      // se coloca el pivote en su lugar de forma que tendremos                                    
        A[j]=pivote;      // los menores a su izquierda y los mayores a su derecha
         
        if(izq < j-1)
            quick(A,izq,j-1);          // ordenamos subarray izquierdo
        if(j+1 < der)
            quick(A,j+1,der);          // ordenamos subarray derecho
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
            }
            else {
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

    /*Function to implement the heap sort*/  
    static void heapSort(int a[], int n){
        for (int i = n / 2 - 1; i >= 0; i--)  
            heapify(a, n, i);  
  
        // One by one extract an element from heap  
        for (int i = n - 1; i >= 0; i--) {  
            /* Move current root element to end*/  
            // swap a[0] with a[i]  
            int temp = a[0];  
            a[0] = a[i];  
            a[i] = temp;  
          
            heapify(a, i, 0);  
        }
    }

    static void heapify(int a[], int n, int i){
        int largest = i; // Initialize largest as root  
        int left = 2 * i + 1; // left child  
        int right = 2 * i + 2; // right child  
        // If left child is larger than root  
        if (left < n && a[left] > a[largest])  
            largest = left;  
        // If right child is larger than root  
        if (right < n && a[right] > a[largest])  
            largest = right;  
        // If root is not largest  
        if (largest != i){  
            // swap a[i] with a[largest]  
            int temp = a[i];  
            a[i] = a[largest];  
            a[largest] = temp;  
          
            heapify(a, n, largest);  
        }  
    }  
    

}