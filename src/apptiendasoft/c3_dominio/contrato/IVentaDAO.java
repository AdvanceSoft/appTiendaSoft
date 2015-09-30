/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Venta;

/**
 *
 * @author HacybeykerS
 */
public interface IVentaDAO {
    public void registrarVenta(Venta venta)throws Exception;
}
