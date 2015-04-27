/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;


/**
 *
 *  <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public abstract class Enterprice {
    private int codigo;
    private String actividad_servicio_rubro; 
    private String celular; 
    private String direccion; 
    private String email; 
    private String paginaweb;
    private String razonsocial; 
    private String ruc;
    private String telefono;
    private boolean activo; 

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getActividad_servicio_rubro() {
        return actividad_servicio_rubro;
    }

    public void setActividad_servicio_rubro(String actividad_servicio_rubro) {       
        if(actividad_servicio_rubro != null)
            this.actividad_servicio_rubro = actividad_servicio_rubro.trim().isEmpty() ? null : actividad_servicio_rubro.trim().toUpperCase();
        else
            this.actividad_servicio_rubro = null;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        if(celular != null)
            this.celular = celular.trim().isEmpty() ? null : celular.trim().toUpperCase();
        else
            this.celular = null;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if(direccion != null)
            this.direccion = direccion.trim().isEmpty() ? null : direccion.trim().toUpperCase();
        else
            this.direccion = null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null)
            this.email = email.trim().isEmpty() ? null : email.trim().toUpperCase();
        else
            this.email = null;
    }

    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        if(paginaweb != null)
            this.paginaweb = paginaweb.trim().isEmpty() ? null : paginaweb.trim();
        else
            this.paginaweb = null;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        if(razonsocial != null)
            this.razonsocial = razonsocial.trim().isEmpty() ? null : razonsocial.trim().toUpperCase();
        else
            this.razonsocial = null;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }    
            
  
}
