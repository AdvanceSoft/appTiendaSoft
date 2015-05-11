/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IEmpresaDAO;
import apptiendasoft.c3_dominio.entidad.Empresa;
import apptiendasoft.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class EmpresaDAOPostgre implements IEmpresaDAO{

    GestorJDBC gestorJDBC;

    public EmpresaDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    @Override
    public void modificar(Empresa empresa) throws Exception {
        String consulta = "update razonsocialempresa=?,rucempresa=?,servicioempresa=?,direccionempresa=?,"
                + "telefonoempresa=?,celularempresa=?,paginawebempresa=?,activoempresa=?,logoempresa=?,"
                + "hostempresa=?,puertoempresa=?,usuarioempresa=?,claveempresa=?,basedatosempresa=?,"
                + "formatoempresa=?,rutaguardadoempresa=?,archivopostgresempresa=? where codigoempresa="+empresa.getCodigo();
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, empresa.getRazonsocial());
        sentencia.setString(2, empresa.getRuc());
        sentencia.setString(3, empresa.getActividad_servicio_rubro());
        sentencia.setString(4, empresa.getDireccion());
        sentencia.setString(5, empresa.getTelefono());
        sentencia.setString(6, empresa.getCelular());
        sentencia.setString(7, empresa.getPaginaweb());
        sentencia.setBoolean(8, empresa.isActivo());
        sentencia.setString(9, empresa.getLogo());
        sentencia.setString(10, empresa.getHost());
        sentencia.setString(11, empresa.getPuerto());
        sentencia.setString(12, empresa.getUsuario());
        sentencia.setString(13, empresa.getClave());
        sentencia.setString(14, empresa.getBd());
        sentencia.setString(15, empresa.getFormato());
        sentencia.setString(16, empresa.getRutaguradar());
        sentencia.setString(17, empresa.getArchivopostgres());
        sentencia.setInt(18, empresa.getCodigo());
    }

    @Override
    public Empresa buscar() throws Exception {        
        String consulta = "select codigoempresa,razonsocialempresa,rucempresa,servicioempresa,direccionempresa,"
                + "telefonoempresa,celularempresa,paginawebempresa,activoempresa,logoempresa,"
                + "hostempresa,puertoempresa,usuarioempresa,claveempresa,basedatosempresa,"
                + "formatoempresa,rutaguardadoempresa,archivopostgresempresa from empresa";        
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        Empresa empresa = null;
        if(resultado.next()){
            empresa = new Empresa();
            empresa.setCodigo(resultado.getInt(1));
            empresa.setRazonsocial(resultado.getString(2));
            empresa.setRuc(resultado.getString(3));
            empresa.setActividad_servicio_rubro(resultado.getString(4));
            empresa.setDireccion(resultado.getString(5));
            empresa.setTelefono(resultado.getString(6));
            empresa.setCelular(resultado.getString(7));
            empresa.setPaginaweb(resultado.getString(8));
            empresa.setActivo(resultado.getBoolean(9));
            empresa.setLogo(resultado.getString(10));
            empresa.setHost(resultado.getString(11));
            empresa.setPuerto(resultado.getString(12));
            empresa.setUsuario(resultado.getString(13));
            empresa.setClave(resultado.getString(14));
            empresa.setBd(resultado.getString(15));
            empresa.setFormato(resultado.getString(16));
            empresa.setRutaguradar(resultado.getString(17));
            empresa.setArchivopostgres(resultado.getString(18));
        }
        return empresa;
    }
    
}
