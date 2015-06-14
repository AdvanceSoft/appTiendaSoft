/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IProvinciaDAO;
import apptiendasoft.c3_dominio.entidad.Distrito;
import apptiendasoft.c3_dominio.entidad.Provincia;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c6_transversal.exepcion.ExcepcionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 */
public class ProvinciaDAOPostgre implements IProvinciaDAO{
    GestorJDBC gestorJDBC;

    public ProvinciaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    /**
     *
     * @param provincia
     * @throws Exception
     */
    @Override
    public void crear(Provincia provincia) throws Exception {
        int registros_afectados, provinciaid_maximo;        
        PreparedStatement sentencia;
        ResultSet resultado;
        String sentenciaSQL1 = "insert into provincia(nombreprovincia) values(?)";
        String sentenciaSQL2 = "select max(codigoprovincia) as codigoprovincia_maximo from provincia";
        String sentenciaSQL3 = "update distrito set codigoprovincia=? where codigodistrito=?";
        try {
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL1);
            sentencia.setString(1, provincia.getNombre());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if(registros_afectados == 0){
                throw ExcepcionSQL.crearErrorInsertar();
            }
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL2);
            resultado = sentencia.executeQuery();
            if(resultado.next())
                provinciaid_maximo = resultado.getInt("codigoprovincia_maximo");
            else
                throw ExcepcionSQL.crearErrorInsertar();
            resultado.close();
            sentencia.close();
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL3);
            for(Distrito distrito : provincia.getListadistrito()){
                sentencia.setInt(1, provinciaid_maximo);
                sentencia.setDouble(2, distrito.getCodigo());
                registros_afectados = sentencia.executeUpdate();
                if(registros_afectados == 0){
                    throw ExcepcionSQL.crearErrorInsertar();
                }
            }
            sentencia.close();      
        } 
        catch (Exception e) {
            throw ExcepcionSQL.crearErrorInsertar();
        }
       
    }

    @Override
    public void modificar(Provincia provincia) throws Exception {
        int registros_afectados;        
        PreparedStatement sentencia;
        String sentenciaSQL1 = "delete from distrito where codigoprovincia= ?";
        String sentenciaSQL2 = "insert into distrito(codigoprovincia ,nombredistrito) values(?,?)";
        try {
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL1);
            sentencia.setInt(1, provincia.getCodigo());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if(registros_afectados == 0){
                throw ExcepcionSQL.crearErrorModificar();
            }
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL2);
            for(Distrito distrito : provincia.getListadistrito()){
                sentencia.setInt(1, provincia.getCodigo());
                sentencia.setString(2, distrito.getNombre());
                registros_afectados = sentencia.executeUpdate();
                if(registros_afectados == 0){
                    throw ExcepcionSQL.crearErrorModificar();
                }
            }
            sentencia.close();
        } 
        catch (ExcepcionSQL er) {
            throw ExcepcionSQL.crearErrorModificar();
        }
    }

    @Override
    public void eliminar(Provincia provincia) throws Exception {
        int registros_afectados;
        PreparedStatement sentencia;
        String consulta="update distrito set codigoprovincia=null where codigoprovincia=?";
        String consulta1="delete from provincia where codigoprovincia=?";
        try{
            sentencia=gestorJDBC.prepararSentencia(consulta);
            sentencia.setInt(1, provincia.getCodigo());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
             if(registros_afectados == 0){
                throw ExcepcionSQL.crearErrorEliminar();
            }
            sentencia = gestorJDBC.prepararSentencia(consulta1);
            sentencia.setInt(1, provincia.getCodigo());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if(registros_afectados == 0){
                    throw ExcepcionSQL.crearErrorModificar();
                }
            sentencia.close();
        }catch(ExcepcionSQL e){
            throw ExcepcionSQL.crearErrorEliminar();
        }
    }

    @Override
    public Provincia buscar(int codigo) throws Exception {
        Provincia provincia=null;
        Distrito distrito;
        String consulta="select p.codigoprovincia,p.nombreprovincia,d.codigodistrito,d.nombredistrito from provincia p "
                + "inner join distrito d on(p.codigoprovincia=d.codigoprovincia)"
                + "where p.codigoprovincia="+codigo;
        ResultSet resultado;
        try{
            resultado=gestorJDBC.ejecutarConsulta(consulta);
                if(resultado.next()){
                    provincia = new Provincia();
                    provincia.setCodigo(resultado.getInt(1));
                    provincia.setNombre(resultado.getString(2));
                }
            resultado.close();
            resultado=gestorJDBC.ejecutarConsulta(consulta);
                while(resultado.next()){
                    distrito = new Distrito();
                    distrito.setCodigo(resultado.getInt(3));
                    distrito.setNombre(resultado.getString(4));
                    provincia.agregarDistrito(distrito);
                }
        }catch(Exception e){
            throw ExcepcionSQL.crearErrorConsultar();
        }
        return provincia;
    }

    @Override
    public ArrayList<Provincia> buscarPorNombre(String nombre) throws Exception {
        Provincia provincia;
        ArrayList<Provincia> listaprovincia= new ArrayList();
        String consulta="select codigoprovincia,nombreprovincia from provincia where nombreprovincia like '%"+nombre+"%' and codigodepartamento is null order by codigoprovincia";
        try{
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
            while(resultado.next()){
                provincia = new Provincia();
                provincia.setCodigo(resultado.getInt(1));
                provincia.setNombre(resultado.getString(2));
                listaprovincia.add(provincia);
            }
        }catch(Exception e){
            throw ExcepcionSQL.crearErrorConsultar();
        }
        return listaprovincia;
    }
}
