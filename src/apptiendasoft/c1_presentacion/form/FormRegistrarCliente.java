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
        llenarComboPais();
        llenarComboDepartamento();
        llenarComboProvincia();
        llenarComboDistrito();
        iniciarCombos();
    }

    public FormRegistrarCliente(JDialog owner, Cliente cliente){
        super(owner,true);
        initComponents();
        tipo_accion = ACCION_MODIFICAR; 
        llenarComboPais();
        llenarComboDepartamento();
        llenarComboProvincia();
        llenarComboDistrito();
        obtenerObjetoDeGestionar(cliente);
        checkEstado.setEnabled(true);
    }
    
    private void iniciarCombos(){
        comboPais.setSelectedIndex(-1);
        comboDepartamento.setSelectedIndex(-1);
        comboProvincia.setSelectedIndex(-1);
        comboDistrito.setSelectedIndex(-1);
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
        comboPais.setSelectedItem(cliente1.getPais());
        comboDepartamento.setSelectedItem(cliente1.getDepartamento());
        comboProvincia.setSelectedItem(cliente1.getProvincia());
        comboDistrito.setSelectedItem(cliente1.getDistrito());
    }
    
    private void llenarComboPais(){
        
        try {
            GestionarPaisServicio gestionarPaisServicio = new GestionarPaisServicio();
            listaPais = new ArrayList<>();
            listaPais = gestionarPaisServicio.buscarPorNombre(null);
            comboPais.removeAllItems();
            for(Pais pais : listaPais){
                comboPais.addItem(pais.getNombre());
            }
        } catch (Exception ex) {
           // Logger.getLogger(FormRegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void llenarComboDepartamento(){
        
        try {
            GestionarDepartamentoServicio gestionarDepartamentoServicio = new GestionarDepartamentoServicio();
            listaDepartamento = new ArrayList<>();
            listaDepartamento = gestionarDepartamentoServicio.buscarPorNombre(null);
            comboDepartamento.removeAllItems();
            for(Departamento departamento : listaDepartamento){
                comboDepartamento.addItem(departamento.getNombre());
            }
        } catch (Exception ex) {
            //Logger.getLogger(FormRegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void llenarComboProvincia(){
        
        try {
            GestionarProvinciaServicio gestionarProvinciaServicio = new GestionarProvinciaServicio();
            listaProvincia = new ArrayList<>();
            listaProvincia = gestionarProvinciaServicio.buscarPorNombre(null);
            comboProvincia.removeAllItems();
            for(Provincia provincia : listaProvincia){
                comboProvincia.addItem(provincia.getNombre());
            }
        } catch (Exception ex) {
            //Logger.getLogger(FormRegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void llenarComboDistrito(){
        
        try {
            GestionarDistritoServicio gestionarDistritoServicio = new GestionarDistritoServicio();
            listaDistrito = new ArrayList<>();
            listaDistrito = gestionarDistritoServicio.buscarPorNombre(null);
            comboDistrito.removeAllItems();
            for(Distrito distrito : listaDistrito){
                comboDistrito.addItem(distrito.getNombre());
            }                
        } catch (Exception ex) {
            //Logger.getLogger(FormRegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboDepartamento = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        comboProvincia = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboDistrito = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
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
        jLabel19 = new javax.swing.JLabel();
        comboPais = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Cliente");
        setResizable(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Departamento:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombres:");

        comboDepartamento.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("DNI:");

        comboProvincia.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Apellidos:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Provincia:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Telefono:");

        comboDistrito.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Direccion:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Distrito:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Correo:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Celular:");

        radioMasculino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioMasculino.setText("Masculino");

        radioFemenino.setText("Femenino");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Estado:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Genero:");

        textoNombres.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textoNombres.setToolTipText("");

        textoTelefono.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textoTelefono.setToolTipText("");

        textoCorreo.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textoCorreo.setToolTipText("");

        textoCelular.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textoCelular.setToolTipText("");

        textoDireccion.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textoDireccion.setToolTipText("");

        textoApellidos.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textoApellidos.setToolTipText("");

        checkEstado.setSelected(true);
        checkEstado.setText("Activo");
        checkEstado.setEnabled(false);

        textoDni.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
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

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Pais:");

        comboPais.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/localizacionx20.png"))); // NOI18N
        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/localizacionx20.png"))); // NOI18N
        jButton2.setText("Crear");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/localizacionx20.png"))); // NOI18N
        jButton3.setText("Crear");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/localizacionx20.png"))); // NOI18N
        jButton4.setText("Crear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addGap(328, 328, 328)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(textoDni, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textoCelular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                        .addComponent(textoTelefono, javax.swing.GroupLayout.Alignment.TRAILING)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioFemenino))
                            .addComponent(checkEstado))
                        .addGap(149, 149, 149))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboProvincia, 0, 183, Short.MAX_VALUE)
                            .addComponent(comboPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboDistrito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel20)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel21)
                                .addComponent(comboProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel22)
                                .addComponent(comboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(radioMasculino)
                            .addComponent(radioFemenino))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(checkEstado)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(textoNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(textoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(textoDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(textoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(textoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        FormRegistrarDistrito formRegistrarDistrito = new FormRegistrarDistrito(this);
        formRegistrarDistrito.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
    private javax.swing.JCheckBox checkEstado;
    private javax.swing.JComboBox comboDepartamento;
    private javax.swing.JComboBox comboDistrito;
    private javax.swing.JComboBox comboPais;
    private javax.swing.JComboBox comboProvincia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
