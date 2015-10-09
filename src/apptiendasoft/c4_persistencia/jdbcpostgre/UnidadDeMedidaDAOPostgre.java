/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IUnidadDeMedidaDAO;
import apptiendasoft.c3_dominio.entidad.UnidadDeMedida;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c6_transversal.exepcion.ExcepcionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public class UnidadDeMedidaDAOPostgre implements IUnidadDeMedidaDAO{
    GestorJDBC gestorJDBC;

    public UnidadDeMedidaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    private UnidadDeMedida crearObjetoUnidadDeMedida(ResultSet resultado) throws SQLException {
        UnidadDeMedida unidadDeMedida = new UnidadDeMedida();
        unidadDeMedida.setCodigoUnidadDeMedida(resultado.getInt("codigounidaddemedida"));
        unidadDeMedida.setNombreUnidadDeMedidaBD(resultado.getString("nombreunidaddemedida"));
        unidadDeMedida.setDescripcionUnidadDeMedida(resultado.getString("descripcionunidaddemedida"));
        return unidadDeMedida;
    }

    @Override
    public UnidadDeMedida buscar(int unidadDeMedidaid) throws Exception {
        UnidadDeMedida unidadDeMedida = null; 
        ResultSet resultado; 
        String sentenciaSQL = "select codigounidaddemedida, nombreunidaddemedida, descripcionunidaddemedida\n" +
                              "from unidaddemedida where codigounidaddemedida = "+unidadDeMedidaid;
        try {
            resultado=gestorJDBC.ejecutarConsulta(sentenciaSQL); 
            if(resultado.next()){
                 unidadDeMedida= crearObjetoUnidadDeMedida(resultado);
            }
            resultado.close();
            return unidadDeMedida;
        } catch (Exception e) {
            throw ExcepcionSQL.crearErrorConsultar();
        }
    }

    @Override
    public void ingresar(UnidadDeMedida unidadDeMedida) throws Exception {
       //int registrosafectados;
       PreparedStatement sentencia; 
       String sentenciaSQL="insert into unidaddemedida(nombreunidaddemedida, descripcionunidaddemedida) values(?,?)";
        try {
            sentencia=gestorJDBC.prepararSentencia(sentenciaSQL);
            asignarParametros(sentencia, unidadDeMedida);
            sentencia.executeUpdate(); 
            sentencia.close();
        } catch (SQLException e) {
            throw ExcepcionSQL.crearErrorInsertar();
        }
    }
    private void asignarParametros(PreparedStatement sentencia, UnidadDeMedida unidadDeMedida) throws SQLException {
        sentencia.setString(1, unidadDeMedida.getNombreUnidadDeMedida());
        sentencia.setString(2, unidadDeMedida.getDescripcionUnidadDeMedida());
    }

    @Override
    public void modificar(UnidadDeMedida unidadDeMedida) throws Exception {
        int registrosafectados; 
        PreparedStatement sentencia;
        String sentenciaSQL ="update unidaddemedida set nombreunidaddemedida= ?, descripcionunidaddemedida=? where codigounidaddemedida= ?";
        try {
            sentencia=gestorJDBC.prepararSentencia(sentenciaSQL);
            asignarParametros(sentencia, unidadDeMedida);
            sentencia.setInt(3, unidadDeMedida.getCodigoUnidadDeMedida());
            registrosafectados= sentencia.executeUpdate(); 
            sentencia.close();
            if(registrosafectados == 0){
                throw ExcepcionSQL.crearErrorModificar();
            }            
        } catch (SQLException | ExcepcionSQL e) {
           throw ExcepcionSQL.crearErrorModificar();
        }
    }

    @Override
    public void eliminar(UnidadDeMedida unidadDeMedida) throws Exception {
        int registrosafectados; 
        String sentenciaSQL ="delete from unidaddemedida where codigounidaddemedida = ?";
        PreparedStatement sentencia; 
        try {
            sentencia=gestorJDBC.prepararSentencia(sentenciaSQL); 
            sentencia.setInt(1, unidadDeMedida.getCodigoUnidadDeMedida());
            registrosafectados = sentencia.executeUpdate();
            sentencia.close();
            if(registrosafectados == 0){
                throw ExcepcionSQL.crearErrorEliminar();
            }
        } catch (SQLException | ExcepcionSQL e) {
            throw ExcepcionSQL.crearErrorEliminar();
        }
    }

    @Override
    public ArrayList<UnidadDeMedida> buscar(String descripcion) throws Exception {
        ArrayList<UnidadDeMedida> unidadesdemedida = new ArrayList();
        UnidadDeMedida unidadmedida;
        ResultSet resultado;
        if(descripcion==null)
            descripcion="";
        
        String sentenciaSQL="select codigounidaddemedida, nombreunidaddemedida, descripcionunidaddemedida\n" +
                            "from unidaddemedida where descripcionunidaddemedida like '%"+descripcion.trim().toUpperCase()+"%'";
        try {
            resultado=gestorJDBC.ejecutarConsulta(sentenciaSQL);
            while(resultado.next()){
              unidadmedida= crearObjetoUnidadDeMedida(resultado);
              unidadesdemedida.add(unidadmedida);                            
            }
            resultado.close();
            return unidadesdemedida;
        } catch (Exception e) {
              throw ExcepcionSQL.crearErrorConsultar();
        }
    }

    
    
    
}
