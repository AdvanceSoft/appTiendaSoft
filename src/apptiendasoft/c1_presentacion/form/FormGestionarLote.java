/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarLoteServicio;
import apptiendasoft.c3_dominio.entidad.Lote;
import java.util.ArrayList;
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
public final class FormGestionarLote extends javax.swing.JDialog {

    ArrayList<Lote> listalote;
    Tabla tabla_lote;
    ModeloTabla modeloTabla;
    
    public FormGestionarLote(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        crearTabla();
    }

    private FormGestionarLote(FormGestionarLote aThis, Lote obtenerObjetoTabla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void crearTabla(){
        tabla_lote = new Tabla();
        tabla_lote.agregarColumna(new Columna("Codigo","java.lang.Integer"));
        tabla_lote.agregarColumna(new Columna("Producto","java.lang.String"));
        tabla_lote.agregarColumna(new Columna("Cantidad", "java.lang.Integer"));
        tabla_lote.agregarColumna(new Columna("Fecha de Vencimiento","java.sql.Date"));
        modeloTabla = new ModeloTabla(tabla_lote);
        tablaLote.setModel(modeloTabla);
        TableColumn column0,column1,column2,column3;
        //codigo
        column0 = tablaLote.getColumnModel().getColumn(0);
        column0.setPreferredWidth(100);
        column0.setMaxWidth(100);
        column0.setMinWidth(100);
        //producto
        column1 = tablaLote.getColumnModel().getColumn(1);
        column1.setPreferredWidth(150);
        column1.setMaxWidth(150);
        column1.setMinWidth(150);
        //cantidad
        column2 = tablaLote.getColumnModel().getColumn(2);
        column2.setPreferredWidth(100);
        column2.setMaxWidth(100);
        column2.setMinWidth(100);
        //Fecha de Vencimiento
        column3 = tablaLote.getColumnModel().getColumn(3);
        column3.setPreferredWidth(120);
        column3.setMaxWidth(120);
        column3.setMinWidth(120);
        tablaLote.removeColumn(column0);
    }
    private Lote obtenerObjetoTabla(){
        Lote lote=null;
        int numFila = tablaLote.getSelectedRow();
        if(numFila == -1){
           GestionarLoteServicio gestionarLoteServicio = new GestionarLoteServicio();
           ModeloTabla modeloTabla = (ModeloTabla) tablaLote.getModel();
           int codigo = (int) modeloTabla.getValueAt(numFila, 0);
            try {
                    lote = gestionarLoteServicio.buscar(codigo);
            } catch (Exception e) {
                Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            }
        }
        else{
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        }
        return lote;
    }
    private void consultarLote(){
        crearTabla();
        String producto = textoBuscar.getText();
        try {
                GestionarLoteServicio gestionarLoteServicio = new GestionarLoteServicio();
                listalote = gestionarLoteServicio.buscarProducto(producto);
                if(listalote!=null && listalote.size()>0){
                    for(Lote lote : listalote){
                        Fila fila = new Fila();
                        fila.agregarValorCelda(lote.getCodigo());
                        fila.agregarValorCelda(lote.getCantidadlote());
                        fila.agregarValorCelda(lote.getFechavencimiento());
                        fila.agregarValorCelda(lote.getProducto().getNombre());
                        modeloTabla.agregarFila(fila);
                    }
                    modeloTabla.refrescarDatos();
                    ponerFocoConSeleccionBuscar();
                }
                else{
                    Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
                    ponerFocoConSeleccionBuscar();
                }
        } catch (Exception e) {
            Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
            ponerFocoConSeleccionBuscar();            
        }
    }
    private void ponerFocoConSeleccionBuscar(){
        textoBuscar.selectAll();
        textoBuscar.requestFocus();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar2 = new javax.swing.JToolBar();
        botonCrear = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLote = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

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
        jToolBar2.add(botonCrear);

        botonModificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/modificarx32.png"))); // NOI18N
        botonModificar.setText("Modificar");
        botonModificar.setFocusable(false);
        botonModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        jToolBar2.add(botonModificar);

        botonEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/eliminarx32.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setFocusable(false);
        botonEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        jToolBar2.add(botonEliminar);

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
        jToolBar2.add(botonSalir);

        getContentPane().add(jToolBar2, java.awt.BorderLayout.PAGE_START);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Producto:");

        textoBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        botonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/buscarx20.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        tablaLote.setAutoCreateRowSorter(true);
        tablaLote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaLote);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
        FormRegistrarLote formRegistrarLote = new FormRegistrarLote(this);
        formRegistrarLote.setVisible(true);
        consultarLote();
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        // TODO add your handling code here:
        if(obtenerObjetoTabla() != null){
            FormGestionarLote formGestionarLote = new FormGestionarLote(this,obtenerObjetoTabla());
            formGestionarLote.setVisible(true);
            consultarLote();
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        GestionarLoteServicio gestionarLoteServicio = new GestionarLoteServicio();
        if(obtenerObjetoTabla()!=null){
            if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
                return;
        try {
            gestionarLoteServicio.eliminar(obtenerObjetoTabla());
            Mensaje.Mostrar_MENSAJE_ELIMINACIONEXITOSA(this);
            consultarLote();
            ponerFocoConSeleccionBuscar();
        } catch (Exception e) {
            Mensaje.Mostrar_MENSAJE_ELIMINACIONERRONEA(this);
            consultarLote();
            ponerFocoConSeleccionBuscar();
        }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        consultarLote();
    }//GEN-LAST:event_botonBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTable tablaLote;
    private javax.swing.JTextField textoBuscar;
    // End of variables declaration//GEN-END:variables
}
