/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.ICargoDAO;
import apptiendasoft.c3_dominio.entidad.Cargo;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.CargoDAOPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import java.util.ArrayList;

/**
 *
 * @author 
 * <Valencia Cerna Nelida Janeth advancesoft.trujillo@gmail.com>
 */
public class GestionarCargoServicio {
    
    GestorJDBC gestorJDBC;
    ICargoDAO cargoDAO;
    
    public GestionarCargoServicio(){
        this.gestorJDBC = new GestorJDBCPostgre();
        this.cargoDAO = new CargoDAOPostgre(gestorJDBC);
    }
    
    public int crear (Cargo cargo)throws Exception{
        gestorJDBC.abrirConexion();
        int estado = cargoDAO.crear(cargo);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    
    public int modificar(Cargo cargo) throws Exception{
        gestorJDBC.abrirConexion();
        int estado = cargoDAO.modificar(cargo);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    
    public int eliminar(int codigo) throws Exception{
        gestorJDBC.abrirConexion();
         int estado = cargoDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    
    public Cargo buscar(int codigo) throws Exception{
        gestorJDBC.abrirConexion();
        Cargo cargo = cargoDAO.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return cargo;
    }
    
    public ArrayList<Cargo> buscarporNombre(String nombre) throws Exception{
        gestorJDBC.abrirConexion();
        ArrayList<Cargo> listaCargo = cargoDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listaCargo;
    }  
    
    public Cargo buscarNombre(String nombre)throws Exception{
        gestorJDBC.abrirConexion();
        Cargo cargo = cargoDAO.buscarNombre(nombre);
        gestorJDBC.cerrarConexion();
        return cargo;
    }
}
