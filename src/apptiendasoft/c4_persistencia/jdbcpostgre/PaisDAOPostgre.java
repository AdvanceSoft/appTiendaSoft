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
        String sentenciaSQL2 = "select max(paisid) as paisid_maximo from pais";
        String sentenciaSQL3 = "update departamento set paisid=? where departamentoid=?";
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
                paisid_maximo = resultado.getInt("paisid_maximo");
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

    @Override //reviar
    public void modificar(Pais pais) throws Exception {
        int registros_afectados;        
        PreparedStatement sentencia;
        String sentenciaSQL1 = "delete from departamento where paisid = ?";
        String sentenciaSQL2 = "insert into departamento(paisid, nombredepartamento) values(?,?)";
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
    public int eliminar(int codigo) throws Exception {
        String consulta="delete from pais where paisid="+codigo;
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public Pais buscar(int codigo) throws Exception {
        Pais pais=null;
        Departamento departamento;
        String consulta="select p.paisid,p.nombrepais,d.departamentoid,d.nombredepartamento from pais p "
                + "inner join departamento d on(p.paisid=d.paisid)"
                + "where p.paisid="+codigo;
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
        ResultSet resultado1=gestorJDBC.ejecutarConsulta(consulta);
            if(resultado.next()){
                pais = new Pais();
                pais.setCodigo(resultado.getInt("codpais"));
                pais.setNombre(resultado.getString("nombrepais"));
            }
            while(resultado1.next()){
                departamento = new Departamento();
                departamento.setCodigo(resultado.getInt("coddepartamento"));
                departamento.setNombre(resultado.getString("nombredepartamento"));
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
        String consulta="select paisid,nombrepais from pais where nombrepais like '%"+nombre+"%' order by paisid";
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
            while(resultado.next()){
                pais = new Pais();
                pais.setCodigo(resultado.getInt("paisid"));
                pais.setNombre(resultado.getString("nombrepais"));
                listapais.add(pais);
            }
        return listapais;
    }
    
}
