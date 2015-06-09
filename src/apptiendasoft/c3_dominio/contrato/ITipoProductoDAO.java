/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.TipoProducto;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public interface ITipoProductoDAO {
    public void crear(TipoProducto tipoProducto)throws Exception;
    public void modificar(TipoProducto tipoProducto)throws Exception;
    public void eliminar(TipoProducto tipoProducto)throws Exception;
    public TipoProducto buscar(int codigo)throws Exception;
    public ArrayList<TipoProducto> buscar(String nombre)throws Exception;
}
