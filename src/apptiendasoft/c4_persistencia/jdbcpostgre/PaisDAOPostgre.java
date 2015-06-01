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
    public int crear(Pais pais) throws Exception {
        String consulta="insert into pais(nombrepais,coddepartamento) values(?,?)";
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, pais.getNombre());
        sentencia.setInt(2, pais.getDepartamento().getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Pais pais) throws Exception {
        String consulta="update pais set nombrepais=?,coddepartamento=? where codpais=?";
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, pais.getNombre());
        sentencia.setInt(2, pais.getDepartamento().getCodigo());
        sentencia.setInt(3, pais.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta="delete from pais where codpais="+codigo;
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public Pais buscar(int codigo) throws Exception {
        Pais pais=null;
        Departamento departamento;
        String consulta="select p.codpais,p.nombrepais,d.coddepartamento,d.nombredepartamento from pais p "
                + "inner join departamento d on(p.coddepartamento=d.coddepartamento)"
                + "where p.codpais="+codigo;
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
            if(resultado.next()){
                departamento = new Departamento();
                departamento.setCodigo(resultado.getInt("coddepartamento"));
                departamento.setNombre(resultado.getString("nombredepartamento"));
                pais = new Pais();
                pais.setCodigo(resultado.getInt("codpais"));
                pais.setNombre(resultado.getString("nombrepais"));
                pais.setDepartamento(departamento);
            }
        return pais;
    }

    @Override
    public ArrayList<Pais> buscarPorNombre(String nombre) throws Exception {
        if(nombre==null){
            nombre="";
        }
        Pais pais;
        Departamento departamento;
        ArrayList<Pais> listapais= new ArrayList<>();
        String consulta="select p.codigopais,p.nombrepais,d.codigodepartamento,d.nombredepartamento from pais p \n" +
                        "inner join departamento d on p.codigodepartamento=d.codigodepartamento\n" +
                        "where p.nombrepais like '%"+nombre+"%'";
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
            while(resultado.next()){
                departamento = new Departamento();
                departamento.setCodigo(resultado.getInt("codigodepartamento"));
                departamento.setNombre(resultado.getString("nombredepartamento"));
                pais = new Pais();
                pais.setCodigo(resultado.getInt("codigopais"));
                pais.setNombre(resultado.getString("nombrepais"));
                pais.setDepartamento(departamento);
                listapais.add(pais);
            }
        return listapais;
    }   
}
