/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c4_persistencia.GestorJDBC;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class GestorJDBCPostgre extends GestorJDBC {    
    @Override
    public void abrirConexion() throws SQLException{    
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) { }
        String url = "jdbc:postgresql://localhost:5432/tienda";
        conexion = DriverManager.getConnection(url, "postgres", "123");
    }   
}
