/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IEmpleadoDAO;
import apptiendasoft.c3_dominio.entidad.Empleado;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.EmpleadoDAOPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class GestionarEmpleadoServicio {
    GestorJDBC gestorJDBC;
    IEmpleadoDAO empleadoDAO;

    public GestionarEmpleadoServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.empleadoDAO = new EmpleadoDAOPostgre(gestorJDBC);
    }
    
    public int crear(Empleado empleado)throws Exception {
        gestorJDBC.abrirConexion();
        int estado = empleadoDAO.crear(empleado);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    
    public int modificar(Empleado empleado)throws Exception {
        gestorJDBC.abrirConexion();
        int estado = empleadoDAO.modificar(empleado);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    
    public int eliminar(int codigo)throws Exception {
        gestorJDBC.abrirConexion();
        int estado = empleadoDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    
    public Empleado buscar(int codigo)throws Exception {
        gestorJDBC.abrirConexion();
        Empleado empleado = empleadoDAO.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return empleado;
    }
    
    public ArrayList<Empleado> buscarPorNombre(String nombre)throws Exception {
        gestorJDBC.abrirConexion();
        ArrayList<Empleado> listaEmpleados = empleadoDAO.buscarPorNOmbre(nombre);
        gestorJDBC.cerrarConexion();
        return listaEmpleados;
    }
}
