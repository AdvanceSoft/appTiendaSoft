/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IVentaDAO;
import apptiendasoft.c3_dominio.entidad.Venta;
import apptiendasoft.c4_persistencia.GestorJDBC;

/**
 *
 * @author HacybeykerS
 */
public class VentaDAOPostgre implements IVentaDAO{

    GestorJDBC gestorJDBC;

    public VentaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
        
    @Override
    public void registrarVenta(Venta venta) throws Exception {
        
        
    }
    
}
