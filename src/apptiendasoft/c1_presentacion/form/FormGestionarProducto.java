/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarProductoServicio;
import apptiendasoft.c3_dominio.entidad.Producto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class FormGestionarProducto extends javax.swing.JDialog {

    /**
     * Creates new form FormGestionarProducto
     * @param parent
     */
    public FormGestionarProducto(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        crearTabla();
    }
    
    private void crearTabla() {
        Tabla tabla_Producto = new Tabla();
        tabla_Producto.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla_Producto.agregarColumna(new Columna("Nombre", "java.lang.String"));
        tabla_Producto.agregarColumna(new Columna("Tipo Producto", "java.lang.String"));
        tabla_Producto.agregarColumna(new Columna("U. Medida", "java.lang.String"));
        tabla_Producto.agregarColumna(new Columna("Marca", "java.lang.String"));
        tabla_Producto.agregarColumna(new Columna("Descripcion", "java.lang.String"));
        //tabla_Producto.agregarColumna(new Columna("Stock", "java.lang.Integer"));
        tabla_Producto.agregarColumna(new Columna("Precio", "java.lang.Double"));
        
        ModeloTabla modeloTablaProducto = new ModeloTabla(tabla_Producto);
        tablaProducto.setModel(modeloTablaProducto );
        
        TableColumn columna0,columna1,columna2,columna3,columna4,columna5,columna6;
        //Codigo
        columna0 = tablaProducto.getColumnModel().getColumn(0);
        columna0.setPreferredWidth(150);
        columna0.setMaxWidth(200);
        columna0.setMinWidth(150);
        //Nombre
        columna1 = tablaProducto.getColumnModel().getColumn(1);
        columna1.setPreferredWidth(140);
        columna1.setMaxWidth(250);
        columna1.setMinWidth(140);
        //Tipo Producto
        columna2 = tablaProducto.getColumnModel().getColumn(2);
        columna2.setPreferredWidth(120);
        columna2.setMaxWidth(160);
        columna2.setMinWidth(120);
        //Unidad de Medida
        columna3 = tablaProducto.getColumnModel().getColumn(3);
        columna3.setPreferredWidth(65);
        columna3.setMaxWidth(75);
        columna3.setMinWidth(65);
        //Marca
        columna4 = tablaProducto.getColumnModel().getColumn(4);
        columna4.setPreferredWidth(100);
        columna4.setMaxWidth(120);
        columna4.setMinWidth(100);
        //Descripcion
        columna5 = tablaProducto.getColumnModel().getColumn(5);
        columna5.setPreferredWidth(250);
        columna5.setMaxWidth(300);
        columna5.setMinWidth(250);
        //Precio
        columna6 = tablaProducto.getColumnModel().getColumn(6);
        columna6.setPreferredWidth(55);
        columna6.setMaxWidth(60);
        columna6.setMinWidth(55);
        tablaProducto.removeColumn(columna0);
    }
    
    private void buscar(){
        ArrayList<Producto> listaProducto;
        ModeloTabla modeloTablaProducto = (ModeloTabla) tablaProducto.getModel();
        modeloTablaProducto.eliminarTotalFilas();
        String nombre = textoBuscar.getText().trim().toLowerCase();
        try {
            GestionarProductoServicio gestionarProductoServicio = new GestionarProductoServicio();
            listaProducto = gestionarProductoServicio.buscar(nombre);
            if(listaProducto!=null && listaProducto.size()>0){
                for(Producto producto : listaProducto){
                    Fila fila = new Fila();
                    fila.agregarValorCelda(producto.getCodigo());
                    fila.agregarValorCelda(producto.getNombre());
                    fila.agregarValorCelda(producto.getTipoProducto().getNombre());
                    fila.agregarValorCelda(producto.getUnidadDeMedida().getNombreUnidadDeMedida());
                    fila.agregarValorCelda(producto.getMarca().getNombre());
                    fila.agregarValorCelda(producto.getDescripcion());
                    fila.agregarValorCelda(producto.getPrecio());
                    modeloTablaProducto.agregarFila(fila);
                }  
                tablaProducto.setModel(modeloTablaProducto);
            }else{
                Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
                //ponerFocoConSeleccionEnBuscar();
            }             
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        botonCrear = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        radioCodigoBarras = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        radioNombre = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        radioTipoProducto = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        radioMarca = new javax.swing.JRadioButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        radioUnidadMedida = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        textoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Producto");
        setResizable(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        botonCrear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/crearx32.png"))); // NOI18N
        botonCrear.setText("Crear");
        botonCrear.setFocusable(false);
        botonCrear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCrear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });
        jToolBar1.add(botonCrear);

        botonModificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/modificarx32.png"))); // NOI18N
        botonModificar.setText("Modificar");
        botonModificar.setFocusable(false);
        botonModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(botonModificar);

        botonEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/eliminarx32.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setFocusable(false);
        botonEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(botonEliminar);

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/salirx32.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setFocusable(false);
        botonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(botonSalir);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        buttonGroup1.add(radioCodigoBarras);
        radioCodigoBarras.setText("Codigo de Barras");
        radioCodigoBarras.setFocusable(false);
        radioCodigoBarras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        radioCodigoBarras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(radioCodigoBarras);
        jToolBar3.add(jSeparator1);

        buttonGroup1.add(radioNombre);
        radioNombre.setSelected(true);
        radioNombre.setText("Nombre ");
        radioNombre.setFocusable(false);
        radioNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        radioNombre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(radioNombre);
        jToolBar3.add(jSeparator2);

        buttonGroup1.add(radioTipoProducto);
        radioTipoProducto.setText("Tipo de Producto");
        radioTipoProducto.setFocusable(false);
        radioTipoProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        radioTipoProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(radioTipoProducto);
        jToolBar3.add(jSeparator3);

        buttonGroup1.add(radioMarca);
        radioMarca.setText("Marca");
        radioMarca.setFocusable(false);
        radioMarca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        radioMarca.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(radioMarca);
        jToolBar3.add(jSeparator4);

        buttonGroup1.add(radioUnidadMedida);
        radioUnidadMedida.setText("Unidad de Medida");
        radioUnidadMedida.setFocusable(false);
        radioUnidadMedida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        radioUnidadMedida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(radioUnidadMedida);

        jPanel1.add(jToolBar3, java.awt.BorderLayout.PAGE_START);

        textoBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        botonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/buscarx20.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.setOpaque(false);
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaProducto);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
        FormRegistrarProducto formRegistrarProducto = new FormRegistrarProducto(this);
        formRegistrarProducto.setVisible(true);
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_botonBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JRadioButton radioCodigoBarras;
    private javax.swing.JRadioButton radioMarca;
    private javax.swing.JRadioButton radioNombre;
    private javax.swing.JRadioButton radioTipoProducto;
    private javax.swing.JRadioButton radioUnidadMedida;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTextField textoBuscar;
    // End of variables declaration//GEN-END:variables
}
