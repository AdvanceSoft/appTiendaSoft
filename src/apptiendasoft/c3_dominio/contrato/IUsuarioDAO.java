/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.contrato;

import apptiendasoft.c3_dominio.entidad.Usuario;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public interface IUsuarioDAO {
    public int crear(Usuario usuario)throws Exception;
    public int modificar(Usuario usuario)throws Exception;
    public int eliminar(int codigo)throws Exception;
    public Usuario Buscar(int codigo)throws Exception;
    public ArrayList<Usuario> buscarPorNombre(String nombre)throws Exception;
}
