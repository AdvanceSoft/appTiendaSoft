/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IUsuarioDAO;
import apptiendasoft.c3_dominio.entidad.Usuario;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.UsuarioDAOPostgre;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class GestionarUsuarioServicio {
    GestorJDBC gestorJDBC;
    IUsuarioDAO usuarioDAO;
    
    public GestionarUsuarioServicio(){
        this.gestorJDBC = new GestorJDBCPostgre();
        this.usuarioDAO =new UsuarioDAOPostgre( gestorJDBC);        
    }
    
    public int crear(Usuario usuario)throws Exception{
        gestorJDBC.abrirConexion();
        int estado = usuarioDAO.crear(usuario);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    
    public int modificar(Usuario usuario)throws Exception{
        gestorJDBC.abrirConexion();
        int estado = usuarioDAO.modificar(usuario);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    
    public int eliminar(int codigo)throws Exception{
        gestorJDBC.abrirConexion();
        int estado = usuarioDAO.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return estado;
    }
    
    public Usuario buscar(int codigo)throws Exception{
        gestorJDBC.abrirConexion();
        Usuario usuario = usuarioDAO.Buscar(codigo);
        gestorJDBC.cerrarConexion();
        return usuario;
    }
    
    public ArrayList<Usuario> buscarPorNombre(String nombre)throws Exception{
        gestorJDBC.abrirConexion();
        ArrayList<Usuario> listaUsuario = usuarioDAO.buscarPorNombre(nombre);
        gestorJDBC.cerrarConexion();
        return listaUsuario;
    }
}
