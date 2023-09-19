public class Main {
    public static void main(String[] args) {
        int casos = 20;
        int pruebas = 0;
        int div = (30000-3000)/(casos);
        for(int i = 3000; i <= 30000; i += div){
                //System.out.print("i: "+i);  
                int arr[] = llenado(i);
                tiempo(arr);
                pruebas ++;
        }
    //System.out.println("pruebas: "+pruebas);
    }


    public static int[] llenado(int n){
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            int a = (int)(Math.random()*200);//*2000000000);
            arr[i] = a;
        }
        return arr;
    }


    public static void tiempo(int arr[]){
        final long inicioI = System.nanoTime();
            heapSort(arr, arr.length);
        final long finI = System.nanoTime();

        System.out.println(/*"  time: "+*/(finI - inicioI)+"");
    }

    public static void prueba(){
        int arr[] = llenado(30);
        heapSort(arr, arr .length);
        for(int i = 0; i<= arr.length; i ++){
            System.out.println(arr[i]);
        }
    }

    public static void heapSort(int arr[], int n){
        for (int i = n / 2 - 1; i >= 0; i--)  
            heapback(arr, n, i);  
        for (int i = n - 1; i >= 0; i--) {  
            int aux = arr[0];  
            arr[0] = arr[i];  
            arr[i] = aux;  
          
            heapback(arr, i, 0);  
        }
    }

    public static void heapback(int arr[], int n, int i){
        int ultimo = i; 
        int izq = 2 * i + 1;
        int der = 2 * i + 2; 
        if (izq < n && a[izq] > a[ultimo])  
            ultimo = izq;  
        if (der < n && a[der] > a[ultimo])  
            ultimo = der;  

        if (ultimo != i){  
            int temp = arr[i];  
            arr[i] = arr[ultimo];  
            arr[ultimo] = temp;  
          
            heapback(arr, n, ultimo);  
        }  
    }  

    
    /*Function to implement the heap sort
    static void heapSort(int a[], int n){
        for (int i = n / 2 - 1; i >= 0; i--)  
            heapify(a, n, i);  
  
        // One by one extract an element from heap  
        for (int i = n - 1; i >= 0; i--) {  
            // Move current root element to end
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
    }*/

}