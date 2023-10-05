/* Date: 02/10/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Implementacion del algoritmo de insertion sort
*/

import java.util.Random;

public class Main{
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
        System.out.println("pruebas: "+pruebas);
        prueba();
        }

                
public static int[] llenado(int n){
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
                int a = (int)(Math.random()*150);//2000000000);
                arr[i] = a;
        }
        return arr;
}


public static void tiempo(int arr[]){
        long inicioI = System.nanoTime();
                insertion(arr);
        long finI = System.nanoTime();

        System.out.println("  time: "+(finI - inicioI)+"");
}

public static void prueba(){
        int arr[] = llenado(20);
        for(int i = 0; i< arr.length; i ++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
        insertion2(arr);
        for(int i = 0; i< arr.length; i ++){
            System.out.print(arr[i]+" ");
        }
    }

public static void insertion(int arr[]){
	for(int i = 0; i < arr.length; i ++){
		int aux = arr[i];
                for(int j = i - 1; j >= 0 && arr[j] > aux; j --){
        	        arr[j + 1] = arr[j];
	                arr[j] = aux;
                }
	}
}

public static void insertion2(int[] arr){
        for(int i = 1; i < arr.length; i ++){
                int actual = arr[i];
                int j = i-1;
                while(j >= 0 && arr[j] > actual){
                        arr[j+1] = arr[j];
                        j --;
                }
                arr[j+1] = actual;
        }
}

}


