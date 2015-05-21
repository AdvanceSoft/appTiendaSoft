/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

import apptiendasoft.c1_presentacion.form.FormMenu;
import apptiendasoft.c2_aplicacion.servicio.GestionarEmpresaServicio;
import javax.swing.ImageIcon;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class Empresa extends Enterprice{
    //Las variables que estan aqui pertenecen al logo
    private String nombrelogo;
    private String rutalogo;
    private String tamanologo;

    public String getNombrelogo() {
        return nombrelogo;
    }

    public void setNombrelogo(String nombrelogo) {
        this.nombrelogo = nombrelogo;
    }

    public String getRutalogo() {
        return rutalogo;
    }

    public void setRutalogo(String rutalogo) {
        this.rutalogo = rutalogo;
    }

    public String getTamanologo() {
        return tamanologo;
    }

    public void setTamanologo(String tamanologo) {
        this.tamanologo = tamanologo;
    }
    
}
