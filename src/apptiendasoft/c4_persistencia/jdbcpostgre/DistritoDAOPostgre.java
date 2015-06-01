/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IDistritoDAO;
import apptiendasoft.c3_dominio.entidad.Distrito;
import apptiendasoft.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public class DistritoDAOPostgre implements IDistritoDAO{
    GestorJDBC gestorJDBC;

    public DistritoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public int crear(Distrito distrito) throws Exception {
        String consulta="insert into distrito(nombredistrito) values(?);";
        PreparedStatement sentencia= gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1,distrito.getNombre());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Distrito distrito) throws Exception {
        String consulta="update distrito set nombredistrito=? where coddistrito=?";
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, distrito.getNombre());
        sentencia.setInt(2, distrito.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta="delete from distrito where coddistrito="+codigo;
        PreparedStatement sentencia=gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }
    @Override
    public Distrito buscar(int codigo) throws Exception {
        Distrito distrito= null;
        String consulta="select nombredistrito from distrito where coddistrito="+codigo;
        ResultSet resultado=gestorJDBC.ejecutarConsulta(consulta);
            if(resultado.next()){
                distrito = new Distrito();
                distrito.setCodigo(resultado.getInt(1));
                distrito.setNombre(resultado.getString(2));
            }
        return distrito;
    }
    @Override
    public ArrayList<Distrito> buscarPorNombre(String nombre) throws Exception {
        if(nombre==null){
            nombre="";
        }
        Distrito distrito;
        ArrayList<Distrito> listadistrito= new ArrayList<>();
        String consulta="select codigodistrito,nombredistrito from distrito where nombredistrito like '%"+nombre+"%' order by codigodistrito";
        ResultSet resultado= gestorJDBC.ejecutarConsulta(consulta);
            while(resultado.next()){
                distrito = new Distrito();
                distrito.setCodigo(resultado.getInt(1));
                distrito.setNombre(resultado.getString(2));
                listadistrito.add(distrito);
            }
        return listadistrito;
    }
}
