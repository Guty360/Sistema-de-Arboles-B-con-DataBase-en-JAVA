
package distribuidora_camassoganare;

import java.sql.Connection; //conexion a la base de datos.
import java.sql.DriverManager; //controlador de la conexion
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; //capturador de errores sql de la base de datos
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Grupo 05
 */

public class Distribuidora extends javax.swing.JFrame {
//atributos generados
    Producto_Cama productoActual;
    Cliente productoActual02;
    int busqueda;
    
    private Connection conexion;
    boolean guardar=false;
    Arbol_B arbol= new Arbol_B(3);
    Cliente cliente = new Cliente();
    Producto_Cama producto = new Producto_Cama();
    public ProductoTableModel productoTModel = new ProductoTableModel();
    
    
    public Distribuidora() {
        
        initComponents();
        this.setTitle("Distribuidora Camas Sognare SA DE CV");
        conectar();
        consultaInicial();
        UpdateJTable();
        panelCrear.setVisible(false);
        panelBuscar.setVisible(false);
    }

    private void consultaInicial(){
        try {
            String sentenciaSql = "SELECT * FROM productocama";
            Statement statement = this.conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sentenciaSql);
            while (resultado.next()){
                
                Producto_Cama producto = new Producto_Cama();
                Cliente cliente = new Cliente();

                    //AGREGANDO PARA PRODUCTO
                producto.setCodigo(resultado.getInt("id"));
                producto.setModelo(resultado.getString("modelo"));
                producto.setTipo(resultado.getString("tipo"));
                producto.setTamaño(resultado.getString("tamano"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setGarantia(resultado.getString("garantia"));
                producto.setDescripcion(resultado.getString("descripcion"));
                producto.setFechaDeEntrega(resultado.getString("fechaventa"));
                producto.setFechaVctoGarantia(resultado.getString("fechaexpiraciongarantia"));

                //AGREGANDO PARA CLIENTE
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setDui(resultado.getString("dui"));
                cliente.setTelefono(resultado.getString("telefono"));
                cliente.setDireccion(resultado.getString("direccion"));

                 //AGREGANDO EL MODELO DE LA TABLA
                productoTModel.productos.add(producto);
                productoTModel.clientes.add(cliente);
            }
            jTable1.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al recuperar los productos de la base de datos");
            ex.printStackTrace();
        }
    }
    private void UpdateJTable() {
        productoTModel.productos.clear();
        productoTModel.clientes.clear();
        try {
            PreparedStatement statement = null;
            String sentenciaSql = "SELECT * FROM productocama ";
            statement = this.conexion.prepareStatement(sentenciaSql);
            
            ResultSet resultado = statement.executeQuery();
        while (resultado.next()) {
            Producto_Cama producto = new Producto_Cama();
            Cliente cliente = new Cliente();
            
            //AGREGANDO PARA PRODUCTO
            producto.setCodigo(resultado.getInt("id"));
            producto.setModelo(resultado.getString("modelo"));
            producto.setTipo(resultado.getString("tipo"));
            producto.setTamaño(resultado.getString("tamano"));
            producto.setPrecio(resultado.getDouble("precio"));
            producto.setGarantia(resultado.getString("garantia"));
            producto.setDescripcion(resultado.getString("descripcion"));
            producto.setFechaDeEntrega(resultado.getString("fechaventa"));
            producto.setFechaVctoGarantia(resultado.getString("fechaexpiraciongarantia"));
            
            //AGREGANDO PARA CLIENTE
            cliente.setNombre(resultado.getString("nombre"));
            cliente.setDui(resultado.getString("dui"));
            cliente.setTelefono(resultado.getString("telefono"));
            cliente.setDireccion(resultado.getString("direccion"));
            
            //AGREGANDO EL MODELO DE LA TABLA
            productoTModel.productos.add(producto);
            productoTModel.clientes.add(cliente);
        }
            
       } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al recuperar los productos de la base de datos");
                ex.printStackTrace();
 }
            //jTable1.repaint();
            productoTModel.fireTableDataChanged();
 }
    private void conectar(){
        try{
            
          conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/distribuidora", "distribuidora", 
"prn315distribuidora");
  
        }catch(SQLException ex){
            Logger.getLogger(Distribuidora.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonActualizar1 = new javax.swing.JButton();
        jButtonActualizar2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelCrear = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTamaño = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtFechaVenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtFechaVcto = new javax.swing.JTextField();
        txtGarantia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDui = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        BtnGuardar = new javax.swing.JButton();
        ModificarG = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        BtnBuscar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnRegistrar = new javax.swing.JButton();
        panelBuscar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtBuscarNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        BtnBuscarC = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        jButtonActualizar1.setBackground(new java.awt.Color(153, 255, 204));
        jButtonActualizar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonActualizar1.setText("REGISTRAR NUEVO");

        jButtonActualizar2.setBackground(new java.awt.Color(153, 255, 204));
        jButtonActualizar2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonActualizar2.setText("REGISTRAR NUEVO");
        jButtonActualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizar2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Distribuidora Camas Sognare SA DE CV");

        jTable1.setModel(productoTModel);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        panelCrear.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Código : ");

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Modelo : ");

        txtTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Descripción : ");

        txtDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jLabel6.setText("Datos Producto");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Tipo : ");

        txtTamaño.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtModelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Tamaño : ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Precio : ");

        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        txtFechaVenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Fecha Venta : ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Garantía : ");

        txtFechaVcto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtGarantia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtGarantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGarantiaActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Fecha Vcto. de Garantía : ");

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jLabel11.setText("Datos Venta");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Dirección : ");

        txtDui.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuiActionPerformed(evt);
            }
        });

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Dui : ");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Teléfono : ");

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Nombre : ");

        jLabel20.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jLabel20.setText("Datos Cliente");

        BtnGuardar.setBackground(new java.awt.Color(153, 102, 255));
        BtnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnGuardar.setText("GUARDAR");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        ModificarG.setBackground(new java.awt.Color(153, 102, 255));
        ModificarG.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ModificarG.setText("MODIFICAR");
        ModificarG.setToolTipText("Modificar y guardar los datos");
        ModificarG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCrearLayout = new javax.swing.GroupLayout(panelCrear);
        panelCrear.setLayout(panelCrearLayout);
        panelCrearLayout.setHorizontalGroup(
            panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearLayout.createSequentialGroup()
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6))
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTamaño, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel14)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFechaVcto)
                    .addComponent(txtGarantia)
                    .addComponent(txtPrecio)
                    .addComponent(txtFechaVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearLayout.createSequentialGroup()
                                .addComponent(ModificarG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDui, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(30, 30, 30))
        );
        panelCrearLayout.setVerticalGroup(
            panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearLayout.createSequentialGroup()
                                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnGuardar)
                            .addComponent(ModificarG)))
                    .addGroup(panelCrearLayout.createSequentialGroup()
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(13, 13, 13)
                                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)))
                            .addGroup(panelCrearLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCrearLayout.createSequentialGroup()
                                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(45, 45, 45))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearLayout.createSequentialGroup()
                                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(txtGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtFechaVcto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnSalir.setBackground(new java.awt.Color(0, 0, 0));
        BtnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnSalir.setForeground(new java.awt.Color(255, 153, 153));
        BtnSalir.setText("SALIR");
        BtnSalir.setToolTipText("Cerrar el programa");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        BtnBuscar.setBackground(new java.awt.Color(153, 255, 204));
        BtnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnBuscar.setText("BUSCAR");
        BtnBuscar.setToolTipText("clicl para buscar registro de venta");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        BtnModificar.setBackground(new java.awt.Color(153, 255, 204));
        BtnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnModificar.setText("MODIFICAR");
        BtnModificar.setToolTipText("clic para modificar registro existente");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnRegistrar.setBackground(new java.awt.Color(153, 255, 204));
        BtnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnRegistrar.setText("REGISTRAR NUEVO");
        BtnRegistrar.setToolTipText("clic para agregar un registro de venta");
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });

        panelBuscar.setBackground(new java.awt.Color(204, 204, 255));

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 24)); // NOI18N
        jLabel9.setText("Búsqueda");

        txtBuscarNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarNombreActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Código de Cama : ");

        BtnBuscarC.setBackground(new java.awt.Color(153, 102, 255));
        BtnBuscarC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnBuscarC.setText("BUSCAR");
        BtnBuscarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarCActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(153, 102, 255));
        btnVolver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVolver.setText("DESHACER BUSQUEDA");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBuscarLayout = new javax.swing.GroupLayout(panelBuscar);
        panelBuscar.setLayout(panelBuscarLayout);
        panelBuscarLayout.setHorizontalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addGap(113, 113, 113)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(BtnBuscarC, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );
        panelBuscarLayout.setVerticalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscarLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBuscarC)
                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(btnVolver))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(BtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addComponent(panelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNombreActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        try {
            if(guardar){
            
            arbol.insertar(Integer.parseInt(txtCodigo.getText()));
            
            //Agregando a los atributos de la clase producto el contenido de los textbox
            producto.setCodigo(Integer.parseInt(txtCodigo.getText()));
            producto.setModelo(txtModelo.getText());
            producto.setTipo(txtTipo.getText());
            producto.setTamaño(txtTamaño.getText());
            producto.setDescripcion(txtDescripcion.getText());
            producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
            producto.setGarantia(txtGarantia.getText());
            producto.setFechaDeEntrega(txtFechaVenta.getText());
            producto.setFechaVctoGarantia(txtFechaVcto.getText());
            
            //Agregando a los atributos de la clase cliente el contenido de los textbox
            cliente.setNombre(txtNombre.getText());
            cliente.setDui(txtDui.getText());
            cliente.setTelefono(txtTelefono.getText());
            cliente.setDireccion(txtDireccion.getText());
            

        String sentenciaSql = "INSERT INTO productocama(id, modelo, tipo, tamano, precio, descripcion, garantia, fechaventa, fechaexpiraciongarantia, nombre, dui, direccion, telefono)VALUES "
         + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSql);
            preparedStatement.setInt(1, producto.getCodigo());
            preparedStatement.setString(2, producto.getModelo());
            preparedStatement.setString(3, producto.getTipo());
            preparedStatement.setString(4, producto.getTamaño());
            preparedStatement.setDouble(5, producto.getPrecio());
            preparedStatement.setString(6, producto.getDescripcion());
            preparedStatement.setString(7, producto.getGarantia());
            preparedStatement.setString(8, producto.getFechaDeEntrega());
            preparedStatement.setString(9, producto.getFechaVctoGarantia());
            preparedStatement.setString(10, cliente.getNombre());
            preparedStatement.setInt(11, Integer.parseInt(cliente.getDui()));
            preparedStatement.setString(12, cliente.getDireccion());
            preparedStatement.setString(13, cliente.getTelefono());
           
            preparedStatement.execute();
//            productoTModel.productos.add(producto);
//            //jTable1.repaint();
//            productoTModel.clientes.add(cliente);
            UpdateJTable();
            
            }else{
                String sentenciaSql = "UPDATE productocama SET id = ?, modelo = ?, tipo = ?, tamano = ?, precio = ?, descripcion = ?, garantia = ?, fechaventa = ?, fechaexpiracionarantia = ?, nombres = ?, dui = ?, direccion = ?, telefono = ? WHERE id = ?"; 
                
                PreparedStatement preparedStatement =conexion.prepareStatement(sentenciaSql);
               preparedStatement.setInt(1, producto.getCodigo());
                preparedStatement.setString(2, producto.getModelo());
                preparedStatement.setString(3, producto.getTipo());
                preparedStatement.setString(4, producto.getTamaño());
                preparedStatement.setDouble(5, producto.getPrecio());
                preparedStatement.setString(6, producto.getDescripcion());
                preparedStatement.setString(7, producto.getGarantia());
                preparedStatement.setString(8, producto.getFechaDeEntrega());
                preparedStatement.setString(9, producto.getFechaVctoGarantia());
                preparedStatement.setString(10, cliente.getNombre());
                preparedStatement.setString(11, cliente.getDui());
                preparedStatement.setString(12, cliente.getDireccion());
                preparedStatement.setString(13, cliente.getTelefono());
                preparedStatement.setInt(14, producto.getCodigo());
               preparedStatement.executeUpdate();
               
               jTable1.repaint();
               BtnGuardar.setEnabled(true);
               
            }
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar el producto");
                
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "El registro se guardo exitosamente!","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            
            BtnGuardar.setEnabled(false);
            panelCrear.setVisible(false);
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtGarantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGarantiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGarantiaActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        panelCrear.setVisible(true);
        BtnGuardar.setEnabled(true);
        
        BtnGuardar.setVisible(false); 
        ModificarG.setVisible(true);
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        panelBuscar.setVisible(true);
        BtnGuardar.setEnabled(true);
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void jButtonActualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActualizar2ActionPerformed

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        BtnGuardar.setVisible(true);
        BtnGuardar.setEnabled(true);
        ModificarG.setVisible(false);        
        panelCrear.setVisible(true);
        guardar=true;
    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void BtnBuscarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarCActionPerformed
//        try{
            
        productoTModel.productos.clear();
        productoTModel.clientes.clear();
        
        ;
        
        try{
            PreparedStatement statement = null;
            busqueda = arbol.buscarNodoPorClave(Integer.parseInt(txtBuscarNombre.getText()));
            
            int codigo = busqueda;
            
            String sentenciaSql = "SELECT * FROM productocama";
            
            
               sentenciaSql += " WHERE id = ?";
               statement = this.conexion.prepareStatement(sentenciaSql);
               statement.setInt(1, codigo);

            
            ResultSet resultado;
             resultado = statement.executeQuery();
           
            while(resultado.next()){
                 //Agregando a los atributos de la clase producto el contenido de los textbox
            producto.setCodigo(resultado.getInt(1));
            producto.setModelo(resultado.getString(2));
            producto.setTipo(resultado.getString(3));
            producto.setTamaño(resultado.getString(4));
            producto.setPrecio(resultado.getDouble(5));
            producto.setDescripcion(resultado.getString(6));
            producto.setGarantia(resultado.getString(7));
            producto.setFechaDeEntrega(resultado.getString(8));
            producto.setFechaVctoGarantia(resultado.getString(9));
            
            //Agregando a los atributos de la clase cliente el contenido de los textbox
            cliente.setNombre(resultado.getString(10));
            cliente.setDui(resultado.getString(11));
            cliente.setTelefono(resultado.getString(12));
            cliente.setDireccion(resultado.getString(13));
                       
                
            
                //Asignacion de informacion de busqueda a la tabla de datos
                productoTModel.productos.add(producto);
                productoTModel.clientes.add(cliente);
                
                
            }
            //muestra un mensaje indicando que no se encontro el producto buscado mediante id
            if(!productoTModel.productos.isEmpty()){
            jTable1.repaint();
            productoTModel.fireTableDataChanged();
           
            }else{
                JOptionPane.showMessageDialog(this,"No se encontro ningun producto que coincida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                txtBuscarNombre.setText("");
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error al recuperar los productos de la base de datos");
            
             ex.printStackTrace();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Datos incompletos o incorrectos!","Información", JOptionPane.ERROR_MESSAGE);
        }
        
//        }catch(Exception e){
//           JOptionPane.showMessageDialog(null, "Ha ocurrido un error en el dato ingresado. Intente nuevamente");
//        } 
        
    }//GEN-LAST:event_BtnBuscarCActionPerformed

    private void txtDuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuiActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed
   
    private void ModificarGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarGActionPerformed
        // TODO add your handling code here:
        int[] indices = jTable1.getSelectedRows();
        int indice = jTable1.getSelectedRow();
        
     
            
        Producto_Cama producto = productoTModel.productos.get(indice);

        String sentenciaSql = "UPDATE productocama SET id = ?, modelo = ?, tipo = ?, tamano = ?, precio = ?, descripcion = ?, garantia = ?, fechaventa = ?, fechaexpiraciongarantia = ?, nombre = ?, dui = ?, direccion = ?, telefono = ? WHERE id = ?";
       

            try {
                PreparedStatement prepStat = conexion.prepareStatement(sentenciaSql);
                prepStat.setInt(1, Integer.parseInt(txtCodigo.getText()));
                prepStat.setString(2, String.valueOf(txtModelo.getText()));
                prepStat.setString(3, String.valueOf(txtTipo.getText()));
                prepStat.setString(4, String.valueOf(txtTamaño.getText()));
                prepStat.setDouble(5, Double.parseDouble(txtPrecio.getText()));
                prepStat.setString(6, String.valueOf(txtDescripcion.getText()));
                prepStat.setString(7, String.valueOf(txtGarantia.getText()));
                prepStat.setString(8, String.valueOf(txtFechaVenta.getText()));
                prepStat.setString(9, String.valueOf(txtFechaVcto.getText()));
                prepStat.setString(10, String.valueOf(txtNombre.getText()));
                prepStat.setInt(11, Integer.parseInt(txtDui.getText()));
                prepStat.setString(12, String.valueOf(txtDireccion.getText()));
                prepStat.setString(13, String.valueOf(txtTelefono.getText()));
                prepStat.setInt(14, producto.getCodigo());
                prepStat.executeUpdate();
                
 
                
                    
     
                
                
                JOptionPane.showMessageDialog(this,"Los datos fueron modificados exitosamente","Información", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                 Logger.getLogger(Distribuidora.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar los datos");
                }

        
        
        UpdateJTable();
        limpiarCampos();
       
        
        panelCrear.setVisible(false);
    }//GEN-LAST:event_ModificarGActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        int clics = evt.getClickCount();
        
            int row = jTable1.rowAtPoint(evt.getPoint());
            if (clics == 2) {
                
                Producto_Cama p = productoTModel.productos.get(row);
                Cliente p2 = productoTModel.clientes.get(row);
                productoActual = p;
                txtCodigo.setText(String.valueOf(p.getCodigo()));
                txtModelo.setText(p.getModelo());
                txtPrecio.setText(String.valueOf(p.getPrecio()));
                txtTipo.setText(p.getTipo());
                txtTamaño.setText(p.getTamaño());
                txtDescripcion.setText(p.getDescripcion());
                txtGarantia.setText(p.getGarantia());
                txtFechaVenta.setText(p.getFechaDeEntrega());
                txtFechaVcto.setText(p.getFechaVctoGarantia());
                
                txtNombre.setText(p2.getNombre());
                txtDui.setText(p2.getDui());
                txtDireccion.setText(p2.getDireccion());
                txtDireccion.setText(p2.getDireccion());
                txtTelefono.setText(p2.getTelefono());
                
                guardar = false;
                
            }
    
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        txtBuscarNombre.setText("");
        panelBuscar.setVisible(false);
        panelCrear.setVisible(false);
        UpdateJTable();
        limpiarCampos();
        
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Distribuidora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Distribuidora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Distribuidora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Distribuidora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Distribuidora().setVisible(true);
            }
        });
    }
    
    @Override
    public Image getIconImage(){
    
    return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/bed.png"));
    }
    
    public void limpiarCampos(){
            txtCodigo.setText("");
                txtModelo.setText("");
                txtPrecio.setText("");
                txtTipo.setText("");
                txtTamaño.setText("");
                txtDescripcion.setText("");
                txtGarantia.setText("");
                txtFechaVenta.setText("");
                txtFechaVcto.setText("");
                
                txtNombre.setText("");
                txtDui.setText("");
                txtDireccion.setText("");
                txtDireccion.setText("");
                txtTelefono.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnBuscarC;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JButton ModificarG;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButtonActualizar1;
    private javax.swing.JButton jButtonActualizar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPanel panelCrear;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDui;
    private javax.swing.JTextField txtFechaVcto;
    private javax.swing.JTextField txtFechaVenta;
    private javax.swing.JTextField txtGarantia;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTamaño;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
