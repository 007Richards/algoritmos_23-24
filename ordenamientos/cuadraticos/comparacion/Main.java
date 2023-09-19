import java.util.Arrays;
import java.util.Random;

public class Main{
	public static void main(String[] args){
		int casos = 20;
                int pruebas = 0;
                int div = (30000-3000)/(casos);

		System.out.println("  i   ,    B   ,     S    ,    I");

                for(int i = 3000; i <= 30000; i += div){
                        System.out.print(i+"   ");
                        int arr0[] = llenado(i);
			int arr1[] = new int[i];
			int arr2[] = new int[i];
			arr1 = java.util.Arrays.copyOfRange(arr0, 0, i);
			arr2 = java.util.Arrays.copyOfRange(arr0, 0, i);

                        tiempoB(arr0);
                        tiempoS(arr1);
                        tiempoI(arr2);
                        pruebas ++;
                }

        System.out.println("pruebas: "+pruebas);
        }

public static int[] llenado(int n){
	int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
                int a = (int)(Math.random()*2000000000);  
                arr[i] = a;
        }
	return arr;
}


public static void tiempoB(int arr[]){
	long inicioB = System.nanoTime();
		bubble(arr);
	long finB = System.nanoTime();

	System.out.print("B "+(finB - inicioB)+"   ");
}


public static void tiempoS(int arr[]){
	long inicioS = System.nanoTime();
		selection(arr);
	long finS = System.nanoTime();

	System.out.print("S "+(finS - inicioS)+"   ");
}


public static void tiempoI(int arr[]){
	long inicioI = System.nanoTime();
		insertion(arr);
	long finI = System.nanoTime();

	System.out.println("I "+(finI - inicioI)+"");
}

public static void bubble(int arr[]){
	for(int i = 0; i < arr.length-1; i ++){
		for(int j = 0; j < arr.length-i-1; j ++){
                	if(arr[j] < arr[j+1]){
                                int aux = arr[j];
                                arr[j] = arr[j+1];
                                arr[j+1] = aux;
                        }
                }
        }
}


public static void insertion(int arr[]){
        for(int i = 0; i < arr.length; i ++){
                int aux = arr[i];
                for(int j = i - 1; j >= 0 && arr[j] > aux; j --){
                        arr[j + 1] = arr[j];
                        arr[j] = aux;
                }
        }
}

public static void selection(int arr[]){
	for(int i = 0; i < arr.length-1; i ++){
                int min = i;
                for(int j = i+1; j < arr.length; j ++){
                        if(arr[min] > arr[j]){
                                min = j;
                        }
                }
                int aux = arr[min];
                arr[min] = arr[i];
                arr[i] = aux;
        }
}


}
