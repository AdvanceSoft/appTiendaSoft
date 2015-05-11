/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IEmpresaDAO;
import apptiendasoft.c3_dominio.entidad.Empresa;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.EmpresaDAOPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class GestionarEmpresaServicio{

    GestorJDBC gestorJDBC;
    IEmpresaDAO EmpresaDAO;

    public GestionarEmpresaServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.EmpresaDAO = new EmpresaDAOPostgre(gestorJDBC);
    }
    
    public void modificar(Empresa empresa) throws Exception {
        gestorJDBC.abrirConexion();
        EmpresaDAO.modificar(empresa);
        gestorJDBC.cerrarConexion();
    }
    
    public Empresa buscar() throws Exception {
        Empresa empresa = null;
        gestorJDBC.abrirConexion();
         empresa = EmpresaDAO.buscar();
         gestorJDBC.cerrarConexion();
         return empresa;
    }
    
}
