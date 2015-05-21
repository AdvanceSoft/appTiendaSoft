/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class Backup {
    private int codigo;
    private String host;
    private String puerto;
    private String usuario;
    private String clave;
    private String bd;
    private String formato;
    private String rutaguradar;
    private String archivopostgres;

    public Backup() {
    }

    public Backup(int codigo, String host, String puerto, String usuario, String clave, String bd, String formato, String rutaguradar, String archivopostgres) {
        this.codigo = codigo;
        this.host = host;
        this.puerto = puerto;
        this.usuario = usuario;
        this.clave = clave;
        this.bd = bd;
        this.formato = formato;
        this.rutaguradar = rutaguradar;
        this.archivopostgres = archivopostgres;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getRutaguradar() {
        return rutaguradar;
    }

    public void setRutaguradar(String rutaguradar) {
        this.rutaguradar = rutaguradar;
    }

    public String getArchivopostgres() {
        return archivopostgres;
    }

    public void setArchivopostgres(String archivopostgres) {
        this.archivopostgres = archivopostgres;
    }
    //
    
}
