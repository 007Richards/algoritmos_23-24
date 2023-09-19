/* Date: 24/08/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Hacer un triángulo con asteriscos
*/

import java.util.Scanner;
public class Main
{
  public static void main (String[] args)
  {
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();

        for (int i=1; i<=n; i++){

          for (int y=0; y<n; y++){
	    if(y != i)
              System.out.print("*");
	    else
	      break;
	  }
	      System.out.println();
	}

  }
}



