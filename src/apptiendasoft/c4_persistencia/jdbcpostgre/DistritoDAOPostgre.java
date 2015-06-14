/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IDistritoDAO;
import apptiendasoft.c3_dominio.entidad.Distrito;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c6_transversal.exepcion.ExcepcionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 */
public class DistritoDAOPostgre implements IDistritoDAO{
    GestorJDBC gestorJDBC;

    public DistritoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public void crear(Distrito distrito) throws Exception {
        String consulta="insert into distrito(nombredistrito) values(?)";
        try{
            PreparedStatement sentencia= gestorJDBC.prepararSentencia(consulta);
            sentencia.setString(1,distrito.getNombre());
            sentencia.executeUpdate();
        }catch(SQLException e){
            throw ExcepcionSQL.crearErrorInsertar();
        }
    }

    @Override
    public void modificar(Distrito distrito) throws Exception {
        String consulta="update distrito set nombredistrito=? where codigodistrito=?";
        try{
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, distrito.getNombre());
        sentencia.setInt(2, distrito.getCodigo());
        sentencia.executeUpdate();
        }catch(SQLException e){
            throw ExcepcionSQL.crearErrorModificar();
        }
    }

    @Override
    public void eliminar(Distrito distrito) throws Exception {
        String consulta="delete from distrito where codigodistrito=?";
        try{
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, distrito.getCodigo());
        sentencia.executeUpdate();
        }catch(SQLException e){
            throw ExcepcionSQL.crearErrorEliminar();
        }
    }
    @Override
    public Distrito buscar(int codigo) throws Exception {
        Distrito distrito= null;
        String consulta="select codigodistrito,nombredistrito from distrito where codigodistrito="+codigo;
        try{
            ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
                if(resultado.next()){
                    distrito = new Distrito();
                    distrito.setCodigo(resultado.getInt(1));
                    distrito.setNombre(resultado.getString(2));
                }
        }catch(Exception e){
            throw ExcepcionSQL.crearErrorConsultar();
        }
        return distrito;
    }
    @Override
    public ArrayList<Distrito> buscarPorNombre(String nombre) throws Exception {
        Distrito distrito;
        ArrayList<Distrito> listadistrito= new ArrayList();
        String consulta="select codigodistrito,nombredistrito from distrito where nombredistrito like '%"+nombre+"%' and codigoprovincia is null order by codigodistrito";
        try{
        ResultSet resultado= gestorJDBC.ejecutarConsulta(consulta);
            while(resultado.next()){
                distrito = new Distrito();
                distrito.setCodigo(resultado.getInt(1));
                distrito.setNombre(resultado.getString(2));
                listadistrito.add(distrito);
            }
            resultado.close();
        }catch(Exception e){
            throw ExcepcionSQL.crearErrorConsultar();
        }  
        return listadistrito;
    }
}