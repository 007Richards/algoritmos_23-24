/* Date: 24/08/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Se le preguntará al usuario un número, y debe adivinar el número escogido 
   dentro del programa. En cada número dado por el usuario, el programa debe "ayudar" 
   indicando si el número es menor o mayor.
*/

import java.util.Scanner;
import java.util.Random;
 
public class Main
{
   public static void main(String[] args)
   {
     int s = (int)Math.floor(Math.random()*100);

     encontrar(s);
     
   }

public static void encontrar(int s){
     Scanner entrada = new Scanner(System.in);
    System.out.print("#?");
    int u = entrada.nextInt();
    if (u == s){
        System.out.println(">encontrado");
    }
    else{
        if(u < s){
             System.out.println(">mayor");
             encontrar(s);
        }
        else{
             System.out.println(">menor");
              encontrar(s);
        }
    }
}


}
