/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IProvinciaDAO;
import apptiendasoft.c3_dominio.entidad.Provincia;
import apptiendasoft.c4_persistencia.GestorJDBC;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public class GestionarProvinciaServicio {
    GestorJDBC gestorJDBC;
    IProvinciaDAO provinciaDAO;

    public GestionarProvinciaServicio() {
        this.gestorJDBC = gestorJDBC;
        this.provinciaDAO = provinciaDAO;
    }
    public int crear(Provincia provincia)throws Exception{
        gestorJDBC.abrirConexion();
        int estado=provinciaDAO.crear(provincia);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    public int modificar(Provincia provincia)throws Exception{
        gestorJDBC.abrirConexion();
        int estado = provinciaDAO.modificar(provincia);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    public int eliminar(int codigo)throws Exception{
        gestorJDBC.abrirConexion();
        int estado = provinciaDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    public Provincia buscar(int codigo)throws Exception{
        gestorJDBC.abrirConexion();
        Provincia provincia = provinciaDAO.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return provincia;
    }
    
    public ArrayList<Provincia> buscarPorNombre(String nombre)throws Exception{
        gestorJDBC.abrirConexion();
        ArrayList<Provincia> listaprovincia = provinciaDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listaprovincia;
    }
}
