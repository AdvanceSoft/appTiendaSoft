/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarDepartamentoServicio;
import apptiendasoft.c2_aplicacion.servicio.GestionarProvinciaServicio;
import apptiendasoft.c3_dominio.entidad.Departamento;
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
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 */
public class FormRegistrarDepartamento extends javax.swing.JDialog {

    ArrayList<Provincia> listaProvincia;
    Departamento departamento;
    public FormRegistrarDepartamento(JDialog owner) {
        super(owner, true);
        initComponents();
        this.departamento = new Departamento();
        crearTabla();
        crearTablaAsignados();
    }
    public FormRegistrarDepartamento(JDialog owner, Departamento departamento) {
        super(owner, true);
        initComponents();
        obtenerObjetoDeGestionar(departamento);
    }
    private void obtenerObjetoDeGestionar(Departamento departamento) {
        this.departamento = departamento;
        textonombredepartamento.setText(departamento.getNombre());
        mostrarprovinciasasignados();
    }
    
    private void crearTabla() {
        // TODO add your handling code here:
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Nombre", "java.lang.String"));
        ModeloTabla modeloTablaProvincia = new ModeloTabla(tabla);
        tablaProvincias.setModel(modeloTablaProvincia);
        //CODIGO
        TableColumn columna0,columna1;
        columna0 = tablaProvincias.getColumnModel().getColumn(0);
        tablaProvincias.removeColumn(columna0);
        //NOMBRE
        columna1 = tablaProvincias.getColumnModel().getColumn(1);
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
        tablaAsignadosProvincias.setModel(modeloTablaAsignado);
        //CODIGO
        TableColumn columna0,columna1;
        columna0 = tablaAsignadosProvincias.getColumnModel().getColumn(0);
        tablaAsignadosProvincias.removeColumn(columna0);
        //NOMBRE
        columna1 = tablaAsignadosProvincias.getColumnModel().getColumn(1);
        columna1.setPreferredWidth(250);
        columna1.setMaxWidth(250);
        columna1.setMinWidth(250); 
    }
    
    private boolean verificarCamposLlenos() {
        boolean estanLlenos;
        if(!(textonombredepartamento.getText().trim().isEmpty()))
            estanLlenos = true;
        else
            estanLlenos = false; 
        return estanLlenos;
    }

    private boolean verificarCamposVacios(){
        boolean verificar = true;
        if(textonombredepartamento.getText().trim().isEmpty()){
           Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
           textonombredepartamento.requestFocus();
           verificar = false;
        }else
            verificar = false;
        return verificar;
    }
    
    private void buscar(){
        String nombre = textoProvinciaBuscar.getText().trim().toUpperCase();
        ModeloTabla modeloTablaProvincia = (ModeloTabla) tablaProvincias.getModel();
        modeloTablaProvincia.eliminarTotalFilas();
        try {
            GestionarProvinciaServicio gestionarProvinciaServicio = new GestionarProvinciaServicio();
            listaProvincia = gestionarProvinciaServicio.buscarPorNombre(nombre);
            if(listaProvincia!=null && listaProvincia.size()>0){
                for(Provincia provincia : listaProvincia){
                    Fila fila = new Fila();
                    fila.agregarValorCelda(provincia.getCodigo());
                    fila.agregarValorCelda(provincia.getNombre());
                    modeloTablaProvincia.agregarFila(fila);
                }         
                modeloTablaProvincia.refrescarDatos();
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
    
    private Provincia obtenerCodigoDeLaTablaProvincia() {
        Provincia provincia = null;
        int numFila = tablaProvincias.getSelectedRow();
        if(numFila >=0){
            GestionarProvinciaServicio gestionarProvinciaServicio = new GestionarProvinciaServicio();
            ModeloTabla modeloTabla = (ModeloTabla) tablaProvincias.getModel();
            int codigo = (int)modeloTabla.getValueAt(numFila, 0);
            try{
                provincia = gestionarProvinciaServicio.buscar(codigo);
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            }
        }
        return provincia;
    }
    private Provincia obtenerCodigoTablaAsignado(){
        Provincia provincia = null;
        int numFila = tablaAsignadosProvincias.getSelectedRow();
        if(numFila >=0){
            GestionarProvinciaServicio gestionarProvinciaServicio = new GestionarProvinciaServicio();
            ModeloTabla modeloTabla = (ModeloTabla) tablaAsignadosProvincias.getModel();
            int codigo = (int)modeloTabla.getValueAt(numFila, 0);
            try{
                provincia = gestionarProvinciaServicio.buscar(codigo);
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            }
        }
        return provincia;
    }
    private void ponerFocoConSeleccionEnBuscar() {
        textoProvinciaBuscar.selectAll();
        textoProvinciaBuscar.requestFocus();
    }
    
    private void mostrarprovinciasasignados(){
        ModeloTabla modeloTablaProvincias = (ModeloTabla) tablaAsignadosProvincias.getModel();
        for(Provincia provincia : departamento.getListaProvincia()){
                Fila fila = new Fila();
                fila.agregarValorCelda(provincia.getCodigo());
                fila.agregarValorCelda(provincia.getNombre());
                modeloTablaProvincias.agregarFila(fila);
        }
        modeloTablaProvincias.refrescarDatos();
        labelcantidad.setText(String.valueOf(departamento.cantidadDeProvincias()));
    }
    private void agregarProvincia(int codigo){
        if(obtenerCodigoDeLaTablaProvincia() != null){
            GestionarProvinciaServicio gestionarProvinciaServicio = new GestionarProvinciaServicio();
            try {
                Provincia provincia = gestionarProvinciaServicio.buscar(codigo);
                if(provincia != null){
                departamento.agregarProvincias(provincia);
                }
                else
                    Mensaje.Mostrar_MENSAJE_FILANOEXISTE(this);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
            }
        }else{
                Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProvincias = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        botonCrear = new javax.swing.JButton();
        textoProvinciaBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        botonQuitar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAsignadosProvincias = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        labelcantidad = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        textonombredepartamento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Provincia");

        tablaProvincias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaProvincias);

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

        textoProvinciaBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

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
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoProvinciaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(textoProvinciaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonBuscar))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonQuitar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonQuitar.setText("Quitar");
        botonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaAsignadosProvincias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaAsignadosProvincias);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Cantidad de Provincias Asignados:");

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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(labelcantidad)))
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
        botonSalir.setPreferredSize(new java.awt.Dimension(117, 41));
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        textonombredepartamento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Departamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textonombredepartamento))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAgregar)
                    .addComponent(botonQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuardar)
                .addGap(10, 10, 10)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textonombredepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(botonAgregar)
                            .addGap(15, 15, 15)
                            .addComponent(botonQuitar))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
        FormRegistrarProvincia formRegistrarProvincia = new FormRegistrarProvincia(this);
        formRegistrarProvincia.setVisible(true);
        buscar();
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:
        agregarProvincia(obtenerCodigoDeLaTablaProvincia().getCodigo());
        mostrarprovinciasasignados();
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarActionPerformed
        // TODO add your handling code here:
        try {
            if(obtenerCodigoTablaAsignado() != null){
                if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
                return;
                departamento.eliminarProvincia(obtenerCodigoTablaAsignado());
                mostrarprovinciasasignados();
            }
            else{
                Mensaje.Mostrar_MENSAJE_FILANOEXISTE(this);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error: "+e.getMessage());
        }

    }//GEN-LAST:event_botonQuitarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        
        departamento.setNombre(textonombredepartamento.getText().trim().toUpperCase());
        GestionarDepartamentoServicio gestionarDepartamentoServicio  = new GestionarDepartamentoServicio();
            try{
                if(departamento.getCodigo()==0){
                    if(verificarCamposVacios()){
                        gestionarDepartamentoServicio.crear(departamento);
                        Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                        this.dispose();
                    }
                }else{
                    gestionarDepartamentoServicio.modificar(departamento);
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
    private javax.swing.JTable tablaAsignadosProvincias;
    private javax.swing.JTable tablaProvincias;
    private javax.swing.JTextField textoProvinciaBuscar;
    private javax.swing.JTextField textonombredepartamento;
    // End of variables declaration//GEN-END:variables
}
