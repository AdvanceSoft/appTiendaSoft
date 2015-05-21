/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c2_aplicacion.servicio;

import apptiendasoft.c3_dominio.contrato.IBackupDAO;
import apptiendasoft.c3_dominio.entidad.Backup;
import apptiendasoft.c4_persistencia.GestorJDBC;
import apptiendasoft.c4_persistencia.jdbcpostgre.BackupDAOPostgre;
import apptiendasoft.c4_persistencia.jdbcpostgre.GestorJDBCPostgre;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class GestionarBackupServicio{

    GestorJDBC gestorJDBC;
    IBackupDAO BackupDAO;

    public GestionarBackupServicio() {
        this.gestorJDBC = new GestorJDBCPostgre();
        this.BackupDAO = new BackupDAOPostgre(gestorJDBC);
    }
    
    public void modificar(Backup backup) throws Exception {
        gestorJDBC.abrirConexion();
        BackupDAO.modificar(backup);
        gestorJDBC.cerrarConexion();
    }
    
    public Backup buscar() throws Exception {
        Backup backup;
        gestorJDBC.abrirConexion();
         backup = BackupDAO.buscar();
         gestorJDBC.cerrarConexion();
         return backup;
    }    
}
