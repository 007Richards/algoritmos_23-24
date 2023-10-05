/* Date: 04/10/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: convertir un numero entero a binario
*/

import java.util.Scanner;

public class Binario {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n;

        do {
            System.out.print("Introduzca numero >0: ");                                                           
            n = entrada.nextInt();
        } while (n < 0);

        System.out.print("\nBinario: ");
        Bin(n);
        entrada.close();
    }

    public static void Bin(int n) {
        if (n < 2) {
            System.out.print(n);
        } else {
            Bin(n / 2);
            System.out.print(n % 2);
        }
    }

}
