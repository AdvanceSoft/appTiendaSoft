/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IDepartamentoDAO;
import apptiendasoft.c3_dominio.entidad.Departamento;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.DepartamentoDAOPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public class GestionarDepartamentoServicio {
    GestorJDBC gestorJDBC;
    IDepartamentoDAO departamentoDAO;

    public GestionarDepartamentoServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.departamentoDAO = new DepartamentoDAOPostgre(gestorJDBC);
    }
    public int crear(Departamento departamento)throws Exception{
        gestorJDBC.abrirConexion();
        int estado=departamentoDAO.crear(departamento);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    public int modificar(Departamento departamento)throws Exception{
        gestorJDBC.abrirConexion();
        int estado = departamentoDAO.modificar(departamento);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    public int eliminar(int codigo)throws Exception{
        gestorJDBC.abrirConexion();
        int estado = departamentoDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    public Departamento buscar(int codigo)throws Exception{
        gestorJDBC.abrirConexion();
        Departamento departamento = departamentoDAO.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return departamento;
    }
    
    public ArrayList<Departamento> buscarPorNombre(String nombre)throws Exception{
        gestorJDBC.abrirConexion();
        ArrayList<Departamento> listadepartamento = departamentoDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listadepartamento;
    }
}
