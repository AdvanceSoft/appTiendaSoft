/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarUnidadDeMedida;
import apptiendasoft.c3_dominio.entidad.UnidadDeMedida;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public class FormGestionarUnidadDeMedida extends javax.swing.JDialog {

    /**
     * Creates new form FormGestionarUnidadDeMedida
     */
    public FormGestionarUnidadDeMedida(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        crearTablaUnidadDeMedida();
    }
    /**
     * Metodo para crear nuestro modelo de la tabla unidad de medida
     */
    private void crearTablaUnidadDeMedida(){  
        Tabla tablaUnidadDeMedida = new Tabla();
        tablaUnidadDeMedida.agregarColumna(new Columna("UNIDADMEDIDAID","java.lang.Integer"));
        tablaUnidadDeMedida.agregarColumna(new Columna("NOMBRE","java.lang.String"));
        tablaUnidadDeMedida.agregarColumna(new Columna("DESCRIPCION","java.lang.String"));
        ModeloTabla modeloTablaUnidadDeMedida = new ModeloTabla(tablaUnidadDeMedida); 
        tablaUnidadDeMedidas.setModel(modeloTablaUnidadDeMedida);
        
        TableColumn columna0,columna1,columna2;
        columna0= tablaUnidadDeMedidas.getColumnModel().getColumn(0);
        tablaUnidadDeMedidas.removeColumn(columna0);
        columna1 = tablaUnidadDeMedidas.getColumnModel().getColumn(0);
        columna1.setPreferredWidth(80);
        columna1.setMaxWidth(150);
        columna1.setMinWidth(50);
        columna2 = tablaUnidadDeMedidas.getColumnModel().getColumn(1);
        columna2.setPreferredWidth(360);
        columna2.setMaxWidth(400);
        columna2.setMinWidth(100);    
    }

    /**
     * Metodo para consultar las unidades de medida por descripcion 
     */
    private void consultarUnidadesDeMedida(){
      String descripcion = textoBusquedaMedida.getText();
      ModeloTabla modeloTablaUnidadDeMedida = (ModeloTabla)tablaUnidadDeMedidas.getModel();
        try {
            GestionarUnidadDeMedida gestionarUnidadDeMedida = new GestionarUnidadDeMedida();
            ArrayList<UnidadDeMedida> listaUnidadDeMedida = (ArrayList)gestionarUnidadDeMedida.buscarUnidadDeMedida(descripcion); 
            modeloTablaUnidadDeMedida.eliminarTotalFilas();
            if(listaUnidadDeMedida.size()>0){
                for(UnidadDeMedida unidadDeMedida : listaUnidadDeMedida){
                    Fila fila = new Fila();
                    fila.agregarValorCelda(unidadDeMedida.getCodigoUnidadDeMedida());
                    fila.agregarValorCelda(unidadDeMedida.getNombreUnidadDeMedida());
                    fila.agregarValorCelda(unidadDeMedida.getDescripcionUnidadDeMedida());
                    modeloTablaUnidadDeMedida.agregarFila(fila);
                }
                    modeloTablaUnidadDeMedida.refrescarDatos();
            }else{
                Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
                ponerFocoConSeleccionEnBuscar();
            }        
        } catch (Exception e) {
          Mensaje.mostrarErrorExcepcion(this, e.getMessage());
        }
    }
  
    private void ponerFocoConSeleccionEnBuscar() {
        textoBusquedaMedida.selectAll();
        textoBusquedaMedida.requestFocus();
    }
    
    private UnidadDeMedida obtenerUnidadDeMedidaTabla(){      
        UnidadDeMedida unidadDeMedida = null;
        int fila = tablaUnidadDeMedidas.getSelectedRow();
        GestionarUnidadDeMedida gestionarUnidadDeMedida = new GestionarUnidadDeMedida();
        if(fila >= 0 ){
            ModeloTabla modeloTablaUnidadDeMedida = (ModeloTabla)tablaUnidadDeMedidas.getModel();
            int unidadDeMedidaID = (Integer)modeloTablaUnidadDeMedida.getValueAt(fila, 0);           
            try{
                unidadDeMedida= gestionarUnidadDeMedida.buscarUnidadDeMedidaID(unidadDeMedidaID);               
            }
            catch(Exception e){
                 Mensaje.mostrarErrorExcepcion(this,e.getMessage());
            }       
        }
        else
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        return unidadDeMedida;
    }
    
    private void eliminarUnidadDeMedida(){
        GestionarUnidadDeMedida gestionarUnidadDeMedida = new GestionarUnidadDeMedida();
        UnidadDeMedida unidadDeMedida = obtenerUnidadDeMedidaTabla(); 
        if(unidadDeMedida!=null){
            if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
                return;         
            try {
                gestionarUnidadDeMedida.eliminarUnidadDeMedida(unidadDeMedida);
                consultarUnidadesDeMedida();
            } catch (Exception e) {
                Mensaje.mostrarErrorExcepcion(this,e.getMessage());
                ponerFocoConSeleccionEnBuscar();
            }
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

        jToolBar1 = new javax.swing.JToolBar();
        botonCrear = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoBusquedaMedida = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUnidadDeMedidas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Unidad De Medida");
        setResizable(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

        botonCrear.setBackground(new java.awt.Color(255, 255, 255));
        botonCrear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/crearx32.png"))); // NOI18N
        botonCrear.setText("Crear");
        botonCrear.setFocusable(false);
        botonCrear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCrear.setOpaque(false);
        botonCrear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });
        jToolBar1.add(botonCrear);

        botonModificar.setBackground(new java.awt.Color(255, 255, 255));
        botonModificar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/modificarx32.png"))); // NOI18N
        botonModificar.setText("Modificar");
        botonModificar.setFocusable(false);
        botonModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonModificar.setOpaque(false);
        botonModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(botonModificar);

        botonEliminar.setBackground(new java.awt.Color(255, 255, 255));
        botonEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/eliminarx32.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setFocusable(false);
        botonEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEliminar.setOpaque(false);
        botonEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(botonEliminar);

        botonSalir.setBackground(new java.awt.Color(255, 255, 255));
        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/salirx32.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setFocusable(false);
        botonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonSalir.setOpaque(false);
        botonSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(botonSalir);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Descripción:");

        textoBusquedaMedida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoBusquedaMedida.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textoBusquedaMedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoBusquedaMedidaKeyTyped(evt);
            }
        });

        botonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/buscarx20.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoBusquedaMedida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonBuscar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoBusquedaMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(tablaUnidadDeMedidas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
      new FormRegistrarUnidadDeMedida(this).setVisible(true);
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed

    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        eliminarUnidadDeMedida();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        consultarUnidadesDeMedida();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void textoBusquedaMedidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoBusquedaMedidaKeyTyped
        consultarUnidadesDeMedida();
    }//GEN-LAST:event_textoBusquedaMedidaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tablaUnidadDeMedidas;
    private javax.swing.JTextField textoBusquedaMedida;
    // End of variables declaration//GEN-END:variables
}
