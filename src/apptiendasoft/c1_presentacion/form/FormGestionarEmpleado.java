/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarEmpleadoServicio;
import apptiendasoft.c3_dominio.entidad.Empleado;
//import apptiendasoft.c3_dominio.entidad.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public final class FormGestionarEmpleado extends javax.swing.JDialog {
    ArrayList<Empleado> listaEmpleados;
    Tabla tabla;
    ModeloTabla modeloTablaEmpleado;
    /**
     * Creates new form FormGestionarEmpleado
     * @param parent
     * @param modal
     */
    public FormGestionarEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Gestionar Empleado");
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
        panelContenedor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setFloatable(false);
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
        textoBuscar.setToolTipText("Ingrese Nombre");

        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/buscarx20.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        tablaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaEmpleado);

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonBuscar)
                .addGap(20, 20, 20))
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
        FormRegistrarEmpleado formRegistrarEmpleado = new FormRegistrarEmpleado(this);
        formRegistrarEmpleado.setVisible(true);
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        // TODO add your handling code here:
        int empleadoCodigo = obtenerCodigoDeLaTabla();
        int codigoUsuario;
        if(empleadoCodigo == 0)
            return;
        GestionarEmpleadoServicio gestionarEmpleadoServicio = new GestionarEmpleadoServicio();
        try {            
            Empleado empleado = gestionarEmpleadoServicio.buscar(empleadoCodigo);
            if(empleado != null){
                FormRegistrarEmpleado formRegistrarEmpleado = new FormRegistrarEmpleado(this,empleado);
                formRegistrarEmpleado.setVisible(true);
            }
            else{
                Mensaje.Mostrar_MENSAJE_FILANOEXISTE(this);
            }
            crearTabla();
            ponerFocoConSeleccionEnBuscar();
                
        } catch (Exception ex) {
            //Logger.getLogger(FormGestionarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        int empleadoCodigo = obtenerCodigoDeLaTabla();
        if(empleadoCodigo == 0)
            return;
        if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
            return;
        GestionarEmpleadoServicio gestionarEmpleadoServicio = new GestionarEmpleadoServicio();
        try {
            int registros_afectados = gestionarEmpleadoServicio.eliminar(obtenerCodigoDeLaTabla());
            if(registros_afectados == 1){
                Mensaje.Mostrar_MENSAJE_ELIMINACIONEXITOSA(this);
                crearTabla();
                ponerFocoConSeleccionEnBuscar();
            }
            else{
             Mensaje.Mostrar_MENSAJE_ELIMINACIONERRONEA(this);
            }                
            ponerFocoConSeleccionEnBuscar();
        } catch (Exception ex) {
            //Logger.getLogger(FormGestionarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        if(!textoBuscar.getText().trim().isEmpty()){
            consultarEmpleado();
            ponerFocoConSeleccionEnBuscar();
        }
        else{
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOBUSCAR(this);
            ponerFocoConSeleccionEnBuscar();
        }
    }//GEN-LAST:event_botonBuscarActionPerformed
    public void ponerFocoConSeleccionEnBuscar(){
        textoBuscar.selectAll();
        textoBuscar.requestFocus();
    } 
    
    public void crearTabla(){
        tabla = new Tabla();
        tabla.agregarColumna( new Columna("Codigo","java.lang.Integer"));
        tabla.agregarColumna( new Columna("Nombres","java.lang.String"));
        tabla.agregarColumna( new Columna("Apellidos","java.lang.String"));
        tabla.agregarColumna( new Columna("DNI","java.lang.String"));
        tabla.agregarColumna( new Columna("Direccion","java.lang.String"));
        tabla.agregarColumna( new Columna("Telefono","java.lang.String"));
        tabla.agregarColumna( new Columna("Celular","java.lang.String"));
        tabla.agregarColumna(new Columna("Correo", "java.lang.String"));
        tabla.agregarColumna( new Columna("Genero","java.lang.String"));
        tabla.agregarColumna( new Columna("Activo","java.lang.String"));
//        tabla.agregarColumna(new Columna("Pais", "java.lang.String"));
//        tabla.agregarColumna(new Columna("Departamento", "java.lang.String"));
//        tabla.agregarColumna(new Columna("Provincia", "java.lang.String"));
//        tabla.agregarColumna(new Columna("Distrito", "java.lang.String"));
        tabla.agregarColumna(new Columna("Cargo", "java.lang.String"));
        tabla.agregarColumna(new Columna("Usuario", "java.lang.String"));
        tabla.agregarColumna( new Columna("Fecha de Ingreso","java.lang.Date"));
        tabla.agregarColumna( new Columna("Fecha de Salida","java.lang.Date"));
        tabla.agregarColumna( new Columna("Sueldo","java.lang.Double"));
        modeloTablaEmpleado = new ModeloTabla(tabla);
        tablaEmpleado.setModel(modeloTablaEmpleado);
        //CODIGO
        TableColumn columna0,columna1,columna2,columna3,columna4,columna5, columna6, columna7, columna8, columna9, columna10, columna11, columna12, columna13,columna14, columna15;
        columna0 = tablaEmpleado.getColumnModel().getColumn(0);
        columna0.setPreferredWidth(100);
        columna0.setMaxWidth(100);
        columna0.setMinWidth(100);
        //NOMBRES
        columna1 = tablaEmpleado.getColumnModel().getColumn(1);
        columna1.setPreferredWidth(150);
        columna1.setMaxWidth(150);
        columna1.setMinWidth(150);
        //APELLIDOS
        columna2 = tablaEmpleado.getColumnModel().getColumn(2);
        columna2.setPreferredWidth(150);
        columna2.setMaxWidth(150);
        columna2.setMinWidth(150);
        //DNI
        columna3 = tablaEmpleado.getColumnModel().getColumn(3);
        columna3.setPreferredWidth(80);
        columna3.setMaxWidth(80);
        columna3.setMinWidth(80);
        //DIRECCION
        columna4 = tablaEmpleado.getColumnModel().getColumn(4);
        columna4.setPreferredWidth(200);
        columna4.setMaxWidth(200);
        columna4.setMinWidth(200);
        //TELEFONO
        columna5 = tablaEmpleado.getColumnModel().getColumn(5);
        columna5.setPreferredWidth(100);
        columna5.setMaxWidth(100);
        columna5.setMinWidth(100);
        //CELULAR
        columna6 = tablaEmpleado.getColumnModel().getColumn(6);
        columna6.setPreferredWidth(100);
        columna6.setMaxWidth(100);
        columna6.setMinWidth(100);
        //CORREO
        columna7 = tablaEmpleado.getColumnModel().getColumn(7);
        columna7.setPreferredWidth(150);
        columna7.setMaxWidth(150);
        columna7.setMinWidth(150);
        //GENERO
        columna8 = tablaEmpleado.getColumnModel().getColumn(8);
        columna8.setPreferredWidth(50);
        columna8.setMaxWidth(50);
        columna8.setMinWidth(50);
        //ESTADO
        columna9 = tablaEmpleado.getColumnModel().getColumn(9);
        columna9.setPreferredWidth(150);
        columna9.setMaxWidth(150);
        columna9.setMinWidth(150);
        //CARGO
        columna10 = tablaEmpleado.getColumnModel().getColumn(10);
        columna10.setPreferredWidth(100);
        columna10.setMaxWidth(100);
        columna10.setMinWidth(100);
        //USUARIO
        columna11 = tablaEmpleado.getColumnModel().getColumn(11);
        columna11.setPreferredWidth(100);
        columna11.setMaxWidth(100);
        columna11.setMinWidth(100);
        //FECHA INGRESO
        columna12 = tablaEmpleado.getColumnModel().getColumn(12);
        columna12.setPreferredWidth(100);
        columna12.setMaxWidth(100);
        columna12.setMinWidth(100);
        //FECHA SALIDA
        columna13 = tablaEmpleado.getColumnModel().getColumn(13);
        columna13.setPreferredWidth(100);
        columna13.setMaxWidth(100);
        columna13.setMinWidth(100);
        //SUELDO
        columna14 = tablaEmpleado.getColumnModel().getColumn(14);
        columna14.setPreferredWidth(50);
        columna14.setMaxWidth(50);
        columna14.setMinWidth(50);
        
        tablaEmpleado.removeColumn(columna0);
    }
    
    private int obtenerCodigoDeLaTabla(){
        int numFila = tablaEmpleado.getSelectedRow();
        if(numFila == -1){
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
            return 0;
        }
        modeloTablaEmpleado = (ModeloTabla) tablaEmpleado.getModel();
        return (Integer)modeloTablaEmpleado.getValueAt(numFila,0); //Se obtendra en codigo de la fila seleccionada
    }
    
    private void consultarEmpleado(){
        crearTabla();
        String nombre = textoBuscar.getText().trim().toUpperCase();
        try {
            GestionarEmpleadoServicio gestionarEmpleadoServicio = new GestionarEmpleadoServicio();
            listaEmpleados = gestionarEmpleadoServicio.buscarPorNombre(nombre);
            if(listaEmpleados!=null && listaEmpleados.size()>0){
                for(Empleado empleado : listaEmpleados){
                    Fila fila = new Fila();
                    fila.agregarValorCelda(empleado.getCodigo());
                    fila.agregarValorCelda(empleado.getNombre());
                    fila.agregarValorCelda(empleado.getApellido());
                    fila.agregarValorCelda(empleado.getDni());
                    fila.agregarValorCelda(empleado.getDireccion());
                    fila.agregarValorCelda(empleado.getTelefono());
                    fila.agregarValorCelda(empleado.getCelular());
                    fila.agregarValorCelda(empleado.getCorreo());
                    fila.agregarValorCelda(empleado.getGenero());
                    fila.agregarValorCelda(empleado.isActivo());
//                    fila.agregarValorCelda(empleado.getPais());
//                    fila.agregarValorCelda(empleado.getDepartamento());
//                    fila.agregarValorCelda(empleado.getProvincia());
//                    fila.agregarValorCelda(empleado.getDistrito());
                    fila.agregarValorCelda(empleado.getCargo());
                    fila.agregarValorCelda(empleado.getUsuario());
                    fila.agregarValorCelda(empleado.getFechaIngreso());
                    fila.agregarValorCelda(empleado.getFechaSalida());
                    fila.agregarValorCelda(empleado.getSueldo());
                    tabla.agregarFila(fila);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(FormGestionarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JTable tablaEmpleado;
    private javax.swing.JTextField textoBuscar;
    // End of variables declaration//GEN-END:variables
}
