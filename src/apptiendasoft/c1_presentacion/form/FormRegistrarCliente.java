/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarClienteServicio;
import apptiendasoft.c2_aplicacion.servicio.GestionarDepartamentoServicio;
import apptiendasoft.c2_aplicacion.servicio.GestionarDistritoServicio;
import apptiendasoft.c2_aplicacion.servicio.GestionarPaisServicio;
import apptiendasoft.c2_aplicacion.servicio.GestionarProvinciaServicio;
import apptiendasoft.c3_dominio.entidad.Cliente;
import apptiendasoft.c3_dominio.entidad.Departamento;
import apptiendasoft.c3_dominio.entidad.Distrito;
import apptiendasoft.c3_dominio.entidad.Pais;
import apptiendasoft.c3_dominio.entidad.Provincia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class FormRegistrarCliente extends javax.swing.JDialog {

    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    int tipo_accion = 0;  
    Cliente cliente;
    List<Pais> listaPais;
    List<Departamento> listaDepartamento;
    List<Provincia> listaProvincia;
    List<Distrito> listaDistrito;
    /**
     * Creates new form FormRegistrarClientes
     * @param owner
     */
    public FormRegistrarCliente(JDialog owner) {
        super(owner, true);
        initComponents();
        tipo_accion=ACCION_CREAR;
        this.cliente = new Cliente();
    }

    public FormRegistrarCliente(JDialog owner, Cliente cliente){
        super(owner,true);
        initComponents();
        tipo_accion = ACCION_MODIFICAR;
        obtenerObjetoDeGestionar(cliente);
        checkEstado.setEnabled(true);
    }
    
    private void obtenerObjetoDeGestionar(Cliente cliente1){
        this.cliente = cliente1;
        textoNombres.setText(String.valueOf(cliente1.getNombre()));
        textoApellidos.setText(String.valueOf(cliente1.getApellido()));
        textoDni.setText(String.valueOf(cliente1.getDni()));
        textoDireccion.setText(String.valueOf(cliente1.getDireccion()));
        textoTelefono.setText(String.valueOf(cliente1.getTelefono()));
        textoCelular.setText(String.valueOf(cliente1.getCelular()));
        textoCorreo.setText(String.valueOf(cliente1.getCorreo()));
        if("MASCULINO".equals(cliente1.getGenero())){
            radioMasculino.setSelected(true);
        }else{
            radioFemenino.setSelected(true);
        }
        if(cliente1.isActivo()){
            checkEstado.setSelected(true);
        }else{
            checkEstado.setSelected(false);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        radioMasculino = new javax.swing.JRadioButton();
        radioFemenino = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        textoNombres = new javax.swing.JTextField();
        textoTelefono = new javax.swing.JTextField();
        textoCorreo = new javax.swing.JTextField();
        textoCelular = new javax.swing.JTextField();
        textoDireccion = new javax.swing.JTextField();
        textoApellidos = new javax.swing.JTextField();
        checkEstado = new javax.swing.JCheckBox();
        textoDni = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Cliente");
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombres:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("DNI:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Apellidos:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Telefono:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Direccion:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Correo:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Celular:");

        buttonGroup1.add(radioMasculino);
        radioMasculino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioMasculino.setText("Masculino");

        buttonGroup1.add(radioFemenino);
        radioFemenino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioFemenino.setText("Femenino");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Estado:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Genero:");

        textoNombres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoNombres.setToolTipText("");

        textoTelefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoTelefono.setToolTipText("");

        textoCorreo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoCorreo.setToolTipText("");

        textoCelular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoCelular.setToolTipText("");

        textoDireccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoDireccion.setToolTipText("");

        textoApellidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoApellidos.setToolTipText("");

        checkEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkEstado.setSelected(true);
        checkEstado.setText("Activo");
        checkEstado.setEnabled(false);

        textoDni.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoDni.setToolTipText("");

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
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(textoDireccion)
                            .addComponent(textoNombres)
                            .addComponent(textoDni)))
                    .addComponent(jLabel12)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textoCelular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                .addComponent(textoTelefono, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkEstado)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioFemenino)))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(textoNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(textoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textoDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(textoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(textoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(radioMasculino)
                    .addComponent(radioFemenino))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(checkEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
                if(verificarCamposLlenos()){
                        cliente.setNombre(textoNombres.getText().trim().toUpperCase());
                        cliente.setApellido(textoApellidos.getText().trim().toUpperCase());
                        cliente.setCelular(textoCelular.getText().trim());
                        cliente.setTelefono(textoTelefono.getText().trim());
                        cliente.setCorreo(textoCorreo.getText().trim());
                        cliente.setDireccion(textoDireccion.getText().trim().toUpperCase());
                        cliente.setDni(textoDni.getText().trim()); 
                        if(radioMasculino.isSelected()){
                            cliente.setGenero("MASCULINO");
                        } else {
                            cliente.setGenero("FEMENINO");
                        }
                        //cliente.setPais(comboPais.getSelectedItem().toString());
                        cliente.setActivo(checkEstado.isSelected());
                        GestionarClienteServicio gestionarClienteServicio = new GestionarClienteServicio();
                        int estado;
                        if(tipo_accion == ACCION_CREAR){
                                try {
                                        estado = gestionarClienteServicio.crear(cliente);
                                        if(estado > 0){
                                                Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                                                this.dispose();
                                            }
                                    } catch (Exception ex) {
                                      //  Logger.getLogger(FormRegistarCliente.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                            }
                        else{
                                try {
                                        estado = gestionarClienteServicio.modificar(cliente);
                                        if(estado > 0){
                                                Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                                                this.dispose();
                                        }
                                    } catch (Exception ex) {
                                        //Logger.getLogger(FormRegistarCliente.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                            }
                    }
                else{
                        Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
                        mostrarCampoVacio();
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

    private boolean verificarCamposLlenos(){
        boolean estanLlenos;
        if(!(textoNombres.getText().trim().isEmpty()) && !(textoApellidos.getText().trim().isEmpty()) && !(textoDni.getText().trim().isEmpty()) &&
                !(textoDireccion.getText().trim().isEmpty())  && !(textoTelefono.getText().trim().isEmpty()) && !(textoCelular.getText().trim().isEmpty())
                && !(textoCorreo.getText().trim().isEmpty()))
            estanLlenos = true;
        else
            estanLlenos = false;
        return estanLlenos;
    }
    
    private void mostrarCampoVacio(){
        if(textoNombres.getText().trim().isEmpty()){
            textoNombres.requestFocus();
        }else if(textoApellidos.getText().trim().isEmpty()){
            textoApellidos.requestFocus();
        }else if(textoDni.getText().trim().isEmpty()){
            textoDni.requestFocus();
        }else if(textoDireccion.getText().trim().isEmpty()){
            textoDireccion.requestFocus();
       }else if(textoTelefono.getText().trim().isEmpty()){
           textoTelefono.requestFocus();
       }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkEstado;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton radioFemenino;
    private javax.swing.JRadioButton radioMasculino;
    private javax.swing.JTextField textoApellidos;
    private javax.swing.JTextField textoCelular;
    private javax.swing.JTextField textoCorreo;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoDni;
    private javax.swing.JTextField textoNombres;
    private javax.swing.JTextField textoTelefono;
    // End of variables declaration//GEN-END:variables
}
