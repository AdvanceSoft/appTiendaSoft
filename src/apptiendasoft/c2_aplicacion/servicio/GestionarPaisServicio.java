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
 *
 * @author sandra
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
        paisDAO.crear(pais);
        gestorJDBC.cerrarConexion();
    }
    public void modificar(Pais pais)throws Exception{
        gestorJDBC.abrirConexion();
        paisDAO.modificar(pais);
        gestorJDBC.cerrarConexion();
    }
    public void eliminar(int codigo)throws Exception{
        gestorJDBC.abrirConexion();
        paisDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
    }
    public Pais buscar(int codigo)throws Exception{
        gestorJDBC.abrirConexion();
        Pais pais = paisDAO.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return pais;
    }
    
    public ArrayList<Pais> buscarPorNombre(String nombre)throws Exception{
        gestorJDBC.abrirConexion();
        ArrayList<Pais> listapais = paisDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listapais;
    }
}
