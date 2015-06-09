/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.ITipoProductoDAO;
import apptiendasoft.c3_dominio.entidad.TipoProducto;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c6_transversal.exepcion.ExcepcionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class TipoProductoDAOPostgre implements ITipoProductoDAO{
    
    GestorJDBC gestorJDBC;

    public TipoProductoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }    

    @Override
    public void crear(TipoProducto tipoProducto) throws Exception {
        String consulta = "insert into tipoproducto(nombretipoproducto,descripciontipoproducto) values(?,?)";
        try{
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
            sentencia.setString(1, tipoProducto.getNombre());
            sentencia.setString(2, tipoProducto.getDescripcion());
            sentencia.executeUpdate();
        }catch(SQLException ex){
            throw ExcepcionSQL.crearErrorInsertar();
        }
    }

    @Override
    public void modificar(TipoProducto tipoProducto) throws Exception {
        String consulta = "update tipoproducto set nombretipoproducto=?,descripciontipoproducto=? where codigotipoproducto=?";
        try{
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
            sentencia.setString(1, tipoProducto.getNombre());
            sentencia.setString(2, tipoProducto.getDescripcion());
            sentencia.setInt(3, tipoProducto.getCodigo());
            sentencia.executeUpdate();
        }catch(Exception ex){
            throw ExcepcionSQL.crearErrorModificar();
        }
                
            
    }

    @Override
    public void eliminar(TipoProducto tipoProducto) throws Exception {
        String consulta = "delete from tipoproducto where codigotipoproducto = ?";
        try{            
            PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
            sentencia.setInt(1, tipoProducto.getCodigo());
            sentencia.executeUpdate();            
        }catch(Exception ex){
            throw ExcepcionSQL.crearErrorEliminar();
        }
    }

    @Override
    public TipoProducto buscar(int codigo) throws Exception {
        String consulta = "select codigotipoproducto,nombretipoproducto,descripciontipoproducto "
                + "from tipoproducto where codigotipoproducto ="+codigo;
        TipoProducto tipoProducto = null;  
        try{
            ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);                  
                if(resultado.next()){
                    tipoProducto = new TipoProducto();
                    tipoProducto.setCodigo(resultado.getInt(1));
                    tipoProducto.setNombre(resultado.getString(2));
                    tipoProducto.setDescripcion(resultado.getString(3));
                }
        }catch(Exception ex){
            throw ExcepcionSQL.crearErrorConsultar();
        }
        return tipoProducto;
    }

    @Override
    public ArrayList<TipoProducto> buscar(String nombre) throws Exception {
        String consulta = "select codigotipoproducto,nombretipoproducto,descripciontipoproducto "
                + "from tipoproducto where nombretipoproducto like '%"+nombre+"%'";
        TipoProducto tipoProducto;
        ArrayList<TipoProducto> listaTipoProducto = new ArrayList<>(); 
        try{
            ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);                   
                while(resultado.next()){
                    tipoProducto = new TipoProducto();
                    tipoProducto.setCodigo(resultado.getInt(1));
                    tipoProducto.setNombre(resultado.getString(2));
                    tipoProducto.setDescripcion(resultado.getString(3));
                    listaTipoProducto.add(tipoProducto);
                }
        }catch(Exception ex){
            throw ExcepcionSQL.crearErrorConsultar();
        }
        return listaTipoProducto;
    }    
}
