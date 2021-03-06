/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarClienteServicio;
import apptiendasoft.c3_dominio.entidad.Cliente;
import java.util.ArrayList;
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
public final class FormGestionarCliente extends javax.swing.JDialog {
    
    ArrayList<Cliente> listaClientes;
    Tabla tabla;
    ModeloTabla modeloTablaCliente;
    /**
     * Creates new form FormGestionarClient
     * @param parent
     * @param modal
     */
    public FormGestionarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Gestionar Clientes");
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
        botnEliminar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

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

        botnEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/eliminarx32.png"))); // NOI18N
        botnEliminar.setText("Eliminar");
        botnEliminar.setFocusable(false);
        botnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(botnEliminar);

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

        botonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/buscarx20.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaClientes.setPreferredSize(new java.awt.Dimension(50, 200));
        tablaClientes.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(tablaClientes);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
        FormRegistrarCliente formRegistarCliente = new FormRegistrarCliente(this);
        formRegistarCliente.setVisible(true);
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        // TODO add your handling code here:
        int clienteCodigo = obtenerCodigoDeLaTabla();
        if(clienteCodigo == 0)
            return;
        GestionarClienteServicio gestionarClienteServicio = new GestionarClienteServicio();
        try {
            Cliente cliente = gestionarClienteServicio.buscar(clienteCodigo);            
            if(cliente != null){
                FormRegistrarCliente formRegistarCliente = new FormRegistrarCliente(this, cliente);
                formRegistarCliente.setVisible(true);
            }
            else{
                Mensaje.Mostrar_MENSAJE_FILANOEXISTE(this);
            }
            crearTabla();
            ponerFocoConSeleccionEnBuscar();
        } catch (Exception ex) {
            //Logger.getLogger(FormGestionarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botnEliminarActionPerformed
        // TODO add your handling code here:
        int marcaCodigo = obtenerCodigoDeLaTabla();
        if(marcaCodigo == 0)
            return;
        if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
            return;
        GestionarClienteServicio gestionarClienteServicio = new GestionarClienteServicio();
        try {
            int registrosAfectados = gestionarClienteServicio.eliminar(obtenerCodigoDeLaTabla());
            if(registrosAfectados == 1){
                Mensaje.Mostrar_MENSAJE_ELIMINACIONEXITOSA(this);
                crearTabla();
                ponerFocoConSeleccionEnBuscar();
            }else{
                Mensaje.Mostrar_MENSAJE_ELIMINACIONERRONEA(this);
            }
            ponerFocoConSeleccionEnBuscar();
        } catch (Exception ex) {
           // Logger.getLogger(FormGestionarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botnEliminarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        if(!textoBuscar.getText().trim().isEmpty()){
            consultarCliente();
            ponerFocoConSeleccionEnBuscar();
        }
        else{
            Mensaje.Mostrar_MENSAJE_LLENARCAMPOBUSCAR(this);
            ponerFocoConSeleccionEnBuscar();
        }        
    }//GEN-LAST:event_botonBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    private void consultarCliente(){
        crearTabla();
        String nombre = textoBuscar.getText().trim().toUpperCase();
        try {
            GestionarClienteServicio gestionarClienteServicio = new GestionarClienteServicio();
            listaClientes = gestionarClienteServicio.buscarPorNombre(nombre);
            if(listaClientes!=null && listaClientes.size()>0){
                for(Cliente cliente : listaClientes){
                    Fila fila = new Fila();
                    fila.agregarValorCelda(cliente.getCodigo());
                    fila.agregarValorCelda(cliente.getNombre());
                    fila.agregarValorCelda(cliente.getApellido());
                    fila.agregarValorCelda(cliente.getDni());
                    fila.agregarValorCelda(cliente.getDireccion());
                    fila.agregarValorCelda(cliente.getTelefono());
                    fila.agregarValorCelda(cliente.getCelular());
                    fila.agregarValorCelda(cliente.getCorreo());
                    fila.agregarValorCelda(cliente.getGenero());
                    fila.agregarValorCelda(cliente.isActivo());
                    tabla.agregarFila(fila);
               }
                tablaClientes.setModel(modeloTablaCliente);
            }
            else{
                Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
                ponerFocoConSeleccionEnBuscar();
            }
        } catch (Exception ex) {
            //Logger.getLogger(FormGestionarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void ponerFocoConSeleccionEnBuscar(){
        textoBuscar.selectAll();
        textoBuscar.requestFocus();
    }
        
    public void crearTabla(){
        // TODO add your handling code here:
        tabla = new Tabla();
        tabla.agregarColumna( new Columna("Codigo","java.lang.Integer"));
        tabla.agregarColumna( new Columna("Nombre","java.lang.String"));
        tabla.agregarColumna( new Columna("Apellidos","java.lang.String"));
        tabla.agregarColumna( new Columna("DNI","java.lang.String"));
        tabla.agregarColumna( new Columna("Direccion","java.lang.String"));
        tabla.agregarColumna( new Columna("Telefono","java.lang.String"));
        tabla.agregarColumna( new Columna("Celular","java.lang.String"));
        tabla.agregarColumna(new Columna("Correo", "java.lang.String"));
        tabla.agregarColumna( new Columna("Genero","java.lang.String"));
        tabla.agregarColumna( new Columna("Ativo","java.lang.String"));
        modeloTablaCliente = new ModeloTabla(tabla);
        tablaClientes.setModel(modeloTablaCliente);
        //CODIGO
        TableColumn columna0,columna1,columna2,columna3,columna4,columna5, columna6, columna7, columna8, columna9, columna10,columna11,columna12, columna13;
        columna0 = tablaClientes.getColumnModel().getColumn(0);
        columna0.setPreferredWidth(100);
        columna0.setMaxWidth(100);
        columna0.setMinWidth(100);
        //NOMBRES
        columna1 = tablaClientes.getColumnModel().getColumn(1);
        columna1.setPreferredWidth(150);
        columna1.setMaxWidth(150);
        columna1.setMinWidth(150);
        //APELLIDOS
        columna2 = tablaClientes.getColumnModel().getColumn(2);
        columna2.setPreferredWidth(150);
        columna2.setMaxWidth(150);
        columna2.setMinWidth(150);
        //DNI
        columna3 = tablaClientes.getColumnModel().getColumn(3);
        columna3.setPreferredWidth(80);
        columna3.setMaxWidth(80);
        columna3.setMinWidth(80);
        //DIRECCION
        columna4 = tablaClientes.getColumnModel().getColumn(4);
        columna4.setPreferredWidth(200);
        columna4.setMaxWidth(200);
        columna4.setMinWidth(200);
        //TELEFONO
        columna5 = tablaClientes.getColumnModel().getColumn(5);
        columna5.setPreferredWidth(100);
        columna5.setMaxWidth(100);
        columna5.setMinWidth(100);
        //CELULAR
        columna6 = tablaClientes.getColumnModel().getColumn(6);
        columna6.setPreferredWidth(100);
        columna6.setMaxWidth(100);
        columna6.setMinWidth(100);
         //CORREO
        columna7 = tablaClientes.getColumnModel().getColumn(7);
        columna7.setPreferredWidth(100);
        columna7.setMaxWidth(100);
        columna7.setMinWidth(100);
        //GENERO
        columna8 = tablaClientes.getColumnModel().getColumn(8);
        columna8.setPreferredWidth(50);
        columna8.setMaxWidth(50);
        columna8.setMinWidth(50);
        //ESTADO
        columna9 = tablaClientes.getColumnModel().getColumn(9);
        columna9.setPreferredWidth(50);
        columna9.setMaxWidth(50);
        columna9.setMinWidth(50);
        
        tablaClientes.removeColumn(columna0);
    }
    
    public int obtenerCodigoDeLaTabla(){
        int numFila = tablaClientes.getSelectedRow();
        if(numFila == -1){
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(null);
            return 0;
        }
        else
            modeloTablaCliente = (ModeloTabla) tablaClientes.getModel();
        return (Integer)modeloTablaCliente.getValueAt(numFila,0);
            
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botnEliminar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField textoBuscar;
    // End of variables declaration//GEN-END:variables
}
