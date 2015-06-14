/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarDistritoServicio;
import apptiendasoft.c2_aplicacion.servicio.GestionarProvinciaServicio;
import apptiendasoft.c3_dominio.entidad.Distrito;
import apptiendasoft.c3_dominio.entidad.Provincia;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 */
public class FormRegistrarProvincia extends javax.swing.JDialog {

    /**
     * Creates new form FormRegistrarProvincia
     */
    Provincia provincia;
    public FormRegistrarProvincia(JDialog owner) {
        super(owner, true);
        initComponents();
        this.provincia = new Provincia();
        crearTabla();
        crearTablaAsignados();
    }
    public FormRegistrarProvincia(JDialog owner, Provincia provincia) {
        super(owner, true);
        initComponents();
        obtenerObjetoDeGestionar(provincia);
    }

    private void obtenerObjetoDeGestionar(Provincia provincia) {
        this.provincia = provincia;
        textoNombreProvincia.setText(provincia.getNombre());
        mostrardistritosasignados();
    }
    
    private void crearTabla() {
        // TODO add your handling code here:
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Nombre", "java.lang.String"));
        ModeloTabla modeloTablaDistrito = new ModeloTabla(tabla);
        tablaDistritos.setModel(modeloTablaDistrito);
        //CODIGO
        TableColumn columna0,columna1;
        columna0 = tablaDistritos.getColumnModel().getColumn(0);
        tablaDistritos.removeColumn(columna0);
        //NOMBRE
        columna1 = tablaDistritos.getColumnModel().getColumn(1);
        columna1.setPreferredWidth(250);
        columna1.setMaxWidth(250);
        columna1.setMinWidth(250);  
    }
    private void crearTablaAsignados() {
        // TODO add your handling code here:
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Nombre", "java.lang.String"));
        ModeloTabla modeloTablaAsignado = new ModeloTabla(tabla);
        tablaAsignadosDistritos.setModel(modeloTablaAsignado);
        //CODIGO
        TableColumn columna0,columna1;
        columna0 = tablaAsignadosDistritos.getColumnModel().getColumn(0);
        tablaAsignadosDistritos.removeColumn(columna0);
        //NOMBRE
        columna1 = tablaAsignadosDistritos.getColumnModel().getColumn(1);
        columna1.setPreferredWidth(250);
        columna1.setMaxWidth(250);
        columna1.setMinWidth(250);
    }
    private void mostrardistritosasignados(){
        ModeloTabla modeloTabla = (ModeloTabla) tablaAsignadosDistritos.getModel();
        for(Distrito distrito : provincia.getListadistrito()){
                    Fila fila = new Fila();
                    fila.agregarValorCelda(distrito.getCodigo());
                    fila.agregarValorCelda(distrito.getNombre());
                    modeloTabla.agregarFila(fila);
                }
        modeloTabla.refrescarDatos();
        labelcantidad.setText(String.valueOf(provincia.cantidadDistritos()));
    }
    private void agregarDistrito(int codigo){
        if(obtenerCodigoDeLaTablaDistrito()!= null){
            GestionarDistritoServicio gestionarDistritoServicio = new GestionarDistritoServicio();
            try {
                Distrito distrito = gestionarDistritoServicio.buscar(codigo);
                    if(distrito != null)
                        provincia.agregarDistrito(distrito);
                    else
                        Mensaje.Mostrar_MENSAJE_FILANOEXISTE(this);
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            }
        }
        else{
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        }
    }
    private boolean verificarCamposLlenos() {
        boolean estanLlenos;
        if(!(textoNombreProvincia.getText().trim().isEmpty()))
            estanLlenos = true;
        else
            estanLlenos = false; 
        return estanLlenos;
    }
     public boolean verificarCamposVacios(){
        boolean verificar = true;
        if(textoNombreProvincia.getText().trim().isEmpty()){
           Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
           textoNombreProvincia.requestFocus();
           verificar = false;
        }else
            verificar = false;
        return verificar;
    }

     private void buscar() {
        String nombre = textoDistritoBuscar.getText().trim().toUpperCase();
        ModeloTabla modeloTablaTipoProducto = (ModeloTabla) tablaDistritos.getModel();
        modeloTablaTipoProducto.eliminarTotalFilas();
        try {
            GestionarDistritoServicio gestionarDistritoServicio = new GestionarDistritoServicio();
            ArrayList<Distrito> listaDistrito = gestionarDistritoServicio.buscarPorNombre(nombre);
            if(listaDistrito!=null && listaDistrito.size()>0){
                for(Distrito distrito : listaDistrito){
                    Fila fila = new Fila();
                    fila.agregarValorCelda(distrito.getCodigo());
                    fila.agregarValorCelda(distrito.getNombre());
                    modeloTablaTipoProducto.agregarFila(fila);
                }         
                modeloTablaTipoProducto.refrescarDatos();
                ponerFocoConSeleccionEnBuscar();
            }else{
                Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
                ponerFocoConSeleccionEnBuscar();
            }
        } catch(Exception e){    
            Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
            ponerFocoConSeleccionEnBuscar();
        }
    }
 
    private Distrito obtenerCodigoDeLaTablaDistrito() {
        Distrito distrito = null;
        int numFila = tablaDistritos.getSelectedRow();
        if(numFila >=0){
            GestionarDistritoServicio gestionarDistritoServicio = new GestionarDistritoServicio();
            ModeloTabla modeloTabla = (ModeloTabla)tablaDistritos.getModel();
            int codigo = (int) modeloTabla.getValueAt(numFila, 0);
            try{
                distrito = gestionarDistritoServicio.buscar(codigo);
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            }
        }else{
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        }
        return distrito;
    }
    private Distrito obtenerCodigoTablaAsignado(){
        Distrito distrito = null;
        int numFila = tablaAsignadosDistritos.getSelectedRow();
        if(numFila >=0){
            GestionarDistritoServicio gestionarDistritoServicio = new GestionarDistritoServicio();
            ModeloTabla modeloTabla = (ModeloTabla)tablaAsignadosDistritos.getModel();
            int codigo = (int) modeloTabla.getValueAt(numFila, 0);
            try{
                distrito = gestionarDistritoServicio.buscar(codigo);
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            }
        }else{
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        }
        return distrito;
    }
    private void ponerFocoConSeleccionEnBuscar() {
        textoDistritoBuscar.selectAll();
        textoDistritoBuscar.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonSalir = new javax.swing.JButton();
        botonQuitar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDistritos = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        botonCrear = new javax.swing.JButton();
        textoDistritoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAsignadosDistritos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        labelcantidad = new javax.swing.JLabel();
        textoNombreProvincia = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Provincia");
        setAlwaysOnTop(true);

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/salirx32.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setPreferredSize(new java.awt.Dimension(117, 41));
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonQuitar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonQuitar.setText("Quitar");
        botonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Distrito: ");

        jScrollPane1.setViewportView(tablaDistritos);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        botonCrear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/crearx32.png"))); // NOI18N
        botonCrear.setFocusable(false);
        botonCrear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCrear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });
        jToolBar1.add(botonCrear);

        textoDistritoBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        botonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/buscarx20.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(4, 4, 4)
                                .addComponent(textoDistritoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonBuscar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(textoDistritoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setViewportView(tablaAsignadosDistritos);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Cantidad de Distritos Asignados:");

        labelcantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelcantidad.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(labelcantidad))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelcantidad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textoNombreProvincia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        botonAgregar.setBackground(new java.awt.Color(255, 255, 255));
        botonAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Provincia:");

        botonGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/guardarx32.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonGuardar)
                        .addGap(35, 35, 35)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(4, 4, 4)
                                .addComponent(textoNombreProvincia))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonAgregar)
                            .addComponent(botonQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonAgregar)
                                .addGap(15, 15, 15)
                                .addComponent(botonQuitar))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textoNombreProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
        FormRegistrarDistrito formRegistrarDistrito = new FormRegistrarDistrito(this);
        formRegistrarDistrito.setVisible(true);
        buscar();
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed

        provincia.setNombre(textoNombreProvincia.getText().trim().toUpperCase());
        GestionarProvinciaServicio gestionarProvinciaServicio  = new GestionarProvinciaServicio();
            try{
                if(provincia.getCodigo()==0){
                    if(verificarCamposVacios()){
                    gestionarProvinciaServicio.crear(provincia);
                    Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                    this.dispose();
                    }
                }else{
                    gestionarProvinciaServicio.modificar(provincia);
                    Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                    this.dispose();     
                }     
            }catch(Exception ex){
                    Mensaje.mostrarErrorExcepcion(this, ex.getMessage());
            }          
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        if(verificarCamposLlenos()){
            if(Mensaje.Mostrar_MENSAJE_SALIRSINGUARDAR(this))
            this.dispose();
        }else
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:
        agregarDistrito(obtenerCodigoDeLaTablaDistrito().getCodigo());
        mostrardistritosasignados();
        
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarActionPerformed
        // TODO add your handling code here:
        try {
            if(obtenerCodigoTablaAsignado() != null){
                if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
                    return;
                provincia.eliminarDistrito(obtenerCodigoTablaAsignado());
                mostrardistritosasignados();
            }
            else{
                Mensaje.Mostrar_MENSAJE_FILANOEXISTE(this);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
        }        
    }//GEN-LAST:event_botonQuitarActionPerformed
/**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonQuitar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelcantidad;
    private javax.swing.JTable tablaAsignadosDistritos;
    private javax.swing.JTable tablaDistritos;
    private javax.swing.JTextField textoDistritoBuscar;
    private javax.swing.JTextField textoNombreProvincia;
    // End of variables declaration//GEN-END:variables
}
