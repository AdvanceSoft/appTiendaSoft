/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IDistritoDAO;
import apptiendasoft.c3_dominio.entidad.Distrito;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.DistritoDAOPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import java.util.ArrayList;

/**
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 */
public class GestionarDistritoServicio {
    GestorJDBC gestorJDBC;
    IDistritoDAO distritoDAO;

    public GestionarDistritoServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.distritoDAO = new DistritoDAOPostgre(gestorJDBC);
    }
    public void crear(Distrito distrito)throws Exception{
        gestorJDBC.abrirConexion();
        try{
            distritoDAO.crear(distrito);
        }catch(Exception e){        
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void modificar(Distrito distrito)throws Exception{
        gestorJDBC.abrirConexion();
        try{
            distritoDAO.modificar(distrito);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void eliminar(Distrito distrito)throws Exception{
        gestorJDBC.abrirConexion();
        try{
            distritoDAO.eliminar(distrito);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    public Distrito buscar(int codigo)throws Exception{
        Distrito distrito;
        gestorJDBC.abrirConexion();
        try{
            distrito = distritoDAO.buscar(codigo);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return distrito;
    }
    public ArrayList<Distrito> buscarPorNombre(String nombre)throws Exception{
        ArrayList<Distrito> listadistrito;
        gestorJDBC.abrirConexion();
        try{
            listadistrito = distritoDAO.buscarPorNombre(nombre);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listadistrito;
    }
}
