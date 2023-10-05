/* Date: 04/10/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: contar el numero de numeros primos en un rango
*/

import java.util.Scanner;

public class NumPrimos {
    public static void main(String[] args) {
        int num, contador = 0;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Escribe el Numero:");
        num = entrada.nextInt();

        for (int x = 0; x <= num; x++) {
            if (esPrimo(x)) {
                contador++;
                System.out.print(String.valueOf(x) + ",");
            }
        }
        System.out.printf("\nTotal: "+ contador);

        entrada.close();
    }

    public static boolean esPrimo(int numero) {
        // El 0, 1 y 4 no son primos
        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        for (int x = 2; x < numero / 2; x++) {
            // Si es divisible por estos números, no es primo
            if (numero % x == 0)
                return false;
        }
        return true;
    }
}