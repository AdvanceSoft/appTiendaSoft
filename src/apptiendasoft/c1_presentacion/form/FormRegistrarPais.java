/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c1_presentacion.form;

import apptiendasoft.c1_presentacion.util.Mensaje;
import apptiendasoft.c2_aplicacion.servicio.GestionarDepartamentoServicio;
import apptiendasoft.c2_aplicacion.servicio.GestionarPaisServicio;
import apptiendasoft.c3_dominio.entidad.Departamento;
import apptiendasoft.c3_dominio.entidad.Pais;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 */
public class FormRegistrarPais extends javax.swing.JDialog {

    Pais pais;
    public FormRegistrarPais(JDialog owner) {
        super(owner, true);
        initComponents();
        this.pais = new Pais();
        crearTabla();
        crearTablaAsignados();
    }
    public FormRegistrarPais(JDialog owner, Pais pais) {
        super(owner, true);
        initComponents();
        obtenerObjetoDeGestionar(pais);
    }
    private void obtenerObjetoDeGestionar(Pais pais) {
        this.pais = pais;
        textonombrepais.setText(pais.getNombre());
        mostrardepartamentosasignados();
    }
    private void crearTabla() {
        // TODO add your handling code here:
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Nombre", "java.lang.String"));
        ModeloTabla modeloTablaDepartamento = new ModeloTabla(tabla);
        tablaDepartamento.setModel(modeloTablaDepartamento);
        //CODIGO
        TableColumn columna0,columna1;
        columna0 = tablaDepartamento.getColumnModel().getColumn(0);
        tablaDepartamento.removeColumn(columna0);
        //NOMBRE
        columna1 = tablaDepartamento.getColumnModel().getColumn(1);
        columna1.setPreferredWidth(250);
        columna1.setMaxWidth(250);
        columna1.setMinWidth(250);  
    }
    private void crearTablaAsignados() {
        // TODO add your handling code here:
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("Nombre", "java.lang.String"));
        ModeloTabla modeloTablaAsignado = new ModeloTabla(tabla);
        tablaAsignadosDepartamentos.setModel(modeloTablaAsignado);
        //CODIGO
        TableColumn columna0,columna1;
        columna0 = tablaAsignadosDepartamentos.getColumnModel().getColumn(0);
        tablaAsignadosDepartamentos.removeColumn(columna0);
        //NOMBRE
        columna1 = tablaAsignadosDepartamentos.getColumnModel().getColumn(1);
        columna1.setPreferredWidth(250);
        columna1.setMaxWidth(250);
        columna1.setMinWidth(250);   
    }
    
    private boolean verificarCamposLlenos() {
        boolean estanLlenos;
        if(!(textonombrepais.getText().trim().isEmpty()))
            estanLlenos = true;
        else
            estanLlenos = false; 
        return estanLlenos;
    }

    private boolean verificarCamposVacios(){
        boolean verificar = true;
        if(textonombrepais.getText().trim().isEmpty()){
           Mensaje.Mostrar_MENSAJE_LLENARCAMPOSOBLIGATORIOS(this);
           textonombrepais.requestFocus();
           verificar = false;
        }else
            verificar = false;
        return verificar;
    }
    
    private void buscar() {
        String nombre = textoDepartamentoBuscar.getText().trim().toUpperCase();
        ModeloTabla modeloTablaTipoProducto = (ModeloTabla) tablaDepartamento.getModel();
        modeloTablaTipoProducto.eliminarTotalFilas();
        try {
            GestionarDepartamentoServicio gestionarDepartamentoServicio = new GestionarDepartamentoServicio();
            ArrayList<Departamento> listaDepartamento = gestionarDepartamentoServicio.buscarPorNombre(nombre);
            if(listaDepartamento!=null && listaDepartamento.size()>0){
                for(Departamento distrito : listaDepartamento){
                    Fila fila = new Fila();
                    fila.agregarValorCelda(distrito.getCodigo());
                    fila.agregarValorCelda(distrito.getNombre());
                    modeloTablaTipoProducto.agregarFila(fila);
                }         
                modeloTablaTipoProducto.refrescarDatos();
                ponerFocoConSeleccionEnBuscar();
            }else{
                Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
                ponerFocoConSeleccionEnBuscar();
            }
        } catch(Exception e){    
            Mensaje.Mostrar_MENSAJE_NOSEENCONTRONINGUNRESULTADO(this);
            ponerFocoConSeleccionEnBuscar();
        }
    }
    
    private Departamento obtenerCodigoDeLaTablaDepartamento() {
        Departamento departamento = null;
        int numFila = tablaDepartamento.getSelectedRow();
        if(numFila >=0){
            GestionarDepartamentoServicio gestionarDepartamentoServicio = new GestionarDepartamentoServicio();
            ModeloTabla modeloTabla = (ModeloTabla)tablaDepartamento.getModel();
            int codigo = (int) modeloTabla.getValueAt(numFila, 0);
            try{
                departamento = gestionarDepartamentoServicio.buscar(codigo);
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            }
        }else{
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        }
        return departamento;
    }
    private Departamento obtenerCodigoTablaAsignado(){
        Departamento departamento = null;
        int numFila = tablaAsignadosDepartamentos.getSelectedRow();
        if(numFila >=0){
            GestionarDepartamentoServicio gestionarDepartamentoServicio = new GestionarDepartamentoServicio();
            ModeloTabla modeloTabla = (ModeloTabla)tablaAsignadosDepartamentos.getModel();
            int codigo = (int) modeloTabla.getValueAt(numFila, 0);
            try{
                departamento = gestionarDepartamentoServicio.buscar(codigo);
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            }
        }else{
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
        }
        return departamento;
    }
    
    private void mostrardepartamentosasignados(){
        ModeloTabla modeloTablaDepartamento = (ModeloTabla) tablaAsignadosDepartamentos.getModel();
        for(Departamento departamento : pais.getListaDepartamento()){
                    Fila fila = new Fila();
                    fila.agregarValorCelda(departamento.getCodigo());
                    fila.agregarValorCelda(departamento.getNombre());
                    modeloTablaDepartamento.agregarFila(fila);
                }
        modeloTablaDepartamento.refrescarDatos();
        labelcantidad.setText(String.valueOf(pais.cantidadDeDepartamentos()));
    }
    private void agregarDepartamento(int codigo){
        GestionarDepartamentoServicio gestionarDepartamentoServicio = new GestionarDepartamentoServicio();
        if(obtenerCodigoTablaAsignado() != null){
            try {
                Departamento departamento = gestionarDepartamentoServicio.buscar(codigo);
                if(departamento != null){
                    pais.agregarDepartamentos(departamento);
                }
                else{
                    Mensaje.Mostrar_MENSAJE_FILANOEXISTE(this);
                }
            }catch(Exception e){
                Mensaje.mostrarErrorExcepcion(this, e.getMessage());
            }
        }else
            Mensaje.Mostrar_MENSAJE_FILANOSELECCIONADO(this);
    }
    private void ponerFocoConSeleccionEnBuscar() {
        textoDepartamentoBuscar.selectAll();
        textoDepartamentoBuscar.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDepartamento = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        botonCrear = new javax.swing.JButton();
        textoDepartamentoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        botonQuitar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAsignadosDepartamentos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        labelcantidad = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        textonombrepais = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Departamento");

        tablaDepartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaDepartamento);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        botonCrear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/crearx32.png"))); // NOI18N
        botonCrear.setFocusable(false);
        botonCrear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCrear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });
        jToolBar1.add(botonCrear);

        textoDepartamentoBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(textoDepartamentoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBuscar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textoDepartamentoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonQuitar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonQuitar.setText("Quitar");
        botonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaAsignadosDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaAsignadosDepartamentos);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Cantidad de Departamentos Asignados:");

        labelcantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelcantidad.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(labelcantidad)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelcantidad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/salirx32.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setPreferredSize(new java.awt.Dimension(117, 51));
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apptiendasoft/c5_recursos/iconos/guardarx32.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        textonombrepais.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("País :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuardar)
                .addGap(10, 10, 10)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonAgregar)
                            .addComponent(botonQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(textonombrepais, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textonombrepais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(botonAgregar)
                        .addGap(15, 15, 15)
                        .addComponent(botonQuitar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
        FormRegistrarDepartamento formRegistrarDepartamento = new FormRegistrarDepartamento(this);
        formRegistrarDepartamento.setVisible(true);
        buscar();
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:
        agregarDepartamento(obtenerCodigoTablaAsignado().getCodigo());
        mostrardepartamentosasignados();
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarActionPerformed
        // TODO add your handling code here:
        GestionarDepartamentoServicio gestionarDepartamentoServicio = new GestionarDepartamentoServicio();
        try {
            if(obtenerCodigoTablaAsignado() != null){
                if(!Mensaje.Mostrar_MENSAJE_PREGUNTADEELIMINACION(this))
                return;
                pais.eliminarDepartamento(obtenerCodigoTablaAsignado());
                mostrardepartamentosasignados();
            }
            else{
                Mensaje.Mostrar_MENSAJE_FILANOEXISTE(this);
            }
        } catch(Exception e){
            Mensaje.mostrarErrorExcepcion(this, e.getMessage());
        }
    }//GEN-LAST:event_botonQuitarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        if(verificarCamposLlenos()){
            if(Mensaje.Mostrar_MENSAJE_SALIRSINGUARDAR(this))
            this.dispose();
        }else
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        pais.setNombre(textonombrepais.getText().trim().toUpperCase());
        GestionarPaisServicio gestionarPaisServicio  = new GestionarPaisServicio();
            try{
                if(pais.getCodigo()==0){
                    if(verificarCamposVacios()){
                        gestionarPaisServicio.crear(pais);
                        Mensaje.Mostrar_MENSAJE_GUARDADOEXITOSO(this);
                        this.dispose();
                    }
                }else{
                    gestionarPaisServicio.modificar(pais);
                    Mensaje.Mostrar_MENSAJE_MODIFICADOEXITOSO(this);
                    this.dispose();
                }
            }catch(Exception ex){
                Mensaje.mostrarErrorExcepcion(this, ex.getMessage());
                }
    }//GEN-LAST:event_botonGuardarActionPerformed
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonQuitar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelcantidad;
    private javax.swing.JTable tablaAsignadosDepartamentos;
    private javax.swing.JTable tablaDepartamento;
    private javax.swing.JTextField textoDepartamentoBuscar;
    private javax.swing.JTextField textonombrepais;
    // End of variables declaration//GEN-END:variables
}
