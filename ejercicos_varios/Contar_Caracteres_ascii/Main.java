public class Main {
    public static void main(String[] args){
        char[] arr = new char[127];
        char incremento = 0;
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = incremento;
            incremento ++;
        }
        
        for(int i = 0; i < arr.length; i++){
            System.out.println("indice "+i+": "+arr[i]);
        }
    }
}

/*
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int y = sc.nextInt();
    int n = sc.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++)
      A[i] = sc.nextInt();
    System.out.println(countOcurrences(A, y, n));
    sc.close();
  }

  static int countOcurrences(int[] A, int y, int i) {
    if (i == 1)
      if (A[0] == y)
        return 1;
      else
        return 0;

    if (A[i - 1] == y)
      return 1 + countOcurrences(A, y, i - 1);
    return countOcurrences(A, y, i - 1);
  }

}*/