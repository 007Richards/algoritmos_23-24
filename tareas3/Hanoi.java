/* Date: 31/08/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Programar el juego de las torres de Hanoi.
*/

import java.util.Scanner;

public class Hanoi{
  public static void main(String[] args){
	Scanner entrada = new Scanner(System.in);
	int n = entrada.nextInt();

	hanoi(n, 'A', 'B', 'C');
  }

  static void hanoi(int n, char origen, char aux, char destino){
	if(n == 1)
		System.out.println("mover disco: "+n+" de "+origen+" a "+destino);
	else{
		hanoi(n-1, origen, destino, aux);
		System.out.println("mover disco: "+n+" de "+origen+" a "+destino);
		hanoi(n-1, aux, origen, destino);		
	}
  }

}
