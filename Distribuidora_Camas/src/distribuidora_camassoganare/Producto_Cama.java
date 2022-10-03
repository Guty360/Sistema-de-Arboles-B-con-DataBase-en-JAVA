package distribuidora_camassoganare;

/**
 * @author GRUPO 05
 */
public class Producto_Cama {  
    //Informacion sobre las camas que se distribuiran
    
    //DECLARACIÓN DE ATRIBUTOS
    private int codigo;
    private String modelo; 
    private String tipo; 
    private String tamaño;
    private double precio;
    private String garantia;
    private String descripcion;
    private String fechaDeEntrega;
    private String fechaVctoGarantia;

    //SET Y GET
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
      
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getFechaDeEntrega() {
        return fechaDeEntrega;
    }

    public void setFechaDeEntrega(String fechaDeEntrega) {
        this.fechaDeEntrega = fechaDeEntrega;
    }

    public String getFechaVctoGarantia() {
        return fechaVctoGarantia;
    }

    public void setFechaVctoGarantia(String fechaVctoGarantia) {
        this.fechaVctoGarantia = fechaVctoGarantia;
    }
    
     public Producto_Cama() {
    }
    
}
