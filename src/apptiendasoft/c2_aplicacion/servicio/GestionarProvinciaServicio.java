/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IProvinciaDAO;
import apptiendasoft.c3_dominio.entidad.Provincia;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.ProvinciaDAOPostgre;
import java.util.ArrayList;

/**
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 */
public class GestionarProvinciaServicio {
    GestorJDBC gestorJDBC;
    IProvinciaDAO provinciaDAO;

    public GestionarProvinciaServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.provinciaDAO = new ProvinciaDAOPostgre(gestorJDBC);
    }
    public void crear(Provincia provincia)throws Exception{
        gestorJDBC.abrirConexion();
        try{
            provinciaDAO.crear(provincia);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
            gestorJDBC.cerrarConexion();
    }
    public void modificar(Provincia provincia)throws Exception{
        gestorJDBC.abrirConexion();
        try{
            provinciaDAO.modificar(provincia);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    public void eliminar(Provincia provincia)throws Exception{
        gestorJDBC.abrirConexion();
        try{
            provinciaDAO.eliminar(provincia);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    public Provincia buscar(int codigo)throws Exception{
        Provincia provincia;
        gestorJDBC.abrirConexion();
        try{
            provincia = provinciaDAO.buscar(codigo);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return provincia;
    }

    public ArrayList<Provincia> buscarPorNombre(String nombre)throws Exception{
        ArrayList<Provincia>listaprovincia;
        gestorJDBC.abrirConexion();
        try{
            listaprovincia = provinciaDAO.buscarPorNombre(nombre);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listaprovincia;
    }
}
