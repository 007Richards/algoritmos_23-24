/* Date: 24/08/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Comparar 3 números para saber en qué orden están
*/

import java.util.Scanner;

public class Main 
{
   public static void main (String[] args)
   {
     Scanner entrada = new Scanner(System.in);

     int i = entrada.nextInt();
     int j = entrada.nextInt();
     int k = entrada.nextInt();

     if(i < j)
	if(j < k)
	   System.out.println(i+" "+j+" "+k);
	else
	   if(k < i)
	      System.out.println(k+" "+i+" "+j);
	   else
	      System.out.println(i+" "+k+" "+j);
     else
	if(k < j)
	   System.out.println(k+" "+j+" "+i);
	else
	   if(k < i)
	      System.out.println(j+" "+k+" "+i);
	   else
	      System.out.println(j+" "+i+" "+k);


   }

}
