/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.ILoteDAO;
import apptiendasoft.c3_dominio.entidad.Lote;
import apptiendasoft.c3_dominio.entidad.Producto;
import apptiendasoft.c4_persistencia.GestorJDBC;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class LoteDAOPostgre implements ILoteDAO{
    GestorJDBC gestorJDBC;

    public LoteDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    @Override
    public void crear(Lote lote) throws Exception {
        String consulta="insert into lote(codigoproducto,cantidadlote,fechavencimiento)values(?,?,?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1,lote.getProducto().getCodigo());
        sentencia.setInt(2, lote.getCantidadlote());
        sentencia.setDate(3, (Date)lote.getFechavencimiento());
        sentencia.executeUpdate();
    }

    @Override
    public void modificar(Lote lote) throws Exception {
        String consulta="update lote set cantidadlote=?,fechavencimiento=?,codigoproducto=? where codigolote=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, lote.getCantidadlote());
        sentencia.setDate(2, (Date)lote.getFechavencimiento());
        sentencia.setInt(3, lote.getProducto().getCodigo());
        sentencia.setInt(4, lote.getCodigo());
        sentencia.executeQuery();
    }

    @Override
    public void eliminar(Lote lote) throws Exception {
        String consulta="delete from lote where codigolote=?";
        PreparedStatement sentencia= gestorJDBC.prepararSentencia(consulta);
        sentencia.setInt(1, lote.getCodigo());
    }

    @Override
    public Lote buscar(int codigo) throws Exception {
        Lote lote = null;
        Producto producto = null;
        String consulta="select l.cantidadlote, l.fechavencimientolote,p.nombreproducto from lote l inner join producto p on (l.codigoproducto=p.codigoproducto) where l.codigolote="+codigo;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            lote = new Lote();
            producto = new Producto();
            producto.setCodigo(resultado.getInt(3));
            lote.setCantidadlote(resultado.getInt(1));
            lote.setFechavencimiento(resultado.getDate(2));
            
           
        }
        return lote;
    }

    @Override
    public ArrayList<Lote> buscarProducto(String producto) throws Exception {
        ArrayList<Lote> listalote = null;
        Lote lote;
        Producto producto1;
        String consulta = "select l.codigolote,l.cantidadlote, l.fechavencimientolote,p.codigoproducto,p.nombreproducto,p.descripcion,p.precioproducto,p.estadoproducto from lote l inner join producto p on (l.codigoproducto=p.codigoproducto)"
                + " where p.nombreproducto like '%"+producto+"%'" ;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        while(resultado.next()){
            producto1 = new Producto();
            lote = new Lote();
            producto1.setCodigo(resultado.getInt(4));
            producto1.setNombre(resultado.getString(5));
            producto1.setDescripcion(resultado.getString(6));
            producto1.setPrecio(resultado.getDouble(7));
            producto1.setEstado(resultado.getBoolean(8));
            lote.setCodigo(resultado.getInt(1));
            lote.setCantidadlote(resultado.getInt(2));
            lote.setFechavencimiento(resultado.getDate(3));
            lote.setProducto(producto1);
            listalote.add(lote);
        }
        return listalote;
    }
}
