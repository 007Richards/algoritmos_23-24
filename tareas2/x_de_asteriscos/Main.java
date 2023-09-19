/* Date: 27/08/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion:Imprimir un asterisco con asteriscos, la entrada será un número entero impar
*/
import java.util.Scanner;

public class Main{

  public static void main(String[] args){
	Scanner entrada = new Scanner(System.in);
	int n = entrada.nextInt();

	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			if(j == i || j == n-(i+1))
				System.out.print("*");
			else
				System.out.print(" ");
		}
		System.out.println();
	}
	



  }

}
