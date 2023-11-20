public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.add(10);
        arbol.add(5);
        arbol.add(15);
        arbol.add(3);
        arbol.add(8);
        arbol.add(13);
        arbol.add(18);
        arbol.add(4);
        arbol.add(6);
        arbol.add(11);
        arbol.add(19);

        int hoja = 4;
        System.out.println("El nodo " +hoja+ " es hoja: " + arbol.isHoja(hoja));

        nodoA p = arbol.raiz.derecho.derecho; // nodo 8  padre 5
        System.out.println("p es igual a "+p.data+" y su padre es: "+ p.padre.data);
        
        System.out.println("La raiz es: "+arbol.raiz.data);

        arbol.showIn();
        arbol.eliminar(10);
        arbol.showIn();

        System.out.println("La raiz es: "+arbol.raiz.data);
    }
    
}
