/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IProductoDAO;
import apptiendasoft.c3_dominio.entidad.Marca;
import apptiendasoft.c3_dominio.entidad.Producto;
import apptiendasoft.c3_dominio.entidad.TipoProducto;
import apptiendasoft.c3_dominio.entidad.UnidadDeMedida;
import apptiendasoft.c4_persistencia.GestorJDBC;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class ProductoDAOPostgre implements IProductoDAO{

    GestorJDBC gestorJDBC;
    public ProductoDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    @Override
    public void crear(Producto producto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Producto producto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Producto producto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto buscar(int codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> buscar(String nombre) throws Exception {
        if(nombre == null){
            nombre = "";
        }
        Producto producto;
        TipoProducto tipoProducto;
        UnidadDeMedida unidadDeMedida;
        Marca marca;
        ArrayList<Producto> listaProducto = new ArrayList<>();
        String consulta = "select tp.codigotipoproducto, tp.nombretipoproducto, tp.descripciontipoproducto, um.codigounidaddemedida,um.nombreunidaddemedida,um.descripcionunidaddemedida,m.codigomarca,m.nombremarca,m.descripcionmarca,p.codigoproducto, p.nombreproducto, p.descripcionproducto, p.precioproducto from producto p inner join tipoproducto tp on p.codigotipoproducto=tp.codigotipoproducto inner join unidaddemedida um on p.codigounidaddemedida=um.codigounidaddemedida inner join marca m on p.codigomarca=m.codigomarca where p.nombreproducto like '%"+nombre+"%' or tp.nombretipoproducto like '%"+nombre+"%' or um.nombreunidaddemedida like '%"+nombre+"%' or m.nombremarca like '%"+nombre+"%'";        
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        while(resultado.next()){
            producto = new Producto();
            tipoProducto = new TipoProducto();
            unidadDeMedida = new UnidadDeMedida();
            marca = new Marca();
            
            tipoProducto.setCodigo(resultado.getInt(1));
            tipoProducto.setNombre(resultado.getString(2));
            tipoProducto.setDescripcion(resultado.getString(3));
            
            unidadDeMedida.setCodigoUnidadDeMedida(resultado.getInt(4));
            unidadDeMedida.setNombreUnidadDeMedida(resultado.getString(5));
            unidadDeMedida.setDescripcionUnidadDeMedida(resultado.getString(6));
            
            marca.setCodigo(resultado.getInt(7));
            marca.setNombre(resultado.getString(8));
            marca.setDescripcion(resultado.getString(9));
            
            producto.setCodigo(resultado.getInt(10));
            producto.setTipoProducto(tipoProducto);
            producto.setUnidadDeMedida(unidadDeMedida);
            producto.setMarca(marca);
            producto.setNombre(resultado.getString(11));
            producto.setDescripcion(resultado.getString(12));
            producto.setPrecio(resultado.getDouble(13));
            
            listaProducto.add(producto);
        }
        return listaProducto;
    }
    
}
