/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IProductoDAO;
import apptiendasoft.c3_dominio.entidad.Producto;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.ProductoDAOPostgre;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class GestionarProductoServicio{

    GestorJDBC gestorJDBC;
    IProductoDAO productoDAO;
    
    public GestionarProductoServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.productoDAO = new ProductoDAOPostgre(gestorJDBC);
    }

    
//    public void crear(Producto producto) throws Exception {
//        
//    }
//
//    
//    public void modificar(Producto producto) throws Exception {
//        
//    }
//
//    
//    public void eliminar(Producto producto) throws Exception {
//        
//    }
//
//    
//    public Producto buscar(int codigo) throws Exception {
//        
//    }

    
    public ArrayList<Producto> buscar(String nombre) throws Exception {
        ArrayList<Producto> listaProducto;
        gestorJDBC.abrirConexion();
        listaProducto = productoDAO.buscar(nombre);
        gestorJDBC.cerrarConexion();
        return listaProducto;
    }
    
}
