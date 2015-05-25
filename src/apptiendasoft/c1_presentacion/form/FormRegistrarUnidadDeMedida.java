/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarUnidadDeMedida;
import apptiendasoft.c3_dominio.entidad.UnidadDeMedida;
import javax.swing.JDialog;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public class FormRegistrarUnidadDeMedida extends javax.swing.JDialog {

    /**
     * Creates new form FormRegistrarUnidadDeMedida
     */
    UnidadDeMedida unidadDeMedida; 
   
    public FormRegistrarUnidadDeMedida(JDialog owner) {
        super(owner, true);
        initComponents();
        etiquetamensaje.setVisible(false);
        this.unidadDeMedida = new UnidadDeMedida();
    }
    
    public FormRegistrarUnidadDeMedida(JDialog owner, UnidadDeMedida unidadDeMedida) {
        super(owner, true);
        initComponents(); 
        etiquetamensaje.setVisible(false);
        obtenerObetoUnidadDeMedida(unidadDeMedida);
    }
    
    private void obtenerObetoUnidadDeMedida(UnidadDeMedida unidadDeMedida){
        this.unidadDeMedida = unidadDeMedida; 
        textoNombre.setText(unidadDeMedida.getNombreUnidadDeMedida());
        textoDescripcion.setText(unidadDeMedida.getDescripcionUnidadDeMedida());
    }
    
    private boolean validarCamposLlenos(){      
       return (!(textoNombre.getText().trim().isEmpty())||!(textoDescripcion.getText().trim().isEmpty()));           
    }
    
    private void mostrarCamposVacios(){
        if(textoNombre.getText().trim().isEmpty()){
            textoNombre.requestFocus();
        }if(textoDescripcion.getText().trim().isEmpty()){
            textoDescripcion.requestFocus();}
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
        jScrollPane1 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botonSalir = new javax.swing.JButton();
        etiquetamensaje = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        textoNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Unidad De Medida");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Abreviatura:");

        textoDescripcion.setColumns(20);
        textoDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoDescripcion.setRows(5);
        jScrollPane1.setViewportView(textoDescripcion);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Descripción:");

        botonSalir.setBackground(new java.awt.Color(255, 255, 255));
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/salirx32.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        etiquetamensaje.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        etiquetamensaje.setForeground(new java.awt.Color(102, 102, 102));
        etiquetamensaje.setText("mensaje excepcion");

        botonGuardar.setBackground(new java.awt.Color(255, 255, 255));
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/guardarx32.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        textoNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoNombreKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetamensaje)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textoNombre)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonSalir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetamensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        if(validarCamposLlenos()){
            if(Mensaje.Mostrar_MENSAJE_SALIRSINGUARDAR(this))
               this.dispose();              
        }else 
            this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        GestionarUnidadDeMedida gestionarUnidadDeMedida = new GestionarUnidadDeMedida();
        unidadDeMedida.setDescripcionUnidadDeMedida(textoDescripcion.getText().trim().toUpperCase());
        try{         
            if(validarCamposLlenos()){                      
            if(unidadDeMedida.getCodigoUnidadDeMedida()==0){
                gestionarUnidadDeMedida.guardarUnidadDeMedida(unidadDeMedida);
                Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                this.dispose();
            }else{
                gestionarUnidadDeMedida.modificarUnidadDeMedida(unidadDeMedida);
                Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                this.dispose();
            }
        }else{
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            mostrarCamposVacios();
        }
        }catch(Exception e){
            Mensaje.mostrarErrorExcepcion(this, e.getMessage());
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void textoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNombreKeyTyped
        try {
            String nombreunidad= textoNombre.getText();
            botonGuardar.setEnabled(true);
            etiquetamensaje.setVisible(false);
            unidadDeMedida.setNombreUnidadDeMedida(nombreunidad);
        } catch (Exception e) {
            etiquetamensaje.setVisible(true);
            etiquetamensaje.setText(e.getMessage());
            botonGuardar.setEnabled(false);
            evt.consume();
        }
    }//GEN-LAST:event_textoNombreKeyTyped
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel etiquetamensaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea textoDescripcion;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables
}
