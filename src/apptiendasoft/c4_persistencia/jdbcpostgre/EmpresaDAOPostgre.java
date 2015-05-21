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
        String consulta = "update empresa set razonsocialempresa=?,rucempresa=?,servicioempresa=?,direccionempresa=?,"
                + "correoempresa=?,telefonoempresa=?,celularempresa=?,paginawebempresa=?,activoempresa=?,nombrelogoempresa=?, "
                + "rutalogo=?,tamanologo=? "
                + "where codigoempresa=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, empresa.getRazonsocial());
        sentencia.setString(2, empresa.getRuc());
        sentencia.setString(3, empresa.getServicio());
        sentencia.setString(4, empresa.getDireccion());
        sentencia.setString(5, empresa.getCorreo());
        sentencia.setString(6, empresa.getTelefono());
        sentencia.setString(7, empresa.getCelular());
        sentencia.setString(8, empresa.getPaginaweb());
        sentencia.setBoolean(9, empresa.isActivo());
        sentencia.setString(10, empresa.getNombrelogo());
        sentencia.setString(11, empresa.getRutalogo());
        sentencia.setString(12, empresa.getTamanologo());
        sentencia.setInt(13, empresa.getCodigo());
        sentencia.executeUpdate();        
    }

    @Override
    public Empresa buscar() throws Exception {        
        String consulta = "select codigoempresa,razonsocialempresa,rucempresa,servicioempresa,direccionempresa,"
                + "correoempresa,telefonoempresa,celularempresa,paginawebempresa,activoempresa,nombrelogoempresa,rutalogo,tamanologo "
                + "from empresa";        
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        Empresa empresa = null;
        if(resultado.next()){
            empresa = new Empresa();
            empresa.setCodigo(resultado.getInt(1));
            empresa.setRazonsocial(resultado.getString(2));
            empresa.setRuc(resultado.getString(3));
            empresa.setServicio(resultado.getString(4));
            empresa.setDireccion(resultado.getString(5));
            empresa.setCorreo(resultado.getString(6));
            empresa.setTelefono(resultado.getString(7));
            empresa.setCelular(resultado.getString(8));
            empresa.setPaginaweb(resultado.getString(9));
            empresa.setActivo(resultado.getBoolean(10));
            empresa.setNombrelogo(resultado.getString(11));
            empresa.setRutalogo(resultado.getString(12));
            empresa.setTamanologo(resultado.getString(13));
        }
        return empresa;
    }
    
}
