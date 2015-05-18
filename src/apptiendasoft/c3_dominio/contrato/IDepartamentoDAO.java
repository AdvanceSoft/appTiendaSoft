/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Departamento;
import java.util.ArrayList;

/**
 *
 * @author sandra
 */
public interface IDepartamentoDAO {
    public int crear(Departamento departamento)throws Exception;
    public int modificar(Departamento departamento) throws Exception;
    public int eliminar(int codigo)throws Exception;
    public Departamento buscar(int codigo)throws Exception;
    public ArrayList<Departamento> buscarPorNombre(String nombre)throws Exception;
}
