/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Empleado;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public interface IEmpleadoDAO {
    public int crear(Empleado empleado)throws Exception;
    public int modificar(Empleado empleado)throws Exception;
    public int eliminar(int codigo)throws Exception;
    public Empleado buscar(int codigo)throws Exception;
    public ArrayList<Empleado> buscarPorNOmbre(String nombre)throws Exception;
}
