/* Date: 04/10/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Practica y ejemplo de una lista enlazada con la clase nodo y lista
*/

public class Main {
    public static void main(String[] args){

        Nodo firts = new Nodo("primero");
        Nodo second = new Nodo(606);
        Nodo third = new Nodo("git");

        firts.enlazarSiguinete(second);
        firts.obtenerSiguiente().enlazarSiguinete(third);

        System.out.println(firts.obtenerSiguiente().obtenerValor().toString());


        Lista list = new Lista();
        
        System.out.println("-------\n\n"+"Esta vacia: " + list.isEmpty());

        list.addPrimero("cadena");
        list.addPrimero(808);
        list.addPrimero("qwerty");
        list.addPrimero(707);

        System.out.println("primer elemento: "+list.obtener(0));
        System.out.println("ultimo elemento: "+list.obtener(list.size()-1));
        System.out.println("indece 2: "+list.obtener(2));

        System.out.println("Esta vacia: " + list.isEmpty());

    }
}
/*

class Nodo{
    Object valor;
    Nodo siguiente;

    public Nodo(Object valor){
        this.valor = valor;
        this.siguiente = null;
    }

    public Object obtenerValor(){
        return this.valor;
    }

    public void enlazarSiguinete(Nodo n){
        siguiente = n;
    }

    public Nodo obtenerSiguiente(){
        return siguiente;
    }
}   


class Lista{
    Nodo cabeza;
    int size;

    public Lista(){
        cabeza = null;
        size = 0;
    }

    public Object obtener(int index){
        int contador = 0;
        Nodo temp = cabeza;

        while(contador < index){
            temp = temp.obtenerSiguiente();
            contador ++;
        }
        return temp.obtenerValor();
    }

    public void addPrimero(Object obj){
        if(cabeza == null){
            cabeza = new Nodo(obj);
        }else{
            Nodo temp = cabeza;
            Nodo nuevo = new Nodo(obj);
            nuevo.enlazarSiguinete(temp);
            cabeza = nuevo;
        }
        size ++;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (cabeza == null)?true:false;
    }

}
*/