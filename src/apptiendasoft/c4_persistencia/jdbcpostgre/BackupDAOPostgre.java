/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c4_persistencia.jdbcpostgre;

import apptiendasoft.c3_dominio.contrato.IBackupDAO;
import apptiendasoft.c3_dominio.entidad.Backup;
import apptiendasoft.c4_persistencia.GestorJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class BackupDAOPostgre implements IBackupDAO{
    GestorJDBC gestorJDBC;

    public BackupDAOPostgre(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }
    
    @Override
    public void modificar(Backup backup) throws Exception {
        String consulta = "update backup set hostbackup=?,puertobackup=?,usuariobackup=?,clavebackup=?,basedatosbackup=?,"
                + "formatobackup=?,rutaguardarbackup=?,archivopostgresbackup=? where codigobackup=?";
        PreparedStatement sentencia = gestorJDBC.prepararSentencia(consulta);
        sentencia.setString(1, backup.getHost());
        sentencia.setString(2, backup.getPuerto());
        sentencia.setString(3, backup.getUsuario());
        sentencia.setString(4, backup.getClave());
        sentencia.setString(5, backup.getBasedatos());
        sentencia.setString(6, backup.getFormato());
        sentencia.setString(7, backup.getRutaguardar());
        sentencia.setString(8, backup.getArchivopostgres());
        sentencia.setInt(9, backup.getCodigo());
        sentencia.executeUpdate();
    }

    @Override
    public Backup buscar() throws Exception {        
        String consulta = "select codigobackup,hostbackup,puertobackup,usuariobackup,clavebackup,basedatosbackup,formatobackup,rutaguardarbackup,archivopostgresbackup from backup";
        ResultSet resultado = gestorJDBC.ejecutarConsulta(consulta);
        Backup backup = null;
        if(resultado.next()){
            backup = new Backup();
            backup.setCodigo(resultado.getInt(1));
            backup.setHost(resultado.getString(2));
            backup.setPuerto(resultado.getString(3));
            backup.setUsuario(resultado.getString(4));
            backup.setClave(resultado.getString(5));
            backup.setBasedatos(resultado.getString(6));
            backup.setFormato(resultado.getString(7));
            backup.setRutaguardar(resultado.getString(8));
            backup.setArchivopostgres(resultado.getString(9));
        }
        return backup;
    }
}
