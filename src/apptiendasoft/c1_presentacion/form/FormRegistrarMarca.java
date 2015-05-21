/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarMarcaServicio;
import apptiendasoft.c3_dominio.entidad.Marca;
import javax.swing.JDialog;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class FormRegistrarMarca extends javax.swing.JDialog {

    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion = 0;
    Marca marca;
    
    /**
     * Creates new form FormRegistrarMarca
     * @param owner
     */
    public FormRegistrarMarca(JDialog owner) {
        super(owner, true);
        initComponents();
        setResizable(false);
        tipo_accion = ACCION_CREAR;
        this.marca = new Marca();
    }

    public FormRegistrarMarca(JDialog owner, Marca marca) {
        super(owner, true);
        initComponents();
        setResizable(false);
        tipo_accion = ACCION_MODIFICAR;
        obtenerObjetoDeGestionar(marca);
    }

    private void obtenerObjetoDeGestionar(Marca marca1) {
        this.marca = marca1;
        textoNombre.setText(marca1.getNombre());
        textoAreaDescripcion.setText(marca1.getDescripcion());
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoAreaDescripcion = new javax.swing.JTextArea();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Marca");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Descripción:");

        textoNombre.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textoNombre.setToolTipText("");

        textoAreaDescripcion.setColumns(20);
        textoAreaDescripcion.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textoAreaDescripcion.setLineWrap(true);
        textoAreaDescripcion.setRows(5);
        jScrollPane1.setViewportView(textoAreaDescripcion);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoNombre)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        if(verificarCamposLlenos()){            
            if(Mensaje.Mostrar_MENSAJE_SALIRSINGUARDAR(this))
                this.dispose();               
        }else
            this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        if(verificarCamposLlenos()){            
            marca.setNombre(textoNombre.getText().trim().toUpperCase());
            marca.setDescripcion(textoAreaDescripcion.getText().trim().toUpperCase());
            GestionarMarcaServicio gestionarMarcaServicio  = new GestionarMarcaServicio();
            int estado;
            if(tipo_accion==ACCION_CREAR){
                try{
                    estado = gestionarMarcaServicio.crear(marca);
                    if(estado > 0){
                        Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                        this.dispose();
                    }
                }catch(Exception ex){
                    //JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }            
            }else{
                try{
                    estado = gestionarMarcaServicio.modificar(marca);
                    if(estado > 0){
                        Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                        this.dispose();
                    }
                }catch(Exception ex){
                    //JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
            }
            
        }else{
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            mostrarCampoVacio();
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    
    private boolean verificarCamposLlenos() {
        boolean estanLlenos;
        if(!(textoNombre.getText().trim().isEmpty()))
            estanLlenos = true;
        else
            estanLlenos = false; 
        return estanLlenos;
    }

    private void mostrarCampoVacio(){
        if(textoNombre.getText().trim().isEmpty())
            textoNombre.requestFocus();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textoAreaDescripcion;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables
}
