/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Proveedor;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public interface IProveedorDAO {
    public List<Proveedor> buscar(String descripcion) throws Exception;
    public List<Proveedor> buscarTodos()throws Exception;
    public Proveedor buscar(int proveedorid) throws Exception;
    public void ingresar(Proveedor proveedor) throws Exception;
    public void modificar(Proveedor proveedor) throws Exception;
    public void eliminar(Proveedor proveedor) throws Exception;      
}
