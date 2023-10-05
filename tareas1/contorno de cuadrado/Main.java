/* Date: 24/08/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Hacer el contorno de un cuadrado con asteriscos
*/

import java.util.Scanner;
public class Main
{
  public static void main (String[] args)
  {
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();

        for (int i=0; i<n; i++){

          for (int y=0; y<n; y++){
	    if(i == 0 || i == n-1)
		System.out.print("*");
	    else
		if(y == 0 || y == n-1)
		  System.out.print("*");
		else
		  System.out.print(" ");		  
          }
          System.out.println();
        }

  }
}


