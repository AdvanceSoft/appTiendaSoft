/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IProvinciaDAO;
import apptiendasoft.c3_dominio.entidad.Distrito;
import apptiendasoft.c3_dominio.entidad.Provincia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public class ProvinciaDAOPostgre implements IProvinciaDAO{
    GestorJDBCPostgre gestorJDBC;

    public ProvinciaDAOPostgre(GestorJDBCPostgre gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int crear(Provincia provincia) throws Exception {
        String consulta="insert into provincia(nombreprovincia,coddistrito) values(?,?)";
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, provincia.getNombre());
        sentencia.setInt(2, provincia.getDistrito().getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Provincia provincia) throws Exception {
        String consulta="update provincia set nombreprovincia=?,coddistrito=? where codprovincia=?";
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, provincia.getNombre());
        sentencia.setInt(2, provincia.getDistrito().getCodigo());
        sentencia.setInt(3, provincia.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta="delete from provincia where codprovincia="+codigo;
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public Provincia buscar(int codigo) throws Exception {
        Provincia provincia=null;
        Distrito distrito;
        String consulta="select p.codprovincia,p.nombreprovincia,d.coddistrito,d.nombredistrito from provincia p "
                + "inner join distrito d on(p.coddistrito=d.coddistrito)"
                + "where p.codprovincia="+codigo;
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
            if(resultado.next()){
                distrito = new Distrito();
                distrito.setCodigo(resultado.getInt("coddistrito"));
                distrito.setNombre(resultado.getString("nombredistrito"));
                provincia = new Provincia();
                provincia.setCodigo(resultado.getInt("codprovincia"));
                provincia.setNombre(resultado.getString("nombreprovincia"));
                provincia.setDistrito(distrito);
            }
        return provincia;
    }

    @Override
    public ArrayList<Provincia> buscarPorNombre(String nombre) throws Exception {
        if(nombre==null){
            nombre="";
        }
        Provincia provincia;
        Distrito distrito;
        ArrayList<Provincia> listaprovincia= new ArrayList<>();
        String consulta="select p.codprovincia,p.nombreprovincia,d.coddistrito,d.nombredistrito from provincia p "
                + "inner join distrito d on(p.coddistrito=d.coddistrito)"
                + "where p.nombreprovincia like '%"+nombre+"%'";
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
            while(resultado.next()){
                distrito = new Distrito();
                distrito.setCodigo(resultado.getInt("coddistrito"));
                distrito.setNombre(resultado.getString("nombredistrito"));
                provincia = new Provincia();
                provincia.setCodigo(resultado.getInt("codprovincia"));
                provincia.setNombre(resultado.getString("nombreprovincia"));
                provincia.setDistrito(distrito);
                listaprovincia.add(provincia);
            }
        return listaprovincia;
    }
}
