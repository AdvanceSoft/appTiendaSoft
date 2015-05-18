/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IDistritoDAO;
import apptiendasoft.c3_dominio.entidad.Distrito;
import apptiendasoft.c4_persistencia.GestorJDBC;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public class GestionarDistritoServicio {
    GestorJDBC gestorJDBC;
    IDistritoDAO distritoDAO;

    public GestionarDistritoServicio() {
        this.gestorJDBC = gestorJDBC;
        this.distritoDAO = distritoDAO;
    }
    public int crear(Distrito distrito)throws Exception{
        gestorJDBC.abrirConexion();
        int estado = distritoDAO.crear(distrito);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    
    public int modificar(Distrito distrito)throws Exception{
        gestorJDBC.abrirConexion();
        int estado = distritoDAO.modificar(distrito);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    
    public int eliminar(int codigo)throws Exception{
        gestorJDBC.abrirConexion();
        int estado = distritoDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    public Distrito buscar(int codigo)throws Exception{
        gestorJDBC.abrirConexion();
        Distrito distrito = distritoDAO.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return distrito;
    }
    public ArrayList<Distrito> buscarPorNombre(String nombre)throws Exception{
        gestorJDBC.abrirConexion();
        ArrayList<Distrito> listadistrito = distritoDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listadistrito;
    }
}
