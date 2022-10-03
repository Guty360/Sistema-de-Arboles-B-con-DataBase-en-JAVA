
package distribuidora_camassoganare;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Grupo 05
 */
public class ProductoTableModel extends AbstractTableModel{
    List<Producto_Cama> productos= new ArrayList<Producto_Cama>();
    List<Cliente> clientes = new ArrayList<Cliente>();
    
    @Override
    public int getRowCount() {
        return productos.size();
    }

    
    @Override
    public int getColumnCount() {
       return 13;
    }

  
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Producto_Cama producto = productos.get(rowIndex);
       Cliente cliente = clientes.get(rowIndex);
       Object valor = null;
       
       switch(columnIndex){
           case 0: valor = producto.getCodigo();
           break;
           
           case 1: valor = producto.getModelo();
           break;
           
           case 2: valor = producto.getTipo();
           break;
           
           case 3: valor = producto.getTamaño();
           break;
           
           case 4: valor = producto.getPrecio();
           break;
           
           case 5: valor = producto.getDescripcion();
           break;
           
           case 6: valor = producto.getGarantia();
           break;
           
           case 7: valor = producto.getFechaDeEntrega();
           break;
           
           case 8: valor = producto.getFechaVctoGarantia();
           break;
           
           case 9: valor = cliente.getNombre();
           break;
           
           case 10: valor = cliente.getDui();
           break;
           
           case 11: valor = cliente.getTelefono();
           break;
           
           case 12: valor = cliente.getDireccion();
           break;
       }
       return valor;
    }
    
    
   
//Inicializa los nombres de cada columna correspondientes
    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0:
                return "Id";
            case 1:
                return "Modelo";
            case 2:
                return "Tipo";
            case 3:
                return "Tamaño";
            case 4:
                return "Precio";
            case 5:
                return "Descripción";
            case 6:
                return "Garantia";
            case 7:
                return "Fecha de venta";
         case 8:
             return "Exp. garantia";
         case 9:
             return "Nombre";
         case 10:
             return "DUI";
         case 11:
             return "Telefono";
         case 12:
             return "Dirección";
         default:
             return "";
        }
    }
}
