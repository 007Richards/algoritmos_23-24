/* Date: 31/08/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Dado un arreglo de n números enteros, el programa debe encontrar 
   el valor máximo entre ellos.
*/

import java.util.Scanner;

public class Main{
  public static void main(String[] args){
	Scanner entrada = new Scanner(System.in);
	int n = entrada.nextInt();
	int[] a = new int[n];

	for(int i = 0; i < n;i ++){
		int k = entrada.nextInt();
		a[i] = k;
	}
	int s = 0, m = a[0];
	buscar(a, s, m);
  }

  static void buscar(int[] a, int s, int m){
	if(s == a.length){
		System.out.println(m);
	}
	else{
		if(m < a[s]){
			m = a[s];
			buscar(a, s+1, m);
		}
		else{
			buscar(a, s+1, m);
		}
	}
  }
}
