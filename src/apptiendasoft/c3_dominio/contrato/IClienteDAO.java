/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Cliente;
import java.util.ArrayList;


/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public interface IClienteDAO {
    public int crear(Cliente cliente)throws Exception;
    public int modificar(Cliente cliente)throws Exception;
    public int eliminar(int codigo)throws Exception;
    public Cliente buscar(int codigo)throws Exception;
    public ArrayList<Cliente> buscarPorNombre(String nombre)throws Exception;
}
