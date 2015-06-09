/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Producto;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public interface IProductoDAO {
    public void crear(Producto producto)throws Exception;
    public void modificar(Producto producto)throws Exception;
    public void eliminar(Producto producto)throws Exception;
    public Producto buscar(int codigo)throws Exception;
    public ArrayList<Producto> buscar(String nombre)throws Exception;
}
