/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Distrito;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public interface IDistritoDAO {
    public int crear(Distrito distrito)throws Exception;
    public int modificar(Distrito distrito) throws Exception;
    public int eliminar(int codigo) throws Exception;
    public Distrito buscar(int codigo) throws Exception;
    public ArrayList<Distrito> buscarPorNombre(String nombre) throws Exception;
}
