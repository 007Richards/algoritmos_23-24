/*
Fecha: 4/10/2023
Autor: Ricardo Fabian Zuniga
Indicaciones: Sumar dos numeros binarios
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //int bina1 = 011001;
        //int bina2 = 100101;
        //suma(bina1, bina2);
        
        sumaBinaria();
        
    }

    public static void sumaBinaria(){
        int[] cadena = new int[20];
        int[] cdena = new int[20];
        int[] cdenamd = new int[20];
        int i, dim, dim2;
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("SUMA Y RESTA DE NUMEROS BINARIOS");
            System.out.println("---------------------------------");
            
            //ingresar los numeros y meterlos a sus respectios arreglos
            System.out.println("Ingresar el primer numero binario:");
            String cadena2 = entrada.nextLine();
            for(i = 0; i < cadena2.length(); i++){
                if(cadena2.charAt(i) == 48){
                    cadena[i] = 0;
                }else{
                    cadena[i] = 1;
                }
            }
            dim = i;
            
            System.out.println("Ingresar el segundo numero binario:");
            String cadena3 = entrada.nextLine();
            for(i = 0; i < cadena3.length(); i++){
                if(cadena3.charAt(i) == 48){
                    cdena[i] = 0;
                }else{
                    cdena[i] = 1;
                }
            }
        }
        dim2 = i;
        
        // Mostrar los numeros 
        int j = 0;
        for(i = 0; i < dim; i ++){
            if(i < (dim - dim2)){
                cdenamd[i] = 0;
            }else{
                cdenamd[i] = cdena[j];
                j ++;
            }
        }
        
        System.out.print("\n"+"El primer numero es: ");
        for(i = 0; i < dim; i ++){
            System.out.print(cadena[i]+" ");
        }
        
        
        System.out.print("\n"+"El segundo numero es: ");
        for(i = 0; i < dim; i ++){
            System.out.print(cdenamd[i]+" ");
        }
        
        // Se realiza la Suma
        int acarreo = 0;
        int resultado[]  = new int[20];
        for(i = dim-1; i >= 0; i --){
            if(acarreo == 1){
                cadena[i] = cadena[i] + acarreo;
                if(cadena[i] == 2){
                    acarreo = 1;
                    cadena[i] = 0;
                }
            }
            resultado[i+1] = cadena[i] + cdenamd[i];
            if(resultado[i+1] == 2){
                acarreo = 1;
                resultado[i + 1] = 0;
            }else{
                acarreo = 0;
            }
        }

        if(acarreo == 1)
            resultado[0] = acarreo;
            
        // Imprimir el reultado de la Suma
        System.out.print("\n"+"Resultado de la Suma: ");
        for(i = 0; i < dim+1; i ++){    
            System.out.print(resultado[i]+" ");
        }

        // Se realiza la Resta
        int acarreo2 = 0;
        int resultado2[] = new int[20];
        for(i = dim-1; i >= 0; i --){
            if(acarreo2 == 1){
                cadena[i] = cadena[i] - acarreo2;
                if(cadena[i] == 0){
                    cadena[i] = 0;
                }else{
                    cadena[i] = 1;
                }
            }
            resultado2[i+1] = cadena[i] - cdenamd[i];
                if(resultado2[i+1] == -1){
                    acarreo2 = 1;
                    resultado2[i + 1] = 1;
                }else{
                    if(resultado2[i+1] == 1){
                        acarreo2 = 0;
                        resultado2[i] = 1;
                    }else{
                        if(resultado2[i + 1] == 0){
                            acarreo2 = 0;
                            resultado2[i] = 0;
                        }
                    }
                }
        }
        if(acarreo2 == 1){
            resultado2[0] = acarreo2;
        }

        // Imprimir el reultado de la Resta
        System.out.print("\n"+"Resultado de la Resta: ");
        for(i = 0; i < dim+1; i ++){
            System.out.print(resultado2[i]+" ");
        }
        System.out.println();

    }



    public static void suma(long binary1, long binary2) {
        int x = 0;
        int acarrear = 0;

        int[] resultado = new int[20];

        while (binary1 != 0 || binary2 != 0) {
            resultado[x++] = (int) ((binary1 % 10 + binary2 % 10 + acarrear) % 2);
            acarrear = (int) ((binary1 % 10 + binary2 % 10 + acarrear) / 2);
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }
        if (acarrear != 0) {
            resultado[x++] = acarrear;
        }
        --x;
        System.out.println("El resultado es: ");
        while (x >= 0) {
            System.out.print(resultado[x--]);
        }
        System.out.println();
    }

}