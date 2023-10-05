/* Date: 27/08/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion:Imprimir un rombo de asteriscos, recibirán de entrada un entero impar
*/
import java.util.Scanner;

public class Main{

   public static void main(String[] args){
	Scanner entrada = new Scanner(System.in);
	int n = entrada.nextInt();
	romboc(n);
  }

 public static void romboc(int n) {
	int m = n/2;
	for (int i = 0; i < n; i++) {
		for (int k = 0; k < n; k++) {
			if (i < (n / 2)) {
				if (k >= m-i && k <= m+i)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			else if (i == m) {
				System.out.print("*");
			}
			else{
				if (k >= m-(n-i-1) && k <= m+(n-i-1))
					System.out.print("*");
				else
					System.out.print(" ");
			}
		}
		System.out.println(" ");
	}
 }

}
