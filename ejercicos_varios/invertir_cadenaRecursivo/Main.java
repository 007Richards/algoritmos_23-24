/*
Fecha: 4/10/2023
Autor: Ricardo Fabian Zuniga
Indicaciones: Invertir una cadena dada recursivamente
*/

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        String palabra = entrada.nextLine();

        invertir(palabra, 0);
        System.out.println();

        entrada.close();
    }

    public static void invertir(String cadena, int i){
        if(i == cadena.length())
            return;
        invertir(cadena, i + 1);
        System.out.print(cadena.charAt(i));
    }
    
}