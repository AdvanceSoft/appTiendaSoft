/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Pais;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public interface IPaisDAO {
    public void crear(Pais pais)throws Exception;
    public void modificar(Pais pais) throws Exception;
    public int eliminar(int codigo)throws Exception;
    public Pais buscar(int codigo)throws Exception;
    public ArrayList<Pais> buscarPorNombre(String nombre)throws Exception;
}
