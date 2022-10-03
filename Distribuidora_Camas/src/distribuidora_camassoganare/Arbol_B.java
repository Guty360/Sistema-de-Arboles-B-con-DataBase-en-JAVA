package distribuidora_camassoganare;

import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 05
 */
public class Arbol_B {

    Nodo_Arbol_B raiz; //inicio o raiz del arbol instancia
    int t; //grado minimo del arbol
    
    
    public Arbol_B(int t){
     this.t = t;   
     raiz = new Nodo_Arbol_B(t);
    } 
    
    public int buscarNodoPorClave(int num) {
        Nodo_Arbol_B temp = search(raiz, num);
        
        if (temp == null) {
            //System.out.println("No se ha encontrado el valor solictado");
            //JOptionPane.showMessageDialog(null, "No se ha encontrado el valor solictado");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el valor solictado");
            for(int i = 0; i < temp.n; i++){
            if(num == temp.key[i]){
                
                //System.out.println("Elemento encontrado: " + num); 
            }
            else{
                //System.out.println("Elemento no encontrado: " + num); 
            }
            //print(temp);
            }
        }
        return num;
    }
    
    
    //Search
    private Nodo_Arbol_B search(Nodo_Arbol_B actual, int key) {
        int i = 0;//se empieza a buscar siempre en la primera posicion

        //Incrementa el indice mientras el valor de la clave del nodo sea menor
        while (i < actual.n && key > actual.key[i]) {
            i++;
        }

        //Si la clave es igual, entonces retornamos el nodo
        if (i < actual.n && key == actual.key[i]) {
            return actual;
        }

        //Si llegamos hasta aqui, entonces hay que buscar los hijos
        //Se revisa primero si tiene hijos
        if (actual.hoja) {
            return null;
        } else {
            //Si tiene hijos, hace una llamada recursiva
            return search(actual.hijo[i], key);
        }
    }
    
    
    public void insertar(int key){
        Nodo_Arbol_B r = raiz;
      
        //verificamos si el nodo esta lleno 
        //n es el valor minimo de del arbol si el nodo esta lleno se divide 
        if(r.n == (2*t)-1){
            Nodo_Arbol_B s = new Nodo_Arbol_B(t);
            raiz = s;
            
            s.hoja = false;
            s.n = 0;
            s.hijo[0] = r;
            split(s,0,r); //No es una funcion es un metodo separador creado de cero
            nonFullInsert(s,key);//<--- Método
            
        }else
        {
            nonFullInsert(r,key);
        }
    }
        //impresion del nodo
    public void showBTree(){
        print(raiz);
    }
   public void print(Nodo_Arbol_B n){
        n.imprimir();
        
        //si corresponde a una hoja
        if(!n.hoja){
            //recorremos el nodo
            for(int j = 0; j <= n.n; j++){
                if(n.hijo[j] != null){
                    System.out.println();
                    print(n.hijo[j]);
                }
            }
        }
    } 
    
    public void split(Nodo_Arbol_B x, int i, Nodo_Arbol_B y){
        //nodo auxiliar siguiendo el modelo de 2t - 1 
        Nodo_Arbol_B z = new Nodo_Arbol_B(t);
        z.hoja = y.hoja;
        z.n = (t - 1);
        
        //copiamos las ultimas hojas de (t - 1) claves del nodo e inicio del nodo Z
        //Z es un nodo auxiliar para realizar separacion y asignaciones
        
        for(int j = 0; j < (t - 1); j++){
            z.key[j] = y.key[j + t];
        }
        
//        sino corresponde a una hoja hay que reasignar

        if(!y.hoja){
            for(int k =0; k < t; k++){
                z.hijo[k] = y.hijo[k+t];
            }
        }
        
        //nuevo tamaño de y 
        y.n = (t - 1);
        
        //movemos los hijos de x para generar el nuevo espacio a z
        for(int j = x.n; j>i; j--){
            x.hijo[(j+1)] = x.hijo[j];
        }
        
        //reasignamos el valor del hijo en (i+1) de x
        x.hijo[(i + 1)] = z;
        
        
        //movemos las claves de x 
        for(int j = x.n;j > i;j--){
            x.key[(j+1)] = x.key[j];
        }
        
        //agregamos la clave situanda en la mediana o mitad del nodo
        x.key[i] = y.key[(t - 1)];
        x.n++;
    }
    
    //metodo nonFullInsert
    //realiza la division de un nodo para insertar mas informacion
    public void nonFullInsert(Nodo_Arbol_B x, int key){
        //si corresponde a una hoja
        
        if(x.hoja){
            int i = x.n;//cantidad del nodo
            
            //buscamos la posicion i para asignar
            while(i >= 1 && key < x.key[i-1])
            {
                //desplazamos una posicion todo los nodos menores
                x.key[i] = x.key[i-1];
                i--;
            }
        x.key[i] = key; //asignamos el valor nuevo
        x.n++;
        }else
        {
            int j = 0;
            
            //buscamos la posicion del hijo
            while(j < x.n && key > x.key[j])
            {
               j++; 
            }
            
            //si el nodo hijo esta lleno lo separamos
            if(x.hijo[j].n == (2*t-1)){
                split(x, j, x.hijo[j]);
                
                if(key > x.key[j])
                {
                    j++;
                }
            }
            nonFullInsert(x.hijo[j], key);
        }
    }
}
