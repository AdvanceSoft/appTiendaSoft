/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarMarcaServicio;
import apptiendasoft.c2_aplicacion.servicio.GestionarProductoServicio;
import apptiendasoft.c2_aplicacion.servicio.GestionarTipoProductoServicio;
import apptiendasoft.c2_aplicacion.servicio.GestionarUnidadDeMedidaServicio;
import apptiendasoft.c3_dominio.entidad.Marca;
import apptiendasoft.c3_dominio.entidad.Producto;
import apptiendasoft.c3_dominio.entidad.TipoProducto;
import apptiendasoft.c3_dominio.entidad.UnidadDeMedida;
import java.awt.Dialog;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class FormRegistrarProducto extends javax.swing.JDialog {

    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    int tipo_accion = 0;
    Producto producto;
    ArrayList<TipoProducto> listaTipoDeProducto;
    ArrayList<UnidadDeMedida> listaUnidadDeMedida;
    List<Marca> listaMarca;
    Marca marca;
    TipoProducto tipoProducto;
    UnidadDeMedida unidadDeMedida;
    GestionarMarcaServicio gestionarMarcaServicio = new GestionarMarcaServicio();
    GestionarTipoProductoServicio gestionarTipoProductoServicio = new GestionarTipoProductoServicio();
    GestionarUnidadDeMedidaServicio gestionarUnidadDeMedidaServicio = new GestionarUnidadDeMedidaServicio();
    /**
     * Creates new form FormRegistrarProducto
     * @param owner
     * Este constructor sirve para crear
     */
    public FormRegistrarProducto(JDialog owner) {
        super(owner, true);
        initComponents();
        tipo_accion = ACCION_CREAR;
        this.producto = new Producto();
        LlenarComboTipoProducto();
        LlenarComboUnidadDeMedida();
        LlenarComboMarca();
        inicializarCombos();
    }
    /*Este contructor sirve para modificar, por lo tanto recibe un objeto producto*/
    public FormRegistrarProducto(Dialog owner, Producto producto) {
        super(owner, true);
        initComponents();
        tipo_accion = ACCION_MODIFICAR;
        checkEstado.setEnabled(true);
        LlenarComboTipoProducto();
        LlenarComboUnidadDeMedida();
        LlenarComboMarca();
        obtenerObjetoDeGestionar(producto);
    }
    
    private void inicializarCombos(){
        comboUnidadMedida.setSelectedIndex(-1);
        comboMarca.setSelectedIndex(-1);
        comboTipoProducto.setSelectedIndex(-1);
    }
    
    private void obtenerObjetoDeGestionar(Producto producto1) {
        this.producto = producto1;
        textoCodigoBarras.setText(String.valueOf(producto1.getCodigobarras()));
        textoNombre.setText(producto1.getNombre());
        comboMarca.setSelectedItem(producto1.getMarca().getNombre());
        textoPrecio.setText(String.valueOf(producto1.getPrecio()));
        textoareaDescripcion.setText(producto1.getDescripcion());
    }
    
    private void LlenarComboTipoProducto(){
        try{
            gestionarTipoProductoServicio = new GestionarTipoProductoServicio();
            listaTipoDeProducto = gestionarTipoProductoServicio.buscar("");
            comboTipoProducto.removeAllItems();
            for (TipoProducto tipoProducto : listaTipoDeProducto) {
                comboTipoProducto.addItem(tipoProducto.getNombre());
            }
        }catch(Exception ex){
            /*MENSAJE DE EXCEPTION*/
        }
    }    
    
    private void LlenarComboUnidadDeMedida(){
        try{
            gestionarUnidadDeMedidaServicio = new GestionarUnidadDeMedidaServicio();
            listaUnidadDeMedida = gestionarUnidadDeMedidaServicio.buscar("");
            comboUnidadMedida.removeAllItems();
            for (UnidadDeMedida unidadDeMedida : listaUnidadDeMedida) {
                comboUnidadMedida.addItem(unidadDeMedida.getNombreUnidadDeMedida());
            }
        }catch(Exception ex){
            /*MENSAJE DE EXCEPTION*/
        }
    }
    
    private void LlenarComboMarca(){
        try{
            gestionarMarcaServicio = new GestionarMarcaServicio();
            listaMarca = new ArrayList();
            listaMarca = gestionarMarcaServicio.buscarPorNombre("");
            comboMarca.removeAllItems();
            for (Marca marcas : listaMarca) {
                comboMarca.addItem(marcas.getNombre());
            }
        }catch(Exception ex){
            /*MENSAJE DE EXCEPTION*/
        }
    }
    
    private boolean verificarDatosLlenos(){
        boolean estanLlenos;
       if(!(textoNombre.getText().trim().isEmpty()) && !(textoCodigoBarras.getText().trim().isEmpty()) && !(textoareaDescripcion.getText().trim().isEmpty()) && !(textoPrecio.getText().trim().isEmpty())
           &&  comboMarca.getSelectedIndex()!=-1 && comboTipoProducto.getSelectedIndex()!=-1 && comboUnidadMedida.getSelectedIndex()!=-1)
            estanLlenos = true;
        else
            estanLlenos = false; 
        return estanLlenos;
    }
    
    private Marca obtenerObjetoMarca(){
        int index = comboMarca.getSelectedIndex();
        if(index>=0)
            marca = listaMarca.get(index);
        return marca;
    }
    
    private TipoProducto obtenerObjetoTipoProducto(){
        int index = comboTipoProducto.getSelectedIndex();
        if(index>=0)
            tipoProducto = listaTipoDeProducto.get(index);
        return tipoProducto;
    }
    
    private UnidadDeMedida obtenerObjetoUnidadMedida(){
        int index = comboUnidadMedida.getSelectedIndex();
        if(index>=0)
            unidadDeMedida = listaUnidadDeMedida.get(index);
        return unidadDeMedida;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textoCodigoBarras = new javax.swing.JTextField();
        textoNombre = new javax.swing.JTextField();
        textoPrecio = new javax.swing.JTextField();
        comboTipoProducto = new javax.swing.JComboBox();
        comboMarca = new javax.swing.JComboBox();
        comboUnidadMedida = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoareaDescripcion = new javax.swing.JTextArea();
        botonCrearTipoProducto = new javax.swing.JButton();
        botonCrearMarca = new javax.swing.JButton();
        botonCrearUnidadMedida = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        checkEstado = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Producto");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo Barras:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Precio:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Descripcion:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Tipo de Producto:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Marca:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Unidad de Medida:");

        textoCodigoBarras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        textoNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        textoPrecio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        comboTipoProducto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        comboMarca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        comboUnidadMedida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        textoareaDescripcion.setColumns(20);
        textoareaDescripcion.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textoareaDescripcion.setLineWrap(true);
        textoareaDescripcion.setRows(5);
        jScrollPane1.setViewportView(textoareaDescripcion);

        botonCrearTipoProducto.setBackground(new java.awt.Color(255, 255, 255));
        botonCrearTipoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/tipoproductox20.png"))); // NOI18N
        botonCrearTipoProducto.setText("Crear");
        botonCrearTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearTipoProductoActionPerformed(evt);
            }
        });

        botonCrearMarca.setBackground(new java.awt.Color(255, 255, 255));
        botonCrearMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/marcax20.png"))); // NOI18N
        botonCrearMarca.setText("Crear");
        botonCrearMarca.setOpaque(false);
        botonCrearMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearMarcaActionPerformed(evt);
            }
        });

        botonCrearUnidadMedida.setBackground(new java.awt.Color(255, 255, 255));
        botonCrearUnidadMedida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/unidaddemedidax20.png"))); // NOI18N
        botonCrearUnidadMedida.setText("Crear");
        botonCrearUnidadMedida.setOpaque(false);
        botonCrearUnidadMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearUnidadMedidaActionPerformed(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/guardarx32.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/salirx32.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Estado:");

        checkEstado.setSelected(true);
        checkEstado.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textoCodigoBarras)
                    .addComponent(textoNombre)
                    .addComponent(textoPrecio)
                    .addComponent(comboTipoProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboUnidadMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addComponent(checkEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCrearTipoProducto)
                    .addComponent(botonCrearMarca)
                    .addComponent(botonCrearUnidadMedida))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textoCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botonCrearTipoProducto)
                    .addComponent(comboTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botonCrearMarca)
                    .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botonCrearUnidadMedida)
                    .addComponent(comboUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(checkEstado))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonCrearTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearTipoProductoActionPerformed
        // TODO add your handling code here:
        FormRegistrarTipoProducto formRegistrarTipoProducto = new FormRegistrarTipoProducto(this);
        formRegistrarTipoProducto.setVisible(true);
        LlenarComboTipoProducto();
        
    }//GEN-LAST:event_botonCrearTipoProductoActionPerformed

    private void botonCrearMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearMarcaActionPerformed
        // TODO add your handling code here:
        FormRegistrarMarca formRegistrarMarca = new FormRegistrarMarca(this);
        formRegistrarMarca.setVisible(true);
        LlenarComboMarca();
    }//GEN-LAST:event_botonCrearMarcaActionPerformed

    private void guardarProducto() throws NumberFormatException {
        // TODO add your handling code here:
        if(verificarDatosLlenos()){
            producto.setMarca(obtenerObjetoMarca());
            producto.setTipoProducto(obtenerObjetoTipoProducto());
            producto.setUnidadDeMedida(obtenerObjetoUnidadMedida());
            producto.setCodigobarras(textoCodigoBarras.getText().trim().toUpperCase());
            producto.setNombre(textoNombre.getText().trim().toUpperCase());
            producto.setDescripcion(textoareaDescripcion.getText().trim().toUpperCase());
            producto.setPrecio(Double.parseDouble(textoPrecio.getText().trim()));
            producto.setEstado(checkEstado.isSelected());
            GestionarProductoServicio gestionarProductoServicio = new GestionarProductoServicio();
            try {
                if(producto.getCodigo()==0){
                    gestionarProductoServicio.crear(producto);
                    Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                    dispose();
                }else{
                    gestionarProductoServicio.modificar(producto);
                    Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                    dispose();
                }
                
            } catch (Exception e) {
                Mensaje.mostrarErrorExcepcion(this,e.getMessage());
            }
        }
    }

    private void botonCrearUnidadMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearUnidadMedidaActionPerformed
        // TODO add your handling code here:
        FormRegistrarUnidadDeMedida formRegistrarUnidadDeMedida = new FormRegistrarUnidadDeMedida(this);
        formRegistrarUnidadDeMedida.setVisible(true);
        LlenarComboUnidadDeMedida();
    }//GEN-LAST:event_botonCrearUnidadMedidaActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        guardarProducto();
    }//GEN-LAST:event_botonGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCrearMarca;
    private javax.swing.JButton botonCrearTipoProducto;
    private javax.swing.JButton botonCrearUnidadMedida;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JCheckBox checkEstado;
    private javax.swing.JComboBox comboMarca;
    private javax.swing.JComboBox comboTipoProducto;
    private javax.swing.JComboBox comboUnidadMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textoCodigoBarras;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoPrecio;
    private javax.swing.JTextArea textoareaDescripcion;
    // End of variables declaration//GEN-END:variables
}
