import java.util.Random;

public class Main{
	public static void main(String[] args){
		int pruebas = 0;
		int casos = 20;
		int div = (30000-3000)/(casos);
		for(int i = 3000; i <= 30000; i += div){
			System.out.println("i: "+i);
			int arr[] = llenado(i);
			tiempo(arr);
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


public static void tiempo(int arr[]){
        long inicioB = System.nanoTime();
                bubble(arr);
        long finB = System.nanoTime();

	System.out.println("t: "+(finB - inicioB)+"\n");
}

public static void bubble(int arr[]){
	long iter = 0;
	for(int i = 0; i < arr.length-1; i ++){
		for(int j = 0; j < arr.length-i-1; j ++){
			if(arr[j] < arr[j+1]){
				int aux = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = aux;
				iter ++;
			}
		}
	}
	System.out.println("ite: "+iter); 
}


}
