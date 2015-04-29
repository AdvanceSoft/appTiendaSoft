/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IMarcaDAO;
import apptiendasoft.c3_dominio.entidad.Marca;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.MarcaDAOPostgre;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class GestionarMarcaServicio {
    GestorJDBC gestorJDBC;
    IMarcaDAO marcaDAO;

    public GestionarMarcaServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.marcaDAO = new MarcaDAOPostgre(gestorJDBC);
    }
    
    public int crear(Marca marca) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = marcaDAO.crear(marca);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    
    public int modificar(Marca marca) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = marcaDAO.modificar(marca);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    public int eliminar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        int estado = marcaDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return estado;
    }

    public Marca buscar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        Marca marca = marcaDAO.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return marca;
    }
    
    public ArrayList<Marca> buscarPorNombre(String nombre) throws Exception {
        gestorJDBC.abrirConexion();
        ArrayList<Marca> listaMarca = marcaDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listaMarca;
    }
    
}
