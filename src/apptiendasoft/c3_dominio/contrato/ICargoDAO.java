/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Cargo;
import java.util.ArrayList;

/**
 *
 * @author <Valencia Cerna Nelida Janeth advancesoft.trujillo@gmail.com>
 */
public interface ICargoDAO {
    public int crear(Cargo cargo)throws Exception;
    public int modificar(Cargo cargo)throws Exception;
    public int eliminar(int codigo)throws Exception;
    public Cargo buscar(int codigo)throws Exception;
    public ArrayList<Cargo> buscarPorNombre(String nombre)throws Exception;
}
