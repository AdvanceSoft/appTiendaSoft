/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IUnidadDeMedidaDAO;
import apptiendasoft.c3_dominio.entidad.UnidadDeMedida;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.UnidadDeMedidaDAOPostgre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public class GestionarUnidadDeMedidaServicio {
    GestorJDBC gestorJDBC; 
    IUnidadDeMedidaDAO unidadDeMedidaDAO;

    public GestionarUnidadDeMedidaServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.unidadDeMedidaDAO = new UnidadDeMedidaDAOPostgre(gestorJDBC);
    }
    
    public ArrayList<UnidadDeMedida> buscar(String descripcion)throws Exception{
        ArrayList<UnidadDeMedida> listaUndiadDeMedida;
        gestorJDBC.abrirConexion(); 
            try {            
                listaUndiadDeMedida = unidadDeMedidaDAO.buscar(descripcion);
            }catch (Exception e) {
                gestorJDBC.cerrarConexion();  
                throw e;
            }                      
        gestorJDBC.cerrarConexion();  
        return listaUndiadDeMedida;   
    }
    public UnidadDeMedida buscar(int unidadDeMedidaID) throws Exception{     
        UnidadDeMedida unidadDeMedida;
        gestorJDBC.abrirConexion();        
            try {
                unidadDeMedida = unidadDeMedidaDAO.buscar(unidadDeMedidaID);
            }catch (Exception e) {
                gestorJDBC.cerrarConexion();  
                throw e;
            }
        gestorJDBC.cerrarConexion();
        return unidadDeMedida;
    }
    public void eliminar(UnidadDeMedida unidadDeMedida)throws Exception{
        gestorJDBC.abrirConexion();
            try {
                unidadDeMedidaDAO.eliminar(unidadDeMedida);
            }catch (Exception e) {
                gestorJDBC.cerrarConexion();
                throw e; 
            }
        gestorJDBC.cerrarConexion();
    }
    public void guardar(UnidadDeMedida unidadDeMedida) throws Exception{     
        gestorJDBC.abrirConexion();
          try {
            unidadDeMedidaDAO.ingresar(unidadDeMedida);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
    
    public void modificar(UnidadDeMedida unidadDeMedida)throws Exception{
        gestorJDBC.abrirConexion();
          try {
            unidadDeMedidaDAO.modificar(unidadDeMedida);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
            throw e;
        }
        gestorJDBC.cerrarConexion();
    }
   
}
