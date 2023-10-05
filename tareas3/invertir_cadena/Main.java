/* Date: 31/08/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Dado un String, invertirlo.
*/

import java.util.Scanner;

public class Main{
  public static void main(String[] args){
	Scanner entrada = new Scanner(System.in);
	String s = entrada.nextLine();

	inv(s, 0);
	System.out.println();
  }

  static void inv(String s, int c){
	if(c<s.length()){
		inv(s, c+1);
		System.out.print(s.charAt(c));
	}
  }

} 
