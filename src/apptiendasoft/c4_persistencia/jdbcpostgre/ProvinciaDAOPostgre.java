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
 *
 * @author sandra
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
        String sentenciaSQL2 = "select max(provinciaid) as provinciaid_maximo from provincia";
        String sentenciaSQL3 = "update distrito set provinciaid=? where distritoid=?";
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
                provinciaid_maximo = resultado.getInt("provinciaid_maximo");
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
        String sentenciaSQL1 = "delete from distrito where provinciaid = ?";
        String sentenciaSQL2 = "insert into distrito(provinciaid, nombredistrito) values(?,?)";
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
                sentencia.setInt(2, distrito.getCodigo());
                sentencia.setString(3, distrito.getNombre());
                registros_afectados = sentencia.executeUpdate();
                if(registros_afectados == 0){
                    throw ExcepcionSQL.crearErrorModificar();
                }
            }
            sentencia.close();
        } 
        catch (ExcepcionSQL er) {
            throw er;
        }
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta="delete from provincia where provinciaid="+codigo;
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public Provincia buscar(int codigo) throws Exception {
        Provincia provincia=null;
        Distrito distrito;
        String consulta="select p.provinciaid,p.nombreprovincia,d.distritoid,d.nombredistrito from provincia p "
                + "inner join distrito d on(p.provinciaid=d.provinciaid)"
                + "where p.provinciaid="+codigo;
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
            if(resultado.next()){
                provincia = new Provincia();
                provincia.setCodigo(resultado.getInt("idprovincia"));
                provincia.setNombre(resultado.getString("nombreprovincia"));
            }
            ResultSet resultado1=gestorJDBC.ejecutarConsulta(consulta);
            while(resultado1.next()){
                distrito = new Distrito();
                distrito.setCodigo(resultado.getInt("iddistrito"));
                distrito.setNombre(resultado.getString("nombredistrito"));
               provincia.agregarDistrito(distrito);
            }
        return provincia;
    }

    @Override
    public ArrayList<Provincia> buscarPorNombre(String nombre) throws Exception {
        if(nombre==null){
            nombre="";
        }
        Provincia provincia;
        ArrayList<Provincia> listaprovincia= new ArrayList();
        String consulta="select provinciaid,nombreprovincia from provincia where nombreprovincia like '%"+nombre+"%' and departamentoid is null order by provinciaid";
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
            while(resultado.next()){
                provincia = new Provincia();
                provincia.setCodigo(resultado.getInt("provinciaid"));
                provincia.setNombre(resultado.getString("nombreprovincia"));
                listaprovincia.add(provincia);
            }
        return listaprovincia;
    }
    
}
