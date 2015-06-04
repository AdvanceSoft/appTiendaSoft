/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IDepartamentoDAO;
import apptiendasoft.c3_dominio.entidad.Departamento;
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
public class DepartamentoDAOPostgre implements IDepartamentoDAO{
    GestorJDBC gestorJDBC;

    public DepartamentoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public void crear(Departamento departamento) throws Exception {
        int registros_afectados, departamentoid_maximo;        
        PreparedStatement sentencia;
        ResultSet resultado;
        String sentenciaSQL1 = "insert into departamento(nombredepartamento) values(?)";
        String sentenciaSQL2 = "select max(codigodepartamento) as codigodepartamento_maximo from departamento";
        String sentenciaSQL3 = "update provincia set codigodepartamento=? where codigoprovincia=?";
        try {
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL1);
            sentencia.setString(1, departamento.getNombre());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if(registros_afectados == 0){
                throw ExcepcionSQL.crearErrorInsertar();
            }
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL2);
            resultado = sentencia.executeQuery();
            if(resultado.next())
                departamentoid_maximo = resultado.getInt("codigodepartamento_maximo");
            else
                throw ExcepcionSQL.crearErrorInsertar();
            resultado.close();
            sentencia.close();
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL3);
            for(Provincia provincia : departamento.getListaProvincia()){
                sentencia.setInt(1, departamentoid_maximo);
                sentencia.setDouble(2, provincia.getCodigo());
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
    public void modificar(Departamento departamento) throws Exception {
        int registros_afectados;        
        PreparedStatement sentencia;
        String sentenciaSQL1 = "delete from provincia where codigodepartamento = ?";
        String sentenciaSQL2 = "insert into provincia(codigodepartamento, nombreprovincia) values(?,?)";
        try {
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL1);
            sentencia.setInt(1, departamento.getCodigo());
            registros_afectados = sentencia.executeUpdate();
            sentencia.close();
            if(registros_afectados == 0){
                throw ExcepcionSQL.crearErrorModificar();
            }
            sentencia = gestorJDBC.prepararSentencia(sentenciaSQL2);
            for(Provincia provincia : departamento.getListaProvincia()){
                sentencia.setInt(1, departamento.getCodigo());
                sentencia.setInt(2, provincia.getCodigo());
                sentencia.setString(3, provincia.getNombre());
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
    public void eliminar(int codigo) throws Exception {
        int registros_afectados;
        PreparedStatement sentencia;
        String consulta="update provincia set codigodepartamento=null where codigodepartamento="+codigo;
        String consulta1="delete from departamento where codigodepartamento="+codigo;
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
    public Departamento buscar(int codigo) throws Exception {
        Departamento departamento=null;
        Provincia provincia;
        String consulta="select p.codigodepartamento,p.nombredepartamento,d.codigoprovincia,d.nombreprovincia from departamento p "
                + "inner join provincia d on(p.codigodepartamento=d.codigodepartamento)"
                + "where p.codigodepartamento="+codigo;
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
        ResultSet resultado1=gestorJDBC.ejecutarConsulta(consulta);
            if(resultado.next()){
                departamento = new Departamento();
                departamento.setCodigo(resultado.getInt(1));
                departamento.setNombre(resultado.getString(2));
            }
            while(resultado1.next()){
                provincia = new Provincia();
                provincia.setCodigo(resultado.getInt(3));
                provincia.setNombre(resultado.getString(4));
                departamento.agregarProvincias(provincia);
            }
        return departamento;
    }

    @Override
    public ArrayList<Departamento> buscarPorNombre(String nombre) throws Exception {
        if(nombre==null){
            nombre="";
        }
        Departamento departamento;
        ArrayList<Departamento> listadepartamento= new ArrayList<>();
        String consulta="select codigodepartamento,nombredepartamento from departamento where nombredepartamento like '%"+nombre+"%' and codigopais is null order by codigodepartamento";
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
            while(resultado.next()){
                departamento = new Departamento();
                departamento.setCodigo(resultado.getInt(1));
                departamento.setNombre(resultado.getString(2));
                listadepartamento.add(departamento);
            }
        return listadepartamento;
    }
}
