/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Marca;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public interface IMarcaDAO {
    public int crear(Marca marca)throws Exception;
    public int modificar(Marca marca)throws Exception;
    public int eliminar(int codigo)throws Exception;
    public Marca buscar(int codigo)throws Exception;
    public ArrayList<Marca> buscarPorNombre(String nombre)throws Exception;
}
