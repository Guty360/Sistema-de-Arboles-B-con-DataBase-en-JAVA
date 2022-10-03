
package distribuidora_camassoganare;

/**
 *
 * @author Grupo 05
 */
public class Nodo_Arbol_B {
    
    int n; //numero de claves almacenadas en cada nodo
    boolean hoja; //si el nodo es hoja (nodo hoja = true; nodo interno = false)
    int key[]; //almacena la clave de cada nodo
    Nodo_Arbol_B hijo[]; //arreglo con referencias a los hijos 
    
    
    public Nodo_Arbol_B(int t) {
        n = 0;
        hoja = true;
        key = new int[((2*t)-1)];
        hijo = new Nodo_Arbol_B[2*t];
    } 

    public void imprimir(){
        System.out.println("[");
        for(int i = 0; i < n; i++)
        {
            if(i < n-1)
            {
                System.out.println(key[i] + "|");   
            }else
            {
                System.out.println(key[i]);
            }
        }      
    }
}
