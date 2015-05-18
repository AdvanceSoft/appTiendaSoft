/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IPaisDAO;
import apptiendasoft.c3_dominio.entidad.Pais;
import apptiendasoft.c4_persistencia.GestorJDBC;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public class GestionarPaisServicio {
    GestorJDBC gestorJDBC;
    IPaisDAO paisDAO;

    public GestionarPaisServicio() {
        this.gestorJDBC = gestorJDBC;
        this.paisDAO = paisDAO;
    }
    public int crear(Pais pais)throws Exception{
        gestorJDBC.abrirConexion();
        int estado=paisDAO.crear(pais);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    public int modificar(Pais pais)throws Exception{
        gestorJDBC.abrirConexion();
        int estado = paisDAO.modificar(pais);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    public int eliminar(int codigo)throws Exception{
        gestorJDBC.abrirConexion();
        int estado = paisDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return estado;
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
