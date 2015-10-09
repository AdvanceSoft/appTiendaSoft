/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.ILoteDAO;
import apptiendasoft.c3_dominio.entidad.Lote;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.LoteDAOPostgre;
import java.util.ArrayList;
/**
 *
 * @author Sandra Zoraida Medrano Parado <advancesoft.trujillo@gmail.com>
 */
public class GestionarLoteServicio {
    GestorJDBC gestorJDBC;
    ILoteDAO loteDAO;
    
    public GestionarLoteServicio() {
        gestorJDBC = new GestorJDBCPostgre();
        loteDAO = new LoteDAOPostgre(gestorJDBC);
    }
    
    public void crear(Lote lote) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            loteDAO.crear(lote);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
        }
        gestorJDBC.cerrarConexion();
    }

    
    public void modificar(Lote lote) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            loteDAO.modificar(lote);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
        }
        gestorJDBC.cerrarConexion();
    }

    
    public void eliminar(Lote lote) throws Exception {
        gestorJDBC.abrirConexion();
        try {
            loteDAO.eliminar(lote);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
        }
        gestorJDBC.cerrarConexion();        
    }

    public Lote buscar(int codigo) throws Exception {
        Lote lote = null;
        gestorJDBC.abrirConexion();
        try {
            lote = loteDAO.buscar(codigo);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
        }
        gestorJDBC.cerrarConexion();
        return lote;
    }
    public ArrayList<Lote> buscarProducto(String producto) throws Exception{
        ArrayList<Lote> listalote = null;
        gestorJDBC.abrirConexion();
        try {
                listalote = loteDAO.buscarProducto(producto);
        } catch (Exception e) {
            gestorJDBC.cerrarConexion();
        }
        gestorJDBC.cerrarConexion();
        return listalote;
    }
}
