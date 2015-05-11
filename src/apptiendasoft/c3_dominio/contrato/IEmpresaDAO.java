/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Empresa;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public interface IEmpresaDAO {
    public void modificar(Empresa empresa)throws Exception;
    public Empresa buscar()throws Exception;
}
