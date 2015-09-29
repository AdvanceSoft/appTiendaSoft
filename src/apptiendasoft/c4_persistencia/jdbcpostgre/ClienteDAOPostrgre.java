/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IClienteDAO;
import apptiendasoft.c3_dominio.entidad.Cliente;
import apptiendasoft.c3_dominio.entidad.Departamento;
import apptiendasoft.c3_dominio.entidad.Distrito;
import apptiendasoft.c3_dominio.entidad.Pais;
import apptiendasoft.c3_dominio.entidad.Provincia;
import apptiendasoft.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class ClienteDAOPostrgre implements IClienteDAO{
    GestorJDBC gestorJDBC;
    
    public ClienteDAOPostrgre(GestorJDBC gestorJDBC){
        this.gestorJDBC = gestorJDBC;
    }
    @Override
    public int crear(Cliente cliente) throws Exception {
        String consulta = "INSERT INTO cliente( nombrecliente, apellidocliente, dnicliente, generocliente, direccioncliente, correocliente, telefonocliente, celularcliente, estadocliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1,cliente.getNombre());
        sentencia.setString(2, cliente.getApellido());
        sentencia.setString(3, cliente.getDni());
        sentencia.setString(4,cliente.getGenero());
        sentencia.setString(5, cliente.getDireccion());
        sentencia.setString(6, cliente.getCorreo());
        sentencia.setString(7, cliente.getTelefono());
        sentencia.setString(8, cliente.getCelular());
        sentencia.setBoolean(9, cliente.isActivo());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Cliente cliente) throws Exception {
        String consulta = "UPDATE cliente SET nombrecliente=?, apellidocliente=?, dnicliente=?, generocliente=?, direccioncliente=?, correocliente=?, telefonocliente=? celularcliente=?, estadocliente=? WHERE codigocliente=?;";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, cliente.getNombre());
        sentencia.setString(2, cliente.getApellido());
        sentencia.setString(3, cliente.getDni());
        sentencia.setString(4, cliente.getGenero());
        sentencia.setString(5, cliente.getDireccion());
        sentencia.setString(6, cliente.getCorreo());
        sentencia.setString(7, cliente.getTelefono());
        sentencia.setString(8, cliente.getCelular());
        sentencia.setBoolean(9, cliente.isActivo());
        sentencia.setInt(10, cliente.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta = "delete from cliente where codigocliente="+codigo;
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public Cliente buscar(int codigo) throws Exception {
        Cliente cliente= null;
        Distrito distrito;
        Pais pais;
        Departamento departamento;
        Provincia provincia;
        String consulta = "SELECT codigocliente,nombrecliente,apellidocliente,dnicliente,generocliente,direccioncliente,correocliente,telefonocliente,celularcliente,estadocliente FROM cliente where codigocliente="+codigo;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            cliente = new Cliente();
            cliente.setCodigo(resultado.getInt(1)); 
            cliente.setNombre(resultado.getString(2));
            cliente.setApellido(resultado.getString(3));
            cliente.setDni(resultado.getString(4));
            cliente.setGenero(resultado.getString(5));
            cliente.setDireccion(resultado.getString(6));
            cliente.setCorreo(resultado.getString(7));
            cliente.setTelefono(resultado.getString(8));
            cliente.setCelular(resultado.getString(9));
            cliente.setActivo(resultado.getBoolean(10));
        }
        return cliente;
    }

    @Override
    public ArrayList<Cliente> buscarPorNombre(String nombre) throws Exception {
        if(nombre == null){
            nombre="";
        }
        Cliente cliente= null;
        Distrito distrito;
        Pais pais;
        Departamento departamento;
        Provincia provincia;
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        String consulta = "SELECT codigocliente,nombrecliente,apellidocliente,dnicliente,generocliente,direccioncliente,correocliente,telefonocliente,celularcliente,estadocliente FROM cliente where nombrecliente like '%"+nombre+"%' order by codigocliente desc";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            cliente = new Cliente();
            cliente.setCodigo(resultado.getInt(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setApellido(resultado.getString(3));
            cliente.setDni(resultado.getString(4));
            cliente.setGenero(resultado.getString(5));
            cliente.setDireccion(resultado.getString(6));
            cliente.setCorreo(resultado.getString(7));
            cliente.setTelefono(resultado.getString(8));
            cliente.setCelular(resultado.getString(9));
            cliente.setActivo(resultado.getBoolean(10));
            listaCliente.add(cliente);
        }
        return listaCliente;
    }    
}
