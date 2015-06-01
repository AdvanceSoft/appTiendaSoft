/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IUsuarioDAO;
import apptiendasoft.c3_dominio.entidad.Usuario;
import apptiendasoft.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author
 * <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class UsuarioDAOPostgre implements IUsuarioDAO{
    GestorJDBC gestorJDBC;
    
    public UsuarioDAOPostgre(GestorJDBC gestorJDBC){
        this.gestorJDBC= gestorJDBC;
    }

    @Override
    public int crear(Usuario usuario) throws Exception {
        String consulta = "INSERT INTO usuario(nombreusuario, passwordusuario) VALUES (?, ?)";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, usuario.getNombre());
        sentencia.setString(2, usuario.getContraseña());
        return sentencia.executeUpdate();
    }

    @Override
    public int modificar(Usuario usuario) throws Exception {
        String consulta ="UPDATE usuario  SET nombreusuario=?, passwordusuario=? WHERE codigousuario=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, usuario.getNombre());
        sentencia.setString(2, usuario.getContraseña());
        sentencia.setInt(3, usuario.getCodigo());
        return sentencia.executeUpdate();
    }

    @Override
    public int eliminar(int codigo) throws Exception {
        String consulta ="delete from usuario where codigousuario="+codigo;
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        return sentencia.executeUpdate();
    }

    @Override
    public Usuario Buscar(int codigo) throws Exception {
        Usuario usuario = null;
        String consulta ="SELECT codigousuario, nombreusuario, passwordusuario FROM usuario where codigousuario="+codigo;
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            usuario = new Usuario();
            usuario.setCodigo(resultado.getInt(1));
            usuario.setNombre(resultado.getString(2));
            usuario.setContraseña(resultado.getString(3));
        }
        return usuario;
    }

    @Override
    public ArrayList<Usuario> buscarPorNombre(String nombre) throws Exception {
        Usuario usuario = null;
        ArrayList<Usuario> listaUsuario = null;
        String consulta ="SELECT codigousuario, nombreusuario, passwordusuario FROM usuario where nombreusuario like '%"+nombre+"%' order by codigousuario desc";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        if(resultado.next()){
            usuario = new Usuario();
            usuario.setCodigo(resultado.getInt(1));
            usuario.setNombre(resultado.getString(2));
            usuario.setContraseña(resultado.getString(3));
            listaUsuario.add(usuario);
        }
        return listaUsuario;
    }
}
