static void rombo1(int n){
        for(int a = 0; a < n-1; a++){
                for(int e = 0; e < n-a  ; e++){
                        System.out.print(" ");
                }
                for(int i = 0; i <(a*2)-1; i++){
                        System.out.print("*");
                }
        System.out.println();
        }
        for(int b = 0; b < n-1; b++){
                for(int j = 0; j <(b*2)-1; j++){
                        System.out.print("*");
                }
                for(int es = 0; es < n-b  ; es++){
                        System.out.print(" ");
                }
        System.out.println();
        }
        System.out.println();
 }


