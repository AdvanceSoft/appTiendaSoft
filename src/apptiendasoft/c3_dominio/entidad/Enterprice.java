/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

import apptiendasoft.c5_recursos.algoritmos.Validador;
import apptiendasoft.c6_transversal.exepcion.ExcepcionRegla;


/**
 *
 *  <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public abstract class Enterprice {
    private int codigo;
    private String actividadrubro; 
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

    public String getActividadrubro() {
        return actividadrubro;
    }

    public void setActividadrubro(String actividad_servicio_rubro)throws ExcepcionRegla{       
        if(actividad_servicio_rubro != null)
            this.actividadrubro = actividad_servicio_rubro.trim().isEmpty() ? "Sin rubro" : actividad_servicio_rubro.trim().toUpperCase();
        else
            this.actividadrubro = "Sin rubro";
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        if(celular != null)
            this.celular = celular.trim().isEmpty() ? "Sin datos" : celular.trim().toUpperCase();
        else
            this.celular = null;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if(direccion != null)
            this.direccion = direccion.trim().isEmpty() ? "Sin dirección" : direccion.trim().toUpperCase();
        else
            this.direccion = "Sin dirección";
    }

    public String getEmail() {
        return email;
    }
    /**
     * Este metoso set se usara solo cuando el usuario va a inresar el dato. 
     * @param email
     * @throws Exception 
     */
    public void setEmail(String email)throws Exception{
        if(email!=null){
            try {
                if(!email.trim().isEmpty()){
                    Validador.validarCorreo(email);          
                    this.email = email.trim().toUpperCase();
                }else
                    this.email= "Sin datos";          
            } catch (Exception e) {
                throw ExcepcionRegla.crearErrorMENSAJE_CORREO();
            }
         }else
            this.email = "Sin datos";  
    }
    /**
     * Este metodo set se usara solo cuando se llame el email de la base de datos
     * @param email 
     */
    public void setEmailBD(String email){
        this.email=email;
    }
    
    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        if(paginaweb != null)
            this.paginaweb = paginaweb.trim().isEmpty() ? "Sin pagina web" : paginaweb.trim();
        else
            this.paginaweb = "Sin pagina web";
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        if(razonsocial != null)
            this.razonsocial = razonsocial.trim().isEmpty() ? "Sin razon social" : razonsocial.trim().toUpperCase();
        else
            this.razonsocial = "Sin razon social";
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
