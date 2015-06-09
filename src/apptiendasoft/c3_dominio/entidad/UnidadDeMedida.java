/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;


/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public class UnidadDeMedida {
    private int codigoUnidadDeMedida;
    private String nombreUnidadDeMedida;
    private String descripcionUnidadDeMedida;

    public UnidadDeMedida() {
        this.codigoUnidadDeMedida = 0;
    }
    
    public int getCodigoUnidadDeMedida() {
        return codigoUnidadDeMedida;
    }

    public void setCodigoUnidadDeMedida(int codigoUnidadDeMedida) {
        this.codigoUnidadDeMedida = codigoUnidadDeMedida;
    }

    public String getNombreUnidadDeMedida() {
        return nombreUnidadDeMedida;
    }

    public void setNombreUnidadDeMedida(String nombreUnidadDeMedida){
         if(nombreUnidadDeMedida!=null){         
                if(!nombreUnidadDeMedida.trim().isEmpty()){         
                    this.nombreUnidadDeMedida = nombreUnidadDeMedida.trim().toUpperCase();
                }else
                    this.nombreUnidadDeMedida= "Sin nombre";                  
         }else
            this.nombreUnidadDeMedida = "Sin nombre";  
    }
    
    /**
     * Metodo para modificar el objeto de la base de datos
     * @param nombreUnidadDeMedida 
     */
    public void setNombreUnidadDeMedidaBD(String nombreUnidadDeMedida){
        this.nombreUnidadDeMedida=nombreUnidadDeMedida;
    }

    public String getDescripcionUnidadDeMedida() {
        return descripcionUnidadDeMedida;
    }

    public void setDescripcionUnidadDeMedida(String descripcionUnidadDeMedida) {        
       if(descripcionUnidadDeMedida!=null)
           this.descripcionUnidadDeMedida = descripcionUnidadDeMedida.trim().isEmpty() ? "Sin descripción" : descripcionUnidadDeMedida.trim().toUpperCase();
       else
           this.descripcionUnidadDeMedida= "Sin descripción";
    }
    
    
}
