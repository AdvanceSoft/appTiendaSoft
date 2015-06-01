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
        String consulta = "INSERT INTO empleado(codigodistrito, codigoprovincia, codigodepartamento, codigopais, codigousuario, codigocargo, nombreempleado, apellidoempleado, dniempleado, generocliente, direccionempleado, correoempleado,  telefonoempleado, celularempleado, estadoempleado, fechaingresoempleado,  fechasalidaempleado, sueldoempleado)\n" +
                        "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, empleado.getDistrito().getCodigo());
        sentencia.setInt(2, empleado.getProvincia().getCodigo());
        sentencia.setInt(3, empleado.getDepartamento().getCodigo());
        sentencia.setInt(4, empleado.getPais().getCodigo());
        sentencia.setInt(5, empleado.getUsuario().getCodigo());
        sentencia.setInt(6, empleado.getCargo().getCodigo());
        sentencia.setString(7, empleado.getNombre());
        sentencia.setString(8, empleado.getApellido());
        sentencia.setString(9, empleado.getDni());
        sentencia.setString(10, empleado.getGenero());
        sentencia.setString(11, empleado.getDireccion());
        sentencia.setString(12, empleado.getCorreo());
        sentencia.setString(13, empleado.getTelefono());
        sentencia.setString(14, empleado.getCelular());
        sentencia.setBoolean(15, empleado.isActivo());
        sentencia.setDate(16, (Date) empleado.getFechaIngreso());
        sentencia.setDate(17, (Date) empleado.getFechaSalida());
        sentencia.setDouble(18, empleado.getSueldo());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Empleado empleado) throws Exception {
   String consulta = "UPDATE empleado SET codigodistrito=?, codigoprovincia=?, codigodepartamento=?, codigopais=?, codigousuario=?, codigocargo=?, nombreempleado=?, apellidoempleado=?, dniempleado=?, generocliente=?, direccionempleado=?, correoempleado=?, telefonoempleado=?, celularempleado=?, estadoempleado=?, \n" +
                "fechaingresoempleado=?, fechasalidaempleado=?, sueldoempleado=? WHERE codigoempleado=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, empleado.getDistrito().getCodigo());
        sentencia.setInt(2, empleado.getProvincia().getCodigo());
        sentencia.setInt(3, empleado.getDepartamento().getCodigo());
        sentencia.setInt(4, empleado.getPais().getCodigo());
        sentencia.setInt(5, empleado.getUsuario().getCodigo());
        sentencia.setInt(6, empleado.getCargo().getCodigo());
        sentencia.setString(7, empleado.getNombre());
        sentencia.setString(8, empleado.getApellido());
        sentencia.setString(9, empleado.getDni());
        sentencia.setString(10, empleado.getGenero());
        sentencia.setString(11, empleado.getDireccion());
        sentencia.setString(12, empleado.getCorreo());
        sentencia.setString(13, empleado.getTelefono());
        sentencia.setString(14, empleado.getCelular());
        sentencia.setBoolean(15, empleado.isActivo());
        sentencia.setDate(16, (Date) empleado.getFechaIngreso());
        sentencia.setDate(17, (Date) empleado.getFechaSalida());
        sentencia.setDouble(18, empleado.getSueldo());
        sentencia.setInt(19, empleado.getCodigo());
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
        String consulta = "SELECT e.codigoempleado,d.codigodistrito,d.nombredistrito, p.codigoprovincia,p.nombreprovincia, de.codigodepartamento,de.nombredepartamento, pa.codigopais,pa.nombrepais, u.codigousuario, nombreusuario, c.codigocargo,c.nombrecargo, e.nombreempleado, e.apellidoempleado, e.dniempleado, e.generocliente, e.direccionempleado, e.correoempleado, e.telefonoempleado, e.celularempleado, e.estadoempleado, e.fechaingresoempleado,  e.fechasalidaempleado, e.sueldoempleado\n" +
                        " FROM empleado e inner join pais pa on e.codigopais=pa.codigopais inner join departamento de on e.codigodepartamento=de.codigodepartamento inner join provincia p on e.codigoprovincia=p.codigoprovincia inner join distrito d on e.codigodistrito=p.codigoprovincia inner join usuario u on e.codigousuario=u.codigousuario inner join cargo c on e.codigocargo= c.codigocargo where codigoempleado="+codigo;
        ResultSet resultado= gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            empleado = new Empleado();
            empleado.setCodigo(resultado.getInt(1));
            distrito = new Distrito();
            distrito.setCodigo(resultado.getInt(2));
            distrito.setNombre(resultado.getString(3));
            provincia = new Provincia();
            provincia.setCodigo(resultado.getInt(4));
            provincia.setNombre(resultado.getString(5));
            departamento = new Departamento();
            departamento.setCodigo(resultado.getInt(6));
            departamento.setNombre(resultado.getString(7));
            pais = new Pais();
            pais.setCodigo(resultado.getInt(8));
            pais.setNombre(resultado.getString(9));
            usuario = new Usuario();
            usuario.setCodigo(resultado.getInt(10));
            usuario.setNombre(resultado.getString(11));
            cargo = new Cargo();
            cargo.setCodigo(resultado.getInt(12));
            cargo.setNombre(resultado.getString(13));
            empleado.setDistrito(distrito);
            empleado.setProvincia(provincia);
            empleado.setDepartamento(departamento);
            empleado.setPais(pais);
            empleado.setUsuario(usuario);
            empleado.setCargo(cargo);
            empleado.setNombre(resultado.getString(14));
            empleado.setApellido(resultado.getString(15));
            empleado.setDni(resultado.getString(16));
            empleado.setGenero(resultado.getString(17));
            empleado.setDireccion(resultado.getString(18));
            empleado.setCorreo(resultado.getString(19));
            empleado.setTelefono(resultado.getString(20));
            empleado.setCelular(resultado.getString(21));
            empleado.setActivo(resultado.getBoolean(22));
            empleado.setFechaIngreso(resultado.getDate(23));
            empleado.setFechaSalida(resultado.getDate(24));
            empleado.setSueldo(resultado.getDouble(25));
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
        String consulta = "SELECT e.codigoempleado,d.codigodistrito,d.nombredistrito, p.codigoprovincia,p.nombreprovincia, de.codigodepartamento,de.nombredepartamento, pa.codigopais,pa.nombrepais, u.codigousuario, nombreusuario, c.codigocargo,c.nombrecargo, e.nombreempleado, e.apellidoempleado, e.dniempleado, e.generocliente, e.direccionempleado, e.correoempleado, e.telefonoempleado, e.celularempleado, e.estadoempleado, e.fechaingresoempleado,  e.fechasalidaempleado, e.sueldoempleado\n" +
                        " FROM empleado e inner join pais pa on e.codigopais=pa.codigopais inner join departamento de on e.codigodepartamento=de.codigodepartamento inner join provincia p on e.codigoprovincia=p.codigoprovincia inner join distrito d on e.codigodistrito=p.codigoprovincia inner join usuario u on e.codigousuario=u.codigousuario inner join cargo c on e.codigocargo= c.codigocargo where e.nombreempleado like '%"+nombre+"%' order by e.codigoempleado desc";
        ResultSet resultado= gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            empleado = new Empleado();
            empleado.setCodigo(resultado.getInt(1));
            distrito = new Distrito();
            distrito.setCodigo(resultado.getInt(2));
            distrito.setNombre(resultado.getString(3));
            provincia = new Provincia();
            provincia.setCodigo(resultado.getInt(4));
            provincia.setNombre(resultado.getString(5));
            departamento = new Departamento();
            departamento.setCodigo(resultado.getInt(6));
            departamento.setNombre(resultado.getString(7));
            pais = new Pais();
            pais.setCodigo(resultado.getInt(8));
            pais.setNombre(resultado.getString(9));
            usuario = new Usuario();
            usuario.setCodigo(resultado.getInt(10));
            usuario.setNombre(resultado.getString(11));
            cargo = new Cargo();
            cargo.setCodigo(resultado.getInt(12));
            cargo.setNombre(resultado.getString(13));
            empleado.setDistrito(distrito);
            empleado.setProvincia(provincia);
            empleado.setDepartamento(departamento);
            empleado.setPais(pais);
            empleado.setUsuario(usuario);
            empleado.setCargo(cargo);
            empleado.setNombre(resultado.getString(14));
            empleado.setApellido(resultado.getString(15));
            empleado.setDni(resultado.getString(16));
            empleado.setGenero(resultado.getString(17));
            empleado.setDireccion(resultado.getString(18));
            empleado.setCorreo(resultado.getString(19));
            empleado.setTelefono(resultado.getString(20));
            empleado.setCelular(resultado.getString(21));
            empleado.setActivo(resultado.getBoolean(22));
            empleado.setFechaIngreso(resultado.getDate(23));
            empleado.setFechaSalida(resultado.getDate(24));
            empleado.setSueldo(resultado.getDouble(25));
            listaEmplado.add(empleado);
        }
        return listaEmplado;        
    }
    
}
