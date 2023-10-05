/* Date: 31/08/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Dado un arreglo de n números enteros, el programa debe encontrar 
   el número de veces que Y aparece entre ellos.
*/
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
	Scanner entrada = new Scanner(System.in);
	int y = entrada.nextInt();
	int n = entrada.nextInt();
	int[] arr = new int[n];

	for(int i = 0; i < n;i ++){
		int k = entrada.nextInt();
		arr[i] = k;
	}
	int i = 0, oc = 0;
	buscar(arr, i, oc, y);
  }

  static void buscar(int[] arr, int i, int oc, int y){
	if(i == arr.length){
		System.out.println(oc);
	}
	else{
		if(arr[i] == y){
			oc ++;
			buscar(arr, i+1, oc, y);
		}
		else{
			buscar(arr, i+1, oc, y);			
		}
	}
  }
}
