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
        String consulta = "INSERT INTO cliente( codigodistrito, codigoprovincia, codigodepartamento, codigopais, nombrecliente, apellidocliente, dnicliente, generocliente, direccioncliente, correocliente, telefonocliente, celularcliente, estadocliente)\n" +
                            "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, cliente.getDistrito().getCodigo());
        sentencia.setInt(2, cliente.getProvincia().getCodigo());
        sentencia.setInt(3, cliente.getDepartamento().getCodigo());
        sentencia.setInt(4, cliente.getPais().getCodigo());
        sentencia.setString(5,cliente.getNombre());
        sentencia.setString(6, cliente.getApellido());
        sentencia.setString(7, cliente.getDni());
        sentencia.setString(8,cliente.getGenero());
        sentencia.setString(9, cliente.getDireccion());
        sentencia.setString(10, cliente.getCorreo());
        sentencia.setString(11, cliente.getTelefono());
        sentencia.setString(12, cliente.getCelular());
        sentencia.setBoolean(13, cliente.isActivo());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Cliente cliente) throws Exception {
        String consulta = "UPDATE cliente SET  codigodistrito=?, codigoprovincia=?, codigodepartamento=?, codigopais=?, nombrecliente=?, apellidocliente=?, dnicliente=?, generocliente=?, direccioncliente=?, correocliente=?, telefonocliente=?, \n" +
                        "celularcliente=?, estadocliente=? WHERE codigocliente=?;";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, cliente.getDistrito().getCodigo());
        sentencia.setInt(2, cliente.getProvincia().getCodigo());
        sentencia.setInt(3, cliente.getDepartamento().getCodigo());
        sentencia.setInt(4, cliente.getPais().getCodigo());
        sentencia.setString(5, cliente.getNombre());
        sentencia.setString(6, cliente.getApellido());
        sentencia.setString(7, cliente.getDni());
        sentencia.setString(8, cliente.getGenero());
        sentencia.setString(9, cliente.getDireccion());
        sentencia.setString(10, cliente.getCorreo());
        sentencia.setString(11, cliente.getTelefono());
        sentencia.setString(12, cliente.getCelular());
        sentencia.setBoolean(13, cliente.isActivo());
        sentencia.setInt(14, cliente.getCodigo());
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
        String consulta = "SELECT c.codigocliente, di.codigodistrito,di.nombredistrito, p.codigoprovincia, p.nombreprovincia, d.codigodepartamento, d.nombredepartamento,  pa.codigopais, pa.nombrepais, c.nombrecliente, c.apellidocliente, c.dnicliente, c.generocliente,  c.direccioncliente, c.correocliente, c.telefonocliente, c.celularcliente, c.estadocliente\n" +
                        "FROM cliente c inner join distrito di on c.codigodistrito=di.codigodistrito inner join provincia p on c.codigoprovincia=p.codigoprovincia inner join departamento d on c.codigodepartamento=d.codigodepartamento inner join pais pa on c.codigopais=pa.codigopais where codigocliente="+codigo;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            cliente = new Cliente();
            cliente.setCodigo(resultado.getInt(1));
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
            cliente.setDistrito(distrito);
            cliente.setProvincia(provincia);
            cliente.setDepartamento(departamento);
            cliente.setPais(pais);  
            cliente.setNombre(resultado.getString(10));
            cliente.setApellido(resultado.getString(11));
            cliente.setDni(resultado.getString(12));
            cliente.setGenero(resultado.getString(13));
            cliente.setDireccion(resultado.getString(14));
            cliente.setCorreo(resultado.getString(15));
            cliente.setTelefono(resultado.getString(16));
            cliente.setCelular(resultado.getString(17));
            cliente.setActivo(resultado.getBoolean(18));
                      
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
        String consulta = "SELECT c.codigocliente, di.codigodistrito,di.nombredistrito, p.codigoprovincia, p.nombreprovincia, d.codigodepartamento, d.nombredepartamento,  pa.codigopais, pa.nombrepais, c.nombrecliente, c.apellidocliente, c.dnicliente, c.generocliente,  c.direccioncliente, c.correocliente, c.telefonocliente, c.celularcliente, c.estadocliente\n" +
                        "FROM cliente c inner join distrito di on c.codigodistrito=di.codigodistrito inner join provincia p on c.codigoprovincia=p.codigoprovincia inner join departamento d on c.codigodepartamento=d.codigodepartamento inner join pais pa on c.codigopais=pa.codigopais where c.nombrecliente like '%"+nombre+"%' order by codigocliente desc";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            cliente = new Cliente();
            cliente.setCodigo(resultado.getInt(1));
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
            cliente.setDistrito(distrito);
            cliente.setProvincia(provincia);
            cliente.setDepartamento(departamento);
            cliente.setPais(pais);  
            cliente.setNombre(resultado.getString(10));
            cliente.setApellido(resultado.getString(11));
            cliente.setDni(resultado.getString(12));
            cliente.setGenero(resultado.getString(13));
            cliente.setDireccion(resultado.getString(14));
            cliente.setCorreo(resultado.getString(15));
            cliente.setTelefono(resultado.getString(16));
            cliente.setCelular(resultado.getString(17));
            cliente.setActivo(resultado.getBoolean(18));
            listaCliente.add(cliente);
        }
        return listaCliente;
    }    
}
