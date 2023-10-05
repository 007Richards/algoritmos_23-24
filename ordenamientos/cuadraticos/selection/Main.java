/* Date: 02/10/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Implementacion del algoritmo de selection sort
*/

import java.util.Random;

public class Main{
        public static void main(String[] args){
		int pruebas = 0;
                int casos = 20;
                int div = (30000-3000)/(casos);
                for(int i = 3000; i <= 30000; i += div){
			System.out.print("i: "+i);
                        int arr[] = llenado(i);
                        tiempo(arr);
                        pruebas ++;
                }
        System.out.println("pruebas: "+pruebas);
        }

public static int[] llenado(int n){
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
                int a = (int)(Math.random()*2000000000);
                arr[i] = a;
        }
        return arr;
}


public static void tiempo(int arr[]){
        long inicioS = System.nanoTime();
                selection(arr);
        long finS = System.nanoTime();

        System.out.println("   time: "+(finS - inicioS)+"");

}


public static void selection(int arr[]){
	for(int i = 0; i < arr.length-1; i ++){
		int min = i;
                for(int j = i+1; j < arr.length; j ++){
                	if(arr[min] > arr[j]){
				min = j;
                        }
		}
		int aux = arr[min];
		arr[min] = arr[i];
		arr[i] = aux;
	}
}

}


