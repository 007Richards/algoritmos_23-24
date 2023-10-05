/* Date: 27/08/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion:Imprimir un asterisco con asteriscos, la entrada será un número entero impar
*/
import java.util.Scanner;

public class Main{

   public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();
        asterisco(n);

  }

public static void asterisco(int n){
        int m =n/2;
        for(int i=0; i<n; i++){
                for(int k=0; k<n; k++){
                        if(i == m || k == m || k == i || k == n-(i+1))
                                System.out.print("*");
                        else
                                System.out.print(" ");

                }
        System.out.println();
        }

}

}

