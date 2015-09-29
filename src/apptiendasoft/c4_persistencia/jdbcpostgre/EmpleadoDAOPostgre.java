/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IEmpleadoDAO;
import apptiendasoft.c3_dominio.entidad.Cargo;
import apptiendasoft.c3_dominio.entidad.Departamento;
import apptiendasoft.c3_dominio.entidad.Distrito;
import apptiendasoft.c3_dominio.entidad.Empleado;
import apptiendasoft.c3_dominio.entidad.Pais;
import apptiendasoft.c3_dominio.entidad.Provincia;
import apptiendasoft.c3_dominio.entidad.Usuario;
import apptiendasoft.c4_persistencia.GestorJDBC;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class EmpleadoDAOPostgre implements IEmpleadoDAO{
    GestorJDBC gestorJDBC;
    
    public EmpleadoDAOPostgre(GestorJDBC gestorJDBC){
        this.gestorJDBC = gestorJDBC;
    }
    @Override
    public int crear(Empleado empleado) throws Exception {
        String consulta = "INSERT INTO empleado(codigousuario, codigocargo, nombreempleado, apellidoempleado, dniempleado, generocliente, direccionempleado, correoempleado,  telefonoempleado, celularempleado, estadoempleado, fechaingresoempleado,  fechasalidaempleado, sueldoempleado) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, empleado.getUsuario().getCodigo());
        sentencia.setInt(2, empleado.getCargo().getCodigo());
        sentencia.setString(3, empleado.getNombre());
        sentencia.setString(4, empleado.getApellido());
        sentencia.setString(5, empleado.getDni());
        sentencia.setString(6, empleado.getGenero());
        sentencia.setString(7, empleado.getDireccion());
        sentencia.setString(8, empleado.getCorreo());
        sentencia.setString(9, empleado.getTelefono());
        sentencia.setString(10, empleado.getCelular());
        sentencia.setBoolean(11, empleado.isActivo());
        sentencia.setDate(12, (Date) empleado.getFechaIngreso());
        sentencia.setDate(13, (Date) empleado.getFechaSalida());
        sentencia.setDouble(14, empleado.getSueldo());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Empleado empleado) throws Exception {
   String consulta = "UPDATE empleado SET codigousuario=?, codigocargo=?, nombreempleado=?, apellidoempleado=?, dniempleado=?, generocliente=?, direccionempleado=?, correoempleado=?, telefonoempleado=?, celularempleado=?, estadoempleado=?,fechaingresoempleado=?, fechasalidaempleado=?, sueldoempleado=? WHERE codigoempleado=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, empleado.getUsuario().getCodigo());
        sentencia.setInt(2, empleado.getCargo().getCodigo());
        sentencia.setString(3, empleado.getNombre());
        sentencia.setString(4, empleado.getApellido());
        sentencia.setString(5, empleado.getDni());
        sentencia.setString(6, empleado.getGenero());
        sentencia.setString(7, empleado.getDireccion());
        sentencia.setString(8, empleado.getCorreo());
        sentencia.setString(9, empleado.getTelefono());
        sentencia.setString(10, empleado.getCelular());
        sentencia.setBoolean(11, empleado.isActivo());
        sentencia.setDate(12, (Date) empleado.getFechaIngreso());
        sentencia.setDate(13, (Date) empleado.getFechaSalida());
        sentencia.setDouble(14, empleado.getSueldo());
        sentencia.setInt(15, empleado.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta = "delete from empleado where codigoempleado="+codigo;
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public Empleado buscar(int codigo) throws Exception {
        Empleado empleado= null;
        Distrito distrito;
        Pais pais;
        Departamento departamento;
        Provincia provincia;
        Usuario usuario;
        Cargo cargo;
        String consulta = "SELECT e.codigoempleado,u.codigousuario, nombreusuario, c.codigocargo,c.nombrecargo, e.nombreempleado, e.apellidoempleado, e.dniempleado, e.generocliente, e.direccionempleado, e.correoempleado, e.telefonoempleado, e.celularempleado, e.estadoempleado, e.fechaingresoempleado,  e.fechasalidaempleado, e.sueldoempleado FROM empleado e inner join pais usuario u on e.codigousuario=u.codigousuario inner join cargo c on e.codigocargo= c.codigocargo where codigoempleado="+codigo;
        ResultSet resultado= gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            empleado = new Empleado();
            empleado.setCodigo(resultado.getInt(1));
            usuario = new Usuario();
            usuario.setCodigo(resultado.getInt(2));
            usuario.setNombre(resultado.getString(3));
            cargo = new Cargo();
            cargo.setCodigo(resultado.getInt(4));
            cargo.setNombre(resultado.getString(5));
            empleado.setUsuario(usuario);
            empleado.setCargo(cargo);
            empleado.setNombre(resultado.getString(6));
            empleado.setApellido(resultado.getString(7));
            empleado.setDni(resultado.getString(8));
            empleado.setGenero(resultado.getString(9));
            empleado.setDireccion(resultado.getString(10));
            empleado.setCorreo(resultado.getString(11));
            empleado.setTelefono(resultado.getString(12));
            empleado.setCelular(resultado.getString(13));
            empleado.setActivo(resultado.getBoolean(14));
            empleado.setFechaIngreso(resultado.getDate(15));
            empleado.setFechaSalida(resultado.getDate(16));
            empleado.setSueldo(resultado.getDouble(17));
        }
        return empleado;
    }

    @Override
    public ArrayList<Empleado> buscarPorNOmbre(String nombre) throws Exception {
        if(nombre==null){
            nombre="";
        }
        Empleado empleado= null;
        Distrito distrito;
        Pais pais;
        Departamento departamento;
        Provincia provincia;
        Usuario usuario;
        Cargo cargo;
        ArrayList<Empleado> listaEmplado = new ArrayList<>();
        String consulta = "SELECT e.codigoempleado, u.codigousuario, nombreusuario, c.codigocargo,c.nombrecargo, e.nombreempleado, e.apellidoempleado, e.dniempleado, e.generocliente, e.direccionempleado, e.correoempleado, e.telefonoempleado, e.celularempleado, e.estadoempleado, e.fechaingresoempleado,  e.fechasalidaempleado, e.sueldoempleado FROM empleado e inner join cargo c on e.codigocargo= c.codigocargo where e.nombreempleado like '%"+nombre+"%' order by e.codigoempleado desc";
        ResultSet resultado= gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            empleado = new Empleado();
            empleado.setCodigo(resultado.getInt(1));
            usuario = new Usuario();
            usuario.setCodigo(resultado.getInt(2));
            usuario.setNombre(resultado.getString(3));
            cargo = new Cargo();
            cargo.setCodigo(resultado.getInt(4));
            cargo.setNombre(resultado.getString(5));
            empleado.setUsuario(usuario);
            empleado.setCargo(cargo);
            empleado.setNombre(resultado.getString(6));
            empleado.setApellido(resultado.getString(7));
            empleado.setDni(resultado.getString(8));
            empleado.setGenero(resultado.getString(9));
            empleado.setDireccion(resultado.getString(10));
            empleado.setCorreo(resultado.getString(11));
            empleado.setTelefono(resultado.getString(12));
            empleado.setCelular(resultado.getString(13));
            empleado.setActivo(resultado.getBoolean(14));
            empleado.setFechaIngreso(resultado.getDate(15));
            empleado.setFechaSalida(resultado.getDate(16));
            empleado.setSueldo(resultado.getDouble(17));
            listaEmplado.add(empleado);
        }
        return listaEmplado;        
    }
    
}
