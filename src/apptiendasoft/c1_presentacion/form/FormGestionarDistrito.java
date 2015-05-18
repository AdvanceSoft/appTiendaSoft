/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarDistritoServicio;
import apptiendasoft.c3_dominio.entidad.Distrito;
import java.util.ArrayList;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author sandra
 */
public class FormGestionarDistrito extends javax.swing.JDialog {

    ArrayList<Distrito> listaDistrito;
    Tabla tabla;
    ModeloTabla modeloTablaDistrito;
    public FormGestionarDistrito(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Gestionar Distrito");
        setResizable(false);
        crearTabla();
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
        panelcontenedor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDistrito = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(botonModificar);

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        textoBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoBuscar.setHorizontalAlignment(javax.swing.JTextField.LEFT);

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

        tablaDistrito.setAutoCreateRowSorter(true);
        tablaDistrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaDistrito);

        javax.swing.GroupLayout panelcontenedorLayout = new javax.swing.GroupLayout(panelcontenedor);
        panelcontenedor.setLayout(panelcontenedorLayout);
        panelcontenedorLayout.setHorizontalGroup(
            panelcontenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcontenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelcontenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelcontenedorLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelcontenedorLayout.setVerticalGroup(
            panelcontenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcontenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelcontenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelcontenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelcontenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        if(!textoBuscar.getText().trim().isEmpty()){
            consultarDistrito();
            ponerFocoConSeleccionEnBuscar();
        }else{
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOBUSCAR(this);
            ponerFocoConSeleccionEnBuscar();
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        int distritoid = obtenerCodigoDeLaTabla();
        if(distritoid == 0)
        return;
        if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
        return;
        GestionarDistritoServicio gestionarDistritoServicio = new GestionarDistritoServicio();
        try {
            int registros_afectados = gestionarDistritoServicio.eliminar(obtenerCodigoDeLaTabla());
            if(registros_afectados == 1){
                Mensaje.Mostrar_MENSAJE_ELIMINACIONEXITOSA(this);
                crearTabla();
                ponerFocoConSeleccionEnBuscar();
            }else{
                Mensaje.Mostrar_MENSAJE_ELIMINACIONERRONEA(this);
            }
            ponerFocoConSeleccionEnBuscar();
        } catch(Exception e){
            //JOptionPane.showMessageDialog(panelContenedor, e.getMessage());
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        // TODO add your handling code here:
        int distritoid = obtenerCodigoDeLaTabla();
        if(distritoid == 0)
        return;
        GestionarDistritoServicio gestionarDistritoServicio = new GestionarDistritoServicio();
        try {
            Distrito distrito = gestionarDistritoServicio.buscar(distritoid);
            if(distrito != null){
                FormRegistrarDistrito formRegistrarDistrito = new FormRegistrarDistrito(this, distrito);
                formRegistrarDistrito.setVisible(true);
            }
            else{
                Mensaje.Mostrar_MENSAJE_FILANOEXISTE(this);
            }
            crearTabla();
            ponerFocoConSeleccionEnBuscar();
        } catch(Exception e){
            //Mensaje.mostrarErrorDeConsulta(this);
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
        FormRegistrarDistrito formRegistrarDistrito = new FormRegistrarDistrito(this);
        formRegistrarDistrito.setVisible(true);
    }//GEN-LAST:event_botonCrearActionPerformed

    private void consultarDistrito() {
        crearTabla();
        String nombre = textoBuscar.getText().trim().toUpperCase();
        try {
            GestionarDistritoServicio gestionarDistritoServicio = new GestionarDistritoServicio();
            listaDistrito = gestionarDistritoServicio.buscarPorNombre(nombre);
            if(listaDistrito!=null && listaDistrito.size()>0){
                for(Distrito distrito : listaDistrito){
                    Fila fila = new Fila();
                    fila.agregarValorCelda(distrito.getCodigo());
                    fila.agregarValorCelda(distrito.getNombre());
                    tabla.agregarFila(fila);
                }         
                tablaDistrito.setModel(modeloTablaDistrito);
            }else{
                Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
                ponerFocoConSeleccionEnBuscar();
            }
        } catch(Exception e){    
            //
        }
    }
    private void ponerFocoConSeleccionEnBuscar() {
        textoBuscar.selectAll();
        textoBuscar.requestFocus();
    }
    private void crearTabla() {
        // TODO add your handling code here:
        tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Nombre", "java.lang.String"));
        modeloTablaDistrito  = new ModeloTabla(tabla);
        tablaDistrito.setModel(modeloTablaDistrito);
        //CODIGO
        TableColumn columna0,columna1;
        columna0 = tablaDistrito.getColumnModel().getColumn(0);
        columna0.setPreferredWidth(100);
        columna0.setMaxWidth(100);
        columna0.setMinWidth(100);
        //NOMBRE
        columna1 = tablaDistrito.getColumnModel().getColumn(1);
        columna1.setPreferredWidth(250);
        columna1.setMaxWidth(250);
        columna1.setMinWidth(250);
        
        tablaDistrito.removeColumn(columna0);
    }
    
    private int obtenerCodigoDeLaTabla() {
        int numFila = tablaDistrito.getSelectedRow();
        if(numFila == -1){
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
            return 0;
        }
        modeloTablaDistrito = (ModeloTabla) tablaDistrito.getModel();
        return (Integer)modeloTablaDistrito.getValueAt(numFila, 0); // se retorna el id de la fila seleccionada
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelcontenedor;
    private javax.swing.JTable tablaDistrito;
    private javax.swing.JTextField textoBuscar;
    // End of variables declaration//GEN-END:variables
}