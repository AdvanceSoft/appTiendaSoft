/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Departamento;
import java.util.ArrayList;

/**
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 */
public interface IDepartamentoDAO {
    public void crear(Departamento departamento)throws Exception;
    public void modificar(Departamento departamento) throws Exception;
    public void eliminar(Departamento departamento)throws Exception;
    public Departamento buscar(int codigo)throws Exception;
    public ArrayList<Departamento> buscarPorNombre(String nombre)throws Exception;
}
