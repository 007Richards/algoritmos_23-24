/* Date: 02/10/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Implementacion del algoritmo de quick sort
*/

public class Main {
    public static void main(String[] args){
        int casos = 20;
        int pruebas = 0;
        int div = (30000-3000)/(casos);
        for(int i = 3000; i <= 30000; i += div){
                System.out.print("i: "+i);  
                int arr[] = llenado(i);
                tiempo(arr);
                pruebas ++;
        }
    //System.out.println("pruebas: "+pruebas);
    //prueba();
    }


    public static int[] llenado(int n){
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            int a = (int)(Math.random()*100);//*2000000000);
            arr[i] = a;
        }
        return arr;
    }


    public static void tiempo(int arr[]){
        long inicioI = System.nanoTime();
            quick(arr, 0, arr.length-1);
        long finI = System.nanoTime();

        System.out.println("  time: "+(finI - inicioI));
    }

    public static void prueba(){
        int arr[] = llenado(30);
        quick(arr, 0, arr.length-1);
        for(int i = 0; i<= arr.length; i ++){
            System.out.println(arr[i]);
        }
    }

    public static void quick(int A[], int izq, int der) {
        int pivote=A[izq];
        int i=izq;
        int j=der;
        int aux;
       
        while(i < j){                           // mientras no se crucen las búsquedas                                
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
            quick(A,izq,j-1);
        if(j+1 < der)
            quick(A,j+1,der);
    }

}
