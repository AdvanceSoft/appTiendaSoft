/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.UnidadDeMedida;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public interface IUnidadDeMedidaDAO {
    public List<UnidadDeMedida> buscar(String descripcion) throws Exception;
    public UnidadDeMedida buscar(int unidadDeMedidaid) throws Exception;
    public void ingresar(UnidadDeMedida unidadDeMedida) throws Exception;
    public void modificar(UnidadDeMedida unidadDeMedida) throws Exception;
    public void eliminar(UnidadDeMedida unidadDeMedida) throws Exception;  
}
