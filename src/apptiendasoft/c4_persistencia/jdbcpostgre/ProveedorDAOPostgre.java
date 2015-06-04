/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IProveedorDAO;
import apptiendasoft.c3_dominio.entidad.Departamento;
import apptiendasoft.c3_dominio.entidad.Distrito;
import apptiendasoft.c3_dominio.entidad.Pais;
import apptiendasoft.c3_dominio.entidad.Proveedor;
import apptiendasoft.c3_dominio.entidad.Provincia;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c6_transversal.exepcion.ExcepcionSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public class ProveedorDAOPostgre implements IProveedorDAO{
    GestorJDBC gestorJDBC;

    public ProveedorDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    @Override
    public List<Proveedor> buscar(String descripcion) throws Exception {
        ArrayList<Proveedor> proveedores = new ArrayList();
        Proveedor proveedor;
        ResultSet resultado;
        String sentenciaSQL="select d.codigodistrito, d.nombredistrito, pr.codigoprovincia, pr.nombreprovincia, de.codigodepartamento, de.nombredepartamento, pa.codigopais, pa.nombrepais,\n" +
                            "p.codigoproveedor, p.razonsocialproveedor, p.rucproveedor, p.servicioproveedor, p.direccionproveedor, p.correoproveedor, p.telefonoproveedor, p.celularproveedor, p.paginaproveedor, p.activoempresa \n" +
                            "from proveedor p inner join distrito d on (p.codigodistrito=d.codigodistrito)inner join provincia pr\n" +
                            "on (p.codigoprovincia=pr.codigoprovincia)inner join departamento de on (p.codigodepartamento=de.codigodepartamento) inner join \n" +
                            "pais pa on (p.codigopais=pa.codigopais)\n" +
                            "where p.razonsocialproveedor like '%"+descripcion.trim().toUpperCase()+"%' and p.activoempresa= true\n" +
                            "order by p.razonsocialproveedor";
        try {
            resultado=gestorJDBC.ejecutarConsulta(sentenciaSQL);
            while(resultado.next()){
              proveedor= crearObjetoProveedor(resultado);
              proveedores.add(proveedor);                            
            }
            resultado.close();
            return proveedores;
        } catch (Exception e) {
              throw ExcepcionSQL.crearErrorConsultar();
        }
    }

    @Override
    public Proveedor buscar(int proveedorid) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresar(Proveedor proveedor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Proveedor proveedor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Proveedor proveedor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proveedor> buscarTodos() throws Exception {
        ArrayList<Proveedor> proveedores = new ArrayList();
        Proveedor proveedor;
        ResultSet resultado;
        String sentenciaSQL="select d.codigodistrito, d.nombredistrito, pr.codigoprovincia, pr.nombreprovincia, de.codigodepartamento, de.nombredepartamento, pa.codigopais, pa.nombrepais,\n" +
                            "p.codigoproveedor, p.razonsocialproveedor, p.rucproveedor, p.servicioproveedor, p.direccionproveedor, p.correoproveedor, p.telefonoproveedor, p.celularproveedor, p.paginaproveedor, p.activoempresa \n" +
                            "from proveedor p inner join distrito d on (p.codigodistrito=d.codigodistrito)inner join provincia pr\n" +
                            "on (p.codigoprovincia=pr.codigoprovincia)inner join departamento de on (p.codigodepartamento=de.codigodepartamento) inner join \n" +
                            "pais pa on (p.codigopais=pa.codigopais)\n" +
                            "order by p.razonsocialproveedor";
        try {
            resultado=gestorJDBC.ejecutarConsulta(sentenciaSQL);
            while(resultado.next()){
              proveedor= crearObjetoProveedor(resultado);
              proveedores.add(proveedor);                            
            }
            resultado.close();
            return proveedores;
        } catch (Exception e) {
              throw ExcepcionSQL.crearErrorConsultar();
        }
        
    }
    private Proveedor crearObjetoProveedor(ResultSet resultado) throws SQLException {
        Proveedor proveedor = new Proveedor();
        proveedor.setCodigo(resultado.getInt("codigoproveedor"));
        proveedor.setRazonsocial(resultado.getString("razonsocialproveedor"));
        proveedor.setRuc(resultado.getString("rucproveedor"));
        proveedor.setServicio(resultado.getString("servicioproveedor"));
        proveedor.setDireccion(resultado.getString("direccionproveedor"));
        proveedor.setCorreo(resultado.getString("correoproveedor"));
        proveedor.setTelefono(resultado.getString("telefonoproveedor"));
        proveedor.setCelular(resultado.getString("celularproveedor"));
        proveedor.setPaginaweb(resultado.getString("paginaproveedor"));
        proveedor.setActivo(resultado.getBoolean("activoempresa"));
        Distrito distrito = new Distrito();
        distrito.setCodigo(resultado.getInt("codigodistrito"));
        distrito.setNombre(resultado.getString("nombredistrito"));
        Provincia provincia = new Provincia();
        provincia.setCodigo(resultado.getInt("codigoprovincia"));
        provincia.setNombre(resultado.getString("nombreprovincia"));
        Departamento departamento = new Departamento();
        departamento.setCodigo(resultado.getInt("codigodepartamento"));
        departamento.setNombre(resultado.getString("nombredepartamento"));
        Pais pais = new Pais();
        pais.setCodigo(resultado.getInt("codigopais"));
        pais.setNombre(resultado.getString("nombrepais"));
        proveedor.setDistrito(distrito);
        proveedor.setProvincia(provincia);
        proveedor.setDepartamento(departamento);
        proveedor.setPais(pais);
        return proveedor;       
    }
    
    
    
}
