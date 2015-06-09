/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.ITipoProductoDAO;
import apptiendasoft.c3_dominio.entidad.TipoProducto;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.TipoProductoDAOPostgre;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class GestionarTipoProductoServicio{

    GestorJDBC gestorJDBC;
    ITipoProductoDAO TipoProductoDAO;

    public GestionarTipoProductoServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.TipoProductoDAO = new TipoProductoDAOPostgre(gestorJDBC);
    }
    
    public void crear(TipoProducto tipoProducto) throws Exception {
        gestorJDBC.abrirConexion();
        try{
            TipoProductoDAO.crear(tipoProducto);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }

    
    public void modificar(TipoProducto tipoProducto) throws Exception {
        gestorJDBC.abrirConexion();
        try{
            TipoProductoDAO.modificar(tipoProducto);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }

    
    public void eliminar(TipoProducto tipoProducto) throws Exception {
        gestorJDBC.abrirConexion();
        try{
            TipoProductoDAO.eliminar(tipoProducto);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }

    
    public TipoProducto buscar(int codigo) throws Exception {
        TipoProducto tipoProducto;
        gestorJDBC.abrirConexion();
        try{
            tipoProducto = TipoProductoDAO.buscar(codigo);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return tipoProducto;
    }

    
    public ArrayList<TipoProducto> buscar(String nombre) throws Exception {        
        ArrayList<TipoProducto> listaTipoProducto;
        gestorJDBC.abrirConexion();
        try{
            listaTipoProducto = TipoProductoDAO.buscar(nombre);
        }catch(Exception e){
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
        return listaTipoProducto;
    }    
}
