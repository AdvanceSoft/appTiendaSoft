/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Lote;

/**
 *
 * @author HacybeykerS
 */
public interface ILoteDAO {
    public void crear(Lote lote) throws Exception;
    public void modificar(Lote lote) throws Exception;
    public void eliminar(Lote lote) throws Exception;
    public Lote buscar(int codigo) throws Exception;
}
