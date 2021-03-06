/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarCargoServicio;
import apptiendasoft.c3_dominio.entidad.Cargo;
import javax.swing.JDialog;

/**
 *
 * @author 
 * <Valencia Cerna Nelida Janeth advancesoft.trujillo@gmail.com>
 */
public class FormRegistrarCargo extends javax.swing.JDialog {

    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion = 0;
    Cargo cargo;
    /**
     * Creates new form FormRegistrarCargo
     * @param owner
     */
    
    public FormRegistrarCargo(JDialog owner) {
        super(owner, true);
        initComponents();
        setResizable(false);
        tipo_accion = ACCION_CREAR;
        this.cargo = new Cargo();
    }

    public FormRegistrarCargo(JDialog owner, Cargo cargo) {
        super(owner, true);
        initComponents();
        setResizable(false);
        tipo_accion = ACCION_MODIFICAR;
        obtenerObjetoDeGestionar(cargo);
    }
    
    private void obtenerObjetoDeGestionar(Cargo cargo1) {
        this.cargo = cargo1;
        textoNombre.setText(cargo1.getNombre());
        textoAreaDescripcion.setText(cargo1.getDescripcion());
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
        textoNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoAreaDescripcion = new javax.swing.JTextArea();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Cargo");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nombre :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Descripcion :");

        textoNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        textoAreaDescripcion.setColumns(20);
        textoAreaDescripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textoNombre)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(botonGuardar)
                .addGap(26, 26, 26)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonGuardar)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        if(verificarCamposLlenos()){
            cargo.setNombre(textoNombre.getText().trim().toUpperCase());
            cargo.setDescripcion(textoAreaDescripcion.getText().trim().toUpperCase());
            GestionarCargoServicio gestionarCargoServicio = new GestionarCargoServicio();
            int estado;
            if (tipo_accion == ACCION_CREAR) {
                try{
                   estado=gestionarCargoServicio.crear(cargo);
                    if (estado>0) {
                        Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                        this.dispose();
                    }
                }catch(Exception ex){
                    
                }
            }else{
                try{
                    estado = gestionarCargoServicio.modificar(cargo);
                    if(estado > 0){
                        Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                        this.dispose();
                    }
                }catch(Exception ex){
                }
            }
        }else {
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            mostrarCampoVacio();
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        if (verificarCamposLlenos()) {
            if (Mensaje.Mostrar_MENSAJE_SALIRSINGUARDAR(this)) 
                this.dispose();
        }else
            this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textoAreaDescripcion;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables

    private boolean verificarCamposLlenos() {
        boolean estanLlenos;
        if (!(textoNombre.getText().trim().isEmpty())) 
            estanLlenos = true;
        else
            estanLlenos = false;        
        return estanLlenos;
    }

    private void mostrarCampoVacio() {
        if(textoNombre.getText().trim().isEmpty())
            textoNombre.requestFocus();
    }
}
