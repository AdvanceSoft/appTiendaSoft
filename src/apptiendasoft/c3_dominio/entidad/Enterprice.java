/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

import apptiendasoft.c5_recursos.algoritmos.Validador;
import apptiendasoft.c6_transversal.exepcion.ExcepcionReglaNegocio;


/**
 *@author 
 *<AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public abstract class Enterprice {
    private int codigo;
    private String razonsocial;
    private String ruc;
    private String servicio;
    private String direccion;
    private String correo;
    private String telefono;
    private String celular;
    private String paginaweb;
    private boolean activo;
    
    
//
//    public int getCodigo() {
//        return codigo;
//    }
//
//    public void setCodigo(int codigo) {
//        this.codigo = codigo;
//    }
//
//    public String getServicio() {
//        return servicio;
//    }
//
//    public void setServicio(String actividad_servicio_rubro)throws ExcepcionReglaNegocio{       
//        if(actividad_servicio_rubro != null)
//            this.servicio = actividad_servicio_rubro.trim().isEmpty() ? "Sin rubro" : actividad_servicio_rubro.trim().toUpperCase();
//        else
//            this.servicio = "Sin rubro";
//    }
//
//    public String getCelular() {
//        return celular;
//    }
//
//    public void setCelular(String celular) {
//        if(celular != null)
//            this.celular = celular.trim().isEmpty() ? "Sin datos" : celular.trim().toUpperCase();
//        else
//            this.celular = null;
//    }
//
//    public String getDireccion() {
//        return direccion;
//    }
//
//    public void setDireccion(String direccion) {
//        if(direccion != null)
//            this.direccion = direccion.trim().isEmpty() ? "Sin dirección" : direccion.trim().toUpperCase();
//        else
//            this.direccion = "Sin dirección";
//    }
//
//    public String getCorreo() {
//        return correo;
//    }
//    /**
//     * Este metoso set se usara solo cuando el usuario va a inresar el dato. 
//     * @param correo
//     * @throws Exception 
//     */
//    public void setEmail(String correo)throws Exception{
//        if(correo!=null){
//            if(!correo.trim().isEmpty()){
//                Validador.validarCorreo(correo);          
//                this.correo = correo.trim().toUpperCase();
//            }else
//                this.correo= "Sin datos";                     
//         }else
//            this.correo = "Sin datos";  
//    }
//    /**
//     * Este metodo set se usara solo cuando se llame el email de la base de datos
//     * @param correo 
//     */
//    public void setEmailBD(String correo){
//        this.correo=correo;
//    }
//    
//    public String getPaginaweb() {
//        return paginaweb;
//    }
//
//    public void setPaginaweb(String paginaweb) {
//        if(paginaweb != null)
//            this.paginaweb = paginaweb.trim().isEmpty() ? "Sin pagina web" : paginaweb.trim();
//        else
//            this.paginaweb = "Sin pagina web";
//    }
//
//    public String getRazonsocial() {
//        return razonsocial;
//    }
//
//    public void setRazonsocial(String razonsocial) {
//        if(razonsocial != null)
//            this.razonsocial = razonsocial.trim().isEmpty() ? "Sin razon social" : razonsocial.trim().toUpperCase();
//        else
//            this.razonsocial = "Sin razon social";
//    }
//
//    public String getRuc() {
//        return ruc;
//    }
//
//    public void setRuc(String ruc)throws Exception{
//          if(ruc!=null){         
//                if(!ruc.trim().isEmpty()){
//                    Validador.validarRuc(ruc);          
//                    this.ruc = ruc.trim();
//                }else
//                    this.ruc= "Sin ruc";                  
//         }else
//            this.ruc = "Sin ruc";     
//    }
//    
//    /**
//     * Para modificar desde la base de datos
//     * @param ruc 
//     */
//    public void setRucBD(String ruc){
//        this.ruc=ruc;
//    }
//
//    public String getTelefono() {
//        return telefono;
//    }
//
//    public void setTelefono(String telefono) {
//        this.telefono = telefono.trim();
//    }
//
//    public boolean isActivo() {
//        return activo;
//    }
//
//    public void setActivo(boolean activo) {
//        this.activo = activo;
//    }    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
