/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IPaisDAO;
import apptiendasoft.c3_dominio.entidad.Pais;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.PaisDAOPostgre;
import java.util.ArrayList;

/**
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 */
public class GestionarPaisServicio {
    GestorJDBC gestorJDBC;
    IPaisDAO paisDAO;

    public GestionarPaisServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.paisDAO = new PaisDAOPostgre(gestorJDBC);
    }
    public void crear(Pais pais)throws Exception{
        gestorJDBC.abrirConexion();
        try{
            paisDAO.crear(pais);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    public void modificar(Pais pais)throws Exception{
        gestorJDBC.abrirConexion();
        try{
            paisDAO.modificar(pais);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    public void eliminar(Pais pais)throws Exception{
        gestorJDBC.abrirConexion();
        try{
            paisDAO.eliminar(pais);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    public Pais buscar(int codigo)throws Exception{
        Pais pais;
        gestorJDBC.abrirConexion();
        try{
            pais = paisDAO.buscar(codigo);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return pais;
    }
    
    public ArrayList<Pais> buscarPorNombre(String nombre)throws Exception{
        ArrayList<Pais> listapais;
        gestorJDBC.abrirConexion();
        try{
            listapais = paisDAO.buscarPorNombre(nombre);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
            gestorJDBC.cerrarConexion();
        return listapais;
    }
}
