/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Distrito;
import java.util.ArrayList;

/**
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 */
public interface IDistritoDAO {
    public void crear(Distrito distrito)throws Exception;
    public void modificar(Distrito distrito) throws Exception;
    public void eliminar(Distrito distrito) throws Exception;
    public Distrito buscar(int codigo) throws Exception;
    public ArrayList<Distrito> buscarPorNombre(String nombre) throws Exception;
}
