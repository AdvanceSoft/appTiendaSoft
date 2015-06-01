/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IDepartamentoDAO;
import apptiendasoft.c3_dominio.entidad.Departamento;
import apptiendasoft.c3_dominio.entidad.Provincia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public class DepartamentoDAOPostgre implements IDepartamentoDAO{
    GestorJDBCPostgre gestorJDBC;

    public DepartamentoDAOPostgre(GestorJDBCPostgre gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int crear(Departamento departamento) throws Exception {
        String consulta="insert into departamento(nombredepartamento,codprovincia) values(?,?)";
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, departamento.getNombre());
        sentencia.setInt(2, departamento.getProvincia().getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Departamento departamento) throws Exception {
        String consulta="update departamento set nombredepartamento=?,codprovincia=? where coddepartamento=?";
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, departamento.getNombre());
        sentencia.setInt(2, departamento.getProvincia().getCodigo());
        sentencia.setInt(3, departamento.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta="delete from departamento where coddepartamento="+codigo;
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public Departamento buscar(int codigo) throws Exception {
        Departamento departamento=null;
        Provincia provincia;
        String consulta="select p.coddepartamento,p.nombredepartamento,d.codprovincia,d.nombreprovincia from departamento p "
                + "inner join provincia d on(p.codprovincia=d.codprovincia)"
                + "where p.coddepartamento="+codigo;
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
            if(resultado.next()){
                provincia = new Provincia();
                provincia.setCodigo(resultado.getInt("codprovincia"));
                provincia.setNombre(resultado.getString("nombreprovincia"));
                departamento = new Departamento();
                departamento.setCodigo(resultado.getInt("coddepartamento"));
                departamento.setNombre(resultado.getString("nombredepartamento"));
                departamento.setProvincia(provincia);
            }
        return departamento;
    }

    @Override
    public ArrayList<Departamento> buscarPorNombre(String nombre) throws Exception {
        if(nombre==null){
            nombre="";
        }
        Departamento departamento;
        Provincia provincia;
        ArrayList<Departamento> listadepartamento= new ArrayList<>();
        String consulta="select p.coddepartamento,p.nombredepartamento,d.codprovincia,d.nombreprovincia from departamento p "
                + "inner join provincia d on(p.codprovincia=d.codprovincia)"
                + "where p.nombredepartamento like '%"+nombre+"%'";
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
            while(resultado.next()){
                provincia = new Provincia();
                provincia.setCodigo(resultado.getInt("codprovincia"));
                provincia.setNombre(resultado.getString("nombreprovincia"));
                departamento = new Departamento();
                departamento.setCodigo(resultado.getInt("coddepartamento"));
                departamento.setNombre(resultado.getString("nombredepartamento"));
                departamento.setProvincia(provincia);
                listadepartamento.add(departamento);
            }
        return listadepartamento;
    }
}
