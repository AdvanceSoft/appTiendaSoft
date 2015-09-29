/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarCargoServicio;
import apptiendasoft.c2_aplicacion.servicio.GestionarEmpleadoServicio;
import apptiendasoft.c2_aplicacion.servicio.GestionarUsuarioServicio;
import apptiendasoft.c3_dominio.entidad.Cargo;
import apptiendasoft.c3_dominio.entidad.Empleado;
import apptiendasoft.c3_dominio.entidad.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public final class FormRegistrarEmpleado extends javax.swing.JDialog {
    
    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion = 0;
    Empleado empleado;
    Usuario usuario;
    Cargo cargo = null;
    GestionarCargoServicio gestionarCargoServicio = new GestionarCargoServicio();
//    List<Pais> listaPais;
//    List<Departamento> listaDepartamento;
//    List<Provincia> listaProvincia;
//    List<Distrito> listaDistrito;
    List<Cargo> listaCargo;
    /**
     * Creates new form FormRegistrarEmpleado
     * @param owner
     */
    public FormRegistrarEmpleado(JDialog owner) {
        super(owner, true);
        initComponents();
        setTitle("Gestionar Empleado");
        setResizable(false);
        tipo_accion = ACCION_CREAR;
        this.empleado = new Empleado();
        llenarComboCargo();
//        llenarComboPais();
//        llenarComboDepartamento();
//        llenarComboProvincia();
//        llenarComboDistrito();
        iniciarCombos();
    }
    
    public FormRegistrarEmpleado(JDialog owner, Empleado empleado){
        super(owner, true);
        initComponents();
        setResizable(false);
        tipo_accion = ACCION_MODIFICAR;
        obtenerObjetoEmpleado(empleado); 
        checkEstado.setEnabled(true);
    }
   
    public void obtenerObjetoEmpleado(Empleado empleado1){
        this.empleado = empleado1;
        textoNombres.setText(String.valueOf(empleado1.getNombre()));
        textoApellidos.setText(String.valueOf(empleado1.getApellido()));
        textoDni.setText(String.valueOf(empleado1.getDni()));
        textoDireccion.setText(String.valueOf(empleado1.getDireccion()));
        textoCorreo.setText(String.valueOf(empleado1.getCorreo()));
        textoTelefono.setText(String.valueOf(empleado1.getTelefono()));
        textoCelular.setText(String.valueOf(empleado1.getCelular()));
        checkEstado.setSelected(empleado1.isActivo());
        comboCargo.setSelectedItem(empleado1.getCargo());
//        comboPais.setSelectedItem(empleado1.getPais());
//        comboDepartamento.setSelectedItem(empleado1.getDepartamento());
//        comboProvincia.setSelectedItem(empleado1.getProvincia());
//        comboDistrito.setSelectedItem(empleado1.getDistrito());
        jDateIngreso.setDate(empleado1.getFechaIngreso());
        jDateSalida.setDate(empleado1.getFechaSalida());
        textoSueldo.setText(String.valueOf(empleado1.getSueldo()));
        textoUsuario.setText(String.valueOf(empleado1.getUsuario()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        botonGuardar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textoDireccion = new javax.swing.JTextField();
        textoTelefono = new javax.swing.JTextField();
        textoCelular = new javax.swing.JTextField();
        textoCorreo = new javax.swing.JTextField();
        textoNombres = new javax.swing.JTextField();
        textoApellidos = new javax.swing.JTextField();
        textoDni = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        comboCargo = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        checkEstado = new javax.swing.JCheckBox();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jDateIngreso = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jDateSalida = new com.toedter.calendar.JDateChooser();
        textoSueldo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JTextField();
        textoContraseña = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textoConfirmaContraseña = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Empleado");

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

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Direccion:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Telefono:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Celular:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Correo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombres:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Apellidos:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("DNI:");

        textoDireccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoDireccion.setToolTipText("");

        textoTelefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoTelefono.setToolTipText("");

        textoCelular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoCelular.setToolTipText("");

        textoCorreo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoCorreo.setToolTipText("");

        textoNombres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoNombres.setToolTipText("");

        textoApellidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoApellidos.setToolTipText("");

        textoDni.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoDni.setToolTipText("");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Cargo:");

        comboCargo.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Sexo:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Estado:");

        checkEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkEstado.setSelected(true);
        checkEstado.setText("Activo");
        checkEstado.setEnabled(false);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Masculino");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton2.setText("Femenino");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/cargox20.png"))); // NOI18N
        jButton1.setText("Crear");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel22)
                                .addComponent(jLabel17)
                                .addComponent(jLabel18))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(jRadioButton1)
                                    .addGap(10, 10, 10)
                                    .addComponent(jRadioButton2))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(checkEstado))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(comboCargo, 0, 213, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel11)
                                .addComponent(jLabel13)
                                .addComponent(jLabel10)
                                .addComponent(jLabel2)
                                .addComponent(jLabel9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textoApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                                .addComponent(textoCelular)
                                .addComponent(textoTelefono)
                                .addComponent(textoDireccion)
                                .addComponent(textoCorreo)
                                .addComponent(textoNombres)
                                .addComponent(textoDni)))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(textoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(textoDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(checkEstado))
                .addGap(11, 11, 11))
        );

        jTabbedPane1.addTab("Datos Generales", jPanel1);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Fecha de Ingreso:");

        jDateIngreso.setBackground(new java.awt.Color(255, 255, 255));
        jDateIngreso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Fecha de Salida:");

        jDateSalida.setBackground(new java.awt.Color(255, 255, 255));
        jDateSalida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        textoSueldo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textoSueldo.setToolTipText("");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Sueldo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel19))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoSueldo, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(jDateSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateIngreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateSalida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textoSueldo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(252, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sueldo", jPanel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Usuario:");

        textoUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        textoContraseña.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Contraseña:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Confirmar Contraseña");

        textoConfirmaContraseña.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(textoUsuario)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addComponent(textoConfirmaContraseña)))
                .addGap(11, 11, 11))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(textoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(textoConfirmaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(246, Short.MAX_VALUE))
        );

        jLabel3.getAccessibleContext().setAccessibleName("");
        jLabel4.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("Usuario", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        if(verificarDatosLlenos()){
            String nombreCargo = comboCargo.getSelectedItem().toString();
            try {                
                cargo = gestionarCargoServicio.buscarNombre(nombreCargo);
            } catch (Exception ex) {
                //Logger.getLogger(FormRegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }  
//            String nombrePais = comboPais.getSelectedItem().toString();
//            String nombreDepartamento = comboDepartamento.getSelectedItem().toString();
//            String nombreProvincia = comboProvincia.getSelectedItem().toString();
//            String nombreDistrito = comboDistrito.getSelectedItem().toString();
                //Creamos El usuario del Empleado
                usuario.setNombre(textoUsuario.getText().trim().toUpperCase());
                usuario.setContraseña(textoContraseña.getText());
                empleado.setNombre(textoNombres.getText().trim().toUpperCase());
                empleado.setApellido(textoApellidos.getText().trim().toUpperCase());
                empleado.setDireccion(textoDireccion.getText().trim().toUpperCase());
                empleado.setDni(textoDni.getText().trim());
                empleado.setCelular(textoCelular.getText().trim());
                empleado.setTelefono(textoTelefono.getText().trim());
                empleado.setCorreo(textoCorreo.getText().trim());
                empleado.setFechaIngreso(jDateIngreso.getDate());
                empleado.setFechaSalida(jDateSalida.getDate());
                empleado.setActivo(checkEstado.isSelected());
                empleado.setSueldo(Double.parseDouble(textoSueldo.getText().trim()));
                empleado.setCargo(cargo);
                empleado.setUsuario(usuario);
                //empleado.setPais(comboPais.getSelectedItem().toString());
                //empleado.setDepartamento(comboDepartamento.getSelectedItem().toString());
                //empleado.setProvincia(comboProvincia.getSelectedItem().toString());
                //empleado.setDistrito(comboDistrito.getSelectedItem().toString());
                GestionarUsuarioServicio gestionarUsuarioServicio = new GestionarUsuarioServicio();
                GestionarEmpleadoServicio gestionarEmpleadoServicio = new GestionarEmpleadoServicio();
                int estado;
                int estado1;
                if(tipo_accion==ACCION_CREAR){
                    try {
                        estado=gestionarEmpleadoServicio.crear(empleado);
                        estado1=gestionarUsuarioServicio.crear(usuario);
                        if(estado > 0 && estado1 > 0){
                            Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                            this.dispose();
                        }
                    } catch (Exception ex) {
                        //Logger.getLogger(FormRegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    try {
                        estado=gestionarEmpleadoServicio.modificar(empleado);
                        if(estado > 0){
                            Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                            this.dispose();
                        }
                    } catch (Exception ex) {
                        // Logger.getLogger(FormRegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }else{
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
            mostrarCampoVacio();
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        if(verificarDatosLlenos()){
            if(Mensaje.Mostrar_MENSAJE_SALIRSINGUARDAR(this))
                this.dispose();
        }
        else
            this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed
    
    private boolean verificarDatosLlenos(){
        boolean estanLlenos;
       if(!(textoNombres.getText().trim().isEmpty()) && !(textoApellidos.getText().trim().isEmpty()) && !(textoDni.getText().trim().isEmpty()) && !(textoDireccion.getText().trim().isEmpty())
           && !(textoTelefono.getText().trim().isEmpty()) && !(textoCelular.getText().trim().isEmpty()) && !(textoCorreo.getText().trim().isEmpty()) && checkEstado.isSelected() && comboCargo.getSelectedIndex()!=-1
          && jDateIngreso.getDate()!=null && jDateSalida.getDate()!=null && !(textoSueldo.getText().trim().isEmpty()) && !(textoUsuario.getText().trim().isEmpty()) )
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
        }else if(textoCorreo.getText().trim().isEmpty()){
            textoCorreo.requestFocus();
        }else if(textoTelefono.getText().trim().isEmpty()){
            textoTelefono.requestFocus();
        }else if(textoCelular.getText().trim().isEmpty()){
            textoCelular.requestFocus();
        }else if(!checkEstado.isSelected()){
            checkEstado.requestFocus();
        }else if(comboCargo.getSelectedIndex()<=0){
            comboCargo.requestFocus();
        }else if( jDateIngreso.getDate()== null){
            jDateIngreso.requestFocus();
        }else if(jDateSalida.getDate()==null){
            jDateSalida.requestFocus();
        }else if(textoSueldo.getText().trim().isEmpty()){
            textoSueldo.requestFocus();
        }else if(textoUsuario.getText().trim().isEmpty()){
            textoUsuario.requestFocus();
        }else if(textoContraseña.getText().isEmpty()){
            textoContraseña.requestFocus();
        }
    }
    
    private void iniciarCombos(){
        comboCargo.setSelectedIndex(-1);
//        comboDepartamento.setSelectedIndex(-1);
//        comboDistrito.setSelectedIndex(-1);
//        comboPais.setSelectedIndex(-1);
//        comboProvincia.setSelectedIndex(-1);
    }
    
//    private void llenarComboPais(){
//        try {
//            GestionarPaisServicio gestionarPaisServicio = new GestionarPaisServicio();
//            listaPais = new ArrayList<>();
//            listaPais = gestionarPaisServicio.buscarPorNombre(null);
//            comboPais.removeAllItems();
//            for(Pais pais : listaPais){
//                comboPais.addItem(pais.getNombre());
//            }
//        } catch (Exception ex){
//           // Logger.getLogger(FormRegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    private void llenarComboCargo(){

        try {
            gestionarCargoServicio = new GestionarCargoServicio();
            listaCargo = new ArrayList<>();
            listaCargo = gestionarCargoServicio.buscarporNombre(null);
            comboCargo.removeAllItems();
            for(Cargo cargo1 : listaCargo){
                comboCargo.addItem(cargo1.getNombre());
            }
        } catch (Exception ex) {
            //Logger.getLogger(FormRegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
//    private void llenarComboDepartamento(){
//        
//        try {
//            GestionarDepartamentoServicio gestionarDepartamentoServicio = new GestionarDepartamentoServicio();
//            listaDepartamento = new ArrayList<>();
//            listaDepartamento = gestionarDepartamentoServicio.buscarPorNombre(null);
//            comboDepartamento.removeAllItems();
//            for(Departamento departamento : listaDepartamento){
//                comboDepartamento.addItem(departamento.getNombre());
//            }
//        } catch (Exception ex) {
//            //Logger.getLogger(FormRegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    private void llenarComboProvincia(){
//        
//        try {
//            GestionarProvinciaServicio gestionarProvinciaServicio = new GestionarProvinciaServicio();
//            listaProvincia = new ArrayList<>();
//            listaProvincia = gestionarProvinciaServicio.buscarPorNombre(null);
//            comboProvincia.removeAllItems();
//            for(Provincia provincia : listaProvincia){
//                comboProvincia.addItem(provincia.getNombre());
//            }
//        } catch (Exception ex) {
//            //Logger.getLogger(FormRegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    private void llenarComboDistrito(){
//        
//        try {
//            GestionarDistritoServicio gestionarDistritoServicio = new GestionarDistritoServicio();
//            listaDistrito = new ArrayList<>();
//            listaDistrito = gestionarDistritoServicio.buscarPorNombre(null);
//            comboDistrito.removeAllItems();
//            for(Distrito distrito : listaDistrito){
//                comboDistrito.addItem(distrito.getNombre());
//            }
//        } catch (Exception ex) {
//            //Logger.getLogger(FormRegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkEstado;
    private javax.swing.JComboBox comboCargo;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateIngreso;
    private com.toedter.calendar.JDateChooser jDateSalida;
    private javax.swing.JDesktopPane jDesktopPane1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField textoApellidos;
    private javax.swing.JTextField textoCelular;
    private javax.swing.JPasswordField textoConfirmaContraseña;
    private javax.swing.JPasswordField textoContraseña;
    private javax.swing.JTextField textoCorreo;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoDni;
    private javax.swing.JTextField textoNombres;
    private javax.swing.JTextField textoSueldo;
    private javax.swing.JTextField textoTelefono;
    private javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables
}
