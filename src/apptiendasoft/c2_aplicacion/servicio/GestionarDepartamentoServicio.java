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
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 */
public class GestionarDepartamentoServicio {
    GestorJDBC gestorJDBC;
    IDepartamentoDAO departamentoDAO;

    public GestionarDepartamentoServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.departamentoDAO = new DepartamentoDAOPostgre(gestorJDBC);
    }
    public void crear(Departamento departamento)throws Exception{
        gestorJDBC.abrirConexion();
        try{
            departamentoDAO.crear(departamento);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    public void modificar(Departamento departamento)throws Exception{
        gestorJDBC.abrirConexion();
        try{
            departamentoDAO.modificar(departamento);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    public void eliminar(Departamento departamento)throws Exception{
        gestorJDBC.abrirConexion();
        try{
            departamentoDAO.eliminar(departamento);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    public Departamento buscar(int codigo)throws Exception{
        Departamento departamento;
        gestorJDBC.abrirConexion();
        try{
            departamento = departamentoDAO.buscar(codigo);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return departamento;
    }
    
    public ArrayList<Departamento> buscarPorNombre(String nombre)throws Exception{
        ArrayList<Departamento> listaDepartamentos;
        gestorJDBC.abrirConexion();
        try{
            listaDepartamentos = departamentoDAO.buscarPorNombre(nombre);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listaDepartamentos;
    }
}
