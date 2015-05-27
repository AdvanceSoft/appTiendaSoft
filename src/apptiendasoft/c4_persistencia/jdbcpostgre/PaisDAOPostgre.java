/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IPaisDAO;
import apptiendasoft.c3_dominio.entidad.Departamento;
import apptiendasoft.c3_dominio.entidad.Pais;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c6_transversal.exepcion.ExcepcionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public class PaisDAOPostgre implements IPaisDAO{
    GestorJDBC gestorJDBC;

    public PaisDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    @Override
    public void crear(Pais pais) throws Exception {
        int registros_afectados, paisid_maximo;        
        PreparedStatement sentencia;
        ResultSet resultado;
        String sentenciaSQL1 = "insert into pais(nombrepais) values(?)";
        String sentenciaSQL2 = "select max(codigopais) as codigopais_maximo from pais";
        String sentenciaSQL3 = "update departamento set codigopais=? where codigodepartamento=?";
        try {
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL1);
            sentencia.setString(1, pais.getNombre());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if(registros_afectados == 0){
                throw ExcepcionSQL.crearErrorInsertar();
            }
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL2);
            resultado = sentencia.executeQuery();
            if(resultado.next())
                paisid_maximo = resultado.getInt("codigopais_maximo");
            else
                throw ExcepcionSQL.crearErrorInsertar();
            resultado.close();
            sentencia.close();
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL3);
            for(Departamento departamento : pais.getListaDepartamento()){
                sentencia.setInt(1, paisid_maximo);
                sentencia.setDouble(2, departamento.getCodigo());
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
    public void modificar(Pais pais) throws Exception {
        int registros_afectados;        
        PreparedStatement sentencia;
        String sentenciaSQL1 = "delete from departamento where codigopais = ?";
        String sentenciaSQL2 = "insert into departamento(codigopais, nombredepartamento) values(?,?)";
        try {
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL1);
            sentencia.setInt(1, pais.getCodigo());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if(registros_afectados == 0){
                throw ExcepcionSQL.crearErrorModificar();
            }
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL2);
            for(Departamento departamento : pais.getListaDepartamento()){
                sentencia.setInt(1, pais.getCodigo());
                sentencia.setInt(2, departamento.getCodigo());
                sentencia.setString(3, departamento.getNombre());
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
    public void eliminar(int codigo) throws Exception {
        int registros_afectados;
        PreparedStatement sentencia;
        String consulta="update departamento set codigopais=null where codigopais="+codigo;
        String consulta1="delete from pais where codigopais="+codigo;
        try{
            sentencia=gestorJDBC.prepararSentencia(consulta);
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
             if(registros_afectados == 0){
                throw ExcepcionSQL.crearErrorEliminar();
            }
            sentencia = gestorJDBC.prepararSentencia(consulta1);
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
    public Pais buscar(int codigo) throws Exception {
        Pais pais=null;
        Departamento departamento;
        String consulta="select p.codigopais,p.nombrepais,d.codigodepartamento,d.nombredepartamento from pais p "
                + "inner join departamento d on(p.codigopais=d.codigopais)"
                + "where p.codigopais="+codigo;
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
        ResultSet resultado1=gestorJDBC.ejecutarConsulta(consulta);
            if(resultado.next()){
                pais = new Pais();
                pais.setCodigo(resultado.getInt(1));
                pais.setNombre(resultado.getString(2));
            }
            while(resultado1.next()){
                departamento = new Departamento();
                departamento.setCodigo(resultado.getInt(3));
                departamento.setNombre(resultado.getString(4));
                pais.agregarDepartamentos(departamento);
            }
        return pais;
    }

    @Override
    public ArrayList<Pais> buscarPorNombre(String nombre) throws Exception {
        if(nombre==null){
            nombre="";
        }
        Pais pais;
        ArrayList<Pais> listapais= new ArrayList<>();
        String consulta="select codigopais,nombrepais from pais where nombrepais like '%"+nombre+"%' order by codigopais";
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
            while(resultado.next()){
                pais = new Pais();
                pais.setCodigo(resultado.getInt(1));
                pais.setNombre(resultado.getString(2));
                listapais.add(pais);
            }
        return listapais;
    }
    
}
