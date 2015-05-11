/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

import apptiendasoft.c6_transversal.exepcion.ExcepcionRegla;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class Empresa extends Enterprice{
    private String logo;
    private String host;
    private String puerto;
    private String usuario;
    private String clave;
    private String bd;
    private String formato;
    private String rutaguradar;
    private String archivopostgres;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
    
    public void realizarBackup() throws ExcepcionRegla, IOException{
        LocalDate fecha = LocalDate.now();
        LocalDateTime time = LocalDateTime.now();
        int cadenaHora = time.getHour();
        int cadenaMinuto = time.getMinute();
        int cadenaSegundo = time.getSecond();
        String cadenaFecha = fecha.toString();        
        ProcessBuilder pb;
        Process p;
        String rutaCompleta = rutaguradar+bd+"_"+cadenaFecha+"_"+cadenaHora+"-"+cadenaMinuto+"-"+cadenaSegundo+".backup";
        System.out.println(rutaCompleta);
        pb = new ProcessBuilder(archivopostgres, "--verbose", "--format", formato, "-f", rutaCompleta);
        pb.environment().put("PGHOST", host);
        pb.environment().put("PGPORT", puerto);
        pb.environment().put("PGUSER", usuario);
        pb.environment().put("PGPASSWORD", clave);
        pb.environment().put("PGDATABASE", bd);
        pb.redirectErrorStream(true);
        p = pb.start();         
    }
}
