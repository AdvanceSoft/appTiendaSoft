/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Provincia;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public interface IProvinciaDAO {
    public void crear(Provincia provincia)throws Exception;
    public void modificar(Provincia provincia) throws Exception;
    public int eliminar(int codigo) throws Exception;
    public Provincia buscar(int codigo) throws Exception;
    public ArrayList<Provincia> buscarPorNombre(String nombre)throws Exception;
}
