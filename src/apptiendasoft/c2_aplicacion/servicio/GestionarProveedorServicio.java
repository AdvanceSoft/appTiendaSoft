/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IProveedorDAO;
import apptiendasoft.c3_dominio.entidad.Proveedor;
import apptiendasoft.c3_dominio.servicio.ConsultaProveedores;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.ProveedorDAOPostgre;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public class GestionarProveedorServicio {
    GestorJDBC gestorJDBC; 
    IProveedorDAO proveedorDAO;

    public GestionarProveedorServicio() {
        this.gestorJDBC= new GestorJDBCPostgre();
        this.proveedorDAO= new ProveedorDAOPostgre(gestorJDBC);
    }
    
    public ConsultaProveedores buscar(String descripcion)throws Exception{
        List<Proveedor> listaProveedores;
        ConsultaProveedores consultaProveedores;
        gestorJDBC.abrirConexion(); 
            try {            
                listaProveedores = proveedorDAO.buscar(descripcion);
                consultaProveedores = new ConsultaProveedores(listaProveedores);
            }catch (Exception e) {
                gestorJDBC.cerrarConexion();  
                throw e;
            }                      
        gestorJDBC.cerrarConexion();  
        return consultaProveedores;   
    }
    
    public ConsultaProveedores buscarAll()throws Exception{
        List<Proveedor> listaProveedores;
        ConsultaProveedores consultaProveedores;
        gestorJDBC.abrirConexion(); 
            try {            
                listaProveedores = proveedorDAO.buscarTodos();
                consultaProveedores = new ConsultaProveedores(listaProveedores);
            }catch (Exception e) {
                gestorJDBC.cerrarConexion();  
                throw e;
            }                      
        gestorJDBC.cerrarConexion();  
        return consultaProveedores;
    }
    
    
    
}
