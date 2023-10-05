public class Lista{
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
